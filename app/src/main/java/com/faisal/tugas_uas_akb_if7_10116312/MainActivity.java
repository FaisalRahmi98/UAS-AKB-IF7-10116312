package com.faisal.tugas_uas_akb_if7_10116312;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.faisal.tugas_uas_akb_if7_10116312.fragments.PageFragment1;
import com.faisal.tugas_uas_akb_if7_10116312.fragments.PageFragment2;
import com.faisal.tugas_uas_akb_if7_10116312.fragments.PageFragment3;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ViewPager pager;
    private PagerAdapter pagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        List<Fragment> list = new ArrayList<>();
        list.add(new PageFragment1());
        list.add(new PageFragment2());
        list.add(new PageFragment3());

        pager = findViewById(R.id.pager);
        pagerAdapter = new SlidePagerAdapter(getSupportFragmentManager(),list);

        pager.setAdapter(pagerAdapter);
    }

    public void openMasuk(View view) {
        Intent intent = new Intent(MainActivity.this, MasukActivity.class);
        startActivity(intent);
        finish();
    }
}
