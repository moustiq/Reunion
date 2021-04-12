package com.test.maru.reunion_list;


import android.content.Context;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.test.maru.R;
import com.test.maru.api.ReunionApiService;
import com.test.maru.model.Reunion;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

import static java.security.AccessController.getContext;

public class ReunionRecyclerAdapter extends RecyclerView.Adapter<ReunionRecyclerAdapter.ViewHolder> {

    private final List<Reunion> mReunions;
    private final LayoutInflater mInflater;
    public ReunionApiService mReunionApiService;
    private ReunionRecyclerAdapter mReunionRecyclerAdapter;

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

        holder.deleteIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mReunions.remove(position);
                updateMeeting(holder,position);

                Log.d("DELETE REUNION", "onClick: delete" + position);
            }
        });
    }

    public void updateMeeting(final ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return mReunions.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public ImageView avatar;
        public TextView sujet;
        public TextView mail;
        public ImageView deleteIcon;


        public ViewHolder(View itemView) {
            super(itemView);
            //ButterKnife.bind(this,itemView);
            avatar = itemView.findViewById(R.id.reunion_avatar);
            sujet = itemView.findViewById(R.id.reunion_sujet);
            mail = itemView.findViewById(R.id.reunion_mail);
            avatar = itemView.findViewById(R.id.reunion_avatar);
            deleteIcon = itemView.findViewById(R.id.reunion_delete);
        }

        void bind(Reunion r) {
            avatar.setColorFilter(r.getAvatar(), PorterDuff.Mode.MULTIPLY);
            sujet.setText(r.getSujet() + " - " + r.getHeure() + " - " + r.getLieu());
            mail.setText(r.getMails().toString());
        }

    }
}
