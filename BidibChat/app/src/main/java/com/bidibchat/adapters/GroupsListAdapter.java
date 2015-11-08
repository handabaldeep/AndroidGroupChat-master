package com.bidibchat.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


import com.bidibchat.ChatActivity;
import com.bidibchat.R;
import com.bidibchat.models.GroupsListModel;

import java.util.ArrayList;

/**
 * Created by Inderdeep on 17-09-2015.
 */
public class GroupsListAdapter extends RecyclerView.Adapter<GroupsListAdapter.ViewHolder>{

    Context context;
    ArrayList<GroupsListModel> modelList;

    public GroupsListAdapter(Context context, ArrayList<GroupsListModel> modelList){

        this.context = context;
        this.modelList = modelList;

    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemLayoutView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.group_list_item, null);
        final ViewHolder viewHolder = new ViewHolder(itemLayoutView);

        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent openChatActivity = new Intent(context, ChatActivity.class);
                context.startActivity(openChatActivity);
            }
        });

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.setPos(position);
        holder.groupImage.setImageResource(R.drawable.profile_mask);
        holder.groupNameLabel.setText(modelList.get(position).getGroupName());
        holder.groupMembersLabel.setText(modelList.get(position).geNumberOfGroupMembers());

    }

    @Override
    public int getItemCount() {
        return modelList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{


        public ImageView groupImage;
        public TextView groupNameLabel;
        public TextView groupMembersLabel;

        private int pos = -1;

        public int getPos() {
            return pos;
        }

        public void setPos(int pos) {
            this.pos = pos;
        }

        public ViewHolder(View itemView) {
            super(itemView);

            groupImage = (ImageView) itemView.findViewById(R.id.group_image);
            groupNameLabel = (TextView) itemView.findViewById(R.id.group_name_label);
            groupMembersLabel = (TextView) itemView.findViewById(R.id.number_of_group_members_label);

        }
    }
}
