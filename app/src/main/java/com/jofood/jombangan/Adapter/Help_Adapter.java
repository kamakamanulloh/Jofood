package com.jofood.jombangan.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.jofood.jombangan.R;
import com.jofood.jombangan.model.Model_Help;
import com.jofood.jombangan.model.Model_Menu;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import de.hdodenhof.circleimageview.CircleImageView;

public class Help_Adapter extends RecyclerView.Adapter<Help_Adapter.ViewHolder> {
    List<Model_Help> modelData;


    private Context context;

    public Help_Adapter(Context context, ArrayList<Model_Help> modelData) {
        this.modelData = modelData;
        this.context = context;
    }

    public List<Model_Help> getModelData() {
        return modelData;
    }

    public void setModelData(List<Model_Help> modelData) {
        this.modelData = modelData;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.listhelp, viewGroup, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        final Model_Help data_menu = getModelData().get(i);
        Glide.with(context)
                .load(data_menu.getImage())
                .apply(new RequestOptions().override(50, 50))
                .into(viewHolder.imgItemPhoto);
        viewHolder.tvItemName.setText(data_menu.getJudul());
        viewHolder.tvItemRemarks.setText(data_menu.getTag());



    }

    @Override
    public int getItemCount() {
        return getModelData().size();
    }

    static

    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.img_item_photo)
        CircleImageView imgItemPhoto;
        @BindView(R.id.tv_item_name)
        TextView tvItemName;
        @BindView(R.id.tv_item_remarks)
        TextView tvItemRemarks;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }


}
