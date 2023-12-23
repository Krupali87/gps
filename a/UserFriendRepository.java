package com.app.gpsphonelocator_new;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import java.util.List;

public class UserFriendRepository {
    private UserFriendDao dao;
    private LiveData<List<UserFriend>> alluser;

    public UserFriendRepository(Application application) {
        UserFriendDatabase database = UserFriendDatabase.getInstance(application);
        dao = database.Dao();
        alluser = dao.getAllUser();
    }
    public void insert(UserFriend userFriend) {
        new InsertUserAsyncTask(dao).execute(userFriend);
    }
    public void delete(UserFriend userFriend) {
        new DeleteUserAsyncTask(dao).execute(userFriend);
    }
    public LiveData<List<UserFriend>> getAllUser() {
        return alluser;
    }

    private static class InsertUserAsyncTask extends AsyncTask<UserFriend, Void, Void> {
        private UserFriendDao dao;

        private InsertUserAsyncTask(UserFriendDao dao) {
            this.dao = dao;
        }

        @Override
        protected Void doInBackground(UserFriend... userFriends) {
            dao.insert(userFriends[0]);
           return null;
        }

        }
    private static class DeleteUserAsyncTask extends AsyncTask<UserFriend, Void, Void> {
        private UserFriendDao dao;

        private DeleteUserAsyncTask(UserFriendDao dao) {
            this.dao = dao;
        }


        @Override
        protected Void doInBackground(UserFriend... userFriends) {
            dao.delete(userFriends[0]);
           return null;
        }
    }

}
