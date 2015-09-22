package com.agooo.cherie.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import com.agooo.cherie.app.CherieApplication;

import cn.bmob.v3.Bmob;

import com.agooo.cherie.commons.Constant;

/**
 * author cherie
 * date 2015/9/20
 */
public class StartActivity extends BaseActivity {
    private ImageView backgroundImage;
    private Animation animation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
        CherieApplication.getInstance().addActivity(this);
        Bmob.initialize(getApplicationContext(), Constant.APP_ID);
        initView();
    }

    public void initView() {
        backgroundImage = (ImageView) findViewById(R.id.backgroundImage);
        animation = AnimationUtils.loadAnimation(this, R.anim.entrance);
        animation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                next();
            }

            @Override
            public void onAnimationRepeat(Animation animation) {
            }
        });
        backgroundImage.startAnimation(animation);
    }

    public void next() {
        Intent intent;
        intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        this.finish();
    }

}
