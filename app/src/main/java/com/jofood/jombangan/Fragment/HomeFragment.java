package com.jofood.jombangan.Fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.daimajia.slider.library.Animations.DescriptionAnimation;
import com.daimajia.slider.library.SliderLayout;
import com.daimajia.slider.library.SliderTypes.BaseSliderView;
import com.daimajia.slider.library.SliderTypes.TextSliderView;
import com.jofood.jombangan.Activity.KulinerActivity;
import com.jofood.jombangan.R;
import com.jofood.jombangan.model.Model_Menu;

import java.util.ArrayList;
import java.util.HashMap;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {
    Intent intent;


    Unbinder unbinder;
    @BindView(R.id.btnkuliner)
    LinearLayout btnkuliner;
    @BindView(R.id.btnterdekat)
    LinearLayout btnterdekat;
    @BindView(R.id.btnfav)
    LinearLayout btnfav;

    //    @BindView(R.id.layout2)
//    LinearLayout layout2;
//    @BindView(R.id.layout)
//    LinearLayout layout;
//    @BindView(R.id.layout1)
//    LinearLayout layout1;
//    @BindView(R.id.frame)
//    FrameLayout frame;
    private ArrayList<Model_Menu> list;
    private SliderLayout sliderLayout;

    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.menulayout, container, false);
        unbinder = ButterKnife.bind(this, v);
//        tv.setHasFixedSize(true);


//        list = new ArrayList<Model_Menu>();
//        list.addAll(Data_Menu.getListData());
//
//        tv.setLayoutManager(new GridLayoutManager(getContext(),3));
//        Menu_Adapter adapter_lagu = new Menu_Adapter(getContext(),list);
//        adapter_lagu.setModelData(list);
//        tv.setAdapter(adapter_lagu);

        sliderLayout = (SliderLayout) v.findViewById(R.id.slider);

//        // Load image dari URL
//        HashMap<String, String> url_maps = new HashMap<String, String>();
//        url_maps.put("Wisata Gunung Rinjani", "http://www.lomboktourplus.com/wp-content/uploads/2017/01/Pesona-Gunung-Rinjani-Bak-Surga-Yang-Terlihat-wisata-lombok-lomboktourplus.jpg");
//        url_maps.put("Pantai Kuta Lombok", "http://www.ninabarbosa.com/wp-content/uploads/2017/05/pantai-kuta-lombok.png");
//        url_maps.put("Pantai Sekotong", "http://www.jacktarsuperyachtcharter.com/wp-content/uploads/2013/10/Lombok-Island.jpg");
//        url_maps.put("Bukit Sembalun", "http://www.lombokwandertour.com/images/Artikel - Bukit Selong/Sembalun.jpg");

        // Load Image Dari res/drawable
        HashMap<String, Integer> file_maps = new HashMap<String, Integer>();
        file_maps.put("JoFood Aplikasi Kuliner", R.drawable.splashjofoodnew);
        file_maps.put("", R.drawable.pagi);
        file_maps.put("", R.drawable.siang);
        file_maps.put("", R.drawable.malam);

        for (String name : file_maps.keySet()) {
            TextSliderView textSliderView = new TextSliderView(getContext());

            // initialize a SliderLayout
            textSliderView
                    .description(name)
                    .image(file_maps.get(name))
                    .setScaleType(BaseSliderView.ScaleType.Fit);

            //add your extra information
            textSliderView.bundle(new Bundle());
            textSliderView.getBundle()
                    .putString("extra", name);
            sliderLayout.addSlider(textSliderView);
        }

        sliderLayout.setPresetTransformer(SliderLayout.Transformer.Accordion);
        sliderLayout.setPresetIndicator(SliderLayout.PresetIndicators.Center_Bottom);
        sliderLayout.setCustomAnimation(new DescriptionAnimation());
        sliderLayout.setDuration(4000);
        return v;
    }
//
//    public void hotel_event(View view) {
//        Intent intent = new Intent(DashboardActivity.this, ListSummaryWisataActivity.class);
//        startActivity(intent);
//    }

    private void showRecyclerGrid() {

    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnClick({R.id.btnkuliner, R.id.btnterdekat, R.id.btnfav})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btnkuliner:
                intent=new Intent(getContext(), KulinerActivity.class);
                startActivity(intent);

                break;
            case R.id.btnterdekat:
                break;
            case R.id.btnfav:
                break;
        }
    }
}
