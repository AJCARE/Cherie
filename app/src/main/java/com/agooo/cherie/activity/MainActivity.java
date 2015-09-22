package com.agooo.cherie.activity;

import android.content.DialogInterface;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.agooo.cherie.app.CherieApplication;
import com.agooo.cherie.commons.NavigateType;
import com.agooo.cherie.fragment.MainFragment;
import com.agooo.cherie.utils.LogUtils;
import com.agooo.cherie.utils.SystemBarTintManager;
import com.agooo.cherie.views.ExitActionView;

/**
 * author cherie
 * date 2015/9/20
 */
public class MainActivity extends BaseActivity implements ExitActionView.OnActionSheetSelected,
        DialogInterface.OnCancelListener {
    private static final String TAG = "MainActivity";
    private Toolbar toolbar;
    private FragmentManager fragmentManager;
    private MainFragment mainFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        context = MainActivity.this;

        CherieApplication.getInstance().addActivity(this);
        setActionBarStyle();

        fragmentManager = getSupportFragmentManager();
        setNavigateSelected(NavigateType.HOME.getValue());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_toolbar_items, menu);
        return true;
    }

    private void setActionBarStyle() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            SystemBarTintManager tintManager = new SystemBarTintManager(this);
            tintManager.setStatusBarTintEnabled(true);
            tintManager.setStatusBarTintResource(R.color.lightpink);
        }

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("");
        toolbar.setPadding(0, CherieApplication.getInstance().getDimensionMiss(context), 0, 0);
//      toolbar.inflateMenu(R.menu.main_toolbar_items);
        setSupportActionBar(toolbar);
        // setNavigationIcon() ,setOnMenuItemClickListener() 要設定在 setSupoortActionBar() 后才有作用
        // 否則會出現 back button
        toolbar.setNavigationIcon(R.mipmap.menu);
        toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {
                String msg = "";
                switch (menuItem.getItemId()) {
                    case R.id.action_edit:
                        msg += "Click edit";
                        break;
                    case R.id.action_share:
                        msg += "Click share";
                        break;
                    case R.id.action_settings:
                        msg += "Click setting";
                        break;
                }
                if (!msg.equals("")) {
                    Toast.makeText(MainActivity.this, msg, Toast.LENGTH_SHORT).show();
                }
                return true;
            }
        });
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "HOME", Toast.LENGTH_SHORT).show();
            }
        });
    }

    /**
     * @param navigateType 显示切换选中的导航项
     */
    public void setNavigateSelected(int navigateType) {
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        LogUtils.cLog("setNavigateSelected", "completed");
        switch (navigateType) {
            case 0:
                hideFragments(transaction);
                if (null == mainFragment) {
                    mainFragment = new MainFragment(MainActivity.this);
                    transaction.add(R.id.main_content, mainFragment);
                } else {
                    transaction.show(mainFragment);
                }
                break;
        }
        transaction.commit();
    }

    /**
     * @param transaction 将所有fragment都置为隐藏状态
     */
    private void hideFragments(FragmentTransaction transaction) {
        if (mainFragment != null) {
            transaction.hide(mainFragment);
        }
    }

    @Override
    public void onBackPressed() {
        ExitActionView.showExitActionSheet(this, this, this);
    }

    @Override
    public void onClick(int whichButton) {
        switch (whichButton) {
            case 0:   //  点击了退出
                CherieApplication.getInstance().exit();
                break;
            case 1:   // 点击了取消
                break;
            default:
                break;
        }
    }

    @Override
    public void onCancel(DialogInterface dialog) {

    }
}
