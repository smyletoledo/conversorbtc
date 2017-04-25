package com.devtoledo.conversorbtc;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Toast;


/**
 * Created by tiago.casemiro on 29/01/2016.
 */
@SuppressLint("InflateParams")
public class Load {
    private View load;

    public Load(final Activity activity) {
        this(activity, Color.PRIMARY_COLOR);
    }

    public Load(final Activity activity, Color color) {
        LayoutInflater inflater = activity.getLayoutInflater();
        Window window = activity.getWindow();

        load = inflater.inflate(R.layout.activity_load, null);
        load.setVisibility(View.INVISIBLE);
        load.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(activity, R.string.aguarde, Toast.LENGTH_LONG).show();
            }
        });

        if(color.equals(Color.DARK)){
            load.findViewById(R.id.progressBarCircularIndeterminate).setBackgroundDrawable(activity.getResources().getDrawable(R.drawable.arredonda_load_black));
        }

        window.addContentView(load, new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
    }

    public void show() {
        if(load != null)
            load.setVisibility(View.VISIBLE);
    }

    public void hide() {
        if(load != null)
            load.setVisibility(View.GONE);
    }

    public void setOnClickListener(OnClickListener onClickListener) {
        if(load != null)
            load.setOnClickListener(onClickListener);
    }

    public enum Color{
        DARK, PRIMARY_COLOR;
    }
}