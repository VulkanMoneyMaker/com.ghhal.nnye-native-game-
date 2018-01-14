package com.ghhal.nnye;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Button;

import com.ghhal.nnye.wheel.src.kankan.wheel.widget.OnWheelScrollListener;
import com.ghhal.nnye.wheel.src.kankan.wheel.widget.WheelView;

import java.util.ArrayList;
import java.util.Random;




public class GameActivity extends AppCompatActivity implements OnWheelScrollListener {

    private WheelView wheelView1;
    private WheelView wheelView2;
    private WheelView wheelView3;
    private WheelView wheelView4;
    private WheelView wheelView5;
    private Button playBtn;
    private ArrayList<Integer> list;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        wheelView1 = findViewById(R.id.wheel1);
        wheelView2 = findViewById(R.id.wheel2);
        wheelView3 = findViewById(R.id.wheel3);
//        wheelView4 = findViewById(R.id.wheel4);
//        wheelView5 = findViewById(R.id.wheel5);
        initSlots();
        playBtn = findViewById(R.id.btn_play);
        playBtn.setOnClickListener(__ -> pushPlay());

    }

    private void initSlots() {
        iniWheel(wheelView1,getList());
        iniWheel(wheelView2,getList());
        iniWheel(wheelView3,getList());
//        iniWheel(wheelView4,getList());
//        iniWheel(wheelView5,getList());
    }

    private ArrayList<Integer> getList(){
        if (list == null) {
            final ArrayList<Integer> list = new ArrayList<>();
            list.add(R.drawable.item1);
            list.add(R.drawable.item2);
            list.add(R.drawable.item3);
            list.add(R.drawable.item4);
            list.add(R.drawable.item5);
            list.add(R.drawable.item6);
            list.add(R.drawable.item7);
            list.add(R.drawable.item8);
            this.list = list;
        }

        return list;
    }

    private void iniWheel(WheelView wheelView, ArrayList<Integer> list) {
        wheelView.setViewAdapter(new GameAdapter(this, list));
        wheelView.setCurrentItem((int) (Math.random() * 10.0d));
        wheelView.setVisibleItems(4);
        wheelView.setCyclic(true);
        wheelView.setEnabled(false);
    }


    private void pushPlay() {
        Random random = new Random();
        wheelView1.scroll(((int) ((Math.random() * ((double) random.nextInt(30))) + 20.0d)) - 350, random.nextInt(3000) + 2000);
        wheelView2.scroll(((int) ((Math.random() * ((double) random.nextInt(30))) + 20.0d)) - 350, random.nextInt(3000) + 2000);
        wheelView3.scroll(((int) ((Math.random() * ((double) random.nextInt(30))) + 20.0d)) - 350, random.nextInt(3000) + 2000);
//        wheelView4.scroll(((int) ((Math.random() * ((double) random.nextInt(30))) + 20.0d)) - 350, random.nextInt(3000) + 2000);
//        wheelView5.scroll(((int) ((Math.random() * ((double) random.nextInt(30))) + 20.0d)) - 350, random.nextInt(3000) + 2000);
    }



    @Override
    public void onScrollingStarted(WheelView wheel) {

    }

    @Override
    public void onScrollingFinished(WheelView wheel) {
        Log.d("onScrollingFinished: ", String.valueOf(wheel.getCurrentItem()));
    }


}
