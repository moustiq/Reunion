package com.test.maru.reunion_list;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.test.maru.R;
import com.test.maru.model.Reunion;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ReunionRecyclerAdapter extends RecyclerView.Adapter<ReunionRecyclerAdapter.ViewHolder> {

    private final List<Reunion> mReunions;

    public ReunionRecyclerAdapter(List<Reunion> reunions) {
        mReunions = reunions;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_reu,parent);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        final Reunion reunion = mReunions.get(position);
        holder.mTextViewName.setText(reunion.getSujet());

    }


    @Override
    public int getItemCount() {
        return mReunions.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.item_avatar)
        public ImageView mImageViewAvatar;

        @BindView(R.id.item_list_name)
        public TextView mTextViewName;

        @BindView(R.id.item_list_delete)
        public ImageButton mImageButtonDelete;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }
}
