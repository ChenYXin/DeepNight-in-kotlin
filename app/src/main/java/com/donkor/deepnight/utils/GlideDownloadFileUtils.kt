package com.donkor.deepnight.utils

import android.content.Context
import android.os.Environment
import android.util.Log
import com.bumptech.glide.Glide
import com.bumptech.glide.request.animation.GlideAnimation
import com.bumptech.glide.request.target.SimpleTarget
import java.io.File
import java.io.FileOutputStream


/**
 *
 * Created by Donkor on 2017/12/15.
 */
class GlideDownloadFileUtils {
    companion object {
        //Glide保存图片
        fun savePicture(context: Context?, fileName: String?, url: String?) {
            Glide.with(context).load(url).asBitmap().toBytes().into(object : SimpleTarget<ByteArray>() {
                override fun onResourceReady(bytes: ByteArray, glideAnimation: GlideAnimation<in ByteArray>) {
                    try {
                        savaFileToSD(fileName, bytes)
                    } catch (e: Exception) {
                        e.printStackTrace()
                    }

                }
            })
        }

        @Throws(Exception::class)
        private fun savaFileToSD(filename: String?, bytes: ByteArray?) {
            var filename = filename
            //如果手机已插入sd卡,且app具有读写sd卡的权限
            if (Environment.getExternalStorageState() == Environment.MEDIA_MOUNTED) {
//                mRootDir = Environment.getExternalStorageDirectory().toString() + "/Uping"
                val filePath = Environment.getExternalStorageDirectory().toString() + "/DeepNight"
                Log.e("asd", "filePath : " + filePath)
                val dir1 = File(filePath)
                if (!dir1.exists()) {
                    val a = dir1.mkdirs()
                    Log.e("asd", "a : " + a)
                }
//                filename = filePath + "/" + filename
                //这里就不要用openFileOutput了,那个是往手机内存中写数据的
                val output = FileOutputStream(filename)
                output.write(bytes)
                //将bytes写入到输出流中
                output.close()
                //关闭输出流
//            Toast.makeText(context, "图片已成功保存到" + filePath, Toast.LENGTH_SHORT).show()
                Log.e("asd", "图片已成功保存到")
            } else
//            Toast.makeText(context, "SD卡不存在或者不可读写", Toast.LENGTH_SHORT).show()
                Log.e("asd", "SD卡不存在或者不可读写")
        }
    }
}