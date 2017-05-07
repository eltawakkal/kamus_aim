package com.myambukances.finalday;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

/**
 * Created by eltawakkal on 5/6/17.
 */

public class DetailActivity extends AppCompatActivity {

    TextView txtArti, txtDesc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        txtArti = (TextView) findViewById(R.id.txtArti);
        txtDesc = (TextView) findViewById(R.id.txtDesc);

        getSupportActionBar().setTitle(getIntent().getStringExtra("kosakata"));

        String arti, des;
        arti = getIntent().getStringExtra("arti");
        des = getIntent().getStringExtra("desc");

        txtArti.setText(arti);
        txtDesc.setText(des);

    }
}
