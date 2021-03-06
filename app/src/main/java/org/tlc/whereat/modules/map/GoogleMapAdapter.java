/**
 *
 * Copyright (c) 2015-present, Total Location Test Paragraph.
 * All rights reserved.
 *
 * This file is part of Where@. Where@ is free software:
 * you can redistribute it and/or modify it under the terms of
 * the GNU General Public License (GPL), either version 3
 * of the License, or (at your option) any later version.
 *
 * Where@ is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. For more details,
 * see the full license at <http://www.gnu.org/licenses/gpl-3.0.en.html>
 *
 */

package org.tlc.whereat.modules.map;

import android.app.Activity;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.model.MarkerOptions;

import org.tlc.whereat.R;

public class GoogleMapAdapter implements MapAdapter {

    // FIELDS
    protected Activity mCtx;
    protected GoogleMap mMap;


    // CONSTRUCTORS

    public static MapAdapter getInstance(Activity ctx){
        return new GoogleMapAdapter(ctx);
    }

    protected GoogleMapAdapter(Activity ctx){
        mCtx = ctx;
    }

    // PUBLIC METHODS

    public MapAdapter getMap(){ // helper function for testing seem. see: https://github.com/robolectric/robolectric/issues/1145
        mMap = getGoogleMap();
        return this;
    }

    public MapAdapter clear(){
        mMap.clear();
        return this;
    }

    public MapAdapter showUserLocation(){
        mMap.setMyLocationEnabled(true);
        return this;
    }

    public MapAdapter center(LatLon latLon){
        mMap.moveCamera(getCameraUpdate(latLon));
        return this;
    }

    public MarkerAdapter addMarker(LatLon latLon, String msg){
        return GoogleMarkerAdapter.getInstance(mMap.addMarker(getMarkerOptions(latLon, msg)));
    }

    // HELPERS

    protected GoogleMap getGoogleMap(){ // for testing seam!
        return ((MapFragment) mCtx.getFragmentManager().findFragmentById(R.id.map_fragment)).getMap();
    }

    protected CameraUpdate getCameraUpdate(LatLon latLon){ // testing seam!
        return CameraUpdateFactory.newLatLngZoom(latLon.asGoogleLatLon(), 15);
    }

    protected MarkerOptions getMarkerOptions(LatLon latLon, String msg){ // seam!
        return new MarkerOptions()
                    .position(latLon.asGoogleLatLon())
                    .title(msg);
    }

}
