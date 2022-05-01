package edu.hanu.myfriend_t5.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Text;

import java.util.List;

import edu.hanu.myfriend_t5.R;
import edu.hanu.myfriend_t5.models.Friend;

public class FriendAdapters extends RecyclerView.Adapter<FriendAdapters.FriendHolder> {
    //viewholder
    protected class FriendHolder extends RecyclerView.ViewHolder {

        public FriendHolder(@NonNull View itemView) {
            super(itemView);

            // get ref to widgets
            //handle events
        }

        //update itemview with data from friend
        public void bind(Friend friend) {
            //get ref to widget
            TextView tvName = itemView.findViewById(R.id.tvFriend);
            tvName.setText(friend.getName());
        }
    }

    //dataset
    private List<Friend> friends;

    public FriendAdapters(List<Friend> friends) {
        this.friends = friends;
    }
    @Override
    public int getItemCount() {
        return friends.size();
    }

    //layout xml -> inflated layout (objects) - view -> display
    @NonNull
    @Override
    public FriendHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //context
        Context context = parent.getContext();

        //layout inflater
        LayoutInflater inflater = LayoutInflater.from(context);

        //inflate - view
        View itemView = inflater.inflate(R.layout.item_friend, parent, false);

        //wrap this view with viewholder -> return
        FriendHolder holder = new FriendHolder(itemView);

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull FriendHolder holder, int position) {
        //get data item at position
        Friend friend = friends.get(position);
        //bind data to view
        holder.bind(friend);
    }
}
