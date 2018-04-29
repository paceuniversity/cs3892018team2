package ahmed.niaz.chinatown_tour.ActivitiesModel;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.media.Image;
import android.widget.ImageView;

/**
 * Created by WilliamZhong on 4/26/18.
 */

public class ActivitiesHeader {
    //public Drawable activity_image;
    public String activity_name;
    public String activity_type;

    public ActivitiesHeader(String activity_name, String activity_type) {
        //this.activity_image = activity_image;
        this.activity_name = activity_name;
        this.activity_type = activity_type;
    }
}
