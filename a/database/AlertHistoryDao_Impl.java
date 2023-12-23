package com.app.gpsphonelocator_new.database;

import android.annotation.SuppressLint;
import android.database.Cursor;
import android.os.CancellationSignal;

import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.room.util.StringUtil;
import androidx.sqlite.db.SupportSQLiteStatement;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class AlertHistoryDao_Impl implements AlertHistoryDao {
    private final RoomDatabase __db;
    private final EntityDeletionOrUpdateAdapter<AlertHistoryEntity> __deletionAdapterOfAlertHistoryEntity;
    private final EntityInsertionAdapter<AlertHistoryEntity> __insertionAdapterOfAlertHistoryEntity;
    private final SharedSQLiteStatement __preparedStmtOfDeleteAll;

    @SuppressLint("RestrictedApi")
    public AlertHistoryDao_Impl(RoomDatabase roomDatabase) {
        this.__db = roomDatabase;
        this.__insertionAdapterOfAlertHistoryEntity = new EntityInsertionAdapter<AlertHistoryEntity>(roomDatabase) {
            public String createQuery() {
                return "INSERT OR ABORT INTO `AlertHistory` (`id`,`zone_id`,`zone_name`,`user_uid`,`user_name`,`on_enter`,`on_leave`,`status`,`time`,`is_tmp`) VALUES (nullif(?, 0),?,?,?,?,?,?,?,?,?)";
            }

            public void bind(SupportSQLiteStatement supportSQLiteStatement, AlertHistoryEntity alertHistoryEntity) {
                supportSQLiteStatement.bindLong(1, (long) alertHistoryEntity.getId());
                supportSQLiteStatement.bindLong(2, (long) alertHistoryEntity.getZoneId());
                if (alertHistoryEntity.getZoneName() == null) {
                    supportSQLiteStatement.bindNull(3);
                } else {
                    supportSQLiteStatement.bindString(3, alertHistoryEntity.getZoneName());
                }
                if (alertHistoryEntity.getUid() == null) {
                    supportSQLiteStatement.bindNull(4);
                } else {
                    supportSQLiteStatement.bindString(4, alertHistoryEntity.getUid());
                }
                if (alertHistoryEntity.getUserName() == null) {
                    supportSQLiteStatement.bindNull(5);
                } else {
                    supportSQLiteStatement.bindString(5, alertHistoryEntity.getUserName());
                }
                supportSQLiteStatement.bindLong(6, alertHistoryEntity.getOnEnter() ? 1 : 0);
                supportSQLiteStatement.bindLong(7, alertHistoryEntity.getOnLeave() ? 1 : 0);
                supportSQLiteStatement.bindLong(8, (long) alertHistoryEntity.getStatus());
                supportSQLiteStatement.bindLong(9, alertHistoryEntity.getTime());
                supportSQLiteStatement.bindLong(10, alertHistoryEntity.isTmp() ? 1 : 0);
            }
        };
        this.__deletionAdapterOfAlertHistoryEntity = new EntityDeletionOrUpdateAdapter<AlertHistoryEntity>(roomDatabase) {
            public String createQuery() {
                return "DELETE FROM `AlertHistory` WHERE `id` = ?";
            }

            public void bind(SupportSQLiteStatement supportSQLiteStatement, AlertHistoryEntity alertHistoryEntity) {
                supportSQLiteStatement.bindLong(1, (long) alertHistoryEntity.getId());
            }
        };
        this.__preparedStmtOfDeleteAll = new SharedSQLiteStatement(roomDatabase) {
            public String createQuery() {
                return "DELETE FROM AlertHistory";
            }
        };
    }

    @SuppressLint("RestrictedApi")
    public void insert(AlertHistoryEntity... alertHistoryEntityArr) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            this.__insertionAdapterOfAlertHistoryEntity.insert( alertHistoryEntityArr);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }

    @SuppressLint("RestrictedApi")
    public void delete(AlertHistoryEntity... alertHistoryEntityArr) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            this.__deletionAdapterOfAlertHistoryEntity.handleMultiple(alertHistoryEntityArr);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }

    @SuppressLint("RestrictedApi")
    public void deleteAll() {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement acquire = this.__preparedStmtOfDeleteAll.acquire();
        this.__db.beginTransaction();
        try {
            acquire.executeUpdateDelete();
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
            this.__preparedStmtOfDeleteAll.release(acquire);
        }
    }

    @SuppressLint("RestrictedApi")
    public List<AlertHistoryEntity> getHistoryList() {
        String str;
        String str2;
        String str3;
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT * FROM AlertHistory WHERE is_tmp = 0", 0);
        this.__db.assertNotSuspendingTransaction();
        Cursor query = DBUtil.query(this.__db, acquire, false, (CancellationSignal) null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(query, "id");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(query, "zone_id");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(query, "zone_name");
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(query, "user_uid");
            int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(query, "user_name");
            int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(query, "on_enter");
            int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(query, "on_leave");
            int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(query, "status");
            int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(query, "time");
            int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(query, "is_tmp");
            ArrayList arrayList = new ArrayList(query.getCount());
            while (query.moveToNext()) {
                int i = query.getInt(columnIndexOrThrow);
                int i2 = query.getInt(columnIndexOrThrow2);
                if (query.isNull(columnIndexOrThrow3)) {
                    str = null;
                } else {
                    str = query.getString(columnIndexOrThrow3);
                }
                if (query.isNull(columnIndexOrThrow4)) {
                    str2 = null;
                } else {
                    str2 = query.getString(columnIndexOrThrow4);
                }
                if (query.isNull(columnIndexOrThrow5)) {
                    str3 = null;
                } else {
                    str3 = query.getString(columnIndexOrThrow5);
                }
                arrayList.add(new AlertHistoryEntity(i, i2, str, str2, str3, query.getInt(columnIndexOrThrow6) != 0, query.getInt(columnIndexOrThrow7) != 0, query.getInt(columnIndexOrThrow8), query.getLong(columnIndexOrThrow9), query.getInt(columnIndexOrThrow10) != 0));
            }
            return arrayList;
        } finally {
            query.close();
            acquire.release();
        }
    }

    @SuppressLint("RestrictedApi")
    public List<AlertHistoryEntity> getHistoryFilter(String str, long j, long j2) {
        String str2;
        String str3;
        String str4;
        String str5 = str;
        @SuppressLint("RestrictedApi") RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT * FROM AlertHistory WHERE user_name LIKE '%' || ? || '%' AND time >= ? AND time <= ? AND is_tmp = 0", 3);
        if (str5 == null) {
            acquire.bindNull(1);
        } else {
            acquire.bindString(1, str5);
        }
        acquire.bindLong(2, j);
        acquire.bindLong(3, j2);
        this.__db.assertNotSuspendingTransaction();
        Cursor query = DBUtil.query(this.__db, acquire, false, (CancellationSignal) null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(query, "id");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(query, "zone_id");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(query, "zone_name");
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(query, "user_uid");
            int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(query, "user_name");
            int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(query, "on_enter");
            int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(query, "on_leave");
            int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(query, "status");
            int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(query, "time");
            int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(query, "is_tmp");
            ArrayList arrayList = new ArrayList(query.getCount());
            while (query.moveToNext()) {
                int i = query.getInt(columnIndexOrThrow);
                int i2 = query.getInt(columnIndexOrThrow2);
                if (query.isNull(columnIndexOrThrow3)) {
                    str2 = null;
                } else {
                    str2 = query.getString(columnIndexOrThrow3);
                }
                if (query.isNull(columnIndexOrThrow4)) {
                    str3 = null;
                } else {
                    str3 = query.getString(columnIndexOrThrow4);
                }
                if (query.isNull(columnIndexOrThrow5)) {
                    str4 = null;
                } else {
                    str4 = query.getString(columnIndexOrThrow5);
                }
                arrayList.add(new AlertHistoryEntity(i, i2, str2, str3, str4, query.getInt(columnIndexOrThrow6) != 0, query.getInt(columnIndexOrThrow7) != 0, query.getInt(columnIndexOrThrow8), query.getLong(columnIndexOrThrow9), query.getInt(columnIndexOrThrow10) != 0));
            }
            return arrayList;
        } finally {
            query.close();
            acquire.release();
        }
    }

    @SuppressLint("RestrictedApi")
    public AlertHistoryEntity getFirstHistory(String r30, int r31) {
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT * FROM AlertHistory WHERE user_uid=? AND zone_id=? ORDER BY time DESC LIMIT 1", 2);
        if (r30 == null) {
            acquire.bindNull(1);
        } else {
            acquire.bindString(1, r30);
        }
        acquire.bindLong(2, r31);
        this.__db.assertNotSuspendingTransaction();
        AlertHistoryEntity alertHistoryEntity = null;
        Cursor query = DBUtil.query(this.__db, acquire, false, null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(query, "id");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(query, "zone_name");
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(query, "user_uid");
            int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(query, "user_name");
            int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(query, "on_enter");
            int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(query, "on_leave");
            int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(query, "status");
            int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(query, "time");
            int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(query, "is_tmp");
            if (query.moveToFirst())
                alertHistoryEntity = new AlertHistoryEntity(query.getInt(columnIndexOrThrow), query.getInt(columnIndexOrThrow), query.isNull(columnIndexOrThrow3) ? null : query.getString(columnIndexOrThrow3), query.isNull(columnIndexOrThrow4) ? null : query.getString(columnIndexOrThrow4), query.isNull(columnIndexOrThrow5) ? null : query.getString(columnIndexOrThrow5), query.getInt(columnIndexOrThrow6) != 0, query.getInt(columnIndexOrThrow7) != 0, query.getInt(columnIndexOrThrow8), query.getLong(columnIndexOrThrow9), query.getInt(columnIndexOrThrow10) != 0);
            return alertHistoryEntity;
        } finally {
            query.close();
            acquire.release();
        }

    }

    @SuppressLint("RestrictedApi")
    public void delete(int... iArr) {
        this.__db.assertNotSuspendingTransaction();
        StringBuilder newStringBuilder = StringUtil.newStringBuilder();
        newStringBuilder.append("DELETE FROM AlertHistory WHERE id=");
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
