package com.example.hyejin.sungshintcommuproject.IntroService;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.hyejin.sungshintcommuproject.MainActivity;
import com.example.hyejin.sungshintcommuproject.R;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText etv_id;
    private EditText etv_pw;
    private Button btn_login;
    private Button btn_join;
    private String id;
    private String pw;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity);
        initView();
    }

    private void initView(){
        etv_id = (EditText)findViewById(R.id.login_activity_etv_id);
        etv_pw = (EditText)findViewById(R.id.login_activity_etv_pw);
        btn_login = (Button) findViewById(R.id.login_activity_btn_login);
        btn_join = (Button) findViewById(R.id.login_activity_btn_join);

        btn_join.setOnClickListener(this);
        btn_login.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.login_activity_btn_join:
                Intent goJoinActivity = new Intent(LoginActivity.this,JoinActivity.class);
                startActivity(goJoinActivity);
                break;
            case R.id.login_activity_btn_login:
                id = etv_id.getText().toString();
                pw = etv_pw.getText().toString();

                Intent goMainActivity = new Intent(LoginActivity.this, MainActivity.class);
                startActivity(goMainActivity);
                break;
        }
    }
}
