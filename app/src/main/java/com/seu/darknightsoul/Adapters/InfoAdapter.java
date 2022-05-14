package com.seu.darknightsoul.Adapters;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.seu.darknightsoul.DrToHelp;
import com.seu.darknightsoul.Model.InfoList;
import com.seu.darknightsoul.R;

import java.util.List;

public class InfoAdapter extends RecyclerView.Adapter<InfoAdapter.InfoViewHolder> {
    Context context;
    List<InfoList> infoLists;
    TextView title,detail;
    Button done;

    public InfoAdapter(Context context, List<InfoList> infoLists) {
        this.context = context;
        this.infoLists = infoLists;
    }

    @NonNull
    @Override
    public InfoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.info_item,parent,false);

        return new InfoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull InfoViewHolder holder, @SuppressLint("RecyclerView") int position) {

        holder.infoTxt.setText(infoLists.get(position).getInfoName());
        holder.infoImg.setImageResource(infoLists.get(position).getInfoImg());

        holder.infoImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (position==3){
                    Intent intent =new Intent(context, DrToHelp.class);
                    holder.itemView.getContext().startActivity(intent);

                }else {
                    Dialog infoD =new Dialog(context);
                    infoD.setContentView(R.layout.info_dialog);
                    infoD.getWindow().setBackgroundDrawableResource(R.drawable.dialog_window);
                    title= infoD.findViewById(R.id.titleD);
                    detail = infoD.findViewById(R.id.detaiD);
                    done= infoD.findViewById(R.id.done);
                    title.setText(infoLists.get(position).getInfoName());
                    detail.setText(infoLists.get(position).getInfoDtl());

                    done.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            infoD.dismiss();
                        }
                    });
                    infoD.show();
                }
            }
        });

    }

    @Override
    public int getItemCount() {
        return infoLists.size();
    }

    public static final class InfoViewHolder extends RecyclerView.ViewHolder{

        ImageView infoImg;
        TextView infoTxt;
        public InfoViewHolder(@NonNull View itemView) {
            super(itemView);
            infoImg = itemView.findViewById(R.id.infoPic);
            infoTxt= itemView.findViewById(R.id.infoTxt);
        }
    }

}
