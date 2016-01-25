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

package org.tlc.whereat.fragments;

import android.app.Dialog;
import android.app.DialogFragment;
import android.os.Bundle;

import com.google.android.gms.common.GooglePlayServicesUtil;

public class PlayServicesAlertFragment extends DialogFragment {

    protected final static int PLAY_SERVICES_RESOLUTION_REQUEST = 1000; //TODO: move to resources
    int mCode;

    public PlayServicesAlertFragment setCode(int code){
        mCode = code;
        return this;
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        return GooglePlayServicesUtil.getErrorDialog(mCode, getActivity(), PLAY_SERVICES_RESOLUTION_REQUEST);
    }
}
