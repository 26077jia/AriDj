package com.aritime.aridj.cardreader;

import android.app.PendingIntent;
import android.content.Intent;
import android.content.IntentFilter;
import android.nfc.NfcAdapter;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.provider.Settings;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.aritime.aridj.R;

import static com.aritime.aridj.utils.DataTypeConverUtils.ByteArrayToHexString;

/**
 * Created by jiajia on 2016/10/26.
 */

public class CardReaderActivity extends AppCompatActivity {
    private TextView tv_card_id;
    private Button btn_sync;
    private ImageButton imgBtn_back;

    private NfcAdapter nfcAdapter = null;

    private PendingIntent mpendingIntent;
    private IntentFilter[] mInterFilter;
    private String[][] mTechLists;
    Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            String s = (String) msg.obj;
            tv_card_id.setText(s);
        }
    };

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_card_reader);

        nfcAdapter = nfcAdapter.getDefaultAdapter(this);
        mpendingIntent = PendingIntent.getActivity(this, 0, new Intent(this, getClass()).addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP), 0);
        isEnabled();

        initView();
        initEvent();
    }


    private void initView() {
        tv_card_id = (TextView) findViewById(R.id.tv_card_id);
        btn_sync = (Button) findViewById(R.id.btn_sync_card);
        imgBtn_back = (ImageButton) findViewById(R.id.imgBtn_cardr_back);
    }

    private void initEvent() {
        imgBtn_back.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                finish();
            }
        });
    }

    /**
     * 手机NFC功能是否可用
     */
    public void isEnabled() {

        if (nfcAdapter == null) {
            Toast.makeText(CardReaderActivity.this, "该设备不支持NFC功能",Toast.LENGTH_SHORT).show();
            // finish();
        } else if (!nfcAdapter.isEnabled()) {
            //打开设置NFC开关
            Intent setNfc = new Intent(Settings.ACTION_WIRELESS_SETTINGS);
            startActivity(setNfc);
        }
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);
        if (NfcAdapter.ACTION_TAG_DISCOVERED.equals(intent.getAction())) {
            byte[] myNFCId = intent.getByteArrayExtra(nfcAdapter.EXTRA_ID);
            String m = ByteArrayToHexString(myNFCId);

            Message msg = handler.obtainMessage();
            msg.obj = m;
            handler.sendMessage(msg);
        }

    }

    @Override
    protected void onResume() {
        super.onResume();
        if (nfcAdapter != null) {
            nfcAdapter.enableForegroundDispatch(this, mpendingIntent, mInterFilter, mTechLists);
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        if (nfcAdapter != null)
            nfcAdapter.disableForegroundDispatch(this);
    }

}
