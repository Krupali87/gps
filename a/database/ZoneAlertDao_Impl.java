package com.app.gpsphonelocator_new.database;

import static kotlinx.coroutines.CoroutineScopeKt.CoroutineScope;

import android.annotation.SuppressLint;
import android.database.Cursor;
import android.os.CancellationSignal;

import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.room.util.StringUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import kotlinx.coroutines.Dispatchers;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public final class ZoneAlertDao_Impl implements ZoneAlertDao {
    private final RoomDatabase __db;
    private final EntityDeletionOrUpdateAdapter<AlertZoneEntity> __deletionAdapterOfAlertZoneEntity;
    private final EntityInsertionAdapter<AlertZoneEntity> __insertionAdapterOfAlertZoneEntity;
    private final EntityDeletionOrUpdateAdapter<AlertZoneEntity> __updateAdapterOfAlertZoneEntity;

    private final ExecutorService executorService = Executors.newSingleThreadExecutor();

    @SuppressLint("RestrictedApi")
    public ZoneAlertDao_Impl(RoomDatabase roomDatabase) {
        this.__db = roomDatabase;
        this.__insertionAdapterOfAlertZoneEntity = new EntityInsertionAdapter<AlertZoneEntity>(roomDatabase) {
            public String createQuery() {
                return "INSERT OR ABORT INTO `AlertZone` (`id`,`zone_name`,`latitude`,`longitude`,`address`,`on_enter`,`on_leave `,`status`,`radius`) VALUES (nullif(?, 0),?,?,?,?,?,?,?,?)";
            }

            public void bind(SupportSQLiteStatement supportSQLiteStatement, AlertZoneEntity alertZoneEntity) {
                supportSQLiteStatement.bindLong(1, (long) alertZoneEntity.getId());
                if (alertZoneEntity.getZoneName() == null) {
                    supportSQLiteStatement.bindNull(2);
                } else {
                    supportSQLiteStatement.bindString(2, String.valueOf(alertZoneEntity.getZoneName()));
                }
                if (alertZoneEntity.getLatitude() == null) {
                    supportSQLiteStatement.bindNull(3);
                } else {
                    supportSQLiteStatement.bindDouble(3, alertZoneEntity.getLatitude().doubleValue());
                }
                if (alertZoneEntity.getLongitude() == null) {
                    supportSQLiteStatement.bindNull(4);
                } else {
                    supportSQLiteStatement.bindDouble(4, alertZoneEntity.getLongitude().doubleValue());
                }
                if (alertZoneEntity.getAddress() == null) {
                    supportSQLiteStatement.bindNull(5);
                } else {
                    supportSQLiteStatement.bindString(5, alertZoneEntity.getAddress());
                }
                supportSQLiteStatement.bindLong(6, alertZoneEntity.getOnEnter() ? 1 : 0);
                supportSQLiteStatement.bindLong(7, alertZoneEntity.getOnLeave() ? 1 : 0);
                supportSQLiteStatement.bindLong(8, (long) alertZoneEntity.getStatus());
                supportSQLiteStatement.bindLong(9, (long) alertZoneEntity.getRadius());
            }
        };
        this.__deletionAdapterOfAlertZoneEntity = new EntityDeletionOrUpdateAdapter<AlertZoneEntity>(roomDatabase) {
            public String createQuery() {
                return "DELETE FROM `AlertZone` WHERE `id` = ?";
            }

            public void bind(SupportSQLiteStatement supportSQLiteStatement, AlertZoneEntity alertZoneEntity) {
                supportSQLiteStatement.bindLong(1, (long) alertZoneEntity.getId());
            }
        };
        this.__updateAdapterOfAlertZoneEntity = new EntityDeletionOrUpdateAdapter<AlertZoneEntity>(roomDatabase) {
            public String createQuery() {
                return "UPDATE OR ABORT `AlertZone` SET `id` = ?,`zone_name` = ?,`latitude` = ?,`longitude` = ?,`address` = ?,`on_enter` = ?,`on_leave ` = ?,`status` = ?,`radius` = ? WHERE `id` = ?";
            }

            public void bind(SupportSQLiteStatement supportSQLiteStatement, AlertZoneEntity alertZoneEntity) {
                supportSQLiteStatement.bindLong(1, (long) alertZoneEntity.getId());
                if (alertZoneEntity.getZoneName() == null) {
                    supportSQLiteStatement.bindNull(2);
                } else {
                    supportSQLiteStatement.bindString(2, String.valueOf(alertZoneEntity.getZoneName()));
                }
                if (alertZoneEntity.getLatitude() == null) {
                    supportSQLiteStatement.bindNull(3);
                } else {
                    supportSQLiteStatement.bindDouble(3, alertZoneEntity.getLatitude().doubleValue());
                }
                if (alertZoneEntity.getLongitude() == null) {
                    supportSQLiteStatement.bindNull(4);
                } else {
                    supportSQLiteStatement.bindDouble(4, alertZoneEntity.getLongitude().doubleValue());
                }
                if (alertZoneEntity.getAddress() == null) {
                    supportSQLiteStatement.bindNull(5);
                } else {
                    supportSQLiteStatement.bindString(5, alertZoneEntity.getAddress());
                }
                supportSQLiteStatement.bindLong(6, alertZoneEntity.getOnEnter() ? 1 : 0);
                supportSQLiteStatement.bindLong(7, alertZoneEntity.getOnLeave() ? 1 : 0);
                supportSQLiteStatement.bindLong(8, (long) alertZoneEntity.getStatus());
                supportSQLiteStatement.bindLong(9, (long) alertZoneEntity.getRadius());
                supportSQLiteStatement.bindLong(10, (long) alertZoneEntity.getId());
            }
        };
    }

    @SuppressLint("RestrictedApi")
    public void insert(AlertZoneEntity... alertZoneEntityArr) {

        executorService.execute(() -> __insertionAdapterOfAlertZoneEntity.insert(alertZoneEntityArr));
    }

    @SuppressLint("RestrictedApi")
    public void delete(AlertZoneEntity... alertZoneEntityArr) {
        executorService.execute(() -> __deletionAdapterOfAlertZoneEntity.handleMultiple(alertZoneEntityArr));
    }

    @SuppressLint("RestrictedApi")
    public void update(AlertZoneEntity... alertZoneEntityArr) {
        executorService.execute(() -> __updateAdapterOfAlertZoneEntity.handleMultiple(alertZoneEntityArr));
    }

    @SuppressLint("RestrictedApi")
    public List<AlertZoneEntity> getListZone() {
        String str;
        Double d;
        Double d2;
        String str2;
        @SuppressLint("RestrictedApi") RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT * FROM AlertZone", 0);
        this.__db.assertNotSuspendingTransaction();
        Cursor query = DBUtil.query(this.__db, acquire, false, (CancellationSignal) null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(query, "id");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(query, "zone_name");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(query, "latitude");
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(query, "longitude");
            int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(query, "address");
            int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(query, "on_enter");
            int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(query, "on_leave ");
            int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(query, "status");
            int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(query, "radius");
            ArrayList arrayList = new ArrayList(query.getCount());
            while (query.moveToNext()) {
                int i = query.getInt(columnIndexOrThrow);
                if (query.isNull(columnIndexOrThrow2)) {
                    str = null;
                } else {
                    str = query.getString(columnIndexOrThrow2);
                }
                if (query.isNull(columnIndexOrThrow3)) {
                    d = null;
                } else {
                    d = Double.valueOf(query.getDouble(columnIndexOrThrow3));
                }
                if (query.isNull(columnIndexOrThrow4)) {
                    d2 = null;
                } else {
                    d2 = Double.valueOf(query.getDouble(columnIndexOrThrow4));
                }
                if (query.isNull(columnIndexOrThrow5)) {
                    str2 = null;
                } else {
                    str2 = query.getString(columnIndexOrThrow5);
                }
                arrayList.add(new AlertZoneEntity(i, str, d, d2, str2, query.getInt(columnIndexOrThrow6) != 0, query.getInt(columnIndexOrThrow7) != 0, query.getInt(columnIndexOrThrow8), query.getInt(columnIndexOrThrow9)));
            }
            return arrayList;
        } finally {
            query.close();
            acquire.release();
        }
    }

    @SuppressLint("RestrictedApi")
    public void delete(int... iArr) {
        this.__db.assertNotSuspendingTransaction();
        StringBuilder newStringBuilder = StringUtil.newStringBuilder();
        newStringBuilder.append("DELETE FROM AlertZone WHERE id=");
        StringUtil.appendPlaceholders(newStringBuilder, iArr.length);
        SupportSQLiteStatement compileStatement = this.__db.compileStatement(newStringBuilder.toString());
        int i = 1;
        for (int i2 : iArr) {
            compileStatement.bindLong(i, (long) i2);
            i++;
        }
        this.__db.beginTransaction();
        try {
            compileStatement.executeUpdateDelete();
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }

    public static List<Class<?>> getRequiredConverters() {
        return Collections.emptyList();
    }
}
