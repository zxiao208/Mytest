package com.zx.mytest.util;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Created by zhaoxiao on 2018/7/10.
 * 流处理工具
 */

public class StreamHelper {
    public  static String convertStreamToString(InputStream is) {

        BufferedReader reader = new BufferedReader(new InputStreamReader(is));

        StringBuilder sb = new StringBuilder();



        String line = null;

        try {

            while ((line = reader.readLine()) != null) {

                sb.append(line + "/n");

            }

        } catch (IOException e) {

            e.printStackTrace();

        } finally {

            try {

                is.close();

            } catch (IOException e) {

                e.printStackTrace();

            }

        }



        return sb.toString();

    }

    public   static String   inputStream3String   (InputStream   in)   throws   IOException   {
        StringBuffer   out   =   new   StringBuffer();
        byte[]   b   =   new   byte[4096];
        for   (int   n;   (n   =   in.read(b))   !=   -1;)   {
            out.append(new   String(b,   0,   n));
        }
        return   out.toString();
    }

    public   static   String   inputStream4String(InputStream   is)   throws   IOException{
        ByteArrayOutputStream baos   =   new   ByteArrayOutputStream();
        int   i=-1;
        while((i=is.read())!=-1){
            baos.write(i);
        }
        return   baos.toString();
    }
}
