package com.example.suryasolanki.matka.Adapters;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AlertDialog;
import android.text.InputType;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.suryasolanki.matka.Java.BidData;
import com.example.suryasolanki.matka.R;
import com.example.suryasolanki.matka.Tabs.Tabbed;

import org.w3c.dom.Text;

import java.util.HashMap;
import java.util.List;

/**
 * Created by surya.solanki on 18-12-2016.
 */

public class ExpandableListViewAdapter extends BaseExpandableListAdapter {
    private Context context;
    private List<String>  listDataHeader;
    private HashMap<String,List<String>> listDataChild;
    private AlertDialog.Builder alertDialog;
    private TextView bidValue;

    public ExpandableListViewAdapter(Context context, List<String> listDataHeader, HashMap<String, List<String>> listDataChild) {
        this.context = context;
        this.listDataHeader = listDataHeader;
        this.listDataChild = listDataChild;
    }

    @Override
    public int getGroupCount() {
        return this.listDataHeader.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return this.listDataChild.get(this.listDataHeader.get(groupPosition)).size();
    }

    @Override
    public Object getGroup(int groupPostion) {
        return this.listDataHeader.get(groupPostion);
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return this.listDataChild.get(this.listDataHeader.get(groupPosition)).get(childPosition);
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        String headerTitle=(String)getGroup(groupPosition);
        if(convertView==null){
            LayoutInflater inflater=(LayoutInflater) this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView=inflater.inflate(R.layout.list_header,null);
        }
        TextView listHeaderText=(TextView) convertView.findViewById(R.id.list_group_txt);
       // listHeaderText.setTypeface(null, Typeface.BOLD);
        //listHeaderText.setText(headerTitle);
        return convertView;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View view, ViewGroup viewGroup) {
        final String childText=(String) getChild(groupPosition,childPosition);

        if(view==null){
            LayoutInflater layoutInflater=(LayoutInflater) this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view=layoutInflater.inflate(R.layout.list_item,null);
        }
//        TextView txtListChild=(TextView)view.findViewById(R.id.list_item_txt);
//        txtListChild.setText(childText);

        Button btnValue1=(Button) view.findViewById(R.id.list_item_btn1);
        btnValue1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                alertBidDialog(view);
            }
        });
        return view;
    }

    @Override
    public boolean isChildSelectable(int i, int i1) {
        return true;
    }

    public void alertBidDialog(View view){
        alertDialog=new AlertDialog.Builder(context);

//        TextView editText=(TextView)view.findViewById(R.id.walletAmount);
//        editText.setText("100.00");

        LayoutInflater inflater=(LayoutInflater) this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        final View alertDialogView=inflater.inflate(R.layout.bid_layout,null);
        alertDialog.setView(alertDialogView);
        final TextView  walletText=(TextView) alertDialogView.findViewById(R.id.walletAmount);
        walletText.setText(String.valueOf(String.format("%.2f",BidData.amount)));
         bidValue=(TextView) alertDialogView.findViewById(R.id.BetAmount);


         //alertDialog.setTitle("Bid Value");
       // alertDialog.setMessage("Plese enter Bid Value");
        final EditText editBidText=new EditText(context);
        editBidText.setInputType(InputType.TYPE_CLASS_PHONE);
        //LinearLayout.LayoutParams lp=new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,
          //      LinearLayout.LayoutParams.MATCH_PARENT);
        //editBidText.setLayoutParams(lp);
        //alertDialog.setView(editBidText);


        alertDialog.setPositiveButton("Confirm Bet",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {

                        String bidValues = bidValue.getText().toString();
                        if (!TextUtils.isEmpty(bidValues))
                            {
                                float tempWalletAmount=Float.parseFloat(walletText.getText().toString());
                                if(Float.parseFloat(bidValues)<tempWalletAmount){
                                    BidData.amount=tempWalletAmount-Float.parseFloat(bidValues);
                                    Toast.makeText(context,"Bid  Placed"+ BidData.amount,Toast.LENGTH_SHORT).show();
                                }
                                else{
                                    Toast.makeText(context,"Insufficent Funds",Toast.LENGTH_SHORT).show();
                                }

                            } else {
                                Toast.makeText(context,
                                        "Please enter value", Toast.LENGTH_SHORT).show();
                            }
                    }
                });

        alertDialog.setNegativeButton("Cancel",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });

        alertDialog.show();
    }
}
