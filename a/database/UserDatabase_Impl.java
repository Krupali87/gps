package com.app.gpsphonelocator_new.database;

import android.annotation.SuppressLint;

import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.RoomDatabase;
import androidx.room.RoomMasterTable;
import androidx.room.RoomOpenHelper;
import androidx.room.migration.Migration;
import androidx.room.util.DBUtil;
import androidx.room.util.TableInfo;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public final class UserDatabase_Impl extends UserDatabase {
    private volatile AlertHistoryDao _alertHistoryDao;
    private volatile UserTrackedDao _userTrackedDao;
    private volatile ZoneAlertDao _zoneAlertDao;



    @SuppressLint("RestrictedApi")
    public SupportSQLiteOpenHelper createOpenHelper(DatabaseConfiguration databaseConfiguration) {
        return databaseConfiguration.sqliteOpenHelperFactory.create(SupportSQLiteOpenHelper.Configuration.builder(databaseConfiguration.context).name(databaseConfiguration.name).callback(new RoomOpenHelper(databaseConfiguration, new RoomOpenHelper.Delegate(6) {
            public void onPostMigrate(SupportSQLiteDatabase supportSQLiteDatabase) {
            }

            public void createAllTables(SupportSQLiteDatabase supportSQLiteDatabase) {
                supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `UserTracked` (`uid` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `name` TEXT, `phone` TEXT, `uuid` TEXT, `checked` TEXT)");
                supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `AlertZone` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `zone_name` TEXT, `latitude` REAL, `longitude` REAL, `address` TEXT, `on_enter` INTEGER NOT NULL, `on_leave ` INTEGER NOT NULL, `status` INTEGER NOT NULL, `radius` INTEGER NOT NULL)");
                supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `AlertHistory` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `zone_id` INTEGER NOT NULL, `zone_name` TEXT, `user_uid` TEXT, `user_name` TEXT, `on_enter` INTEGER NOT NULL, `on_leave` INTEGER NOT NULL, `status` INTEGER NOT NULL, `time` INTEGER NOT NULL, `is_tmp` INTEGER NOT NULL)");
                supportSQLiteDatabase.execSQL(RoomMasterTable.CREATE_QUERY);
                supportSQLiteDatabase.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, '3ea9af20639b6a9dc264db0b9136078e')");
            }

            public void dropAllTables(SupportSQLiteDatabase supportSQLiteDatabase) {
                supportSQLiteDatabase.execSQL("DROP TABLE IF EXISTS `UserTracked`");
                supportSQLiteDatabase.execSQL("DROP TABLE IF EXISTS `AlertZone`");
                supportSQLiteDatabase.execSQL("DROP TABLE IF EXISTS `AlertHistory`");
                if (UserDatabase_Impl.this.mCallbacks != null) {
                    int size = UserDatabase_Impl.this.mCallbacks.size();
                    for (int i = 0; i < size; i++) {
                        ((RoomDatabase.Callback) UserDatabase_Impl.this.mCallbacks.get(i)).onDestructiveMigration(supportSQLiteDatabase);
                    }
                }
            }


            public void onCreate(SupportSQLiteDatabase supportSQLiteDatabase) {
                if (UserDatabase_Impl.this.mCallbacks != null) {
                    int size = UserDatabase_Impl.this.mCallbacks.size();
                    for (int i = 0; i < size; i++) {
                        ((RoomDatabase.Callback) UserDatabase_Impl.this.mCallbacks.get(i)).onCreate(supportSQLiteDatabase);
                    }
                }
            }

            public void onOpen(SupportSQLiteDatabase supportSQLiteDatabase) {
                SupportSQLiteDatabase unused = UserDatabase_Impl.this.mDatabase = supportSQLiteDatabase;
                UserDatabase_Impl.this.internalInitInvalidationTracker(supportSQLiteDatabase);
                if (UserDatabase_Impl.this.mCallbacks != null) {
                    int size = UserDatabase_Impl.this.mCallbacks.size();
                    for (int i = 0; i < size; i++) {
                        ((RoomDatabase.Callback) UserDatabase_Impl.this.mCallbacks.get(i)).onOpen(supportSQLiteDatabase);
                    }
                }
            }

            public void onPreMigrate(SupportSQLiteDatabase supportSQLiteDatabase) {
                DBUtil.dropFtsSyncTriggers(supportSQLiteDatabase);
            }


            @SuppressLint("WrongConstant")
            public RoomOpenHelper.ValidationResult onValidateSchema(SupportSQLiteDatabase supportSQLiteDatabase) {
                SupportSQLiteDatabase supportSQLiteDatabase2 = supportSQLiteDatabase;
                HashMap hashMap = new HashMap(5);
                hashMap.put("uid", new TableInfo.Column("uid", "INTEGER", true, 1, (String) null, 1));
                hashMap.put("name", new TableInfo.Column("name", "TEXT", false, 0, (String) null, 1));
                hashMap.put("phone", new TableInfo.Column("phone", "TEXT", false, 0, (String) null, 1));
                hashMap.put("uuid", new TableInfo.Column("uuid", "TEXT", false, 0, (String) null, 1));
                hashMap.put("checked", new TableInfo.Column("checked", "TEXT", false, 0, (String) null, 1));
                TableInfo tableInfo = new TableInfo("UserTracked", hashMap, new HashSet(0), new HashSet(0));
                TableInfo read = TableInfo.read(supportSQLiteDatabase2, "UserTracked");
                if (!tableInfo.equals(read)) {
                    return new RoomOpenHelper.ValidationResult(false, "UserTracked(com.phone.number.gpstracker.familylocator.phonetracker.database.UserTracked).\n Expected:\n" + tableInfo + "\n Found:\n" + read);
                }
                HashMap hashMap2 = new HashMap(9);
                hashMap2.put("id", new TableInfo.Column("id", "INTEGER", true, 1, (String) null, 1));
                hashMap2.put("zone_name", new TableInfo.Column("zone_name", "TEXT", false, 0, (String) null, 1));
                hashMap2.put("latitude", new TableInfo.Column("latitude", "REAL", false, 0, (String) null, 1));
                hashMap2.put("longitude", new TableInfo.Column("longitude", "REAL", false, 0, (String) null, 1));
                hashMap2.put("address", new TableInfo.Column("address", "TEXT", false, 0, (String) null, 1));
                hashMap2.put("on_enter", new TableInfo.Column("on_enter", "INTEGER", true, 0, (String) null, 1));
                hashMap2.put("on_leave ", new TableInfo.Column("on_leave ", "INTEGER", true, 0, (String) null, 1));
                hashMap2.put("status", new TableInfo.Column("status", "INTEGER", true, 0, (String) null, 1));
                hashMap2.put("radius", new TableInfo.Column("radius", "INTEGER", true, 0, (String) null, 1));
                TableInfo tableInfo2 = new TableInfo("AlertZone", hashMap2, new HashSet(0), new HashSet(0));
                TableInfo read2 = TableInfo.read(supportSQLiteDatabase2, "AlertZone");
                if (!tableInfo2.equals(read2)) {
                    return new RoomOpenHelper.ValidationResult(false, "AlertZone(com.phone.number.gpstracker.familylocator.phonetracker.database.AlertZoneEntity).\n Expected:\n" + tableInfo2 + "\n Found:\n" + read2);
                }
                HashMap hashMap3 = new HashMap(10);
                hashMap3.put("id", new TableInfo.Column("id", "INTEGER", true, 1, (String) null, 1));
                hashMap3.put("zone_name", new TableInfo.Column("zone_name", "TEXT", false, 0, (String) null, 1));
                hashMap3.put("user_uid", new TableInfo.Column("user_uid", "TEXT", false, 0, (String) null, 1));
                hashMap3.put("user_name", new TableInfo.Column("user_name", "TEXT", false, 0, (String) null, 1));
                hashMap3.put("on_enter", new TableInfo.Column("on_enter", "INTEGER", true, 0, (String) null, 1));
                hashMap3.put("on_leave", new TableInfo.Column("on_leave", "INTEGER", true, 0, (String) null, 1));
                hashMap3.put("status", new TableInfo.Column("status", "INTEGER", true, 0, (String) null, 1));
                hashMap3.put("time", new TableInfo.Column("time", "INTEGER", true, 0, (String) null, 1));
                hashMap3.put("is_tmp", new TableInfo.Column("is_tmp", "INTEGER", true, 0, (String) null, 1));
                TableInfo tableInfo3 = new TableInfo("AlertHistory", hashMap3, new HashSet(0), new HashSet(0));
                TableInfo read3 = TableInfo.read(supportSQLiteDatabase2, "AlertHistory");
                if (!tableInfo3.equals(read3)) {
                    return new RoomOpenHelper.ValidationResult(false, "AlertHistory(com.phone.number.gpstracker.familylocator.phonetracker.database.AlertHistoryEntity).\n Expected:\n" + tableInfo3 + "\n Found:\n" + read3);
                }
                return new RoomOpenHelper.ValidationResult(true, (String) null);
            }
        }, "3ea9af20639b6a9dc264db0b9136078e", "ca90d6a9c5163b735d1c90a944047f2f")).build());
    }

    /* access modifiers changed from: protected */
    @SuppressLint("RestrictedApi")
    public InvalidationTracker createInvalidationTracker() {
        return new InvalidationTracker(this, new HashMap(0), new HashMap(0), "UserTracked", "AlertZone", "AlertHistory");
    }

    @SuppressLint("RestrictedApi")
    public void clearAllTables() {
        super.assertNotMainThread();
        SupportSQLiteDatabase writableDatabase = super.getOpenHelper().getWritableDatabase();
        try {
            super.beginTransaction();
            writableDatabase.execSQL("DELETE FROM `UserTracked`");
            writableDatabase.execSQL("DELETE FROM `AlertZone`");
            writableDatabase.execSQL("DELETE FROM `AlertHistory`");
            super.setTransactionSuccessful();
        } finally {
            super.endTransaction();
            writableDatabase.query("PRAGMA wal_checkpoint(FULL)").close();
            if (!writableDatabase.inTransaction()) {
                writableDatabase.execSQL("VACUUM");
            }
        }
    }

    /* access modifiers changed from: protected */
    public Map<Class<?>, List<Class<?>>> getRequiredTypeConverters() {
        HashMap hashMap = new HashMap();
        hashMap.put(UserTrackedDao.class, UserTrackedDao_Impl.getRequiredConverters());
        hashMap.put(ZoneAlertDao.class, ZoneAlertDao_Impl.getRequiredConverters());
        hashMap.put(AlertHistoryDao.class, AlertHistoryDao_Impl.getRequiredConverters());
        return hashMap;
    }

    public Set<Class<? extends AutoMigrationSpec>> getRequiredAutoMigrationSpecs() {
        return new HashSet();
    }

    public List<Migration> getAutoMigrations(Map<Class<? extends AutoMigrationSpec>, AutoMigrationSpec> map) {
        return Arrays.asList(new Migration[0]);
    }

    public UserTrackedDao userDAO() {
        UserTrackedDao userTrackedDao;
        if (this._userTrackedDao != null) {
            return this._userTrackedDao;
        }
        synchronized (this) {
            if (this._userTrackedDao == null) {
                this._userTrackedDao = new UserTrackedDao_Impl(this);
            }
            userTrackedDao = this._userTrackedDao;
        }
        return userTrackedDao;
    }

    public ZoneAlertDao zoneDAO() {
        ZoneAlertDao zoneAlertDao;
        if (this._zoneAlertDao != null) {
            return this._zoneAlertDao;
        }
        synchronized (this) {
            if (this._zoneAlertDao == null) {
                this._zoneAlertDao = new ZoneAlertDao_Impl(this);
            }
            zoneAlertDao = this._zoneAlertDao;
        }
        return zoneAlertDao;
    }

    public AlertHistoryDao alertHistoryDAO() {
        AlertHistoryDao alertHistoryDao;
        if (this._alertHistoryDao != null) {
            return this._alertHistoryDao;
        }
        synchronized (this) {
            if (this._alertHistoryDao == null) {
                this._alertHistoryDao = new AlertHistoryDao_Impl(this);
            }
            alertHistoryDao = this._alertHistoryDao;
        }
        return alertHistoryDao;
    }
}
