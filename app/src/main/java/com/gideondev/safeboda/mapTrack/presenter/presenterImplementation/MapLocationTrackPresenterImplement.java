package com.gideondev.safeboda.mapTrack.presenter.presenterImplementation;

import android.graphics.Color;
import android.os.AsyncTask;
import android.support.annotation.NonNull;
import android.util.Log;
import android.widget.Toast;

import com.gideondev.safeboda.Utility.PreferenUtil;
import com.gideondev.safeboda.Utility.ProgressBarHandler;
import com.gideondev.safeboda.Utility.data.DataParser;
import com.gideondev.safeboda.mapTrack.presenter.presenterView.MapLocationTrackPresenter;
import com.gideondev.safeboda.mapTrack.presenter.presenterView.MapLocationTrackView;
import com.gideondev.safeboda.model.AirportItem;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolylineOptions;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class MapLocationTrackPresenterImplement implements MapLocationTrackPresenter {
    private MapLocationTrackView mView;
    private PreferenUtil preferenUtil;
    private AirportItem arrivalAirportItem;
    private AirportItem originAirportItem;
    public static final String Direction_API = "https://maps.googleapis.com/maps/api/directions/json?origin=";
    public static final String API_KEY = "AIzaSyCwwHCIzIIi0rJ3TF9lxIBL8UUpSWLKNe0";
    GoogleMap mMap;
    public List<LatLng> list;
    private ProgressBarHandler progressBarHandler;


    @Override
    public void resume() {

    }

    @Override
    public void pause() {

    }

    @Override
    public void destroy() {

    }

    @Override
    public void setView(@NonNull MapLocationTrackView view) {
        this.mView = view;
    }


    @Override
    public void getData() {
        preferenUtil = PreferenUtil.getInstant(mView.getContext());
        progressBarHandler = new ProgressBarHandler(mView.getContext());
        originAirportItem = preferenUtil.getDepartureItem();
        arrivalAirportItem = preferenUtil.getArrivalItem();
    }


    @Override
    public void setMap(GoogleMap map) {
        mMap = map;
        list = new ArrayList<>();
        LatLng barcelona = new LatLng(originAirportItem.getPosition().getCoordinate().getLatitude(), originAirportItem.getPosition().getCoordinate().getLongitude());
        LatLng madrid = new LatLng(arrivalAirportItem.getPosition().getCoordinate().getLatitude(), arrivalAirportItem.getPosition().getCoordinate().getLongitude());
        list.add(barcelona);
        list.add(madrid);


        map.setOnMapLoadedCallback(new GoogleMap.OnMapLoadedCallback() {
            @Override
            public void onMapLoaded() {
                progressBarHandler.show();
                LatLng origin = list.get(0);
                LatLng dest = list.get(1);

                // Getting URL to the Google Directions API
                String url = getUrl(String.valueOf(origin.latitude), String.valueOf(origin.longitude), String.valueOf(dest.latitude), String.valueOf(dest.latitude));
                Log.d("onMapClick", url.toString());
                FetchUrl FetchUrl = new FetchUrl();

                // Start downloading json data from Google Directions API
                FetchUrl.execute(url);

                LatLng barcelona = new LatLng(originAirportItem.getPosition().getCoordinate().getLatitude(), originAirportItem.getPosition().getCoordinate().getLongitude());
                mMap.addMarker(new MarkerOptions().position(barcelona).title("Departure"));

                LatLng madrid = new LatLng(arrivalAirportItem.getPosition().getCoordinate().getLatitude(), arrivalAirportItem.getPosition().getCoordinate().getLongitude());
                mMap.addMarker(new MarkerOptions().position(madrid).title("Arrival"));
            }
        });


    }


    private static String getUrl(String originLat, String originLong, String destinationLat, String destinationLong) {
        return Direction_API + originLat + "," + originLong + "&destination=" + destinationLat + "," + destinationLong + "&key=" + API_KEY;
    }

    public void drawPolyLineOnMap(List<LatLng> list, GoogleMap googleMap) {
        PolylineOptions polyOptions = new PolylineOptions();
        polyOptions.color(Color.RED);
        polyOptions.width(5);
        polyOptions.addAll(list);

        googleMap.clear();
        googleMap.addPolyline(polyOptions);

        LatLngBounds.Builder builder = new LatLngBounds.Builder();
        for (LatLng latLng : list) {
            builder.include(latLng);
        }

        final LatLngBounds bounds = builder.build();

        CameraUpdate cu = CameraUpdateFactory.newLatLngBounds(bounds, 6);
        googleMap.animateCamera(cu);
    }


    private class FetchUrl extends AsyncTask<String, Void, String> {

        @Override
        protected String doInBackground(String... url) {

            // For storing data from web service
            String data = "";

            try {
                // Fetching the data from web service
                data = downloadUrl(url[0]);
                Log.d("Background Task data", data.toString());
            } catch (Exception e) {
                Log.d("Background Task", e.toString());
            }
            return data;
        }

        @Override
        protected void onPostExecute(String result) {
            super.onPostExecute(result);

            ParserTask parserTask = new ParserTask();

            // Invokes the thread for parsing the JSON data
            parserTask.execute(result);

        }
    }


    private String downloadUrl(String strUrl) throws IOException {
        String data = "";
        InputStream iStream = null;
        HttpURLConnection urlConnection = null;
        try {
            URL url = new URL(strUrl);

            // Creating an http connection to communicate with url
            urlConnection = (HttpURLConnection) url.openConnection();

            // Connecting to url
            urlConnection.connect();

            // Reading data from url
            iStream = urlConnection.getInputStream();

            BufferedReader br = new BufferedReader(new InputStreamReader(iStream));

            StringBuffer sb = new StringBuffer();

            String line = "";
            while ((line = br.readLine()) != null) {
                sb.append(line);
            }

            data = sb.toString();
            Log.d("downloadUrl", data.toString());
            br.close();

        } catch (Exception e) {
            Log.d("Exception", e.toString());
        } finally {
            iStream.close();
            urlConnection.disconnect();
        }
        return data;
    }


    private class ParserTask extends AsyncTask<String, Integer, List<List<HashMap<String, String>>>> {

        // Parsing the data in non-ui thread
        @Override
        protected List<List<HashMap<String, String>>> doInBackground(String... jsonData) {

            JSONObject jObject;
            List<List<HashMap<String, String>>> routes = null;

            try {
                jObject = new JSONObject(jsonData[0]);
                Log.d("ParserTask", jsonData[0].toString());
                DataParser parser = new DataParser();
                Log.d("ParserTask", parser.toString());

                // Starts parsing data
                routes = parser.parse(jObject);
                Log.d("ParserTask", "Executing routes");
                Log.d("ParserTask", routes.toString());

            } catch (Exception e) {
                Log.d("ParserTask", e.toString());
                e.printStackTrace();
            }
            return routes;
        }

        // Executes in UI thread, after the parsing process
        @Override
        protected void onPostExecute(List<List<HashMap<String, String>>> result) {
            ArrayList<LatLng> points;
            PolylineOptions lineOptions = null;

            // Traversing through all the routes
            for (int i = 0; i < result.size(); i++) {
                points = new ArrayList<>();
                lineOptions = new PolylineOptions();

                // Fetching i-th route
                List<HashMap<String, String>> path = result.get(i);

                // Fetching all the points in i-th route
                for (int j = 0; j < path.size(); j++) {
                    HashMap<String, String> point = path.get(j);

                    double lat = Double.parseDouble(point.get("lat"));
                    double lng = Double.parseDouble(point.get("lng"));
                    LatLng position = new LatLng(lat, lng);

                    points.add(position);
                }

                // Adding all the points in the route to LineOptions
                lineOptions.addAll(points);
                lineOptions.width(10);
                lineOptions.color(Color.RED);

                Log.d("onPostExecute", "onPostExecute lineoptions decoded");

            }

            // Drawing polyline in the Google Map for the i-th route
            if (lineOptions != null) {
                //to draw polyline with google api route
                progressBarHandler.hide();
                mMap.addPolyline(lineOptions);
            } else {

                //to draw polyline without using google api route
                drawPolyLineOnMap(list, mMap);
                LatLng barcelona = new LatLng(originAirportItem.getPosition().getCoordinate().getLatitude(), originAirportItem.getPosition().getCoordinate().getLongitude());
                mMap.addMarker(new MarkerOptions().position(barcelona).title("Departure"));

                LatLng madrid = new LatLng(arrivalAirportItem.getPosition().getCoordinate().getLatitude(), arrivalAirportItem.getPosition().getCoordinate().getLongitude());
                mMap.addMarker(new MarkerOptions().position(madrid).title("Arrival"));
                Toast.makeText(mView.getContext(), "Could not draw a polyline from googleapi", Toast.LENGTH_LONG).show();
                progressBarHandler.hide();
                Log.d("onPostExecute", "without Polylines drawn");
            }
        }
    }


}
