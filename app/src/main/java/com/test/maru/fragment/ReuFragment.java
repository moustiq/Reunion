package com.test.maru.fragment;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.textfield.TextInputEditText;
import com.test.maru.R;
import com.test.maru.api.ReunionApiService;
import com.test.maru.di.DI;
import com.test.maru.model.Reunion;
import com.test.maru.reunion_list.AddReunionActivity;
import com.test.maru.reunion_list.MainActivity;
import com.test.maru.reunion_list.ReunionRecyclerAdapter;
import com.test.maru.utils.Utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;


public class ReuFragment extends Fragment {

    public static final String TAG = "REUNION_LIST";
    private ReunionApiService mReunionApiService;
    private List<Reunion> mReunions;
    private RecyclerView mRecyclerView;
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

        Log.d("HERE", "onCreateView: start create");

        adapter = new ReunionRecyclerAdapter(getContext(), Collections.<Reunion>emptyList());
        mRecyclerView = view.findViewById(R.id.reu_recycler);
        floatingButton = view.findViewById(R.id.floating_button);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        //mRecyclerView.addItemDecoration(new DividerItemDecoration(Objects.requireNonNull(getContext()),DividerItemDecoration.VERTICAL));
        mRecyclerView.setAdapter(adapter);
        refresh();
        setListner();

        Log.d("HERE", "onCreateView: return view");
        return view;
    }

    private void setListner() {

        floatingButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), AddReunionActivity.class);
                startActivity(intent);
            }
        });

    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        refresh();
    }

    private void refresh() {
        mReunions = mReunionApiService.getReunions();
        Log.d("REFRESH", "refresh: am i visible ? " + isVisible());
        // assert
        adapter.updateMeeting(mReunions);

    }

    public void filter() {

        adapter.updateMeeting(Utils.result);

    }

}