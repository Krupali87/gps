package com.app.gpsphonelocator_new;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class ViewModal extends AndroidViewModel {

    private  UserFriendRepository repository;
    private LiveData<List<UserFriend>> alluser;

    private UserFriendDao userFriendDao;

    public ViewModal(@NonNull Application application) {
        super(application);
        repository = new UserFriendRepository(application);
        alluser = repository.getAllUser();
       userFriendDao = getUserFriendDao();
    }

    public void insert(UserFriend userFriend) {
        repository.insert(userFriend);
    }
    public void delete(UserFriend userFriend) {
        repository.delete(userFriend);
    }

    public UserFriendDao getUserFriendDao() {
        return userFriendDao;
    }

    public LiveData<List<UserFriend>> alluser() {
        return alluser;
    }
}
