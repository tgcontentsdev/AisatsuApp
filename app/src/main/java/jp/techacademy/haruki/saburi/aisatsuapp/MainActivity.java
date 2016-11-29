package jp.techacademy.haruki.saburi.aisatsuapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.TimePicker;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity implements View.OnClickListener,TimePicker.OnTimeChangedListener {

    TextView mTextView;
    TimePicker mTimePicker;
    int nowHour;
    int nowMinute;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button1 = (Button) findViewById(R.id.button1);
        button1.setOnClickListener(this);

        mTextView = (TextView) findViewById(R.id.textView1);
        mTimePicker = (TimePicker) findViewById(R.id.timePicker1);
        mTimePicker.setOnTimeChangedListener(this);
        mTimePicker.setIs24HourView(true);

        Calendar cal = Calendar.getInstance();
        nowHour = cal.get(Calendar.HOUR_OF_DAY);
    }

    @Override
    public void onTimeChanged(TimePicker view, int hourOfDay, int minute){
        nowHour = hourOfDay;
        nowMinute = minute;
    }

    @Override
    public void onClick(View v){
        if (nowHour >= 2 && nowHour <= 9){
            mTextView.setText("「おはよう」");
        }else if (nowHour >= 10 && nowHour <= 17){
            mTextView.setText("「こんにちは」");
        }else {
            mTextView.setText("「こんばんは」");
        }

    }
}
