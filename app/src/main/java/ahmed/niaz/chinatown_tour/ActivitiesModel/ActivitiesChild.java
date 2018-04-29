package ahmed.niaz.chinatown_tour.ActivitiesModel;

import android.media.Image;
import android.widget.Button;

/**
 * Created by WilliamZhong on 4/26/18.
 */

public class ActivitiesChild {
    public String description;
    public Button phone;
    public Button website;

    public ActivitiesChild(String description) { //Button phone, Button website) {
        this.description = description;
        //this.phone = phone;
        //this.website = website;
    }
}
