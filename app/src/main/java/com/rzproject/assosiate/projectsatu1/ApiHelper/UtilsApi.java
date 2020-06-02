package com.rzproject.assosiate.projectsatu1.ApiHelper;

public class UtilsApi {
    public static final String BASE_URL_API = "https://vast-reef-07673.herokuapp.com/";

    public static BaseApiService getAPIService() {
        return RetrofitClient.getClient(BASE_URL_API).create(BaseApiService.class);
    }

}

