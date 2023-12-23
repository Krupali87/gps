package com.app.gpsphonelocator_new.database;

import androidx.sqlite.db.SupportSQLiteDatabase;

public interface AutoMigrationSpec {
    default void onPostMigrate(SupportSQLiteDatabase supportSQLiteDatabase) {
    }
}
