package com.example.nurdiansyah.sc3;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

public class  DetailActivity extends AppCompatActivity {

    int count = 0;
    int angka1, angka2;
    int counts = 6;
    TextView levelbatre;
    ImageView batre, plus, minus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        TextView mineralTitle = (TextView)findViewById(R.id.titledetail);
        ImageView mineralImage = (ImageView)findViewById(R.id.mineralimagedetail);
        TextView mineralsub =(TextView)findViewById(R.id.subTitledetail);

        Drawable drawable = ContextCompat.getDrawable
                (this,getIntent().getIntExtra("image_resource", 0));

        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(Color.GRAY);

        if(drawable!=null) {
            gradientDrawable.setSize(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        }

        mineralTitle.setText(getIntent().getStringExtra("title"));

        Glide.with(this).load(getIntent().getIntExtra("image_resource",0))
                .into(mineralImage);

        Toast.makeText(DetailActivity.this,"Dikit nih",Toast.LENGTH_LONG).show();

        batre = (ImageView)findViewById(R.id.gambarbatre);
        plus = (ImageView)findViewById(R.id.tambah);
        minus = (ImageView)findViewById(R.id.kurang);
        levelbatre = (TextView)findViewById(R.id.level);

        plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (view.getId()){
                    case R.id.tambah:
                        batre.setImageLevel(count);
                        count++;
                        angka1 = count;
                        final String hasil = String.valueOf(angka1);
                        levelbatre.setText(hasil);

                        if(count>=7){
                            count=6;
                            Toast.makeText(DetailActivity.this,"Full cuy, luber dah",Toast.LENGTH_LONG).show();
                            count=1;
                        }
                        break;


                    default:
                        break;
                }

            }
        });

        minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (view.getId()){
                    case R.id.kurang:
                        batre.setImageLevel(counts);
                        counts--;
                        angka2 = counts;
                        final String hasil = String.valueOf(angka2);
                        levelbatre.setText(hasil);
                        if (counts<1){
                            counts = 0;
                            Toast.makeText(DetailActivity.this,"Air Sedikit",Toast.LENGTH_LONG).show();
                            counts =6;
                        }
                        break;

                    default:
                        break;
                }
            }
        });
    }

}
