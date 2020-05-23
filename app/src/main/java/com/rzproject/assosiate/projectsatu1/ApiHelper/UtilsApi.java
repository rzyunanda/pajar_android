package com.rzproject.assosiate.projectsatu1.ApiHelper;

public class UtilsApi {
    public static final String BASE_URL_API = "http://192.168.100.7/pajar_restapi/public/api/";

    public static BaseApiService getAPIService() {
        return RetrofitClient.getClient(BASE_URL_API).create(BaseApiService.class);
    }


}

