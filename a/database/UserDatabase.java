package com.app.gpsphonelocator_new.database;

import android.content.Context;

import androidx.room.Room;
import androidx.room.RoomDatabase;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;


public abstract class UserDatabase extends RoomDatabase {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final String DATABASE_NAME = "User.db";

    public static volatile UserDatabase instance;

    public abstract AlertHistoryDao alertHistoryDAO();

    public abstract UserTrackedDao userDAO();

    public abstract ZoneAlertDao zoneDAO();


    public static final class Companion {
        public  Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final UserDatabase getInstance(Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            if (instance == null) {
                synchronized (this) {
                    Companion companion = UserDatabase.Companion;
                    UserDatabase.instance = Room.databaseBuilder(context, UserDatabase.class, "User.db").allowMainThreadQueries().build();

                }
            }
            return UserDatabase.instance;
        }
    }
}
