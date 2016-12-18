package com.example.suryasolanki.matka;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.suryasolanki.matka.Adapters.RecylcerViewAdapter;
import com.example.suryasolanki.matka.Java.BidData;

import java.util.ArrayList;
import java.util.List;

public class HomeActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecylcerViewAdapter recylcerViewAdapter;
    private List<BidData> bidDataList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        recyclerView=(RecyclerView) findViewById(R.id.recyclerView);

        bidDataList=new ArrayList<>();
        recylcerViewAdapter=new RecylcerViewAdapter(this,bidDataList);

        RecyclerView.LayoutManager layoutManager=new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(recylcerViewAdapter);

        prepareBidData();
    }

    private void prepareBidData(){
        int thumbNail=R.mipmap.ic_launcher;

        BidData bidData=new BidData("Value 1",thumbNail);
        bidDataList.add(bidData);

        BidData bidData1=new BidData("Value 2",thumbNail);
        bidDataList.add(bidData1);

        BidData bidData2=new BidData("Value 3",thumbNail);
        bidDataList.add(bidData2);

        BidData bidData3=new BidData("Value 4",thumbNail);
        bidDataList.add(bidData3);

        BidData bidData4=new BidData("Value 5",thumbNail);
        bidDataList.add(bidData4);

        recylcerViewAdapter.notifyDataSetChanged();

    }
}
