package com.jofood.jombangan.Fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jofood.jombangan.Adapter.Help_Adapter;
import com.jofood.jombangan.Adapter.Menu_Adapter;
import com.jofood.jombangan.R;
import com.jofood.jombangan.model.Data_Help;
import com.jofood.jombangan.model.Data_Menu;
import com.jofood.jombangan.model.Model_Help;
import com.jofood.jombangan.model.Model_Menu;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class HelpFragment extends Fragment {


    @BindView(R.id.rv)
    RecyclerView rv;
    Unbinder unbinder;
    private ArrayList<Model_Help> list;

    public HelpFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_help, container, false);
        unbinder = ButterKnife.bind(this, v);
        rv.setHasFixedSize(true);



        list = new ArrayList<Model_Help>();
        list.addAll(Data_Help.getListData());

        rv.setLayoutManager(new LinearLayoutManager(getContext()));
        Help_Adapter adapter_lagu = new Help_Adapter(getContext(),list);
        adapter_lagu.setModelData(list);
        rv.setAdapter(adapter_lagu);

        return v;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
