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

package org.tlc.whereat.support;

import com.google.android.gms.common.api.GoogleApiClient;

import org.tlc.whereat.modules.db.LocationDao;
import org.tlc.whereat.services.LocationPublisher;
import org.tlc.whereat.modules.schedule.Scheduler;


/**
 * Author: @aguestuser
 * License: GPLv3 (https://www.gnu.org/licenses/gpl-3.0.html)
 */
public class FakeLocationPublisher extends LocationPublisher {

    public FakeLocationPublisher setGoogleApiClient(GoogleApiClient cl){
        mGoogClient = cl;
        return this;
    }

    public FakeLocationPublisher setDao(LocationDao dao){
        mDao = dao;
        return this;
    }

    public FakeLocationPublisher setScheduler(Scheduler sch){
        mScheduler = sch;
        return this;
    }

}


