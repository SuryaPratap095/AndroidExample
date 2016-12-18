package com.example.suryasolanki.matka.Adapters;

import android.content.Context;
import android.support.v7.widget.PopupMenu;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.suryasolanki.matka.Java.BidData;
import com.example.suryasolanki.matka.R;

import java.util.List;

import static com.example.suryasolanki.matka.Adapters.ExtendedRecyclerAdapter.ExtendedViewHolder.CHILD;
import static com.example.suryasolanki.matka.Adapters.ExtendedRecyclerAdapter.ExtendedViewHolder.HEADER;

/**
 * Created by surya.solanki on 12-12-2016.
 */

public class ExtendedRecyclerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context context;
    private PopupMenu popupMenu;
    private List<BidData> bidDataList;

    public class ExtendedViewHolder extends RecyclerView.ViewHolder {

        public TextView bidText;
        public ImageView thumbNail;
        public int referItem;

        public static final int HEADER = 0;
        public static final int CHILD = 1;

        public ExtendedViewHolder(View view) {
            super(view);
            bidText = (TextView) view.findViewById(R.id.itemName);
            thumbNail = (ImageView) view.findViewById(R.id.dropdownIcon);
        }
    }

    public ExtendedRecyclerAdapter(Context context, List<BidData> bidDataList) {
        this.context = context;
        this.bidDataList = bidDataList;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        float dp = context.getResources().getDisplayMetrics().density;
        int subItemPaddingLeft = (int) (18 * dp);
        int subItemPaddingTopandBottom = (int) (5 * dp);

        switch (viewType) {
            case HEADER:
                LayoutInflater inflater = (LayoutInflater) parent.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                View view = inflater.inflate(R.layout.card_view, parent, false);
                ExtendedViewHolder header = new ExtendedViewHolder(view);
                return header;
            case CHILD:
                TextView itemTextView = new TextView(context);
                itemTextView.setPadding(subItemPaddingLeft, subItemPaddingTopandBottom, 0, subItemPaddingTopandBottom);
                itemTextView.setTextColor(0x88000000);
                itemTextView.setLayoutParams(
                        new ViewGroup.LayoutParams(
                                ViewGroup.LayoutParams.MATCH_PARENT,
                                ViewGroup.LayoutParams.WRAP_CONTENT));
                return new RecyclerView.ViewHolder(itemTextView) {

                };
        }
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        final BidData item = bidDataList.get(position);
        switch(item.getType()){
            case HEADER:
                ExtendedViewHolder extendedViewHolder=(ExtendedViewHolder) holder;
                extendedViewHolder.referItem=item.getType();
                extendedViewHolder.bidText.setText(item.getType());
                //int temp=item.getType();
                if(item.getBidValue()==null){


                }

        }

    }

    @Override
    public int getItemCount() {
        return 0;
    }

}





