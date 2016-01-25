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

package org.tlc.whereat.modules.pubsub.receivers;

import android.content.Intent;
import android.content.IntentFilter;
import android.support.v4.content.LocalBroadcastManager;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.robolectric.RobolectricGradleTestRunner;
import org.robolectric.RuntimeEnvironment;
import org.robolectric.annotation.Config;

import org.tlc.whereat.BuildConfig;
import org.tlc.whereat.activities.MapActivity;
import org.tlc.whereat.modules.pubsub.broadcasters.LocPubBroadcasters;
import org.tlc.whereat.model.UserLocation;
import org.tlc.whereat.modules.schedule.Scheduler;

import static org.mockito.Mockito.*;
import static org.assertj.core.api.Assertions.*;
import static org.tlc.whereat.support.LocationHelpers.s17UserLocationStub;


@RunWith(RobolectricGradleTestRunner.class)
@Config(constants = BuildConfig.class, sdk = 21)

public class LocationMappingReceiversTest extends ReceiversTest {

    LocationMappingReceivers rcv;

    @Before
    public void setup(){
        ctx = mock(MapActivity.class);
        lbm = spy(LocalBroadcastManager.getInstance(RuntimeEnvironment.application));
        ifArg = ArgumentCaptor.forClass(IntentFilter.class);
        rcv = new LocationMappingReceivers(ctx, lbm);
    }
    @Test
    public void register_should_registerBroadcastReceivers(){
        rcv.register();

        verify(lbm).registerReceiver(eq(rcv.mMap), ifArg.capture());
        assertThat(ifArg.getValue().hasAction(LocPubBroadcasters.ACTION_LOCATION_RECEIVED)).isTrue();

        verify(lbm).registerReceiver(eq(rcv.mForget), ifArg.capture());
        assertThat(ifArg.getValue().hasAction(Scheduler.ACTION_LOCATIONS_FORGOTTEN)).isTrue();

    }

    @Test
    public void unregister_should_unRegisterAllReceivers(){
        rcv.unregister();

        verify(lbm).unregisterReceiver(rcv.mMap);
        verify(lbm).unregisterReceiver(rcv.mForget);
    }

    @Test
    public void locationReceiver_should_addReceivedLocationToMap(){
        rcv.register();
        rcv.mCtx = spy(rcv.mCtx);
        UserLocation loc = s17UserLocationStub();

        lbm.sendBroadcast(new Intent()
            .setAction(LocPubBroadcasters.ACTION_LOCATION_RECEIVED)
            .putExtra(LocPubBroadcasters.ACTION_LOCATION_RECEIVED, loc));

        verify((MapActivity)rcv.mCtx).map(loc);
    }

}