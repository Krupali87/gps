package com.app.gpsphonelocator_new.adapter;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.app.gpsphonelocator_new.R;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.Marker;

public class CustomInfoWindowAdapter implements GoogleMap.InfoWindowAdapter {
    private final Activity context;

    public View getInfoContents(Marker marker) {
        return null;
    }

    public CustomInfoWindowAdapter(Activity activity) {
        this.context = activity;
    }

    public View getInfoWindow(Marker marker) {
        View inflate = this.context.getLayoutInflater().inflate(R.layout.custom_infor, (ViewGroup) null);
        ((TextView) inflate.findViewById(R.id.tvTitle)).setText(marker.getTitle());
        ((TextView) inflate.findViewById(R.id.tv_subtitle)).setText(marker.getSnippet());
        return inflate;
    }
}
