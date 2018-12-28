package br.com.nobre.threadnotificacaoprogramada;

import android.app.Notification;
import android.os.Handler;

import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import static br.com.nobre.threadnotificacaoprogramada.App.CANAL_1_ID;
import static br.com.nobre.threadnotificacaoprogramada.App.CANAL_2_ID;

public class MainActivity extends AppCompatActivity {

    private Handler handler = new Handler();
    private Runnable runnable;
    private NotificationManagerCompat notificationManagerCompat;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        notificationManagerCompat = NotificationManagerCompat.from(this);

        runnable = new Runnable() {
            @Override
            public void run() {

                Log.i("teste ", "Executou");

                notificarCanal2();
                handler.postDelayed(runnable, 10000); // executa a cada 10 segundos
            }
        };

        handler.post(runnable);
    }


    /*
    Notificações
        criar os canais na classe App(Extend application)
        inserir o name na classe App no manifest*/
    public void notificarCanal1(View v) {
        Notification notification = new NotificationCompat.Builder(this, CANAL_1_ID)
                .setSmallIcon(R.drawable.ic_android_black_24dp)
                .setContentTitle("Teste")
                .setContentText("Teste Notificacao")
                .setPriority(NotificationCompat.PRIORITY_HIGH) // entra como nortificação de mensagem
                .setCategory(NotificationCompat.CATEGORY_MESSAGE)
                .build();

        notificationManagerCompat.notify(1, notification);
    }

    public void notificarCanal2() {
        Notification notification = new NotificationCompat.Builder(this, CANAL_2_ID)
                .setSmallIcon(R.drawable.ic_android_black_24dp)
                .setContentTitle("Teste")
                .setContentText("Teste Notificacao")
                .setPriority(NotificationCompat.PRIORITY_LOW) // somente aparece a notificação
                .setCategory(NotificationCompat.CATEGORY_MESSAGE)
                .build();

        notificationManagerCompat.notify(2, notification);

    }
}
