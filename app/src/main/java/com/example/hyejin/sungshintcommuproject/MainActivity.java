package com.example.hyejin.sungshintcommuproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.hyejin.sungshintcommuproject.CommunityService.FeedActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btn_goFeedActivity;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_goFeedActivity = (Button)findViewById(R.id.main_activity_go_feed_btn);
        btn_goFeedActivity.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.main_activity_go_feed_btn:
                Intent goFeed = new Intent(MainActivity.this, FeedActivity.class);
                startActivity(goFeed);
                break;
        }
    }
}
