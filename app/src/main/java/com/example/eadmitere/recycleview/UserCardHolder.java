package com.example.eadmitere.recycleview;

import android.view.View;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.eadmitere.R;

public class UserCardHolder extends RecyclerView.ViewHolder {
    public TextView nume;
    public TextView prenume;
    public TextView media;

    public UserCardHolder(View itemView){
        super(itemView);

        nume=(TextView) itemView.findViewById(R.id.nume);
        prenume=(TextView) itemView.findViewById(R.id.prenume);
        media=(TextView) itemView.findViewById(R.id.mediaConcurs);

    }
}
