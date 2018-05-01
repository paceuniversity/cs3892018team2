package ahmed.niaz.chinatown_tour;

import android.graphics.drawable.Drawable;
import android.widget.ImageView;

/**
 * Created by WilliamZhong on 5/1/18.
 */

public class BusObject {
    private String bus;
    private String description;
    private Drawable image;

    public String getBus() {
        return bus;
    }

    public void setBus(String bus) {
        this.bus = bus;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Drawable getImage() {
        return image;
    }

    public void setDay(Drawable day) {
        this.image = day;
    }

    public BusObject(String bus, String description, Drawable image) {
        this.bus = bus;
        this.description = description;
        this.image = image;
    }
}
