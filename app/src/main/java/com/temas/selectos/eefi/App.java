package com.temas.selectos.eefi;

import android.app.Application;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.os.Build;

public class App extends Application {
    public static final String ID_CANAL = "canalDeServicio";

    @Override
    public void onCreate() {
        super.onCreate();

        crearCanalDeNotificacion();
    }

    private void crearCanalDeNotificacion(){
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            NotificationChannel canalDeServicio = new NotificationChannel(ID_CANAL, "Canal de Servicio", NotificationManager.IMPORTANCE_DEFAULT);

            NotificationManager manager = getSystemService(NotificationManager.class);
            manager.createNotificationChannel(canalDeServicio);
        }
    }
}
