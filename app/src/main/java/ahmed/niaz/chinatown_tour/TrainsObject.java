package ahmed.niaz.chinatown_tour;

import android.graphics.drawable.Drawable;

/**
 * Created by WilliamZhong on 5/1/18.
 */

public class TrainsObject {
    private String station;
    private String trains;
    private String description;
    private Drawable image;

    public TrainsObject(String station, String trains, String description, Drawable image) {
        this.station = station;
        this.trains = trains;
        this.description = description;
        this.image = image;
    }

    public String getStation() {
        return station;
    }

    public void setStation(String station) {
        this.station = station;
    }

    public String getTrains() {
        return trains;
    }

    public void setTrains(String trains) {
        this.trains = trains;
    }

    public String getDecription() {
        return description;
    }

    public void setDecription(String decription) {
        this.description = decription;
    }

    public Drawable getImage() {
        return image;
    }

    public void setImage(Drawable image) {
        this.image = image;
    }
}
