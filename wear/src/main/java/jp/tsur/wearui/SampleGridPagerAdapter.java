package jp.tsur.wearui;


import android.app.Fragment;
import android.app.FragmentManager;
import android.support.wearable.view.CardFragment;
import android.support.wearable.view.FragmentGridPagerAdapter;

import java.util.ArrayList;
import java.util.List;

public class SampleGridPagerAdapter extends FragmentGridPagerAdapter {

    private List<Fragment> rows;

    public SampleGridPagerAdapter(FragmentManager fm) {
        super(fm);

        rows = new ArrayList<>();
        rows.add(CardFragment.create("タイトル", "テキスト"));
        rows.add(CardFragment.create("タイトル２", "テキスト２"));
        rows.add(new CustomCardFragment());
    }

    @Override
    public Fragment getFragment(int row, int col) {
        return rows.get(row);
    }

    @Override
    public int getRowCount() {
        return rows.size();
    }

    @Override
    public int getColumnCount(int rowNum) {
        return 1;
    }
}
