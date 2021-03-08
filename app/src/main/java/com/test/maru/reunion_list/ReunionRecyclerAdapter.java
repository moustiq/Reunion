package com.test.maru.reunion_list;


import android.content.Context;
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
    private final LayoutInflater mInflater;

    public ReunionRecyclerAdapter(Context context, List<Reunion> reunions) {
        mReunions = reunions;
        mInflater = LayoutInflater.from(context);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.row_reu, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.bind(mReunions.get(position));
    }

    @Override
    public int getItemCount() {
        return mReunions.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public ImageView avatar;
        public TextView sujet;
        public ImageView deleteIcon;

        public ViewHolder(View itemView) {
            super(itemView);
            //ButterKnife.bind(this,itemView);
            sujet = itemView.findViewById(R.id.reunion_sujet);
            avatar = itemView.findViewById(R.id.reunion_avatar);
            deleteIcon = itemView.findViewById(R.id.reunion_delete);
        }

        void bind(Reunion r) {
            sujet.setText(r.getSujet() + " - " + r.getHeure() + " - " + r.getLieu());
        }
    }
}
