package com.example.nurdiansyah.sc3;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.GradientDrawable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class MineralAdapter extends RecyclerView.Adapter<MineralAdapter.ViewHolder>  {

    private ArrayList<Mineral> mMineralData;
    private Context mContext;


    MineralAdapter(Context context, ArrayList<Mineral> minData) {
        this.mMineralData = minData;
        this.mContext = context;
    }


    @Override
    public MineralAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(mContext).inflate(R.layout.list_gambar, parent, false));
    }


    @Override
    public void onBindViewHolder(MineralAdapter.ViewHolder holder, int position) {
        Mineral currentSport = mMineralData.get(position);
        holder.bindTo(currentSport);
    }



    @Override
    public int getItemCount() {
        return mMineralData.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private TextView mTitleText;
        private TextView mInfoText;
        private ImageView mMineralImage;
        private Mineral mCurrentMineral;
        private GradientDrawable mGradientDrawable;


        ViewHolder(View itemView) {
            super(itemView);

            mTitleText = (TextView)itemView.findViewById(R.id.title);
            mInfoText = (TextView)itemView.findViewById(R.id.subTitle);
            mMineralImage = (ImageView) itemView.findViewById(R.id.mineralimage);

            itemView.setOnClickListener(this);

        }

        void bindTo(Mineral currentMineral){

            mTitleText.setText(currentMineral.getTitle());
            mInfoText.setText(currentMineral.getInfo());
            mCurrentMineral = currentMineral;


            Glide.with(mContext).load(currentMineral.
                    getImageResource()).placeholder(mGradientDrawable).into(mMineralImage);

        }

        @Override
        public void onClick(View v) {


            Intent detailIntent = new Intent(mContext, DetailActivity.class);

            detailIntent.putExtra("title", mCurrentMineral.getTitle());
            detailIntent.putExtra("image_resource", mCurrentMineral.getImageResource());

            Mineral mCurrentMineral = mMineralData.get(getAdapterPosition());
            mContext.startActivity(detailIntent);


        }
    }
}