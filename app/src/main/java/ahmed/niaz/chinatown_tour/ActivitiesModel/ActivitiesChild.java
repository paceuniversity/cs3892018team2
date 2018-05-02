package ahmed.niaz.chinatown_tour.ActivitiesModel;

import android.graphics.drawable.Drawable;
import android.media.Image;
import android.widget.Button;

/**
 * Created by WilliamZhong on 4/26/18.
 */


public class ActivitiesChild {
    public String phone;
    public String website;
    public String description;

    public ActivitiesChild(String website, String phone, String description) {
        this.phone = phone;
        this.website = website;
        this.description = description;
    }
}