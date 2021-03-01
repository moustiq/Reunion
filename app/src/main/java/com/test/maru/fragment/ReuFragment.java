package com.test.maru.fragment;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.test.maru.R;
import com.test.maru.api.ReunionApiService;
import com.test.maru.di.DI;
import com.test.maru.model.Reunion;
import com.test.maru.reunion_list.ReunionRecyclerAdapter;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ReuFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ReuFragment extends Fragment {

    private ReunionApiService mReunionApiService;
    private List<Reunion> mReunions;
    private RecyclerView mRecyclerView;


    public ReuFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ReuFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ReuFragment newInstance() {
        ReuFragment fragment = new ReuFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mReunionApiService = DI.getReunionApiService();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.reunion_list,container);
        Context context = view.getContext();
        mRecyclerView = (RecyclerView) view;
        mRecyclerView.setLayoutManager(new LinearLayoutManager(context));
        mRecyclerView.addItemDecoration(new DividerItemDecoration(getContext(),DividerItemDecoration.VERTICAL));
        return view;
    }
    private void initList() {
        mReunions = mReunionApiService.getReunions();
        mRecyclerView.setAdapter(new ReunionRecyclerAdapter(mReunions));
    }

    @Override
    public void onResume() {
        super.onResume();
        initList();
    }

    @Override
    public void onStart() {
        super.onStart();
    }

    @Override
    public void onStop() {
        super.onStop();
    }
}