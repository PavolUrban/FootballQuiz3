package com.sample.multiplechoicequiz;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;

public class MenuActivity extends AppCompatActivity {

    private SharedPreferences mPrefs;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
    }

    public void exitApp(View v){
        this.finish();
    }

    public void newGame(View v){
        Intent myIntent = new Intent(MenuActivity.this, QuizActivity.class);
        myIntent.putExtra("typeOfGame", "new"); //Optional parameters
        MenuActivity.this.startActivity(myIntent);
    }

    public void continueGame(View v){
        Intent myIntent = new Intent(MenuActivity.this, QuizActivity.class);
        myIntent.putExtra("typeOfGame", "continue"); //Optional parameters
        MenuActivity.this.startActivity(myIntent);
    }


    public void goToStats(View v){
        mPrefs = getSharedPreferences("app", MODE_PRIVATE);
        String json = mPrefs.getString("HIGH_SCORES", null);
        if(json !=null)
        {
            Intent myIntent = new Intent(MenuActivity.this, StatsActivity.class);
            MenuActivity.this.startActivity(myIntent);
        }

        else
        {
            Toast.makeText(MenuActivity.this, "Zatiaľ nemáte uložené žiadne štatistiky!", Toast.LENGTH_SHORT).show();
        }
    }

    public void goToSettings(View v){
        Intent myIntent = new Intent(MenuActivity.this, SettingsActivity.class);
        MenuActivity.this.startActivity(myIntent);

    }

}
