package ahmed.niaz.chinatown_tour;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import ahmed.niaz.chinatown_tour.ActivitiesModel.ActivitiesChild;
import ahmed.niaz.chinatown_tour.ActivitiesModel.ActivitiesHeader;
import iammert.com.expandablelib.ExpandableLayout;
import iammert.com.expandablelib.Section;


/*public class ActivitiesActivity extends AppCompatActivity {

    // === Main menu header ===
    private ImageView app_logo;
    public ImageButton settings_btn;


    //=== Specific variables ===
    public int activity_name_int;
    public int activity_type_int;
    public int activity_description_int;
    public int activity_image_int;
    public int activity_phone_int;
    public int activity_website_int;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activities);


        // === Renders parent and child expandable layout ===
        ExpandableLayout layout = (ExpandableLayout) findViewById(R.id.activities_expandable_layout);
        layout.setRenderer(new ExpandableLayout.Renderer<ActivitiesHeader, ActivitiesChild>() {
            @Override
            public void renderParent(View view, ActivitiesHeader activitiesHeader, boolean b, int i) {
                //((TextView) view.findViewById(R.id.activity_image)).setText(activitiesHeader.);
                ((TextView) view.findViewById(R.id.activity_names)).setText(activitiesHeader.activity_name);
                ((TextView) view.findViewById(R.id.activity_type)).setText(activitiesHeader.activity_type);
            }

            @Override
            public void renderChild(View view, ActivitiesChild activitiesChild, int i, int i1) {
                ((TextView) view.findViewById(R.id.textview_description)).setText(activitiesChild.description);
                ((TextView) view.findViewById(R.id.textview_website)).setText(activitiesChild.website);

                ((TextView) view.findViewById(R.id.textview_website)).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Uri uri = Uri.parse(getResources().getString(activity_website_int)); // missing 'http://' will cause crashed
                        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                        startActivity(intent);
                    }
                });

                ((TextView) view.findViewById(R.id.textview_phone)).setText(activitiesChild.phone);
                ((TextView) view.findViewById(R.id.textview_phone)).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(ActivitiesActivity.this,activity_phone_int,Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });


        // === Adds each section depending on variables passed ===
        layout.addSection(getSection((R.string.activity1_name),(R.string.activity1_type),(R.string.activity1_static),
                (R.string.activity1_website), (R.string.activity1_phone_number)));
        layout.addSection(getSection((R.string.activity2_name),(R.string.activity2_type),(R.string.activity2_static),
                (R.string.activity2_website), (R.string.activity2_phone_number)));

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
    private Section<ActivitiesHeader,ActivitiesChild> getSection(int name, int type, int description, int website, int phone) {
        activity_name_int = name;
        activity_type_int = type;
        activity_description_int = description;
        activity_website_int = website;
        activity_phone_int = phone;



        // === Converts ints to string/images ===
        //Drawable activity_image = getResources().getDrawable(activity_image_int);
        String activity_name = getResources().getString(activity_name_int);
        String activity_type = getResources().getString(activity_type_int);
        String activity_description = getResources().getString(activity_description_int);
        String activity_website = getResources().getString(activity_website_int);
        String activity_phone = getResources().getString(activity_phone_int);


        // === Creates header ===
        Section<ActivitiesHeader, ActivitiesChild> section = new Section<>();
        ActivitiesHeader activitiesHeader = new ActivitiesHeader(activity_name,activity_type);


        // === Creates child ===
        List<ActivitiesChild> listActivities = new ArrayList<>();
            listActivities.add(new ActivitiesChild(activity_description,activity_website,activity_phone));
            section.parent = activitiesHeader;
            section.children.addAll(listActivities);


        return section;
    }
}
*/

public class ActivitiesActivity extends AppCompatActivity {

    public int activity_name_int;
    public int activity_phone_int;
    public int activity_website_int;
    public int activity_image_int;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activities);


        ExpandableLayout layout = (ExpandableLayout) findViewById(R.id.activities_expandable_layout);
        layout.setRenderer(new ExpandableLayout.Renderer<ActivitiesHeader, ActivitiesChild>() {
            @Override
            public void renderParent(View view, ActivitiesHeader activitiesHeader, boolean b, int i) {
                ((TextView) view.findViewById(R.id.activity_names)).setText(activitiesHeader.activity_name);
                ((ImageView) view.findViewById(R.id.activity_image)).setImageDrawable(activitiesHeader.activity_image);
            }

            @Override
            public void renderChild(View view, final ActivitiesChild activitiesChild, final int i, int i1) {

                ((TextView) view.findViewById(R.id.textview_website)).setText(activitiesChild.website);
                ((TextView) view.findViewById(R.id.textview_website)).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(ActivitiesActivity.this,activitiesChild.website,Toast.LENGTH_SHORT).show();
                    }
                });

                ((TextView) view.findViewById(R.id.textview_phone)).setText(activitiesChild.phone);
                ((TextView) view.findViewById(R.id.textview_phone)).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        Toast.makeText(ActivitiesActivity.this, activitiesChild.phone, Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });


        layout.addSection(getSection((R.drawable.activity1_image1),(R.string.activity1_name), (R.string.activity1_website), (R.string.activity1_phone_number)));
        layout.addSection(getSection((R.drawable.activity2_image),(R.string.activity2_name), (R.string.activity2_website), (R.string.activity2_phone_number)));
    }


    // === Creates the List of Activities ===
    private Section<ActivitiesHeader,ActivitiesChild> getSection(int image, int name, int website, int phone) {
        activity_name_int = name;
        activity_website_int = website;
        activity_phone_int = phone;
        activity_image_int = image;

        String activity_name = getResources().getString(activity_name_int);
        String activity_website = getResources().getString(activity_website_int);
        String activity_phone = getResources().getString(activity_phone_int);
        Drawable activity_image = getResources().getDrawable(activity_image_int);


        Section<ActivitiesHeader, ActivitiesChild> section = new Section<>();
        ActivitiesHeader activitiesHeader = new ActivitiesHeader(activity_image, activity_name);


        List<ActivitiesChild> listActivities = new ArrayList<>();
        listActivities.add(new ActivitiesChild(activity_website,activity_phone));
        section.parent = activitiesHeader;
        section.children.addAll(listActivities);


        return section;
    }
}