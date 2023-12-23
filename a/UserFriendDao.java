package com.app.gpsphonelocator_new;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface UserFriendDao {
    @Query("SELECT * FROM usertrackingfriend_table")
    LiveData<List<UserFriend>> getAllUser();
    @Insert
    void insert(UserFriend userFriend);

    @Delete
    public void delete(UserFriend userFriend);

    @Query("DELETE FROM usertrackingfriend_table")
    void deleteAllFriends();

}