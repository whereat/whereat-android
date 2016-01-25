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

import org.junit.Test;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.Mockito.*;

/**
 * coded with <3 for where@
 */

public class GoogleMapAdapterFactoryTest {

    @Test
    public void getInstance_should_delegateToGoogleMapContainerAndReturnAMapContainer() throws Exception {
        Activity ctx = mock(Activity.class);
        GoogleMapAdapterFactory mcf = new GoogleMapAdapterFactory(ctx);

        assertThat(mcf.mCtx).isEqualTo(ctx);
        assertThat(mcf.createMapAdapter()).isInstanceOf(MapAdapter.class);
    }
}