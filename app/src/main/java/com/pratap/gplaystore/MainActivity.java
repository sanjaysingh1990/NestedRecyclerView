package com.pratap.gplaystore;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import com.pratap.gplaystore.adapters.RecyclerViewDataAdapter;
import com.pratap.gplaystore.adapters.ViewPagerAdapter;
import com.pratap.gplaystore.models.SectionDataModel;
import com.pratap.gplaystore.models.SingleItemModel;

import java.util.ArrayList;

import android.view.View;

public class MainActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private View mViewIndicator1;
    private View mViewIndicator2;
    private View mViewIndicator3;



    ArrayList<SectionDataModel> allSampleData;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mViewIndicator1 = findViewById(R.id.view_indicator1);
        mViewIndicator2 = findViewById(R.id.view_indicator2);
        mViewIndicator3 = findViewById(R.id.view_indicator3);

        toolbar = (Toolbar) findViewById(R.id.toolbar);

        allSampleData = new ArrayList<SectionDataModel>();

        if (toolbar != null) {
            setSupportActionBar(toolbar);
            toolbar.setTitle("G PlayStore");

        }


        createDummyData();


        RecyclerView my_recycler_view = (RecyclerView) findViewById(R.id.my_recycler_view);

        my_recycler_view.setHasFixedSize(true);

        RecyclerViewDataAdapter adapter = new RecyclerViewDataAdapter(this, allSampleData);
        my_recycler_view.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        my_recycler_view.setAdapter(adapter);

        ArrayList<String> items = new ArrayList<>();
        items.add("https://www.wingilariver.com/sysimg/media-box-image-lone-butte-casino-dining-food-court-6010-6013-image.jpg");
        items.add("http://www.charlesriverhealth.org/wp-content/uploads/2017/03/Vegetables.jpg");
        items.add("https://www.wingilariver.com/sysimg/media-box-image-lone-butte-casino-dining-food-court-6010-6012-image.jpg");

        //item view pager
        ViewPagerAdapter mAdapter = new ViewPagerAdapter(this, items);
        ViewPager viewPager = (ViewPager) findViewById(R.id.viewpager);
        viewPager.setAdapter(mAdapter);
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
               resetIndicator(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

    }

    private void resetIndicator(int pos) {
        mViewIndicator1.setBackgroundColor(Color.parseColor("#4DFFFFFF"));
        mViewIndicator2.setBackgroundColor(Color.parseColor("#4DFFFFFF"));
        mViewIndicator3.setBackgroundColor(Color.parseColor("#4DFFFFFF"));
        if (pos == 0) {
            mViewIndicator1.setBackgroundColor(Color.parseColor("#FFFFFF"));


        } else if (pos == 1) {
            mViewIndicator2.setBackgroundColor(Color.parseColor("#FFFFFF"));

        } else {
            mViewIndicator3.setBackgroundColor(Color.parseColor("#FFFFFF"));

        }
    }

    public void createDummyData() {
        for (int i = 1; i <= 3; i++) {

            SectionDataModel dm = new SectionDataModel();
            if(i==1)
            dm.setHeaderTitle("Delivery within 3 min");
            else if(i==2)
            {
                dm.setHeaderTitle("Delivery within 2 min");

            }
            else {
                dm.setHeaderTitle("Delivery within 1 min");

            }
            ArrayList<SingleItemModel> singleItem = new ArrayList<SingleItemModel>();
            for (int j = 0; j <= 5; j++) {
                singleItem.add(new SingleItemModel("Item " + j, "URL " + j));
            }

            dm.setAllItemsInSection(singleItem);

            allSampleData.add(dm);

        }
    }
}
