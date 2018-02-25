package com.example.nurdiansyah.sc3;

import android.content.res.TypedArray;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.View;

import java.util.ArrayList;
import java.util.Collections;

public class MainActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private ArrayList<Mineral> mMineralData;
    private MineralAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        mRecyclerView = (RecyclerView)findViewById(R.id.recyclerView);

        int gridColumnCount = getResources().getInteger(R.integer.grid_column_count);

        //Set the Layout Manager
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        mRecyclerView.setLayoutManager(new GridLayoutManager(this, gridColumnCount));

        //Initialize the ArrayLIst that will contain the data
        mMineralData = new ArrayList<>();

        //Initialize the adapter and set it ot the RecyclerView
        mAdapter = new MineralAdapter(this, mMineralData);
        mRecyclerView.setAdapter(mAdapter);

        //Get the data
        initializeData();


        int swipeDirs;
        if(gridColumnCount > 1){
            swipeDirs = 0;
        } else {
            swipeDirs = ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT;
        }
        ItemTouchHelper helper = new ItemTouchHelper(new ItemTouchHelper.SimpleCallback
                ( ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT | ItemTouchHelper.DOWN | ItemTouchHelper.UP
                        , swipeDirs) {

            @Override
            public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target) {


                int from = viewHolder.getAdapterPosition();
                int to = target.getAdapterPosition();

                Collections.swap(mMineralData, from, to);
                mAdapter.notifyItemMoved(from, to);

                return false;
            }

            @Override
            public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction) {
                mMineralData.remove(viewHolder.getAdapterPosition());
                mAdapter.notifyItemRemoved(viewHolder.getAdapterPosition());
            }
        });
        helper.attachToRecyclerView(mRecyclerView);
    }

    /**
     * Method for initializing the mineral data from resources.
     */
    private void initializeData() {
        //Get the resources from the XML file
        String[] sportsList = getResources().getStringArray(R.array.mineral_titles);
        String[] sportsInfo = getResources().getStringArray(R.array.mineral_info);

        //Clear the existing data (to avoid duplication)
        mMineralData.clear();

        TypedArray sportsImageResources =
                getResources().obtainTypedArray(R.array.mineral_images);

        //Create the ArrayList of mineral objects with the titles and information about each mineral
        for(int i=0;i<sportsList.length;i++){
            mMineralData.add(new Mineral(sportsList[i],sportsInfo[i],
                    sportsImageResources.getResourceId(i,0)));

        }

        //Notify the adapter of the change
        mAdapter.notifyDataSetChanged();
    }
    public void resetMineral(View view) {
        initializeData();
    }
}
