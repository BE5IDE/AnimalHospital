package com.example.animalhospital;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    EditText edt_userid, edt_passward;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn_login = findViewById(R.id.btn_login);
        edt_userid = findViewById(R.id.edt_userid);
        edt_passward = findViewById(R.id.edt_passward);

        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "로그인 버튼 클릭", Toast.LENGTH_SHORT).show();
                //아이디 20자리 비번 13자리
                String str_userid = edt_userid.getText().toString();
                String str_passward = edt_passward.getText().toString();
                Log.d("SHIN","str_userid"+str_userid);
                Log.d("SHIN", str_passward);

                if(str_userid.length()!=6){
                    Toast.makeText(MainActivity.this, "아이디는 6자입니다", Toast.LENGTH_SHORT).show();
                }
                else if(str_passward.length() < 6 || str_passward.length()>12){
                    Toast.makeText(MainActivity.this, "비밀번호는 6~12자입니다", Toast.LENGTH_SHORT).show();
                }
                else if(str_userid.equals("system") && str_passward.equals("123456789")){
                    Toast.makeText(MainActivity.this, str_userid+"님 환영합니다.", Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(MainActivity.this, "입력한 로그인", Toast.LENGTH_SHORT).show();
                }

            }
        });
        findViewById(R.id.btn_info).setOnClickListener(this);
        findViewById(R.id.btn_guide).setOnClickListener(this);
        findViewById(R.id.btn_call).setOnClickListener(this);
        findViewById(R.id.btn_shop).setOnClickListener(this);
    }


    @Override
    public void onClick(View view) { //int n
        Intent intent = null;
        switch (view.getId()){
            case R.id.btn_info:
                intent = new Intent(MainActivity.this,InfoActivity.class);
                intent.putExtra("MSG","안녕하세요.");
                break;
            case R.id.btn_guide:
                intent = new Intent(MainActivity.this,GuideActivity.class);
                break;
            case R.id.btn_call:
                intent = new Intent(MainActivity.this,CallActivity.class);
                break;
            case R.id.btn_shop:
                intent = new Intent(MainActivity.this,ShopActivity.class);
                break;
        }
        startActivity(intent);
    }
}