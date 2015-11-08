package com.bidibchat;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;

import com.bidibchat.adapters.ChatListAdapter;
import com.bidibchat.models.MessageModel;

import java.util.ArrayList;
import java.util.List;


public class ChatActivity extends AppCompatActivity {

    RecyclerView chatList;
    MessageModel model;
    List<MessageModel> modelList;
    ChatListAdapter adapter;

    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_chat);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        chatList = (RecyclerView) findViewById(R.id.chat_recycler_view);
        editText = (EditText) findViewById(R.id.chatTextField);
        editText.setSelected(false);

        modelList = new ArrayList<MessageModel>();
        model = new MessageModel();
        model.setSenderName("Savvy");
        model.setText("How are you?");

        modelList.add(model);
        modelList.add(model);
        modelList.add(model);
        modelList.add(model);
        modelList.add(model);
        modelList.add(model);
        modelList.add(model);
        modelList.add(model);

        modelList.add(model);
        modelList.add(model);
        modelList.add(model);
        modelList.add(model);
        modelList.add(model);
        modelList.add(model);
        modelList.add(model);
        modelList.add(model);
        adapter = new ChatListAdapter(this,modelList);

        chatList.setLayoutManager(new LinearLayoutManager(this));
        chatList.setAdapter(adapter);

    }

    public void performSend(View v){

        model = new MessageModel();
        model.setSenderName("Savvy");
        model.setText(editText.getText().toString());
        modelList.add(model);

        adapter.notifyDataSetChanged();
        chatList.smoothScrollToPosition(modelList.size()-1);

        editText.setText("");
    }

}
