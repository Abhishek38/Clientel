package com.example.testapp.ui.home;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.testapp.R;
import com.example.testapp.RecyclerClick;
import com.example.testapp.adapter.RecyclerAdapter;
import com.example.testapp.model.recycler_model;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment implements RecyclerClick {
    private final List<recycler_model> dataList=new ArrayList<>();
    RecyclerAdapter madapter;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_home, container, false);
        return root;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        PrepareData();
        Log.d("DebugAbhi","onViewCreated");
        RecyclerView recyclerView = view.findViewById(R.id.RecyclerView_Cosmetics);
        RecyclerAdapter madapter = new RecyclerAdapter(dataList, this);
        RecyclerView.LayoutManager mlayoutmanager=new LinearLayoutManager(getActivity(),LinearLayoutManager.HORIZONTAL,false);
        recyclerView.setAdapter(madapter);
        Log.d("DebugAbhi","Adapter has been set");


    }
    private void PrepareData(){
        recycler_model data=new recycler_model(
                "\"https://static2.srcdn.com/wordpress/wp-content/uploads/2017/01/Vegeta-in-Dragon-Ball-over-9000.jpg?q=50&fit=crop&w=740&h=370",
                "500",
                "15%");
        dataList.add(data);
        data=new recycler_model("https://static2.srcdn.com/wordpress/wp-content/uploads/2017/03/0.GohanKamehameha.jpg?q=50&fit=crop&w=740&h=370","230","10%");
        dataList.add(data);
        data=new recycler_model("https://www.istockphoto.com/photo/beauty-swatches-gm1135739022-302245781","450","20%");
        dataList.add(data);
        data=new recycler_model("https://www.istockphoto.com/photo/beauty-products-gm1150934901-311741936","750","10%");
        dataList.add(data);
        data=new recycler_model("https://www.istockphoto.com/photo/cosmetics-background-gm499889783-42884162","102","7%");
        dataList.add(data);
        data=new recycler_model("https://www.istockphoto.com/photo/pressed-powder-gm177847164-24328759","690","20%");
        dataList.add(data);
        data=new recycler_model("https://www.istockphoto.com/photo/pressed-powder-gm904720876-249490498","7850","26%");
        dataList.add(data);
        data=new recycler_model("https://www.istockphoto.com/photo/pressed-powder-gm904721004-249490497","5600","25%");
        dataList.add(data);
        data=new recycler_model("https://www.istockphoto.com/photo/pressed-powder-gm177748016-24148005","2601","50%");
        dataList.add(data);


        Log.d("DebugAbhi","Data reading successful");


    }


    @Override
    public void itemClick(recycler_model data, int i) {
        Toast.makeText(getContext(), data.getImgLink(), Toast.LENGTH_SHORT).show();

    }
}