package com.gideondev.safeboda.retrofit;

import com.gideondev.safeboda.model.AirportResponse;
import com.gideondev.safeboda.model.Token;
import com.gideondev.safeboda.model.cities.CitiesResponse;
import com.gideondev.safeboda.model.schedules.ScheduleResponse;
import com.google.gson.JsonObject;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface webservice {
    @POST("oauth/token")
    @FormUrlEncoded
    Call<Token> requestToken(@Field("client_id") String clientId,
                             @Field("client_secret") String secret,
                             @Field("grant_type") String userId);

    @GET("references/cities")
    Call<CitiesResponse> getAllCities(@Header("Authorization") String token, @Header("Accept") String accept);


    @GET("references/cities/{cityCode}")
    Call<JsonObject> getAllAirportPerCity(@Header("Authorization") String token, @Header("Accept") String accept, @Path("cityCode") String city);

    @GET("operations/schedules/{origin}/{destination}/{fromDateTime}")
    Call<ScheduleResponse> getAllFlight(@Header("Authorization") String token,
                                        @Header("Accept") String accept,
                                        @Path("origin") String origin,
                                        @Path("destination") String destination,
                                        @Path("fromDateTime") String fromDateTime,
                                        @Query("directFlights") boolean tt);
    @GET("references/airports")
    Call<AirportResponse> getAllAirport(@Header("Authorization") String token, @Header("Accept") String accept);
}
