package jp.tsur.wearui;

import android.app.Activity;
import android.os.Bundle;
import android.support.wearable.view.DelayedConfirmationView;
import android.view.View;
import android.widget.Toast;

/**
 * Created by teshi on 2015/11/24.
 */
public class DelayedConfirmationViewActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delayed_confirmation);

        DelayedConfirmationView delayedConfirmationView =
                (DelayedConfirmationView) findViewById(R.id.delayed_confirmation_view);

        delayedConfirmationView.setTotalTimeMs(5000);
        delayedConfirmationView.setListener(new DelayedConfirmationView.DelayedConfirmationListener() {
            @Override
            public void onTimerFinished(View view) {
                Toast.makeText(DelayedConfirmationViewActivity.this, "Finished!!", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onTimerSelected(View view) {
                // DelayedConfirmationView がタップされると呼ばれる
            }
        });
        delayedConfirmationView.start();
    }
}
