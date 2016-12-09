package com.aritime.aridj.activity.about;

import android.os.Bundle;
import android.os.PowerManager;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

/**
 * Created by jiajia on 2016/10/26.
 */

public class AboutActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        PowerManager mPowerManager = (PowerManager) getSystemService(POWER_SERVICE);
        PowerManager.WakeLock wakeLock = mPowerManager.newWakeLock(PowerManager.PARTIAL_WAKE_LOCK, "MyWakeTag");
        wakeLock.acquire();
    }

    public void ReceiveServerSocket() {
        DatagramSocket socket;
        try {
            socket = new DatagramSocket(8080);//实例化端口号
            byte data[] = new byte[4 * 1024];
            DatagramPacket packet = new DatagramPacket(data, data.length);
            socket.receive(packet);
            String result = new String(packet.getData(), packet.getOffset(), packet.getLength());
            socket.close();
        } catch (SocketException e) {
            e.printStackTrace();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void sendData() {
        try {
            DatagramSocket socket = new DatagramSocket(8080);
            InetAddress serverAddress = InetAddress.getByName("192.168.0.1");
            String str = "要发送的信息";
            byte data[] = str.getBytes();
            DatagramPacket packet = new DatagramPacket(data, data.length, serverAddress, 100023);
            socket.send(packet);

        } catch (SocketException e) {
            e.printStackTrace();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
