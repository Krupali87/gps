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
import androidx.sqlite.db.SupportSQLiteStatement;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class UserTrackedDao_Impl implements UserTrackedDao {
    private final RoomDatabase __db;
    private final EntityDeletionOrUpdateAdapter<UserTracked> __deletionAdapterOfUserTracked;
    private final EntityInsertionAdapter<UserTracked> __insertionAdapterOfUserTracked;
    private final SharedSQLiteStatement __preparedStmtOfDeleteById;
    private final SharedSQLiteStatement __preparedStmtOfUpdateChecked;

    @SuppressLint("RestrictedApi")
    public UserTrackedDao_Impl(RoomDatabase roomDatabase) {
        this.__db = roomDatabase;
        this.__insertionAdapterOfUserTracked = new EntityInsertionAdapter<UserTracked>(roomDatabase) {
            public String createQuery() {
                return "INSERT OR ABORT INTO `UserTracked` (`uid`,`name`,`phone`,`uuid`,`checked`) VALUES (nullif(?, 0),?,?,?,?)";
            }

            public void bind(SupportSQLiteStatement supportSQLiteStatement, UserTracked userTracked) {
                supportSQLiteStatement.bindLong(1, (long) userTracked.getUid());
                if (userTracked.getName() == null) {
                    supportSQLiteStatement.bindNull(2);
                } else {
                    supportSQLiteStatement.bindString(2, userTracked.getName());
                }
                if (userTracked.getPhone() == null) {
                    supportSQLiteStatement.bindNull(3);
                } else {
                    supportSQLiteStatement.bindString(3, userTracked.getPhone());
                }
                if (userTracked.getUuid() == null) {
                    supportSQLiteStatement.bindNull(4);
                } else {
                    supportSQLiteStatement.bindString(4, userTracked.getUuid());
                }
                if (userTracked.getChecked() == null) {
                    supportSQLiteStatement.bindNull(5);
                } else {
                    supportSQLiteStatement.bindString(5, userTracked.getChecked());
                }
            }
        };
        this.__deletionAdapterOfUserTracked = new EntityDeletionOrUpdateAdapter<UserTracked>(roomDatabase) {
            public String createQuery() {
                return "DELETE FROM `UserTracked` WHERE `uid` = ?";
            }

            public void bind(SupportSQLiteStatement supportSQLiteStatement, UserTracked userTracked) {
                supportSQLiteStatement.bindLong(1, (long) userTracked.getUid());
            }
        };
        this.__preparedStmtOfDeleteById = new SharedSQLiteStatement(roomDatabase) {
            public String createQuery() {
                return "DELETE FROM usertracked WHERE uuid=?";
            }
        };
        this.__preparedStmtOfUpdateChecked = new SharedSQLiteStatement(roomDatabase) {
            public String createQuery() {
                return "UPDATE usertracked SET checked =? WHERE uuid =?";
            }
        };
    }

    @SuppressLint("RestrictedApi")
    public void insert(UserTracked... userTrackedArr) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            this.__insertionAdapterOfUserTracked.insert( userTrackedArr);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }

    @SuppressLint("RestrictedApi")
    public void delete(UserTracked... userTrackedArr) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            this.__deletionAdapterOfUserTracked.handleMultiple( userTrackedArr);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }

    @SuppressLint("RestrictedApi")
    public void deleteById(String str) {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement acquire = this.__preparedStmtOfDeleteById.acquire();
        if (str == null) {
            acquire.bindNull(1);
        } else {
            acquire.bindString(1, str);
        }
        this.__db.beginTransaction();
        try {
            acquire.executeUpdateDelete();
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
            this.__preparedStmtOfDeleteById.release(acquire);
        }
    }

    @SuppressLint("RestrictedApi")
    public void updateChecked(String str, String str2) {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement acquire = this.__preparedStmtOfUpdateChecked.acquire();
        if (str == null) {
            acquire.bindNull(1);
        } else {
            acquire.bindString(1, str);
        }
        if (str2 == null) {
            acquire.bindNull(2);
        } else {
            acquire.bindString(2, str2);
        }
        this.__db.beginTransaction();
        try {
            acquire.executeUpdateDelete();
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
            this.__preparedStmtOfUpdateChecked.release(acquire);
        }
    }

    @SuppressLint("RestrictedApi")
    public List<UserTracked> getAllUser() {
        String str;
        String str2;
        String str3;
        String str4;
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT * FROM usertracked", 0);
        this.__db.assertNotSuspendingTransaction();
        Cursor query = DBUtil.query(this.__db, acquire, false, (CancellationSignal) null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(query, "uid");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(query, "name");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(query, "phone");
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(query, "uuid");
            int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(query, "checked");
            ArrayList arrayList = new ArrayList(query.getCount());
            while (query.moveToNext()) {
                int i = query.getInt(columnIndexOrThrow);
                if (query.isNull(columnIndexOrThrow2)) {
                    str = null;
                } else {
                    str = query.getString(columnIndexOrThrow2);
                }
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
                arrayList.add(new UserTracked(i, str, str2, str3, str4));
            }
            return arrayList;
        } finally {
            query.close();
            acquire.release();
        }
    }


    @SuppressLint("RestrictedApi")
    public UserTracked getUser(String r15) {
        @SuppressLint("RestrictedApi") RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT * FROM usertracked WHERE uuid=?", 1);
        if (r15 == null) {
            acquire.bindNull(1);
        } else {
            acquire.bindString(1, r15);
        }
        this.__db.assertNotSuspendingTransaction();
        UserTracked userTracked = null;
        Cursor query = DBUtil.query(this.__db, acquire, false, null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(query, "uid");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(query, "name");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(query, "phone");
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(query, "uuid");
            int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(query, "checked");
            if (query.moveToFirst()) {
                userTracked = new UserTracked(query.getInt(columnIndexOrThrow), query.isNull(columnIndexOrThrow2) ? null : query.getString(columnIndexOrThrow2), query.isNull(columnIndexOrThrow3) ? null : query.getString(columnIndexOrThrow3), query.isNull(columnIndexOrThrow4) ? null : query.getString(columnIndexOrThrow4), query.isNull(columnIndexOrThrow5) ? null : query.getString(columnIndexOrThrow5));
            }
            return userTracked;
        } finally {
            query.close();
            acquire.release();
        }

    }

    @SuppressLint("RestrictedApi")
    public List<UserTracked> getCheckedFriends(String str) {
        String str2;
        String str3;
        String str4;
        String str5;
        String str6 = str;
        @SuppressLint("RestrictedApi") RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT * FROM usertracked WHERE uuid=?", 1);
        if (str6 == null) {
            acquire.bindNull(1);
        } else {
            acquire.bindString(1, str6);
        }
        this.__db.assertNotSuspendingTransaction();
        Cursor query = DBUtil.query(this.__db, acquire, false, (CancellationSignal) null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(query, "uid");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(query, "name");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(query, "phone");
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(query, "uuid");
            int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(query, "checked");
            ArrayList arrayList = new ArrayList(query.getCount());
            while (query.moveToNext()) {
                int i = query.getInt(columnIndexOrThrow);
                if (query.isNull(columnIndexOrThrow2)) {
                    str2 = null;
                } else {
                    str2 = query.getString(columnIndexOrThrow2);
                }
                if (query.isNull(columnIndexOrThrow3)) {
                    str3 = null;
                } else {
                    str3 = query.getString(columnIndexOrThrow3);
                }
                if (query.isNull(columnIndexOrThrow4)) {
                    str4 = null;
                } else {
                    str4 = query.getString(columnIndexOrThrow4);
                }
                if (query.isNull(columnIndexOrThrow5)) {
                    str5 = null;
                } else {
                    str5 = query.getString(columnIndexOrThrow5);
                }
                arrayList.add(new UserTracked(i, str2, str3, str4, str5));
            }
            return arrayList;
        } finally {
            query.close();
            acquire.release();
        }
    }

    public static List<Class<?>> getRequiredConverters() {
        return Collections.emptyList();
    }
}
