package com.cobanogluhasan.swipetoshowbuttonrecycler;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.Toast;

import com.cobanogluhasan.swipetoshowbuttonrecycler.Adapter.MyAdapter;
import com.cobanogluhasan.swipetoshowbuttonrecycler.Helper.MyButtonClickListener;
import com.cobanogluhasan.swipetoshowbuttonrecycler.Helper.SwipeHelper;
import com.cobanogluhasan.swipetoshowbuttonrecycler.Model.Item;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    MyAdapter adapter;
    LinearLayoutManager layoutManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        recyclerView = (RecyclerView) findViewById(R.id.recycler_test);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);


        //adding swipe helper to recyclerview

        SwipeHelper swipeHelper = new SwipeHelper(this, recyclerView, 200) {
            @Override
            public void instantiateMyButton(RecyclerView.ViewHolder viewHolder, List<SwipeHelper.MyButton> buffer) {

                buffer.add(new MyButton(MainActivity.this,
                        "Delete",
                        15,
                        0,
                        Color.parseColor("#FF3C30"),
                                new MyButtonClickListener() {
                                    @Override
                                    public void onClick(int pos) {
                                        Toast.makeText(MainActivity.this, "Delete click bi", Toast.LENGTH_SHORT).show();
                                    }
                                }));
                buffer.add(new MyButton(MainActivity.this,
                        "Edit",
                        15,
                        R.drawable.ic_edit_24,
                        Color.parseColor("#FF9502"),
                        new MyButtonClickListener() {
                            @Override
                            public void onClick(int pos) {
                                Toast.makeText(MainActivity.this, "edittt click bi", Toast.LENGTH_SHORT).show();
                            }
                        }));



            }

        };



        generateItem();


    }

    private void generateItem() {
        List<Item> itemList = new ArrayList<>();
        for(int i=1;i<21;i++) {

            itemList.add(new Item("Pie 0 " + (i++), "1000$",
                    "https://www.planetware.com/wpimages/2020/02/france-in-pictures-beautiful-places-to-photograph-eiffel-tower.jpg"
                    ));

        }

        adapter = new MyAdapter(this, itemList);
        recyclerView.setAdapter(adapter);


    }
}