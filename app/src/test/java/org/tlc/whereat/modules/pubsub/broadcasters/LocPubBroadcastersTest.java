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

package org.tlc.whereat.modules.pubsub.broadcasters;


import android.content.Intent;
import android.support.v4.content.LocalBroadcastManager;

import com.google.android.gms.common.ConnectionResult;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.robolectric.RobolectricGradleTestRunner;
import org.robolectric.annotation.Config;
import org.tlc.whereat.BuildConfig;
import org.tlc.whereat.model.ApiMessage;
import org.tlc.whereat.model.UserLocation;
import org.tlc.whereat.services.LocationPublisher;

import static org.mockito.Mockito.*;
import static org.assertj.core.api.Assertions.*;
import static org.tlc.whereat.support.LocationHelpers.*;


@RunWith(RobolectricGradleTestRunner.class)
@Config(constants = BuildConfig.class, sdk = 21)

public class LocPubBroadcastersTest {

    static UserLocation s17 = s17UserLocationStub();
    static ApiMessage msg = ApiMessage.of("Database erased.");
    static ConnectionResult cr = mock(ConnectionResult.class);

    LocPubBroadcasters bc;
    ArgumentCaptor<Intent> intentArg;

    @Before
    public void setup(){
        bc = new LocPubBroadcasters(mock(LocationPublisher.class), mock(LocalBroadcastManager.class));
        intentArg = ArgumentCaptor.forClass(Intent.class);
    }

    @Test
    public void pub_should_broadcast_ACTION_LOCATION_PUBLISHED(){
        bc.pub();

        verify(bc.mLbm).sendBroadcast(intentArg.capture());
        assertThat(intentArg.getValue().getAction())
            .isEqualTo(LocPubBroadcasters.ACTION_LOCATION_PUBLISHED);
    }

    @Test
    public void clear_should_broadcast_ACTION_LOCATIONS_CLEARED(){
        bc.clear(msg);

        verify(bc.mLbm).sendBroadcast(intentArg.capture());
        assertThat(intentArg.getValue().getAction())
            .isEqualTo(LocPubBroadcasters.ACTION_LOCATIONS_CLEARED);
    }

    @Test
    public void map_should_broadcast_ACTION_LOCATIONS_RECEIVED(){
        bc.map(s17);

        verify(bc.mLbm).sendBroadcast(intentArg.capture());
        assertThat(intentArg.getValue().getAction())
            .isEqualTo(LocPubBroadcasters.ACTION_LOCATION_RECEIVED);
        assertThat((UserLocation)intentArg.getValue().getExtras()
            .getParcelable(LocPubBroadcasters.ACTION_LOCATION_RECEIVED))
            .isEqualTo(s17);

    }

    @Test
    public void fail_should_broadcast_ACTION_LOCATION_REQUEST_FAILED(){
        bc.fail();

        verify(bc.mLbm).sendBroadcast(intentArg.capture());
        assertThat(intentArg.getValue().getAction())
            .isEqualTo(LocPubBroadcasters.ACTION_LOCATION_REQUEST_FAILED);
    }

    @Test
    public void googApiDisconnected_should_broadcast_ACTION_GOOGLE_API_CLIENT_DISCONNECTED(){
        bc.googApiDisconnected(cr);

        verify(bc.mLbm).sendBroadcast(intentArg.capture());
        assertThat(intentArg.getValue().getAction())
            .isEqualTo(LocPubBroadcasters.ACTION_GOOGLE_API_CLIENT_DISCONNECTED);
        assertThat((ConnectionResult)intentArg.getValue().getExtras()
            .getParcelable(LocPubBroadcasters.ACTION_GOOGLE_API_CLIENT_DISCONNECTED))
            .isEqualTo(cr);
    }

    @Test
    public void locServicesDisabled_should_broadcast_ACTION_LOCATION_SERVICES_DISABLED(){
        bc.locServicesDisabled();

        verify(bc.mLbm).sendBroadcast(intentArg.capture());
        assertThat(intentArg.getValue().getAction())
            .isEqualTo(LocPubBroadcasters.ACTION_LOCATION_SERVICES_DISABLED);
    }

    @Test
    public void playServicesDisabled_should_broadcast_ACTION_PLAY_SERVICES_DISABLED(){
        bc.playServicesDisabled();

        verify(bc.mLbm).sendBroadcast(intentArg.capture());
        assertThat(intentArg.getValue().getAction())
            .isEqualTo(LocPubBroadcasters.ACTION_PLAY_SERVICES_DISABLED);
    }



}