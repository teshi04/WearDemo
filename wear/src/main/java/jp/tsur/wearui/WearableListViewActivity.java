package jp.tsur.wearui;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.wearable.view.WearableListView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by teshi on 2015/11/23.
 */
public class WearableListViewActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        WearableListView listView = (WearableListView) findViewById(R.id.list);
        final List<String> items = new ArrayList<>();
        items.add("List Item 1");
        items.add("List Item 2");
        items.add("List Item 3");

        listView.setAdapter(new Adapter(this, items));
        listView.setClickListener(new WearableListView.ClickListener() {
            @Override
            public void onClick(WearableListView.ViewHolder viewHolder) {
                int position = viewHolder.getAdapterPosition();
                Toast.makeText(WearableListViewActivity.this,
                        items.get(position), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onTopEmptyRegionClick() {
                // リストの上部をタップしたときに呼ばれる
            }
        });
    }

    private static class Adapter extends WearableListView.Adapter {

        private List<String> items;
        private LayoutInflater inflater;

        private Adapter(Context context, List<String> data) {
            inflater = LayoutInflater.from(context);
            items = data;
        }

        @Override
        public WearableListView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            return new WearableListView.ViewHolder(
                    inflater.inflate(R.layout.list_item, parent, false));
        }

        @Override
        public void onBindViewHolder(WearableListView.ViewHolder holder, int position) {
            TextView view = (TextView) holder.itemView.findViewById(R.id.text);
            view.setText(items.get(position));
        }

        @Override
        public int getItemCount() {
            return items.size();
        }
    }
}
