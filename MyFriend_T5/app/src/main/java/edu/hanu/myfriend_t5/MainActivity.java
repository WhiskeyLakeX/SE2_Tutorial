package edu.hanu.myfriend_t5;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import edu.hanu.myfriend_t5.adapters.FriendAdapters;
import edu.hanu.myfriend_t5.models.Friend;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //init dataset
        List<Friend> friends = new ArrayList<>();
        friends.add(new Friend("Son Nguyen", "sonnguyen@gmail.com", "0132465413"));
        friends.add(new Friend("SoDa Nguyen", "sodanguyen@gmail.com", "016545613"));
        friends.add(new Friend("Ha Nguyen", "hanguyen@gmail.com", "01322394563"));

        Log.i("MPR-Spring", friends.get(0).toString());

        //get ref to recycler view
        RecyclerView rvFriends = findViewById(R.id.rvFriends);

        //set layout
        rvFriends.setLayoutManager(new LinearLayoutManager(MainActivity.this));

        //set adapter
        FriendAdapters adapter = new FriendAdapters(friends);

        //bind recycler view with adapter
        rvFriends.setAdapter(adapter);
    }
}