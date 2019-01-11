package dg.bin.com.banner_viewpager.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import dg.bin.com.banner_viewpager.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        startActivity(new Intent(this, OrdinaryViewPagerActivity.class));
//        startActivity(new Intent(this, CirculationViewPagerActivity.class));
//        startActivity(new Intent(this, AutomaticCirculationViewPagerActivity.class));
        startActivity(new Intent(this, OnePageMoreViewViewPagerActivity.class));
    }
}
