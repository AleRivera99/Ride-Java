package com.proyecto.proyectotransporte.providers;

import com.proyecto.proyectotransporte.models.FCMBody;
import com.proyecto.proyectotransporte.models.FCMResponse;
import com.proyecto.proyectotransporte.retrofit.IFCMApi;
import com.proyecto.proyectotransporte.retrofit.RetrofitClient;

import retrofit2.Call;

public class NotificationProvider {
    private String url = "https://fcm.googleapis.com";

    public NotificationProvider() {
    }

    public Call<FCMResponse> sendNotification(FCMBody body) {
        return RetrofitClient.getClientObject(url).create(IFCMApi.class).send(body);
    }
}
