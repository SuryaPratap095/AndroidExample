package com.example.suryasolanki.matka;

import android.content.Context;
import android.support.v7.widget.PopupMenu;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by surya.solanki on 12-12-2016.
 */

public class ExtendedRecyclerAdapter extends RecyclerView.Adapter<ExtendedRecyclerAdapter.ExtendedViewHolder> {

    private Context context;
    private PopupMenu popupMenu;
    private List<BidData> bidDataList;

    public class ExtendedViewHolder extends RecyclerView.ViewHolder{

        public TextView bidText;
        public ImageView thumbNail;

        public ExtendedViewHolder(View view) {
            super(view);
            bidText=(TextView) view.findViewById(R.id.itemName);
            thumbNail=(ImageView) view.findViewById(R.id.dropdownIcon);
        }
    }

    public ExtendedRecyclerAdapter(Context context, List<BidData> bidDataList) {
        this.context = context;
        this.bidDataList = bidDataList;
    }

    @Override
    public ExtendedRecyclerAdapter.ExtendedViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context=parent.getContext();
        float dp=context.getResources().getDisplayMetrics().density;
        return null;
    }

    @Override
    public void onBindViewHolder(ExtendedRecyclerAdapter.ExtendedViewHolder holder, int position) {

    }
    @Override
    public int getItemCount() {
        return 0;
    }
}
