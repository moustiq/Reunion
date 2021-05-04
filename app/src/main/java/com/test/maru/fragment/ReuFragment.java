package com.test.maru.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.test.maru.R;
import com.test.maru.api.ReunionApiService;
import com.test.maru.di.DI;
import com.test.maru.model.Reunion;
import com.test.maru.reunion_list.AddReunionActivity;
import com.test.maru.reunion_list.ReunionRecyclerAdapter;
import com.test.maru.utils.Utils;

import java.util.Collections;
import java.util.List;


public class ReuFragment extends Fragment {

    public static final String TAG = "REUNION_LIST";
    private ReunionApiService mReunionApiService;
    private FloatingActionButton floatingButton;
    private ReunionRecyclerAdapter adapter;


    public ReuFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mReunionApiService = DI.getReunionApiService();

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_reu, container, false);

        adapter = new ReunionRecyclerAdapter(getContext(), Collections.emptyList());
        RecyclerView recyclerView = view.findViewById(R.id.reu_recycler);
        floatingButton = view.findViewById(R.id.floating_button);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(adapter);
        refresh();
        setListner();

        return view;
    }

    private void setListner() {

        floatingButton.setOnClickListener(v -> {
            Intent intent = new Intent(getContext(), AddReunionActivity.class);
            startActivity(intent);
        });

    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        refresh();
    }

    private void refresh() {
        List<Reunion> reunions = mReunionApiService.getReunions();
        Log.d("REFRESH", "refresh: am i visible ? " + isVisible());
        // assert
        adapter.updateMeeting(reunions);

    }

    public void filter() {

        adapter.updateMeeting(Utils.result);

    }

}