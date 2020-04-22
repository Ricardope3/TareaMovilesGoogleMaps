package com.example.googlemapstarea;
import com.google.android.gms.maps.model.LatLng;

import java.io.Serializable;

public class Ubicacion  implements Serializable {
    double lat;
    double lng;

    public Ubicacion(double lat, double lng) {
        this.lat = lat;
        this.lng = lng;
    }

    @Override
    public String toString() {
        return "Ubicacion{" +
                "lat=" + lat +
                ", lng=" + lng +
                '}';
    }
}
