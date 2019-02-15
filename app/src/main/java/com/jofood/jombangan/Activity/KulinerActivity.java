package com.jofood.jombangan.Activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.jofood.jombangan.Adapter.Menu_Adapter;
import com.jofood.jombangan.R;
import com.jofood.jombangan.model.Data_Menu;
import com.jofood.jombangan.model.Model_Menu;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class KulinerActivity extends AppCompatActivity {

    @BindView(R.id.tv)
    RecyclerView tv;
    private ArrayList<Model_Menu> list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kuliner);
        ButterKnife.bind(this);
        tv.setHasFixedSize(true);



        list = new ArrayList<Model_Menu>();
        list.addAll(Data_Menu.getListData());

        tv.setLayoutManager(new GridLayoutManager(this,3));
        Menu_Adapter adapter_lagu = new Menu_Adapter(this,list);
        adapter_lagu.setModelData(list);
        tv.setAdapter(adapter_lagu);

    }
}
