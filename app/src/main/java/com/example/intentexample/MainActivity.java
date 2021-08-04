package com.example.intentexample;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


//    private Button btn_intent;
    private Button btn_intent, btn_toast;
    private EditText et_text;
    private String str;
    ImageView to_test;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et_text = findViewById(R.id.et_text);

        btn_intent = findViewById(R.id.btn_intent);
        btn_intent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                str = et_text.getText().toString();
                Intent intent = new Intent(MainActivity.this , clock.class);
                intent.putExtra("str",str);
                startActivity(intent); //액티비티 이동
            }
        });

        to_test = findViewById(R.id.to_test);
        to_test.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getBaseContext(), "뭐하냐", Toast.LENGTH_SHORT).show();
            }

        });

        btn_toast = findViewById(R.id.btn_toast);
        btn_toast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast t = new Toast(getApplicationContext());
                t.setDuration(Toast.LENGTH_LONG); // 보여줄 기간 지정
                t.setGravity(Gravity.CENTER, 0, 0); // 보여줄 위치 지정

                LayoutInflater inf = (LayoutInflater)
                        getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                View view = inf.inflate(R.layout.toast_layout, null);
                t.setView(view); // 우리가 만든 뷰를 지정
                t.show(); // 화면에 보여주기

            }

        });
//        public void ClickHandler(View view)
//        {
//            Toast myToast = Toast.makeText(this.getApplicationContext(),"", Toast.LENGTH_SHORT);
//
//            myToast.setGravity(Gravity.CENTER, 0,0 );
//            View toastLayout = getLayoutInflater().inflate(R.layout.toast_layout, null);
//
//            myToast.setView(toastLayout);
//            myToast.show();
//        }

    }
}