package com.seu.darknightsoul.Adapters;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.seu.darknightsoul.DrDetails;
import com.seu.darknightsoul.Model.DrList;
import com.seu.darknightsoul.R;

import java.util.List;

public class DrAdapter extends RecyclerView.Adapter<DrAdapter.DrViewHolder> {

    Context context;
    List<DrList> drLists;

    public DrAdapter(Context context, List<DrList> drLists) {
        this.context = context;
        this.drLists = drLists;
    }

    @NonNull
    @Override
    public DrViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.dr_item,parent,false);
        return new DrViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull DrViewHolder holder, @SuppressLint("RecyclerView") int position) {
        holder.drName.setText(drLists.get(position).getDrName());
        holder.drImg.setImageResource(drLists.get(position).getDrImg());
        holder.drLng.setText(drLists.get(position).getDrLang());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(holder.itemView.getContext(), DrDetails.class);
                intent.putExtra("object", drLists.get(position));
                holder.itemView.getContext().startActivity(intent);

            }
        });

    }

    @Override
    public int getItemCount() {
        return drLists.size();
    }

    public class DrViewHolder extends RecyclerView.ViewHolder {
        ImageView drImg;
        TextView drName,drLng;
        public DrViewHolder(@NonNull View itemView) {
            super(itemView);
            drImg = itemView.findViewById(R.id.drImg);
            drName = itemView.findViewById(R.id.drName);
            drLng = itemView.findViewById(R.id.drLang);
        }
    }
}
