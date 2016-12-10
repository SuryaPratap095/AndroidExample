package com.example.suryasolanki.matka;

import android.content.Context;
import android.media.Image;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by surya.solanki on 10-12-2016.
 */

public class RecylcerViewAdapter extends RecyclerView.Adapter<RecylcerViewAdapter.MyViewHolder>{

    private Context context;
    private List<BidData> bidDataList;

    public class MyViewHolder extends RecyclerView.ViewHolder{

        public TextView bidText;
        public ImageView thumbNail;

        public MyViewHolder(View view) {
            super(view);
            bidText=(TextView) view.findViewById(R.id.itemName);
            thumbNail=(ImageView) view.findViewById(R.id.dropdownIcon);
        }

    }

    public RecylcerViewAdapter(Context context,List<BidData> bidDataList){
        this.context=context;
        this.bidDataList=bidDataList;
    }

    @Override
    public RecylcerViewAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView= LayoutInflater.from(parent.getContext()).inflate(R.layout.card_view,parent,false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final RecylcerViewAdapter.MyViewHolder holder, int position) {
        BidData bidData=bidDataList.get(position);
        holder.bidText.setText(bidData.getBidValue());
        holder.thumbNail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showPopMenu(holder.thumbNail);
            }
        });
    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public void showPopMenu(View view){

    }
}
