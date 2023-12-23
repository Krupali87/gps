package com.app.gpsphonelocator_new.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.app.gpsphonelocator_new.R;
import com.app.gpsphonelocator_new.UserFriend;
import com.app.gpsphonelocator_new.UserFriendDao;
import com.app.gpsphonelocator_new.UserRVAdapter;
import com.app.gpsphonelocator_new.ViewModal;
import com.app.gpsphonelocator_new.phone.view.dialog.DialogAddNewFriend;


import java.util.List;


public final class TrackingUserListActivity extends AppCompatActivity {

    private RecyclerView rvusertracked;

    private ViewModal viewmodal;

    private static final int ADD_USER_REQUEST = 1;
    private static final int EDIT_USER_REQUEST = 2;
    public UserRVAdapter adapter;

    private UserFriendDao userFriendDao;


    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_tracking_user_list);
        rvusertracked = findViewById(R.id.rv_user_tracked);
        ImageView add = findViewById(R.id.img_add_header);


        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getApplicationContext(), DialogAddNewFriend.class);
                startActivityForResult(intent, ADD_USER_REQUEST);
            }
        });
        rvusertracked.setLayoutManager(new LinearLayoutManager(this));
        rvusertracked.setHasFixedSize(true);
        viewmodal = ViewModelProviders.of(this).get(ViewModal.class);
        UserRVAdapter adapter = new UserRVAdapter(userFriendDao);
        rvusertracked.setAdapter(adapter);


        viewmodal.alluser().observe(this, new Observer<List<UserFriend>>() {
            @Override
            public void onChanged(List<UserFriend> models) {
                // when the data is changed in our models we are
                // adding that list to our adapter class.
                adapter.submitList(models);
            }
        });

        new ItemTouchHelper(new ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT) {
            @Override
            public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
                return false;
            }

            @Override
            public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
                viewmodal.delete(adapter.getUserAt(viewHolder.getAdapterPosition()));
                Toast.makeText(getApplicationContext(), "Course deleted", Toast.LENGTH_SHORT).show();
            }
        }).attachToRecyclerView(rvusertracked);


        adapter.setOnItemClickListener(new UserRVAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(UserFriend userFriend) {
                Intent intent = new Intent(getApplicationContext(), DialogAddNewFriend.class);
                intent.putExtra(DialogAddNewFriend.EXTRA_ID, userFriend.getId());
                intent.putExtra(DialogAddNewFriend.EXTRA_NAME, userFriend.getname());
                intent.putExtra(DialogAddNewFriend.EXTRA_SECURITY_CODE, userFriend.getsecurityCode());
                intent.putExtra(DialogAddNewFriend.EXTRA_PHONE_NUMBER, userFriend.getphoneNumber());

                startActivityForResult(intent, EDIT_USER_REQUEST);
            }
        });


        }
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == ADD_USER_REQUEST && resultCode == RESULT_OK) {
            String Name = data.getStringExtra(DialogAddNewFriend.EXTRA_NAME);
            String securityCode = data.getStringExtra(DialogAddNewFriend.EXTRA_SECURITY_CODE);
            String phoneNumber = data.getStringExtra(DialogAddNewFriend.EXTRA_PHONE_NUMBER);
            UserFriend userFriend = new UserFriend(Name, securityCode, phoneNumber);
            viewmodal.insert(userFriend);
            Toast.makeText(this, "user saved", Toast.LENGTH_SHORT).show();
            dismissDialog(Integer.parseInt(DialogAddNewFriend.EXTRA_ID));
        } else if (requestCode == EDIT_USER_REQUEST && resultCode == RESULT_OK) {
            int id = data.getIntExtra(DialogAddNewFriend.EXTRA_ID, -1);
            if (id == -1) {
                Toast.makeText(this, "user can't be updated", Toast.LENGTH_SHORT).show();
                return;
            }
            String Name = data.getStringExtra(DialogAddNewFriend.EXTRA_NAME);
            String securityCode = data.getStringExtra(DialogAddNewFriend.EXTRA_SECURITY_CODE);
            String phoneNumber = data.getStringExtra(DialogAddNewFriend.EXTRA_PHONE_NUMBER);
            UserFriend userFriend = new UserFriend(Name, securityCode, phoneNumber);
            userFriend.setId(id);

        } else {
            Toast.makeText(this, "user not saved", Toast.LENGTH_SHORT).show();
        }


    }




}
