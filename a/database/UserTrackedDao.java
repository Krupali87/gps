package com.app.gpsphonelocator_new.database;

import java.util.List;

import kotlin.Metadata;


public interface UserTrackedDao {
    void delete(UserTracked... userTrackedArr);

    void deleteById(String str);

    List<UserTracked> getAllUser();

    List<UserTracked> getCheckedFriends(String str);

    UserTracked getUser(String str);

    void insert(UserTracked... userTrackedArr);

    void updateChecked(String str, String str2);
}
