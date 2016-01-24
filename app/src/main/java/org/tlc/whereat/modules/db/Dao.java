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

package org.tlc.whereat.modules.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class Dao extends SQLiteOpenHelper {

    // FIELDS

    public static final String TABLE_LOCATIONS = "locations";
    public static final String COLUMN_ID = "_id";
    public static final String COLUMN_LAT = "lat";
    public static final String COLUMN_LON = "lon";
    public static final String COLUMN_TIME = "time";

    protected static final String DB_NAME = "whereat.db";

    protected static final int DB_VERSION = 3;
    protected static final String DB_CREATE =
        "create table " + TABLE_LOCATIONS + " (" +
            COLUMN_ID + " text primary key not null, " +
            COLUMN_LAT + " real not null, " +
            COLUMN_LON + " real not null, " +
            COLUMN_TIME + " integer not null);";

    private static Dao sInstance;

    // CONSTRUCTOR

    public static synchronized Dao getInstance(Context ctx){
        return new Dao(ctx);
        //TODO can multiple activities share the same instance? Should they?
//        if (sInstance == null) sInstance = new Dao(ctx);
//        return sInstance;
    }

    private Dao(Context ctx){
        super(ctx, DB_NAME, null, DB_VERSION);
    }

    protected Dao(Context ctx, String dbName){
        super(ctx, dbName, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(DB_CREATE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.w(Dao.class.getName(), "Upgrading DB from v. " + oldVersion + " to " + newVersion);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_LOCATIONS);
        onCreate(db);
    }



    // MIGRATIONS

    private static class Patch {
        public void apply(SQLiteDatabase db){}
        public void revert(SQLiteDatabase db){}
    }

    protected static final Patch[] PATCHES = new Patch[] {
        new Patch(){
            @Override
            public void apply(SQLiteDatabase db) {
                db.execSQL(DB_CREATE);
            }

            @Override
            public void revert(SQLiteDatabase db) {
                db.execSQL("DROP TABLE IF EXISTS" + TABLE_LOCATIONS);
            }
        }
    };

    //HELPERS

    private void log(String msg){
        Log.w(Dao.class.getName(), msg);
    }
}
