package com.example.sunmoonapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class Chat extends AppCompatActivity {
    EditText input;
    ListView listView;
    Intent intent;
    ArrayList<Message> messages = new ArrayList<>();
    MessageAdapter mAdapter;
    FirebaseDatabase fb_db;
    DatabaseReference root, childRef2;

    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.chat_layout);
        intent = getIntent();

        final String userNickname = intent.getStringExtra("nickname");
        // input = findViewById(null);
        mAdapter = new MessageAdapter(messages, getLayoutInflater(), userNickname);
        listView.setAdapter(mAdapter);
        fb_db = FirebaseDatabase.getInstance();
        root = fb_db.getReference();
        childRef2 = root.child("ChatData");

        childRef2.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
                Message newMessage = snapshot.getValue(Message.class);
                messages.add(newMessage);
                mAdapter.notifyDataSetChanged();
            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {

            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot snapshot) {

            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

    public void sendMessageToDB (String nickName) {
        String inputMessage = input.getText().toString();
        Message messageObject = new Message(nickName, inputMessage, "2020-01-01", "11:11");

        DatabaseReference msgNode = childRef2.push();
        msgNode.setValue(messageObject);

        input.setText("");
    }
}
