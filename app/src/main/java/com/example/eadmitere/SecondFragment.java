package com.example.eadmitere;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.eadmitere.databinding.FragmentSecondBinding;
import com.example.eadmitere.recycleview.UserCardAdapter;

import java.util.List;

public class SecondFragment extends Fragment {

    private FragmentSecondBinding binding;

    private List<User> users;
    private RecyclerView recyclerView;
    private  RecyclerView.Adapter usersAdapter;
    private RecyclerView.LayoutManager layout;



    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = FragmentSecondBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        DBConnector db=new DBConnector(getContext());
        users=db.getAllUsers();
        Log.d("users",users.toString());

        recyclerView= getView().findViewById(R.id.recycle);
        Log.d("af",recyclerView.toString());
        recyclerView.setNestedScrollingEnabled(false);
        recyclerView.setHasFixedSize(true);

        layout=new LinearLayoutManager(this.getContext());
        recyclerView.setLayoutManager(layout);
        usersAdapter=new UserCardAdapter(this.getContext(),users);
        recyclerView.setAdapter(usersAdapter);

        binding.buttonSecond.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(SecondFragment.this)
                        .navigate(R.id.action_SecondFragment_to_FirstFragment);
            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}