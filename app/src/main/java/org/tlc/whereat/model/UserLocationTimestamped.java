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

package org.tlc.whereat.model;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;

public class UserLocationTimestamped {

    @SerializedName("lastPing") private Long mLastPing;
    @SerializedName("location") private UserLocation mUserLocation;

    public UserLocationTimestamped(Long lp, UserLocation ul) {
        mLastPing = lp;
        mUserLocation = ul;
    }

    // CONVERTERS

    public String toJson(){
        return new Gson().toJson(this);
    }

    public static UserLocationTimestamped fromJson(String json){
        return new Gson().fromJson(json, UserLocationTimestamped.class);
    }

    // ACESSORS
    public UserLocation getUserLocation() {
        return mUserLocation;
    }

    public Long getLastPing() {
        return mLastPing;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserLocationTimestamped that = (UserLocationTimestamped) o;

        if (!mLastPing.equals(that.mLastPing)) return false;
        return mUserLocation.equals(that.mUserLocation);

    }

    @Override
    public int hashCode() {
        int result = mLastPing.hashCode();
        result = 31 * result + mUserLocation.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "UserLocationTimestamped{" +
            "lastPing=" + mLastPing +
            ", userLocation=" + mUserLocation +
            '}';
    }
}
