package com.example.intentexample;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;

public class SharedPreferences extends AppCompatActivity {

    EditText et_save;
    String shared = "file";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shared_preferences);

        et_save = (EditText)findViewById(R.id.et_save);

        android.content.SharedPreferences sharedPreferences = getSharedPreferences(shared, 0);
        String value = sharedPreferences.getString("asdf", "");
        et_save.setText(value);


    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        android.content.SharedPreferences sharedPreferences = getSharedPreferences(shared, 0);
        android.content.SharedPreferences.Editor editor = sharedPreferences.edit();
        String value = et_save.getText().toString();
        editor.putString("asdf", value);
        editor.commit();
    }
}