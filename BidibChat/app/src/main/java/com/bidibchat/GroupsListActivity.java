package com.bidibchat;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Toast;


import com.bidibchat.adapters.GroupsListAdapter;
import com.bidibchat.models.GroupsListModel;

import java.util.ArrayList;


public class GroupsListActivity extends AppCompatActivity {

    Toolbar toolbar;
    RecyclerView groupListView;
    ArrayList<GroupsListModel> dummyDataList;
    GroupsListModel dummyData;
    GroupsListAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_groups_list);

        toolbar = (Toolbar) findViewById(R.id.groups_toolbar);
        setSupportActionBar(toolbar);

        groupListView = (RecyclerView) findViewById(R.id.groups_list_recycler_view);

        dummyDataList = new ArrayList<>();

        dummyData = new GroupsListModel();

        dummyData.setGroupImageName("");
        dummyData.setGroupName("Dummy Name");
        dummyData.setNumberOfGroupMembers("90");

        for(int i=0;i<4;i++) {
            dummyDataList.add(dummyData);
        }

        adapter = new GroupsListAdapter(this,dummyDataList);
        groupListView.setLayoutManager(new LinearLayoutManager(this));
        groupListView.setAdapter(adapter);

    }

    public void onAddGroupButtonClicked(View v){

        GroupsListModel temp = new GroupsListModel();
        temp.setGroupImageName("");
        temp.setNumberOfGroupMembers("1");
        temp.setGroupName("New Group Name");
        dummyDataList.add(temp);
        adapter.notifyDataSetChanged();
        groupListView.smoothScrollToPosition(dummyDataList.size()-1);

    }

}
