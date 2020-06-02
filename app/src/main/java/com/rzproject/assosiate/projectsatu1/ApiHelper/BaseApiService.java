package com.rzproject.assosiate.projectsatu1.ApiHelper;

import com.rzproject.assosiate.projectsatu1.Model.InstingData;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.DELETE;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface BaseApiService {

    @POST("logout")
    Call<ResponseBody> logout(@Header("Authorization") String authToken);

    @FormUrlEncoded
    @POST("login")
    Call<ResponseBody> loginRequest(@Field("username") String username, @Field("password") String password);

    @GET("insting")
    Call<InstingData> getInsting(@Header("Authorization") String authToken);

}
