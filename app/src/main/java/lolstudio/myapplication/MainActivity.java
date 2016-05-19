package lolstudio.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;
import android.widget.ViewSwitcher;

public class MainActivity extends AppCompatActivity implements View.OnClickListener,OnCountryListener {

    ViewSwitcher viewSwitcher;
    ImageView iv_back, iv_complete;
    Button btn_changeLanguage;
    ChangeLanguageFragment mChangeLanguageFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initListener();
    }

    private void initListener() {
        btn_changeLanguage.setOnClickListener(this);
        iv_back.setOnClickListener(this);
        iv_complete.setOnClickListener(this);
    }

    private void initView() {
        iv_back = (ImageView) findViewById(R.id.iv_back);
        iv_complete = (ImageView) findViewById(R.id.iv_complete);
        viewSwitcher = (ViewSwitcher) findViewById(R.id.viewSwitch);
        btn_changeLanguage = (Button) findViewById(R.id.btn_changeLanguage);
    }

    @Override
    public void onClick(View v) {
        boolean flag = false;
        switch (v.getId()) {
            case R.id.btn_changeLanguage:
                flag = false;
                break;
            case R.id.iv_back:
                flag = true;
                break;
            case R.id.iv_complete:
                flag = true;
                break;
        }
        showPrevious(flag);
    }

    private void showPrevious(boolean showPrevious) {
        iv_complete.setVisibility(showPrevious ? View.INVISIBLE : View.VISIBLE);
        iv_back.setVisibility(showPrevious ? View.INVISIBLE : View.VISIBLE);
        viewSwitcher.setInAnimation(MainActivity.this, showPrevious ? android.R.anim.slide_in_left : R.anim.slide_in_right);
        viewSwitcher.setOutAnimation(MainActivity.this, showPrevious ? android.R.anim.slide_out_right : R.anim.slide_out_left);
        if (showPrevious) {
            viewSwitcher.showPrevious();
        } else {
            mChangeLanguageFragment=new ChangeLanguageFragment();
            mChangeLanguageFragment.setOnCountryListener(this);
            getSupportFragmentManager().beginTransaction().add(R.id.fl_ChangeLanguage, mChangeLanguageFragment).commitAllowingStateLoss();
            viewSwitcher.showNext();
        }
    }

    @Override
    public void btnClick(boolean isBack) {
        Toast.makeText(this,">>"+isBack,Toast.LENGTH_LONG).show();
        if (isBack)
        showPrevious(true);
    }
}
