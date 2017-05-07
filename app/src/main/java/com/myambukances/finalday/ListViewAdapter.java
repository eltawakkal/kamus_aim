package com.myambukances.finalday;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by eltawakkal on 5/6/17.
 */

public class ListViewAdapter extends ArrayAdapter<String> {

    Activity activity;
    String[] kosakata;
    int[] imgResource = {R.drawable.man1, R.drawable.man2, R.drawable.girl1, R.drawable.girl2, R.drawable.girl3, R.drawable.girl4};

    public ListViewAdapter(@NonNull Activity activity, String[] kosakata) {
        super(activity, R.layout.custom_view, kosakata);
        this.activity = activity;
        this.kosakata = kosakata;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        if (convertView == null){
            convertView = activity.getLayoutInflater().inflate(R.layout.custom_view, parent, false);
        }

        TextView txtTitle = (TextView) convertView.findViewById(R.id.txtTitle);
        ImageView imgProf = (ImageView) convertView.findViewById(R.id.imgProf);
        //imgProf.setImageResource(imgResource[position]);
        txtTitle.setText(kosakata[position]);

        return convertView;
    }
}
