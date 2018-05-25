package com.example.com.mumbai;


import com.example.com.mumbai.Remote.IGoogleAPIService;
import com.example.com.mumbai.Remote.RetrofitClient;

/**
 * Created by mahir on 11-03-2018.
 */

public class Common {
    public static final String GOOGLE_API_URL="https://maps.googleapis.com";
    public static IGoogleAPIService getGoogleAPIService(){
        return RetrofitClient.getClient(GOOGLE_API_URL).create(IGoogleAPIService.class);
    }
}
