package com.android.fragmentrecyclerviewdemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<DataModel> list = new ArrayList();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buildData();
        initRecyclerView();
    }

    private void initRecyclerView() {
        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);

        recyclerView.setLayoutManager(layoutManager);
        RecyclerViewAdapter adapter = new RecyclerViewAdapter();
        adapter.setDataList(list);

        ItemTouchHelper.Callback callback = new RecyclerRowMoveCallback(adapter);
        ItemTouchHelper touchHelper = new ItemTouchHelper(callback);
        touchHelper.attachToRecyclerView(recyclerView);

        recyclerView.setAdapter(adapter);
    }

    private void buildData() {
        list.add(new DataModel("Row -1"));
        list.add(new DataModel("Row -2"));
        list.add(new DataModel("Row -3"));
        list.add(new DataModel("Row -4"));
        list.add(new DataModel("Row -5"));
        list.add(new DataModel("Row -6"));
        list.add(new DataModel("Row -7"));
        list.add(new DataModel("Row -8"));

    }
}