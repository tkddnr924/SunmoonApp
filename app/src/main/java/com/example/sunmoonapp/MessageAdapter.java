package com.example.sunmoonapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class MessageAdapter extends BaseAdapter {
    ArrayList<Message> messages;
    LayoutInflater inflater;
    String userNickname;

    public MessageAdapter (ArrayList<Message> ms, LayoutInflater li, String nick) {
        messages = ms;
        inflater = li;
        userNickname = nick;
    }

    @Override
    public int getCount() { return messages.size(); }

    @Override
    public Object getItem(int position) { return messages.get(position); }

    @Override
    public long getItemId(int position) { return position; }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Message message = messages.get(position);
        View itemView;
        TextView tvNick, tvDate, tvTime, tvMsg;

        if (message.nickname.equals(userNickname)) {
            itemView = inflater
                    .inflate(R.layout.my_message, parent, false);

            tvNick = itemView.findViewById(R.id.tv_myName);
            tvDate = itemView.findViewById(R.id.tv_sendDate);
            tvTime = itemView.findViewById(R.id.tv_sendTime);
            tvMsg = itemView.findViewById(R.id.tv_myMessage);

        } else {
            itemView = inflater
                    .inflate(R.layout.other_message, parent, false);

            tvNick = itemView.findViewById(R.id.tv_otherName);
            tvDate = itemView.findViewById(R.id.tv_reciveDate);
            tvTime = itemView.findViewById(R.id.tv_reciveTime);
            tvMsg = itemView.findViewById(R.id.tv_otherMessage);
        }

        tvNick.setText(message.getNickname());
        tvDate.setText(message.getDate());
        tvTime.setText(message.getTime());
        tvMsg.setText(message.getMsg());

        return itemView;
    }
}
