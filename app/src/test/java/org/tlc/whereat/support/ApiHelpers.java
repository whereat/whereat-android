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

import android.net.Uri;
import android.util.Log;

import org.tlc.whereat.model.ApiMessage;

import java.io.IOException;
import java.util.Collections;

import retrofit.client.Client;
import retrofit.client.Request;
import retrofit.client.Response;
import retrofit.mime.TypedByteArray;

/**
 * Author: @aguestuser
 * License: GPLv3 (https://www.gnu.org/licenses/gpl-3.0.html)
 */
public class ApiHelpers {

    public static final String REMOVE_MSG = "1 record(s) deleted.";

    public static final String REMOVE_MSG_JSON = "{\"msg\":\"" + REMOVE_MSG + "\"}";

    public static ApiMessage removeMsgStub(){
        return ApiMessage.of(REMOVE_MSG);
    }

//    public class MockClient implements Client {
//        @Override
//        public Response execute(Request request) throws IOException {
//
//            Uri uri = Uri.parse(request.getUrl());
//
//            Log.d("MOCK SERVER", "fetching uri: " + uri.toString());
//
//            String responseString = "";
//
//            if(uri.getPath().equals("/locations/req")) {
//                responseString = "JSON STRING HERE";
//            } else {
//                responseString = "OTHER JSON RESPONSE STRING";
//            }
//
//            return new Response(request.getUrl(), 200, "nothing", Collections.EMPTY_LIST, new TypedByteArray("application/json", responseString.getBytes()));
//        }
//    }

}
