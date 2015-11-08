package com.bidibchat.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bidibchat.R;
import com.bidibchat.models.GroupsListModel;
import com.bidibchat.models.MessageModel;

import java.util.ArrayList;
import java.util.List;

public class ChatListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    Context context;
    List<MessageModel> modelList;


    public ChatListAdapter(Context context, List<MessageModel> modelList) {
        this.context = context;
        this.modelList = modelList;
    }


    @Override
    public int getItemCount() {
        return modelList.size();
    }

    @Override
    public int getItemViewType(int position) {
        // Just as an example, return 0 or 1 depending on position

      if(position % 2 == 0){

          return 0;
      }
        else {

          return 1;
      }

    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
//        View itemLayoutView = LayoutInflater.from(parent.getContext())
//                .inflate(R.layout.receive_message, null);
//        final ViewHolderSend viewHolder = new ViewHolderSend(itemLayoutView);
//
//        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Toast.makeText(context, "Message Name : " + modelList.get(viewHolder.getPos()).getText(), Toast.LENGTH_SHORT).show();
//            }
//        });
//
//        return viewHolder;

        switch (viewType) {
            case 0:
                View itemLayoutView = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.send_message,parent, false);

                final ViewHolderSend viewHolder = new ViewHolderSend(itemLayoutView);
                viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        Toast.makeText(context, Integer.toString(viewHolder.getPos()), Toast.LENGTH_SHORT).show();

                    }
                });
                return viewHolder;

            case 1:

                View headerView = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.receive_message,parent, false);

                final ViewHolderReceive headerViewHolder = new ViewHolderReceive(headerView);
                headerViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(context, Integer.toString(headerViewHolder.getPos()), Toast.LENGTH_SHORT).show();
                    }
                });
                return headerViewHolder;

            default:
                return null;

        }


    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        if(holder.getClass().equals(ViewHolderReceive.class)){

            ((ViewHolderReceive)holder).setPos(position);
            ((ViewHolderReceive)holder).messageImage.setImageResource(R.drawable.profile_mask);
            ((ViewHolderReceive)holder).senderNameLabel.setText(modelList.get(position).getSenderName());
            ((ViewHolderReceive)holder).textLabel.setText(modelList.get(position).getText());

        }
        if(holder.getClass().equals(ViewHolderSend.class)){

            ((ViewHolderSend)holder).setPos(position);
            ((ViewHolderSend)holder).textLabel.setText(modelList.get(position).getText());
        }

    }

    public class ViewHolderSend extends RecyclerView.ViewHolder{

        public TextView textLabel;

        private int pos = -1;

        public int getPos() {
            return pos;
        }

        public void setPos(int pos) {
            this.pos = pos;
        }

        public ViewHolderSend(View itemView) {
            super(itemView);

            textLabel = (TextView) itemView.findViewById(R.id.send_message_text);
        }
    }

    public class ViewHolderReceive extends RecyclerView.ViewHolder{

        public ImageView messageImage;
        public TextView senderNameLabel;
        public TextView textLabel;

        private int pos = -1;

        public int getPos() {
            return pos;
        }

        public void setPos(int pos) {
            this.pos = pos;
        }

        public ViewHolderReceive(View itemView) {
            super(itemView);

            messageImage = (ImageView) itemView.findViewById(R.id.sender_image);
            senderNameLabel = (TextView) itemView.findViewById(R.id.sender_name);
            textLabel = (TextView) itemView.findViewById(R.id.receive_message_text);

        }
    }
}