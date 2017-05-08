package io.github.yusukeiwaki.headsupnotificationplayground;

import android.app.Activity;
import android.app.Notification;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;
import android.view.View;

import java.security.SecureRandom;

public class MainActivity extends Activity {

    private final SecureRandom secureRandom = new SecureRandom();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.notification1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Context context = v.getContext();
                Notification n = new NotificationCompat.Builder(context)
                        .setContentTitle("うぇーい　新しいメッセージが届きました" + System.currentTimeMillis())
                        .setContentText("組長！こんにちはボットです。先日の件についてですがどうなりましたかね？")
                        .setSmallIcon(R.drawable.ic_stat_me)
                        .setAutoCancel(true)
                        .setGroup("toKumicho")
                        .build();
                NotificationManagerCompat.from(context)
                        .notify(secureRandom.nextInt(), n);

                // Android 6.0まではこれだけが表示される
                Notification n2 = new NotificationCompat.Builder(context)
                        .setContentTitle("さまり(kumicho)" + System.currentTimeMillis())
                        .setContentText("〜〜〜〜〜")
                        .setSmallIcon(R.drawable.ic_stat_me)
                        .setGroup("toKumicho")
                        .setGroupSummary(true)
                        .build();
                NotificationManagerCompat.from(context)
                        .notify(1, n2);
            }
        });

        findViewById(R.id.notification2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Context context = v.getContext();
                Notification n = new NotificationCompat.Builder(context)
                        .setContentTitle("うぇーい　新しいメッセージが届きました" + System.currentTimeMillis())
                        .setContentText("ボット！こんにちは組長です。先日の件についてですがどうなりましたかね？")
                        .setSmallIcon(R.drawable.ic_stat_me)
                        .setAutoCancel(true)
                        .setGroup("toBot")
                        .setDefaults(NotificationCompat.DEFAULT_ALL)
                        .setPriority(NotificationCompat.PRIORITY_HIGH)
                        .build();
                NotificationManagerCompat.from(context)
                        .notify(secureRandom.nextInt(), n);

                // Android 6.0まではこれだけが表示される
                Notification n2 = new NotificationCompat.Builder(context)
                        .setContentTitle("さまり(bot)" + System.currentTimeMillis())
                        .setContentText("〜〜〜〜〜")
                        .setSmallIcon(R.drawable.ic_stat_me)
                        .setGroup("toBot")
                        .setGroupSummary(true)
                        .build();
                NotificationManagerCompat.from(context)
                        .notify(2, n2);
            }
        });
    }
}
