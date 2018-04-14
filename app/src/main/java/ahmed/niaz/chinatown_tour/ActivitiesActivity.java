package ahmed.niaz.chinatown_tour;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class ActivitiesActivity extends AppCompatActivity {


    private ImageView app_logo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activities);

        app_logo = (ImageView) findViewById(R.id.appIcon);

        // === LINK APP ICON TO MAIN MENU ====
        app_logo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ActivitiesActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });

    }
}
