package com.example.suryasolanki.matka.Adapters;

import android.content.Context;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.suryasolanki.matka.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by surya.solanki on 14-12-2016.
 */

public class NewExtendedAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{

    public final static int HEADER=0;
    public final static  int CHILD=1;

    private List<Item> data;
    public Item item;
    public ListViewHolder itemCollector;

    public NewExtendedAdapter(List<Item> item){
        this.data=item;
    }
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int type) {
        View view=null;
        Context context=parent.getContext();
        float dp=context.getResources().getDisplayMetrics().density;
        int subItemPaddingLeft=(int)(18 * dp);
        int subItemPaddingTopandBottom=(int)(5 * dp);
        switch(type){
            case HEADER:
                LayoutInflater inflater=(LayoutInflater) parent.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                view=inflater.inflate(R.layout.list_header,parent,false);
                ListViewHolder header=new ListViewHolder(view);
                return header;
            case CHILD:
                TextView itemTextView=new TextView(context);
                itemTextView.setPadding(subItemPaddingLeft,subItemPaddingTopandBottom,0,subItemPaddingTopandBottom);
                itemTextView.setTextColor(0x88000000);
                itemTextView.setLayoutParams(
                        new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                                ViewGroup.LayoutParams.WRAP_CONTENT));
                return new RecyclerView.ViewHolder(itemTextView){
                };
        }
        return new ListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        item=data.get(position);
        switch (item.type){
            case HEADER:
           itemCollector=(ListViewHolder) holder;
            itemCollector.referalType=item;
                itemCollector.header_title.setText(item.text);
                if(item.invisibleChildren==null){
                    itemCollector.btn_expand_toggle.setImageResource(R.mipmap.circle_minus);
                }else{
                    itemCollector.btn_expand_toggle.setImageResource(R.mipmap.circle_plus);
                }
                itemCollector.btn_expand_toggle.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if(item.invisibleChildren==null){
                            item.invisibleChildren=new ArrayList<Item>();
                            int count=0;
                            int pos=data.indexOf(itemCollector.referalType);
                            while(data.size() > pos + 1 && data.get(pos+1).type==CHILD){
                                item.invisibleChildren.add(data.remove(pos+1));
                                count++;
                            }
                            notifyItemRangeRemoved(pos+1,count);
                            itemCollector.btn_expand_toggle.setImageResource(R.mipmap.circle_plus);
                        }
                        else {
                            int pos=data.indexOf(itemCollector.referalType);
                            int index=pos+1;
                            for(Item i: item.invisibleChildren){
                                data.add(index,i);
                                index++;
                            }
                            notifyItemRangeRemoved(pos+1,index-pos-1);
                            itemCollector.btn_expand_toggle.setImageResource(R.mipmap.circle_minus);
                            item.invisibleChildren=null;
                        }
                    }
                });
                break;
            case CHILD:
                TextView itemTextView=(TextView) holder.itemView;
                itemTextView.setText(data.get(position).text);
                break;
        }

    }

    @Override
    public int getItemViewType(int position) {
        return data.get(position).type;
    }

    @Override
    public int getItemCount() {

        return data.size();
    }



    public class ListViewHolder extends RecyclerView.ViewHolder{

        public TextView header_title;
        public ImageView btn_expand_toggle;
        public Item  referalType;

        public ListViewHolder(final View itemView) {
            super(itemView);
            header_title=(TextView) itemView.findViewById(R.id.header_title);
            btn_expand_toggle=(ImageView) itemView.findViewById(R.id.btn_expand_toggle);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    //Snackbar snackBar;
                   // Snackbar.make(itemView,"Card View Clicked",Snackbar.LENGTH_LONG).show();
                    if(item.invisibleChildren==null){
                        item.invisibleChildren=new ArrayList<Item>();
                        int count=0;
                        int pos=data.indexOf(itemCollector.referalType);
                        while(data.size() > pos + 1 && data.get(pos+1).type==CHILD){
                            item.invisibleChildren.add(data.remove(pos+1));
                            count++;
                        }
                        notifyItemRangeRemoved(pos+1,count);
                        itemCollector.btn_expand_toggle.setImageResource(R.mipmap.circle_plus);
                    }
                    else {
                        int pos=data.indexOf(itemCollector.referalType);
                        int index=pos+1;
                        for(Item i: item.invisibleChildren){
                            data.add(index,i);
                            index++;
                        }
                        notifyItemRangeRemoved(pos+1,index-pos-1);
                        itemCollector.btn_expand_toggle.setImageResource(R.mipmap.circle_minus);
                        item.invisibleChildren=null;
                    }


                }
            });
        }


    }

    public static class Item{
        public int type;
        public String text;
        public List<Item> invisibleChildren;

        public Item() {
        }

        public Item(String text, int type) {
            this.text = text;
            this.type = type;
        }

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

        public String getText() {
            return text;
        }

        public void setText(String text) {
            this.text = text;
        }

        public List<Item> getinvisibleChildren() {
            return invisibleChildren;
        }

        public void setItemList(List<Item> invisibleChildren) {
            this.invisibleChildren = invisibleChildren;
        }
    }
}
