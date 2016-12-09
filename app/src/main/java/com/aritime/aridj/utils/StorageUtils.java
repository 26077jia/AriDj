package com.aritime.aridj.utils;

import android.os.Environment;
import android.os.StatFs;

import java.io.File;

/**
 * Created by jiajia on 2016/11/17.
 */

public class StorageUtils {

    File dataFileDir = Environment.getDataDirectory();

    /**
     * 根据路径获取总存储空间
     * @param path
     * @return string 空间大小
     */
    public static String getMemoryInfo(File path) {

        StatFs stat = new StatFs(path.getPath());// 获得一个磁盘状态对象
        long blockSize = stat.getBlockSizeLong ();// 获得一个扇区的大小
        long totalBlocks = stat.getBlockCountLong();// 获得扇区的总数
        // 总空间
        return  ConvertUtils.byte2FitSize(totalBlocks * blockSize);
    }
    /**
     * 根据路径获取剩余存储空间
     * @param path
     * @return string 空间大小
     */
    public static String getMemoryFree(File path) {

        StatFs stat = new StatFs(path.getPath());// 获得一个磁盘状态对象
        long blockSize = stat.getBlockSizeLong ();// 获得一个扇区的大小
        long availableBlocks = stat.getAvailableBlocksLong();// 获得可用的扇区数量

        return ConvertUtils.byte2FitSize(availableBlocks * blockSize);

    }
}
