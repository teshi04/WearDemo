package jp.tsur.wearui;


import android.app.Fragment;
import android.app.FragmentManager;
import android.support.wearable.view.CardFragment;
import android.support.wearable.view.FragmentGridPagerAdapter;

import java.util.ArrayList;
import java.util.List;

public class SampleGridPagerAdapter extends FragmentGridPagerAdapter {

    private List<String> rows;

    public SampleGridPagerAdapter(FragmentManager fm) {
        super(fm);

        rows = new ArrayList<>();
        rows.add("おはよう");
        rows.add("こんにちは");
        rows.add("おやすみ");
    }

    @Override
    public Fragment getFragment(int row, int col) {
        String text = rows.get(row);

        switch (col) {
            case 0:
                return CardFragment.create("タイトル", text);
            case 1:
                return CardFragment.create("タイトル", "2ページ目");
            case 2:
                return CardFragment.create("タイトル", "3ページ目");
            default:
                return null;
        }
    }

    @Override
    public int getRowCount() {
        return rows.size();
    }

    @Override
    public int getColumnCount(int rowNum) {
        return 3;
    }
}
