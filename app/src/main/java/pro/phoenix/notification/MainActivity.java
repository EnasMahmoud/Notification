package pro.phoenix.notification;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;

public class MainActivity extends AppCompatActivity{

    private static final int NOTIFICATION_ID=0;
    Button notifyBtn,cancelBtn,updateBtn;
    private NotificationManager mNotifyManger;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mNotifyManger = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);

        notifyBtn = findViewById(R.id.notifyBtn);
        cancelBtn = findViewById(R.id.cancelBtn);
        updateBtn = findViewById(R.id.updateBtn);
        /*notifyBtn.setEnabled(true);
        cancelBtn.setEnabled(false);
        updateBtn.setEnabled(false);*/


    }


    public void cancelNotify(View view) {
        mNotifyManger.cancel(NOTIFICATION_ID);
    }

    public void updateNotify(View view) {
        Bitmap notifyImg = BitmapFactory.decodeResource(getResources(),R.drawable.quraan);
        Intent notificationIntent = new Intent(this , MainActivity.class);
        PendingIntent notificationPendingIntent = PendingIntent.getActivity(this,NOTIFICATION_ID,notificationIntent,PendingIntent.FLAG_UPDATE_CURRENT);

        NotificationCompat.Builder notifyBuilder = new NotificationCompat.Builder(this)
                .setContentText("This is Your notification text.")
                .setContentTitle("You Have been notified")
                .setPriority(NotificationCompat.PRIORITY_HIGH)
                .setDefaults(NotificationCompat.DEFAULT_ALL)
                .setSmallIcon(R.drawable.ic_library_music_black_24dp)
                .setStyle(new NotificationCompat.BigPictureStyle().bigPicture(notifyImg).setBigContentTitle("Notification Updated!!"));

        Notification myNotification = notifyBuilder.build();
        mNotifyManger.notify(NOTIFICATION_ID , myNotification);
    }

    public void openNotify(View view) {
        Intent notificationIntent = new Intent(this , MainActivity.class);
        PendingIntent notificationPendingIntent = PendingIntent.getActivity(this,NOTIFICATION_ID,notificationIntent,PendingIntent.FLAG_UPDATE_CURRENT);
        NotificationCompat.Builder notifyBuilder = new NotificationCompat.Builder(this)
                .setContentText("This is Your notification text.")
                .setContentTitle("You Have been notified")
                .setPriority(NotificationCompat.PRIORITY_HIGH)
                .setDefaults(NotificationCompat.DEFAULT_ALL)
                .setSmallIcon(R.drawable.ic_library_music_black_24dp);

        Notification myNotification = notifyBuilder.build();
        mNotifyManger.notify(NOTIFICATION_ID , myNotification);

       /* notifyBtn.setEnabled(false);
        updateBtn.setEnabled(true);
        cancelBtn.setEnabled(true);*/
    }
}
