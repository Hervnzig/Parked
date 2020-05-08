package com.example.parkedapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {

    Context mContext;
    List<PaidTicketsModel> mData;

    //    public class MyViewHolder extends RecyclerView.ViewHolder{
    //        public MyViewHolder(@NonNull View itemView) {
    //            super(itemView);
    //        }
    //    }

    public RecyclerViewAdapter(Context mContext, List<PaidTicketsModel> mData) {
        this.mContext = mContext;
        this.mData = mData;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v;
        v = LayoutInflater.from(mContext).inflate(R.layout.item_paid_tickets,parent,false);
        MyViewHolder viewHolder = new MyViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        holder.tv_price.setText(mData.get(position).getTicket_price());
        holder.tv_date.setText(mData.get(position).getDate());
        holder.tv_agent_number.setText(mData.get(position).getAgent_nbr());
        holder.plate_img.setImageResource(mData.get(position).getPlate());

    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{
        private TextView tv_price;
        private TextView tv_agent_number;
        private TextView tv_date;
        private ImageView plate_img;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            tv_price = (TextView) itemView.findViewById(R.id.price);
            tv_agent_number = (TextView) itemView.findViewById(R.id.agent_nbr);
            tv_date = (TextView) itemView.findViewById(R.id.date);
            plate_img = (ImageView) itemView.findViewById(R.id.plate_ticket_img);
        }
    }



}
