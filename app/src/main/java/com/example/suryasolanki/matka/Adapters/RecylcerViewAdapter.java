package com.example.suryasolanki.matka.Adapters;

import android.content.Context;
import android.content.Intent;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.PopupMenu;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.suryasolanki.matka.Java.BidData;
import com.example.suryasolanki.matka.R;
import com.example.suryasolanki.matka.Tabs.Tabbed;

import java.util.List;

/**
 * Created by surya.solanki on 10-12-2016.
 */

public class RecylcerViewAdapter extends RecyclerView.Adapter<RecylcerViewAdapter.MyViewHolder> {

    private Context context;
    private List<BidData> bidDataList;
    private PopupMenu popupMenu;
    // private CoordinatorLayout coordinatorLayout;

    public class MyViewHolder extends RecyclerView.ViewHolder {

        public TextView bidText;
        public ImageView thumbNail;
        public CoordinatorLayout coordinatorLayout;
        public Context context;

        public MyViewHolder(View view) {
            super(view);
            context=view.getContext();
            bidText = (TextView) view.findViewById(R.id.itemName);
            thumbNail = (ImageView) view.findViewById(R.id.dropdownIcon);
            coordinatorLayout = (CoordinatorLayout) view.findViewById(R.id.coordinatorLayout);
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent=new Intent(context,Tabbed.class);
                    context.startActivity(intent);

                }
            });
        }

    }

    public RecylcerViewAdapter(Context context, List<BidData> bidDataList) {
        this.context = context;
        this.bidDataList = bidDataList;
    }

    @Override
    public RecylcerViewAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_view, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final RecylcerViewAdapter.MyViewHolder holder, int position) {
        BidData bidData = bidDataList.get(position);
        holder.bidText.setText(bidData.getBidValue());
        holder.thumbNail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showPopMenu(holder.thumbNail);
                //Intent intent=new Intent()
            }
        });
    }

    @Override
    public int getItemCount() {
        return bidDataList.size();
    }

    public void showPopMenu(View view) {


        Toast.makeText(context, "Item Clicked ", Toast.LENGTH_SHORT).show();
        popupMenu = new PopupMenu(context, view);
        MenuInflater menuInflater = popupMenu.getMenuInflater();
        menuInflater.inflate(R.menu.menu_item, popupMenu.getMenu());
        CustomizedMenuClickListner menuClickListen = new CustomizedMenuClickListner();
        menuClickListen.setView(view);
        popupMenu.setOnMenuItemClickListener(menuClickListen);
        popupMenu.show();

    }

    class CustomizedMenuClickListner implements PopupMenu.OnMenuItemClickListener {

        public View view;

        public void setView(View view) {
            this.view = view;
        }

        @Override
        public boolean onMenuItemClick(MenuItem item) {
            //View view= (View) Menu.;
            Snackbar snackbar;

            switch (item.getItemId()) {
                case R.id.Bid_Value_1: {
                    snackbar = Snackbar.make(view, "Add to favorite \n favorite", Snackbar.LENGTH_LONG)
                            .setAction("Bid", new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    Toast.makeText(context, "Value Selected", Toast.LENGTH_SHORT).show();
                                }
                            });
                    View snaView = snackbar.getView();
                    TextView txtView = (TextView) snaView.findViewById(android.support.design.R.id.snackbar_text);
                    txtView.setMaxLines(5);
                    snackbar.show();
                    return true;
                }
                case R.id.Bid_value_2: {
                    snackbar = Snackbar.make(view, "Add to favorite \n favorite", Snackbar.LENGTH_LONG)
                            .setAction("Bid", new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    Toast.makeText(context, "Value Selected", Toast.LENGTH_SHORT).show();
                                }
                            });
                    View snaView = snackbar.getView();
                    TextView txtView = (TextView) snaView.findViewById(android.support.design.R.id.snackbar_text);
                    txtView.setMaxLines(5);
                    snackbar.show();
                    return true;
                }
                default:
            }

            return false;
        }
    }


}
