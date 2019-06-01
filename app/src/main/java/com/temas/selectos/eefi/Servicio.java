package com.temas.selectos.eefi;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.support.v4.app.NotificationCompat;

import com.temas.selectos.eefi.Central.adaptadorEvento;

import static com.temas.selectos.eefi.App.ID_CANAL;

public class Servicio extends Service {

    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        String titulo = intent.getStringExtra("inputExtra");

        Intent intentaNotificacion = new Intent(this, MainActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intentaNotificacion, 0);

        Notification notification = new NotificationCompat.Builder(this, ID_CANAL).setContentTitle("Recordatorio").setContentText(titulo).setSmallIcon(R.drawable.ic_event).setContentIntent(pendingIntent).build();

        startForeground(1, notification);

        return START_NOT_STICKY;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
