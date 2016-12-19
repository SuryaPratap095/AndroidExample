package com.example.suryasolanki.matka.Tabs;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.suryasolanki.matka.R;

import org.w3c.dom.Text;

/**
 * Created by surya.solanki on 18-12-2016.
 */

public class Tab2 extends android.support.v4.app.Fragment {

    public Tab2(){

    }



    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view=inflater.inflate(R.layout.fragment_tabbed_2,container,false);
    //    TextView tabText=(TextView) view.findViewById(R.id.Bid_value_2);
//        tabText.setText("Second TAB");
        return view;

    }
}
