package com.example.hi.constellationapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {


    DatePicker datePicker;
    Button button;
    EditText editText;
    ImageView imageView;
    TextView textView;
    String sTemp;

    int[] infoarry = { R.string.aquarius , R.string.pisces, R.string.aries, R.string.taurus, R.string.gemini, R.string.cancer, R.string.leo, R.string.virgo, R.string.libra, R.string.scorpio, R.string.sagittarius, R.string.capricornus };
    int[] imagearray = { R.drawable.aquarius, R.drawable.pisces, R.drawable.aries, R.drawable.taurus, R.drawable.gemini, R.drawable.cancer, R.drawable.leo, R.drawable.libra, R.drawable.scorpio, R.drawable.sagittarius, R.drawable.capricornus };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        datePicker = (DatePicker)findViewById(R.id.datePicker);
        button = (Button)findViewById(R.id.button);
        editText = (EditText) findViewById(R.id.editText);
        imageView = (ImageView) findViewById(R.id.imageView);
        textView = (TextView) findViewById(R.id.textView3);

        Calendar calendar = Calendar.getInstance();

        final int year = calendar.get(Calendar.YEAR);
        final int month = calendar.get(Calendar.MONTH);
        final int day = calendar.get(Calendar.DAY_OF_MONTH);


        datePicker.init(year, month, day, new DatePicker.OnDateChangedListener(){

            @Override
            public void onDateChanged(DatePicker datePicker, int i, int i1, int i2) {

                sTemp = editText.getText().toString();
                editText.setText(sTemp + i2 + "/" + i1 + "/" + i);
            }
        });

        button.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                int index = getIndex(datePicker.getMonth(), datePicker.getDayOfMonth());

                String strInfo = getString(infoarry[index]);
                textView.setText(sTemp + " Your constellation is as following:\n " + strInfo);
                imageView.setVisibility(View.VISIBLE);
                imageView.setImageResource(imagearray[index]);
            }
        });
    }
    public int getIndex(int month, int day){

        int index = month;
        int[] dayArr = { 20, 19, 21, 20, 21, 22, 23, 23, 23, 24, 23, 22 };

        if(day < dayArr[index]){

            index = month - 1;
            if(index < 0)
                index = 11;
        }else
            index = month;
        return index;
    }
}
