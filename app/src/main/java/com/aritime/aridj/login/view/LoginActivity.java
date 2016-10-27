package com.aritime.aridj.login.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.aritime.aridj.R;
import com.aritime.aridj.login.contract.LoginContract;
import com.aritime.aridj.login.presenter.LoginPresenter;
import com.aritime.aridj.main.MainActivity;
import com.rengwuxian.materialedittext.MaterialEditText;

/**
 * Created by jiajia on 2016/10/18.
 */

public class LoginActivity extends AppCompatActivity implements View.OnClickListener, LoginContract.View {
    private static final String TAG = "MainActivity";

    private MaterialEditText et_user_account, et_user_pwd;//账号与密码
    private CheckBox chk_remb_pwd;
    private Button mbtn_login;
    private LinearLayout mll_card_login, mll_nocheck_login;//刷卡登录、无账号登录

    private LoginContract.Presenter mLoginPresenter;

//    private NfcAdapter nfcAdapter = null;
//
//    private PendingIntent mpendingIntent;
//    private IntentFilter[] mInterFilter;
//    private String[][] mTechLists;
//
//    Handler handler = new Handler() {
//        @Override
//        public void handleMessage(Message msg) {
//            String s = (String )msg.obj;
//            Log.v("main",s);
//            loginSuccess();
//        }
//    };

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_login);
//
//        nfcAdapter = nfcAdapter.getDefaultAdapter(this);
//        mpendingIntent = PendingIntent.getActivity(this, 0, new Intent(this, getClass()).addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP), 0);
//        isEnabled();


        initView();
        initEvent();
    }

//    /**
//     * 手机NFC功能是否可用
//     */
//    public void isEnabled() {
//
//        if (nfcAdapter == null) {
////            Snackbar.make(null,"该设备不支持NFC功能", Snackbar.LENGTH_SHORT).show();
//            finish();
//        } else if (!nfcAdapter.isEnabled()) {
//            //打开设置NFC开关
//            Intent setNfc = new Intent(Settings.ACTION_WIRELESS_SETTINGS);
//            startActivity(setNfc);
//        }
//    }
//    @Override
//    protected void onNewIntent(Intent intent) {
//        super.onNewIntent(intent);
//        setIntent(intent);
//        if (NfcAdapter.ACTION_TAG_DISCOVERED.equals(intent.getAction())) {
//            byte[] myNFCId = intent.getByteArrayExtra(nfcAdapter.EXTRA_ID);
//            String m = ByteArrayToHexString(myNFCId);
//
//            Message msg = handler.obtainMessage();
//            msg.obj = m;
//            handler.sendMessage(msg);
//        }
//
//    }
//    @Override
//    protected void onResume() {
//        super.onResume();
//        if (nfcAdapter != null) {
//            nfcAdapter.enableForegroundDispatch(this, mpendingIntent, mInterFilter, mTechLists);
//        }
//    }
//
//    @Override
//    protected void onPause() {
//        super.onPause();
//        if (nfcAdapter != null)
//            nfcAdapter.disableForegroundDispatch(this);}

    private String ByteArrayToHexString(byte[] inarray) { // converts byte arrays to string
        int i, j, in;
        String[] hex = {
                "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "A", "B", "C", "D", "E", "F"
        };
        String out = "";

        for (j = 0; j < inarray.length; ++j) {
            in = inarray[j] & 0xff;
            i = (in >> 4) & 0x0f;
            out += hex[i];
            i = in & 0x0f;
            out += hex[i];
        }
        return out;
    }
    public void initView() {
        //控件初始化
        et_user_account = (MaterialEditText) findViewById(R.id.et_user_account);
        et_user_pwd = (MaterialEditText) findViewById(R.id.et_user_pwd);
        chk_remb_pwd = (CheckBox) findViewById(R.id.chk_remb_pwd);
        mbtn_login = (Button) findViewById(R.id.btn_login);
        mll_card_login = (LinearLayout) findViewById(R.id.ll_card_login);
        mll_nocheck_login = (LinearLayout) findViewById(R.id.ll_no_user_login);
    }

    private void initEvent() {
        mLoginPresenter = new LoginPresenter(this);
        mbtn_login.setOnClickListener(this);
        mll_card_login.setOnClickListener(this);
        mll_nocheck_login.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_login:
                mLoginPresenter.accountLogin();
                break;
            case R.id.ll_card_login:
                mLoginPresenter.cardLogin();
                break;
            case R.id.ll_no_user_login:
                mLoginPresenter.noUserLogin();
                break;
        }
    }

    /**
     * 获取用户账号
     */
    @Override
    public String getAccount() {
        return et_user_account.getText().toString();
    }

    /**
     * 获取用户密码
     */
    @Override
    public String getPwd() {
        return et_user_pwd.getText().toString();
    }

    /**
     * 记住用户密码是否选中
     */
    @Override
    public boolean isRembPwd() {
        return chk_remb_pwd.isChecked();
    }

    /**
     * 登录成功
     */
    @Override
    public void loginSuccess() {
        Log.d(TAG, "登录成功");
        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
        startActivity(intent);


    }

    /**
     * 登录失败
     */
    @Override
    public void loginFailed(String msg) {
        Log.v(TAG, msg);
        Toast.makeText(this, msg, Toast.LENGTH_LONG).show();
    }


}
