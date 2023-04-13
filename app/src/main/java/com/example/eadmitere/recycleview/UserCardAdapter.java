package com.example.eadmitere.recycleview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.eadmitere.R;
import com.example.eadmitere.User;

import java.util.List;

public class UserCardAdapter extends RecyclerView.Adapter<UserCardHolder> {
    Context context;
    private List<User> users;

    public  UserCardAdapter(Context context,List<User> users){
        this.context=context;
        this.users=users;
    }

    @NonNull
    @Override
    public UserCardHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View layout= LayoutInflater.from(parent.getContext()).inflate(R.layout.user_card,null,false);
        RecyclerView.LayoutParams params=new RecyclerView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.WRAP_CONTENT);
        layout.setLayoutParams(params);

        UserCardHolder uch=new UserCardHolder((layout));
        return uch;
    }

    @Override
    public void onBindViewHolder(@NonNull UserCardHolder holder, int position) {
        holder.nume.setText(users.get(position).getNume());
        holder.prenume.setText(users.get(position).getPrenume());

        double media=Double.parseDouble(users.get(position).getMediaScolara())*0.7+Double.parseDouble(users.get(position).getMediaBAC())*0.3;
        holder.media.setText(media+"");

    }

    @Override
    public int getItemCount() {
        return users.size();
    }
}
