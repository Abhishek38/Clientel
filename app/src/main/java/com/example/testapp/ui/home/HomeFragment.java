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
       recyclerView.setLayoutManager(mlayoutmanager);
        recyclerView.setAdapter(madapter);
        Log.d("DebugAbhi","Adapter has been set");


    }
    private void PrepareData(){
        recycler_model data=new recycler_model("https://i.redd.it/o3d32byv1z461.jpg",
                "500",
                "15%",
                "Complete Peach and Lily");
        dataList.add(data);
        data=new recycler_model("https://i.redd.it/tku58uvhas461.jpg","230","10%"," AB shelfie");
        dataList.add(data);
        data=new recycler_model("https://preview.redd.it/ug9q49o38z461.jpg?width=828&format=pjpg&auto=webp&s=fb0afa810a3acf44bb7e79716abc49699b17cdef","450","20%","Vitamin C");
        dataList.add(data);
        data=new recycler_model("https://preview.redd.it/x4dp4c05sq461.jpg?width=3024&format=pjpg&auto=webp&s=109fcbff4f581eeb08034c7a689b51b43fc3a2e2","750","10%","Korean skincare");
        dataList.add(data);
        data=new recycler_model("https://preview.redd.it/03jmnu7iqn461.jpg?width=2999&format=pjpg&auto=webp&s=211ab73c650b97184727e95acbf59866d9dfa9c4","102","7%","cleansers");
        dataList.add(data);
        data=new recycler_model("https://i.redd.it/iahhckcgan461.jpg","690","20%","propolis synergy toner!");
        dataList.add(data);
        data=new recycler_model("https://preview.redd.it/j5jhywv29p461.jpg?width=719&format=pjpg&auto=webp&s=b6cb54a51648d0e00a43be4dab0b31fc182f6545","7850","26%","Dr. Ceuracle Vegan Tea Kombucha Essence");
        dataList.add(data);
        data=new recycler_model("https://preview.redd.it/49ujsi7e47461.jpg?width=3024&format=pjpg&auto=webp&s=fcd9d2ad503eb1abe0c4a4aaad0f7284331f4eec","5600","25%"," Neogen Probiotics Relief cream");
        dataList.add(data);
        data=new recycler_model("https://i.redd.it/q9ejqmqx73461.jpg","2601","50%","Tony Moly Wonder Ceramide Toner");
        dataList.add(data);


        Log.d("DebugAbhi","Data reading successful");


    }


    @Override
    public void itemClick(recycler_model data, int i) {
        Toast.makeText(getContext(), data.getImgLink(), Toast.LENGTH_SHORT).show();

    }
}