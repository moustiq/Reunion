package com.test.maru.reunion_list;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.test.maru.R;
import com.test.maru.model.Reunion;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;


public class ReunionRecyclerAdapter extends RecyclerView.Adapter<ReunionRecyclerAdapter.ViewHolder> {

    private final LayoutInflater mInflater;
    private List<Reunion> mReunions;


    public ReunionRecyclerAdapter(Context context, List<Reunion> reunions) {
        mReunions = reunions;
        mInflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.row_reu, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.bind(mReunions.get(position));

        holder.deleteIcon.setOnClickListener(v -> {

            mReunions.remove(position);
            updateMeeting(mReunions);

        });
    }

    public void updateMeeting(List<Reunion> newListe) {
        mReunions = newListe;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return mReunions.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        public CircleImageView avatar;
        public TextView sujet;
        public TextView mail;
        public ImageView deleteIcon;
        int randomDrawable = (int) (5 * Math.random()) + 1;
        int[] drawable = new int[]{R.drawable.circle, R.drawable.circle2, R.drawable.circle3, R.drawable.circle4, R.drawable.circle5, R.drawable.circle6, R.drawable.circle7, R.drawable.circle8};

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
            avatar.setImageResource(drawable[randomDrawable]);
            sujet.setText(String.format("%s - %s - %s", r.getSujet(), r.getHeure(), r.getLieu()));
            mail.setText(r.getMails().toString().replaceAll("[\\[\\](){}]", ""));
        }

    }
}
