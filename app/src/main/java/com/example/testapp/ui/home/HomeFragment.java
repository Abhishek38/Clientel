package com.example.testapp.ui.home;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.testapp.R;
import com.example.testapp.RecyclerClick;
import com.example.testapp.adapter.Cos_RecyclerAdapter;
import com.example.testapp.model.recycler_model;
import com.google.android.material.bottomsheet.BottomSheetBehavior;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment implements RecyclerClick {
    public final List<recycler_model> dataList_cosmetics=new ArrayList<>();
    public final List<recycler_model> dataList_supplements=new ArrayList<>();
    public final List<recycler_model> dataList_medicine=new ArrayList<>();
    ConstraintLayout layout;

    BottomSheetBehavior<ConstraintLayout> bottomSheetBehavior;
    ImageView PrevImg;
    TextView namePro,Price;
    TextView quantity;
    Spinner spinner;




    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_home, container, false);
        return root;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
       PrepareDataForSupplements();
        PrepareDataforcosmetics();
        Log.d("DebugAbhi","onViewCreated");
        /*===============================================================================*/
        RecyclerView recyclerView_cosmetics = view.findViewById(R.id.RecyclerView_Cosmetics);
        RecyclerView recyclerView_supplements=view.findViewById(R.id.RecyclerView_Supplements);
        RecyclerView recyclerView_medicine=view.findViewById(R.id.RecyclerView_Medicines);
        /*===============================================================================*/
        Cos_RecyclerAdapter cos_adapter = new Cos_RecyclerAdapter(dataList_cosmetics, this);
        Cos_RecyclerAdapter sup_adapter=new Cos_RecyclerAdapter(dataList_supplements,this);
        Cos_RecyclerAdapter med_adapter=new Cos_RecyclerAdapter(dataList_supplements,this);
        /*===============================================================================*/
        RecyclerView.LayoutManager cos_layoutmanager=new LinearLayoutManager(getActivity(),LinearLayoutManager.HORIZONTAL,false);
        RecyclerView.LayoutManager sup_layoutmanager=new LinearLayoutManager(getActivity(),LinearLayoutManager.HORIZONTAL,false);
        RecyclerView.LayoutManager med_layoutmanager=new LinearLayoutManager(getActivity(),LinearLayoutManager.HORIZONTAL,false);
        /*===============================================================================*/
       recyclerView_cosmetics.setLayoutManager(cos_layoutmanager);
       recyclerView_supplements.setLayoutManager(sup_layoutmanager);
       recyclerView_medicine.setLayoutManager(med_layoutmanager);
        /*===============================================================================*/
        recyclerView_cosmetics.setAdapter(cos_adapter);
        recyclerView_supplements.setAdapter(sup_adapter);
        recyclerView_medicine.setAdapter(med_adapter);
        Log.d("DebugAbhi","Adapter has been set");
        /*===============================================================================*/
         PrevImg=view.findViewById(R.id.PreviewImage);
         namePro=view.findViewById(R.id.Name_of_product);
         quantity=view.findViewById(R.id.Quantity);
         spinner=view.findViewById(R.id.spinner);
         layout=view.findViewById(R.id.bottomSheet);
         Price=view.findViewById(R.id.priceamount);
         Button add2cart=view.findViewById(R.id.button2cart);


        Integer[] items = new Integer[]{1,2,3,4,5,6,7,8,9,10};
        ArrayAdapter<Integer> adapter = new ArrayAdapter<Integer>(getContext(),android.R.layout.simple_spinner_item, items);
        spinner.setAdapter(adapter);



         add2cart.setOnClickListener(v -> {
             if(bottomSheetBehavior.getState()==BottomSheetBehavior.STATE_EXPANDED){
                 bottomSheetBehavior.setState(BottomSheetBehavior.STATE_HIDDEN);
             }

         });





    }

    private  void PrepareDataforcosmetics(){
        recycler_model data=new recycler_model("https://i.redd.it/o3d32byv1z461.jpg",
                "500",
                "15%",
                "Complete Peach and Lily");
        dataList_cosmetics.add(data);
        data=new recycler_model("https://i.redd.it/tku58uvhas461.jpg","230","10%"," AB shelfie");
        dataList_cosmetics.add(data);
        data=new recycler_model("https://preview.redd.it/ug9q49o38z461.jpg?width=828&format=pjpg&auto=webp&s=fb0afa810a3acf44bb7e79716abc49699b17cdef","450","20%","Vitamin C");
        dataList_cosmetics.add(data);
        data=new recycler_model("https://preview.redd.it/x4dp4c05sq461.jpg?width=3024&format=pjpg&auto=webp&s=109fcbff4f581eeb08034c7a689b51b43fc3a2e2","750","10%","Korean skincare");
        dataList_cosmetics.add(data);
        data=new recycler_model("https://preview.redd.it/03jmnu7iqn461.jpg?width=2999&format=pjpg&auto=webp&s=211ab73c650b97184727e95acbf59866d9dfa9c4","102","7%","cleansers");
        dataList_cosmetics.add(data);
        data=new recycler_model("https://i.redd.it/iahhckcgan461.jpg","690","20%","propolis synergy toner!");
        dataList_cosmetics.add(data);
        data=new recycler_model("https://preview.redd.it/j5jhywv29p461.jpg?width=719&format=pjpg&auto=webp&s=b6cb54a51648d0e00a43be4dab0b31fc182f6545","7850","26%","Dr. Ceuracle Vegan Tea Kombucha Essence");
        dataList_cosmetics.add(data);
        data=new recycler_model("https://preview.redd.it/49ujsi7e47461.jpg?width=3024&format=pjpg&auto=webp&s=fcd9d2ad503eb1abe0c4a4aaad0f7284331f4eec","5600","25%"," Neogen Probiotics Relief cream");
        dataList_cosmetics.add(data);
        data=new recycler_model("https://i.redd.it/q9ejqmqx73461.jpg","2601","50%","Tony Moly Wonder Ceramide Toner");
        dataList_cosmetics.add(data);


        Log.d("DebugAbhi","Data reading successful");


    }
    private  void PrepareDataForSupplements(){
        recycler_model data= new recycler_model("https://i.imgur.com/mrkaAwX.jpeg","2500","10","GOD Whey");
        dataList_supplements.add(data);
        data=new recycler_model("https://i.imgur.com/6Qd3CPn.jpg","6000","10","ISO Pure");
        dataList_supplements.add(data);
        data=new recycler_model("https://images-na.ssl-images-amazon.com/images/I/7151vaVLcoL._SL1500_.jpg","2000","20","Nature Fresh fish oil capsule");
        dataList_supplements.add(data);
        data=new recycler_model("https://www.watsons.com.sg/medias/Omega-3-Fish-Oil-1000mg-60s-22996.jpg?context=bWFzdGVyfGZyb250L3pvb218MTA2NTMzfGltYWdlL2pwZWd8ZnJvbnQvem9vbS84OTkxNDEzMDEwNDYyLmpwZ3w5ODA3ZWE0ZDQyZTMyOWJlOTgxNmQxZmY1NDVkMTRhNGFmNjgyYTA3MTU5NzNhODgzMTAwNDFmZGU3ZTZhYTdm","2500","25","Omega#");
        dataList_supplements.add(data);
        data=new recycler_model("https://lh3.googleusercontent.com/xTa0eFVcqGpm9KyLx227OptQov51B0-UPEiazkN3rIkzKCPuMpISpuxtfEq5AoNjupKKfe-g=w1080-h608-p-no-v0","6000","10","Whey Protein");
        dataList_supplements.add(data);
        data=new recycler_model("https://5.imimg.com/data5/JE/KS/ZO/SELLER-68638023/m-strong-nutrition-mass-gainer-supplement-powder-500x500.jpg","5500","10","Mass Gainer");
        dataList_supplements.add(data);
        data=new recycler_model("https://miro.medium.com/max/500/0*UJ6KqDpFunzTAj7m.","1600","10","BCAA");
        dataList_supplements.add(data);
        data=new recycler_model("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRrq5AdYwo7eCkK2xYe4Yjr5sEMjIRim0UbDg&usqp=CAU","6000","15","Gain Bolic 6000");
        dataList_supplements.add(data);
        data=new recycler_model("https://media.karousell.com/media/photos/products/2018/04/03/gym_supplements_1522731210_c7b8353b.jpg","2500","10","Amino");
        dataList_supplements.add(data);
    }
    private void InitializeBottomSheet(){
        bottomSheetBehavior= BottomSheetBehavior.from(layout);
        bottomSheetBehavior.setState(BottomSheetBehavior.STATE_HALF_EXPANDED);

        bottomSheetBehavior.addBottomSheetCallback(new BottomSheetBehavior.BottomSheetCallback() {
            @Override
            public void onStateChanged(@NonNull View bottomSheet, int newState) {

            }

            @Override
            public void onSlide(@NonNull View bottomSheet, float slideOffset) {

            }
        });
    }


    @Override
    public void itemClick(recycler_model data, int i) {
        InitializeBottomSheet();
        RequestOptions options=new RequestOptions();
        Log.d("DebugAbhi","executing bind function");
        options.placeholder(R.drawable.ic_launcher_foreground)
                .error(R.drawable.ic_baseline_error_24);
        Glide.with(this)
                .applyDefaultRequestOptions(options)
                .asBitmap()
                .load(data.getImgLink())
                .into(PrevImg);
        namePro.setText(data.getName());
        Price.setText(data.getPrice());


    }
}