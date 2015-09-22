package com.agooo.cherie.fragment;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.agooo.cherie.activity.MainActivity;
import com.agooo.cherie.activity.R;

/**
 * author cherie
 * date 2015/9/20
 */
public class MainFragment extends Fragment {

    private static final String TAG = "MainFragment" ;
    private View contentView;
    private MainActivity mainActivity;

    @SuppressLint("ValidFragment")
    public MainFragment(MainActivity mainActivity){
        this.mainActivity = mainActivity ;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        contentView = inflater.inflate(R.layout.main_fmt_layout,null) ;
        initView();
        return contentView ;
    }

    public void initView(){
    }

    @Override
    public void onAttach(Activity activity) {
        mainActivity = (MainActivity) activity;
        super.onAttach(activity);
    }
}
