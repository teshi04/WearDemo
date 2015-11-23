package jp.tsur.wearui;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.wearable.view.WearableListView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by teshi on 2015/11/23.
 */
public class WearableListViewActivity extends Activity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        String[] menu = getResources().getStringArray(R.array.menu);

        WearableListView listView = (WearableListView) findViewById(R.id.list);
        listView.setAdapter(new Adapter(this, menu));
    }

    private static final class Adapter extends WearableListView.Adapter {

        private static String[] menu;
        private Context context;

        private Adapter(Context context, String[] data) {
            this.context = context;
            menu = data;
        }

        @Override
        public WearableListView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            return new WearableListView.ViewHolder(
                    LayoutInflater.from(context).inflate(R.layout.list_item, null));
        }

        @Override
        public void onBindViewHolder(WearableListView.ViewHolder holder, int position) {
            TextView view = (TextView) holder.itemView.findViewById(R.id.text);
            view.setText(menu[position]);
            holder.itemView.setTag(position);
        }

        @Override
        public int getItemCount() {
            return menu.length;
        }
    }
}
