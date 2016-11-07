package com.aritime.aridj.measure;

import android.media.MediaRecorder;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;

import com.aritime.aridj.R;

import java.io.File;
import java.io.IOException;

/**
 * Created by jiajia on 2016/11/1.
 */

public class MeasureActivity extends AppCompatActivity implements View.OnClickListener {

    private MediaRecorder mMediaRecorder;
    private File recAudioFile;

    private ImageButton imgBtn_back, imgBtn_audio, imgBtn_camera;// 返回、录音、拍照按钮
    private int flag = 0;//录音标识位，0，未录音，1，录音中

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_measure);
        initView();
        initEvent();
    }

    private void initView() {
        imgBtn_back = (ImageButton) findViewById(R.id.imgBtn_back_sign);
        imgBtn_audio = (ImageButton) findViewById(R.id.imgBtn_audio);
        imgBtn_camera = (ImageButton) findViewById(R.id.imgBtn_camera);

        recAudioFile = new File(this.getFilesDir(),"new.amr");//文件路径及文件名：[data/data/包名/files/文件]
    }

    private void initEvent() {
        imgBtn_back.setOnClickListener(this);
        imgBtn_audio.setOnClickListener(this);
        imgBtn_camera.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.imgBtn_back_sign:
                break;
            case R.id.imgBtn_audio:
                if (flag == 0) {// 未录音
                    flag = 1;
                    startRecorder();
                } else if (flag == 1) {// 录音中
                    flag = 0;
                    stopRecorder();
                }
                break;
            case R.id.imgBtn_camera:
                break;
        }
    }
    private void startRecorder() {
        mMediaRecorder = new MediaRecorder();
        if (recAudioFile.exists()) {
            this.deleteFile(recAudioFile.getName());
        }

        mMediaRecorder.setAudioSource(MediaRecorder.AudioSource.MIC);// 设置音频源
        mMediaRecorder.setOutputFormat(MediaRecorder.OutputFormat.DEFAULT);// 设置音频格式
        mMediaRecorder.setAudioEncoder(MediaRecorder.AudioEncoder.DEFAULT);// 设置音频编码模式
        mMediaRecorder.setOutputFile(recAudioFile.getAbsolutePath());// 设置音频的输出路径
        try {
            mMediaRecorder.prepare();
        } catch (IllegalStateException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        mMediaRecorder.start();
    }

    private void stopRecorder(){
        if (recAudioFile!=null) {
            mMediaRecorder.stop();
            mMediaRecorder.release();
        }
    }

}
