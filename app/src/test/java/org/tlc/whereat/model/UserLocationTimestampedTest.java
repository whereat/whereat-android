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

import org.junit.Test;


import static org.tlc.whereat.support.LocationHelpers.*;
import static org.assertj.core.api.Assertions.*;

public class UserLocationTimestampedTest {

    @Test
    public void toJson_should_serializeToJson(){
        assertThat(
            s17LocationTimestampedStub().toJson())
            .isEqualTo(S17_WITH_PING_JSON);
    }

    @Test
    public void fromJson_should_deserializeFromJson(){
        assertThat(
            UserLocationTimestamped.fromJson(S17_WITH_PING_JSON))
            .isEqualTo(s17LocationTimestampedStub());
    }


}