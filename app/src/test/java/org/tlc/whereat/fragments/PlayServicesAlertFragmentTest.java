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

import android.app.AlertDialog;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricGradleTestRunner;
import org.robolectric.annotation.Config;
import org.robolectric.shadows.ShadowAlertDialog;
import org.tlc.whereat.BuildConfig;

import static org.robolectric.Shadows.shadowOf;
import static org.robolectric.util.FragmentTestUtil.startFragment;
import static org.assertj.core.api.Assertions.*;
import static android.app.AlertDialog.BUTTON_POSITIVE;


@RunWith(RobolectricGradleTestRunner.class)
@Config(constants = BuildConfig.class, sdk = 21)

public class PlayServicesAlertFragmentTest {

    protected static PlayServicesAlertFragment mFrag;
    protected static AlertDialog mAlert;

    @Before
    public void setup() throws Exception {
        mFrag = new PlayServicesAlertFragment().setCode(1);
        startFragment(mFrag);
        mAlert = ShadowAlertDialog.getLatestAlertDialog();
    }

    @Test
    public void fragment_should_haveCorrectContents(){
        ShadowAlertDialog shAlert = shadowOf(mAlert);

        assertThat(mFrag).isNotNull();
        assertThat(mAlert).isNotNull();
        assertThat(mAlert.isShowing()).isTrue();

        assertThat(shAlert.getTitle())
            .isEqualTo("Get Google Play services");
        assertThat(shAlert.getMessage())
            .isEqualTo("This app won't run without Google Play services, which are missing from your phone.");
        assertThat(mAlert.getButton(BUTTON_POSITIVE).getText())
            .isEqualTo("Get Google Play services");
    }

}