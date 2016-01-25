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

import com.google.android.gms.maps.model.LatLng;

public class LatLon {

    // FIELDS

    protected double mLat;
    protected double mLon;

    // CONTRUCTOR

    public LatLon(double lat, double lon){
        mLat = lat;
        mLon = lon;
    }

    // ACCESSORS

    public double getLat(){
        return mLat;
    }
    public double getLon(){
        return mLon;
    }

    // CONVERTERS

    public LatLng asGoogleLatLon() { return new LatLng(mLat, mLon); }


    // EQUALITY

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        LatLon latLon = (LatLon) o;

        if (Double.compare(latLon.mLat, mLat) != 0) return false;
        return Double.compare(latLon.mLon, mLon) == 0;
    }
}
