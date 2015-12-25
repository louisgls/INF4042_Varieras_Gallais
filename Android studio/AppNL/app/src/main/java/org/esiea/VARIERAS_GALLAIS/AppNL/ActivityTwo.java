package org.esiea.VARIERAS_GALLAIS.AppNL;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.NotificationManager;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.NotificationCompat;
import android.support.v7.widget.Toolbar;
import android.text.format.DateUtils;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;

public class ActivityTwo extends AppCompatActivity {

        protected TextView tv_hw2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //Date
        tv_hw2 = (TextView)findViewById(R.id.tv_hello_world2);
        String date = DateUtils.formatDateTime(getApplicationContext(), (new Date()).getTime(), DateFormat.FULL);
        tv_hw2.setText(date);

        //Toast
        Button btn_hw = (Button)findViewById(R.id.btn_hello_world);
        btn_hw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), getString(R.string.msg), Toast.LENGTH_LONG). show();
            }
        });

        //DatePickerDialog
        final Calendar cal = Calendar.getInstance();
        year = cal.get(Calendar.YEAR);
        month = cal.get(Calendar.MONTH);
        day = cal.get(Calendar.DAY_OF_MONTH);
        showDialogOnButtonClick();
    }


    //DatePickerDialog
    Button btn;
    int year,month,day;
    static final int DIALOG_ID = 0;
    public void showDialogOnButtonClick(){
        btn = (Button)findViewById(R.id.dpd);
        btn.setOnClickListener(
                new View.OnClickListener(){
                    @Override
                    public void onClick(View v){
                        showDialog(DIALOG_ID);
                    }
                }
        );
    }
    @Override
    protected Dialog onCreateDialog(int id){
        if (id==DIALOG_ID)
            return new DatePickerDialog(this, dpickerListener, year, month, day);
        return null;
    }
    private DatePickerDialog.OnDateSetListener dpickerListener
            = new DatePickerDialog.OnDateSetListener(){
        @Override
        public void onDateSet(DatePicker view, int years, int monthOfYear, int dayOfMonth) {
            year = years;
            month = monthOfYear + 1;
            day = dayOfMonth;
            Toast.makeText(ActivityTwo.this, day + "-" + month + "-" + year, Toast.LENGTH_LONG).show();
        }
    };
    //Notification
    public void notification_test(View view){
        NotificationCompat.Builder mBuilder =
                (NotificationCompat.Builder) new NotificationCompat.Builder(this)
                        .setSmallIcon(R.drawable.ic_launcher)
                        .setContentTitle("Voici la notification")
                        .setContentText("Hello World!");
        final NotificationManager notificationManager = (NotificationManager)getSystemService(Context.NOTIFICATION_SERVICE);
        notificationManager.notify(100, mBuilder.build());
        Toast.makeText(getApplicationContext(), getString(R.string.notif), Toast.LENGTH_LONG). show();
    }

}
