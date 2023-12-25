package com.kylinxin.myweather.login;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.kylinxin.myweather.MainActivity;
import com.kylinxin.myweather.R;
import com.kylinxin.myweather.ui.WeatherDetailActivity;

import java.util.ArrayList;

public class Login extends AppCompatActivity {

    private DatabaseHelper mSQLite;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Button btn_login = findViewById(R.id.login);
        Button btn_register = findViewById(R.id.register);
        EditText ed_name = findViewById(R.id.userName);
        EditText ed_password = findViewById(R.id.userpassword);

        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String name = ed_name.getText().toString().trim();
                String password = ed_password.getText().toString().trim();

                ArrayList<User> data = mSQLite.getAllDATA();
                boolean flag = false;
                for(int i = 0; i < data.size(); i++){
                    User userdata = data.get(i);
                    if(name.equals(userdata.getName())&&password.equals(userdata.getPassword())){
                        flag = true;
                        break;
                    }else{
                        flag = false;
                    }
                }

                if(!TextUtils.isEmpty(name)&&!TextUtils.isEmpty(password)){
                    if(flag){
                        Intent intent1 = new Intent(Login.this, WeatherDetailActivity.class);
                        startActivity(intent1);
                        finish();
                        Toast.makeText(Login.this, "登录成功", Toast.LENGTH_SHORT).show();
                    }
                    else{
                        Toast.makeText(Login.this, "用户名或密码不正确", Toast.LENGTH_SHORT).show();
                    }
                }
                else{
                    Toast.makeText(Login.this, "用户名与密码不能为空", Toast.LENGTH_SHORT).show();
                }
            }
        });

        btn_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent2 = new Intent(Login.this, Register.class);
                startActivity(intent2);
                finish();
            }
        });
        mSQLite = new DatabaseHelper(Login.this);
    }
}