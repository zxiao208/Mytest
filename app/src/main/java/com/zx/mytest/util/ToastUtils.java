package com.zx.mytest.util;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by Administrator on 2018/3/9 0009.
 */

public class ToastUtils {


    public static void longShow(Context context, String message) {
        Toast.makeText(context, message, Toast.LENGTH_LONG).show();
    }

    public static void shortShow(Context context, String message) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
    }
}
