package com.gideondev.safeboda.adapter;

import android.app.Activity;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.gideondev.safeboda.R;
import com.gideondev.safeboda.availableFlights.presenter.presenter_view.AirlineListPresenter;
import com.gideondev.safeboda.model.schedules.FlightItem;
import com.gideondev.safeboda.model.schedules.ScheduleItem;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


public class airlineListAdapter extends RecyclerView.Adapter<airlineListAdapter.ViewHolder> {

    List<ScheduleItem> scheduleList;
    Context context;
    Activity activity;
    AirlineListPresenter airlineListPresenter;

    public airlineListAdapter(Context context, List<ScheduleItem> schedule,AirlineListPresenter presenter) {
        this.scheduleList = schedule;
        this.context = context;
        airlineListPresenter = presenter;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        //  public TextView airlineID,airlineDeparture,airlineReturn;
        LinearLayout lnAirInfo;
        View itemView;
        public ViewHolder(View view) {
            super(view);
            lnAirInfo = view.findViewById(R.id.info);
            itemView = view;
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_airlinelist, parent, false);

        ViewHolder viewHolder = new ViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final ViewHolder Viewholder, final int position) {

        final ScheduleItem model = scheduleList.get(position);
        List<FlightItem> flightItemList = model.getFlight();
        if (flightItemList != null && flightItemList.size() > 0) {
            for (int i = 0; i < flightItemList.size(); i++) {
                addFlightInfo(Viewholder.lnAirInfo,flightItemList.get(i));
            }
        }

        Viewholder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                airlineListPresenter.openRouteScreen();
            }
        });
    }

    private void addFlightInfo(LinearLayout parentView,FlightItem  flightItem ) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_attached_flightdetails, null);
        TextView airlineID = view.findViewById(R.id.airline_listID);
        airlineID.setText(flightItem.getMarketingCarrier().getAirlineID());
        TextView airlineDeparture = view.findViewById(R.id.airline_departure_earliest);
        TextView airlineReturn = view.findViewById(R.id.airline_return_time);
        String arrivalTime = flightItem.getArrival().getScheduledTimeLocal().getDateTime();
        arrivalTime = arrivalTime.split("T")[1];

        String departureTime = flightItem.getDeparture().getScheduledTimeLocal().getDateTime();
        departureTime = departureTime.split("T")[1];
        airlineReturn.setText(arrivalTime
                + "(" + flightItem.getArrival().getAirportCode() + ")");
       airlineDeparture.setText(departureTime
                + "(" + flightItem.getDeparture().getAirportCode() + ")");
        view.setLayoutParams(new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.FILL_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT));

        parentView.addView(view);
    }


    private String getTime(String dateTime){
        Date date = null;
        String time = null;
        try {
            date = new SimpleDateFormat("yyyy-MM-dd HH:mm").parse(dateTime);
         time  = new SimpleDateFormat("H:mm").format(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return time;
    }

    @Override
    public int getItemCount() {

        return null == scheduleList ? 0 : scheduleList.size();
    }

}

