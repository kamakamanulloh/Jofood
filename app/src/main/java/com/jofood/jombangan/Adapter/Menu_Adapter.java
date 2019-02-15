package com.jofood.jombangan.Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.jofood.jombangan.Activity.ListKulinerActivity;
import com.jofood.jombangan.R;
import com.jofood.jombangan.model.Data_Menu;
import com.jofood.jombangan.model.Model_Menu;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Menu_Adapter extends RecyclerView.Adapter<Menu_Adapter.ViewHolder> {

    List<Model_Menu> modelData;

    public Menu_Adapter(Context context, ArrayList<Model_Menu> list) {
        this.context = context;
    }

    private Context context;

    public List<Model_Menu> getModelData() {
        return modelData;
    }

    public void setModelData(List<Model_Menu> modelData) {
        this.modelData = modelData;
    }

    public Menu_Adapter(List<Model_Menu> modelData) {
        this.modelData = modelData;

    }

    @NonNull
    @Override


    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.listmenu, viewGroup, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder viewHolder, int i) {
        final Model_Menu data_menu = getModelData().get(i);
        Glide.with(context)
                .load(data_menu.getImage())
                .apply(new RequestOptions().override(50, 50))
                .into(viewHolder.imgItemPhoto);
        viewHolder.txtjudul.setText(data_menu.getJudul());
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(viewHolder.itemView.getContext(), ListKulinerActivity.class);
                viewHolder.itemView.getContext().startActivity(intent);
            }
        });


    }

    @Override
    public int getItemCount() {
        return getModelData().size();
    }

    static

    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.img_item_photo)
        ImageView imgItemPhoto;
        @BindView(R.id.txtjudul)
        TextView txtjudul;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }


}
