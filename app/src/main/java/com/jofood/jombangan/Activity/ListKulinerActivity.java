package com.jofood.jombangan.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;

import com.jofood.jombangan.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ListKulinerActivity extends AppCompatActivity {

    @BindView(R.id.cv)
    CardView cv;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.item_kuliner_layout);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.cv)
    public void onViewClicked() {
        intent=new Intent(ListKulinerActivity.this,DetailKulinerActivity.class);
        startActivity(intent);
    }
}
