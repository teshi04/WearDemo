package jp.tsur.wearui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.wearable.view.WearableListView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;

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
        final List<MenuItem> menuItems = new ArrayList<>();
        menuItems.add(new MenuItem("CircularButton", new Intent(this, CircularButtonActivity.class)));
        menuItems.add(new MenuItem("ActionLabel", new Intent(this, ActionLabelActivity.class)));
        menuItems.add(new MenuItem("ConfirmationActivity", new Intent(this, ConfirmationActivityActivity.class)));
        menuItems.add(new MenuItem("DelayedConfirmationView", new Intent(this, DelayedConfirmationViewActivity.class)));
        menuItems.add(new MenuItem("CircularImageView", new Intent(this, CircularImageViewActivity.class)));
        menuItems.add(new MenuItem("CardFrame", new Intent(this, CardFrameActivity.class)));
        menuItems.add(new MenuItem("ProgressSpinner", new Intent(this, ProgressSpinnerActivity.class)));
        menuItems.add(new MenuItem("BoxInsetLayout", new Intent(this, BoxInsetLayoutActivity.class)));
        menuItems.add(new MenuItem("WearableFrameLayout", new Intent(this, WearableFrameLayoutActivity.class)));

        listView.setAdapter(new Adapter(this, menuItems));
        listView.setClickListener(new WearableListView.ClickListener() {
            @Override
            public void onClick(WearableListView.ViewHolder viewHolder) {
                int position = viewHolder.getAdapterPosition();
                startActivity(menuItems.get(position).getIntent());
            }

            @Override
            public void onTopEmptyRegionClick() {

            }
        });
    }

    private static final class Adapter extends WearableListView.Adapter {

        private List<MenuItem> menuItems;
        private Context context;

        private Adapter(Context context, List<MenuItem> data) {
            this.context = context;
            menuItems = data;
        }

        @Override
        public WearableListView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            return new WearableListView.ViewHolder(
                    LayoutInflater.from(context).inflate(R.layout.list_item, parent, false));
        }

        @Override
        public void onBindViewHolder(WearableListView.ViewHolder holder, int position) {
            TextView view = (TextView) holder.itemView.findViewById(R.id.text);
            view.setText(menuItems.get(position).getTitle());
            holder.itemView.setTag(position);
        }

        @Override
        public int getItemCount() {
            return menuItems.size();
        }
    }

    private class MenuItem {
        private String title;

        private Intent intent;

        public MenuItem(String title, Intent intent) {
            this.title = title;
            this.intent = intent;
        }

        public String getTitle() {
            return title;
        }

        public Intent getIntent() {
            return intent;
        }
    }
}
