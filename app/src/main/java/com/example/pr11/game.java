package com.example.pr11;

import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class game extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        try {
            this.getSupportActionBar().hide();
        }
        catch (NullPointerException e){}
        setContentView(R.layout.game);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);





    }
    public boolean Started = false;
    public boolean Finished = false;
    public void Start(View view){
        Button button = (Button)findViewById(R.id.btnstart);
        if(!Finished){
            if(!Started){
                button.setBackgroundColor(Color.RED);
                button.setText("Пауза");
                Started = true;
            }
            else if(Started){
                button.setBackgroundColor(Color.GREEN);
                button.setText("Старт");
                Started = false;
            }
        }
        else{
            Intent intent=new Intent(this, MainActivity.class);
            startActivity(intent);
        }
    }
    public void Drive1(View view){
        Button button = (Button)findViewById(R.id.btnstart);
        View Car = (View)findViewById(R.id.Car1);
        TextView result = (TextView)findViewById(R.id.tvResult);
        if(Started && !Finished){
            ViewGroup.MarginLayoutParams margin = (ViewGroup.MarginLayoutParams)Car.getLayoutParams();
            margin.leftMargin +=40;
            margin.rightMargin +=40;
            Car.requestLayout();
            if(margin.rightMargin <= -100){
                result.setText("Победа 1 игрока");
                button.setText("Заново");
                result.setTextColor(0xffe91E3);
                Finished = true;
            }
        }
    }
    public void Drive2(View view){
        Button button = (Button)findViewById(R.id.btnstart);
        View Car = (View)findViewById(R.id.Car2);
        TextView result = (TextView)findViewById(R.id.tvResult);
        ImageView finish = (ImageView)findViewById(R.id.finish);
        if(Started && !Finished){
            ViewGroup.MarginLayoutParams margin = (ViewGroup.MarginLayoutParams)Car.getLayoutParams();
            margin.leftMargin +=40;
            margin.rightMargin +=40;
            Car.requestLayout();
            if(margin.rightMargin <= -100){
                result.setText("Победа 2 игрока");
                button.setText("Заново");
                result.setTextColor(0xffe91E3);
                Finished = true;
            }
        }
    }
}
