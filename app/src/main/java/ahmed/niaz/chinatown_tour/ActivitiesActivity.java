package ahmed.niaz.chinatown_tour;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.media.Image;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import ahmed.niaz.chinatown_tour.ActivitiesModel.ActivitiesChild;
import ahmed.niaz.chinatown_tour.ActivitiesModel.ActivitiesHeader;
import iammert.com.expandablelib.ExpandableLayout;
import iammert.com.expandablelib.Section;


public class ActivitiesActivity extends AppCompatActivity {

    // === Main menu header ===
    private ImageView app_logo;
    public ImageButton settings_btn;


    //=== Specific variables ===
    public int activity_name_int;
    public int activity_type_int;
    public int activity_description_int;
    public int activity_image_int;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activities);


        // === Renders parent and child expandable layout ===
        ExpandableLayout layout = (ExpandableLayout) findViewById(R.id.activities_expandable_layout);
        layout.setRenderer(new ExpandableLayout.Renderer<ActivitiesHeader, ActivitiesChild>() {
            @Override
            public void renderParent(View view, ActivitiesHeader activitiesHeader, boolean b, int i) {
                ((TextView) view.findViewById(R.id.activity_names)).setText(activitiesHeader.activity_name);
                ((TextView) view.findViewById(R.id.activity_type)).setText(activitiesHeader.activity_type);
                //((ImageView) view.findViewById(R.id.activity_image)).setImageDrawable(activitiesHeader.activity_image);
            }

            @Override
            public void renderChild(View view, ActivitiesChild activitiesChild, int i, int i1) {
                ((TextView) view.findViewById(R.id.textview_description)).setText(activitiesChild.description);
                //((Button) view.findViewById(R.id.button_phone)).setText(activitiesChild.phone);
                //((Button) view.findViewById(R.id.button_website)).setText(activitiesChild.website);
            }
        });


        // === Adds each section depending on variables passed ===
        layout.addSection(getSection((R.string.activity1_name),(R.string.activity1_type),(R.string.activity1_static)));
        layout.addSection(getSection((R.string.activity2_name),(R.string.activity2_type),(R.string.activity2_static)));
        layout.addSection(getSection((R.string.activity3_name),(R.string.activity3_type),(R.string.activity3_static)));


        app_logo = (ImageView) findViewById(R.id.appIcon);
        // === Main Menu Link ===
        app_logo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ActivitiesActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });


        // === Settings Icon Link ===
        settings_btn = (ImageButton) findViewById(R.id.setting_image_button);
        settings_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ActivitiesActivity.this, SettingsActivity.class);
                startActivity(intent);
            }
        });
    }



    // === Creates the List of Activities ===
    private Section<ActivitiesHeader,ActivitiesChild> getSection(int name, int type, int description) {
        //activity_image_int = image;
        activity_name_int = name;
        activity_type_int = type;
        activity_description_int = description;


        // === Converts ints to strings ===
        //Drawable activity_image = getResources().getDrawable(activity_image_int);
        String activity_name = getResources().getString(activity_name_int);
        String activity_type = getResources().getString(activity_type_int);
        String activity_description = getResources().getString(activity_description_int);


        // === Creates header ===
        Section<ActivitiesHeader, ActivitiesChild> section = new Section<>();
        ActivitiesHeader activitiesHeader = new ActivitiesHeader(activity_name,activity_type);


        // === Creates child ===
        List<ActivitiesChild> listActivities = new ArrayList<>();
            listActivities.add(new ActivitiesChild(activity_description));
            section.parent = activitiesHeader;
            section.children.addAll(listActivities);
        return section;
    }
}
