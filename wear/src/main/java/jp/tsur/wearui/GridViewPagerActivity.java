package jp.tsur.wearui;

import android.app.Activity;
import android.os.Bundle;
import android.support.wearable.view.DotsPageIndicator;
import android.support.wearable.view.GridViewPager;

/**
 * Created by teshi on 2015/11/29.
 */
public class GridViewPagerActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid);

        GridViewPager pager = (GridViewPager) findViewById(R.id.pager);
        pager.setAdapter(new SampleGridPagerAdapter(getFragmentManager()));

        DotsPageIndicator indicator = (DotsPageIndicator) findViewById(R.id.indicator);
        indicator.setPager(pager);
    }
}
