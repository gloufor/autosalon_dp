package com.example.autosalon_bashkirov;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import java.util.ArrayList;

public class VyvodAdapter extends RecyclerView.Adapter<VyvodAdapter.MyViewHolder> {
    Context context;
    ArrayList<User> list;

    public VyvodAdapter(Context context, ArrayList<User> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.userentry, parent, false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        User user = list.get(position);
        holder.dannye_vivod.setText(user.getFio());
        holder.usluga_vyvod.setText(user.getPosition());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{
        TextView dannye_vivod, usluga_vyvod;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            dannye_vivod = itemView.findViewById(R.id.textdannye);
            usluga_vyvod = itemView.findViewById(R.id.textusluga);
        }
    }
}
