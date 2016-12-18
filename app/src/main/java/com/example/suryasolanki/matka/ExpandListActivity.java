package com.example.suryasolanki.matka;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.suryasolanki.matka.Adapters.NewExtendedAdapter;

import java.util.ArrayList;
import java.util.List;

public class ExpandListActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private List<NewExtendedAdapter.Item> items=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_expand_list);
        recyclerView=(RecyclerView) findViewById(R.id.extendRecylerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));

        NewExtendedAdapter.Item fruits =new NewExtendedAdapter.Item("Fruits", NewExtendedAdapter.HEADER);
        fruits.invisibleChildren=new ArrayList<>();
        fruits.invisibleChildren.add(new NewExtendedAdapter.Item("Apple",NewExtendedAdapter.HEADER));
        fruits.invisibleChildren.add(new NewExtendedAdapter.Item("Orange",NewExtendedAdapter.HEADER));
        fruits.invisibleChildren.add(new NewExtendedAdapter.Item("Guava",NewExtendedAdapter.HEADER));
        fruits.invisibleChildren.add(new NewExtendedAdapter.Item("Grapes",NewExtendedAdapter.HEADER));
        fruits.invisibleChildren.add(new NewExtendedAdapter.Item("Mango",NewExtendedAdapter.HEADER));

        items.add(new NewExtendedAdapter.Item("Fruits",NewExtendedAdapter.HEADER));


        NewExtendedAdapter.Item places=new NewExtendedAdapter.Item("Places",NewExtendedAdapter.HEADER);
        places.invisibleChildren=new ArrayList<>();
        places.invisibleChildren.add(new NewExtendedAdapter.Item("India",NewExtendedAdapter.HEADER));
        places.invisibleChildren.add(new NewExtendedAdapter.Item("USA", NewExtendedAdapter.HEADER));
        places.invisibleChildren.add(new NewExtendedAdapter.Item("Australia",NewExtendedAdapter.HEADER));
        places.invisibleChildren.add(new NewExtendedAdapter.Item("Germany",NewExtendedAdapter.HEADER));
        places.invisibleChildren.add(new NewExtendedAdapter.Item("Ireland", NewExtendedAdapter.HEADER));
        NewExtendedAdapter.Item fruits1=new NewExtendedAdapter.Item("Fruits",NewExtendedAdapter.HEADER);


        items.add(places);

        recyclerView.setAdapter(new NewExtendedAdapter(items));


    }
}
