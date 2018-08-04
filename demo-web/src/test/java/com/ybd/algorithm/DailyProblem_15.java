package com.ybd.algorithm;

import org.junit.Test;

import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;

/**
 *
 This problem was asked by Facebook.
 Given a stream of elements too large to store in memory,
 pick a random element from the stream with uniform probability.
 */
public class DailyProblem_15 {


    @Test
    public void test1() {
        FileInputStream fis = null;
        FileOutputStream fos = null;
        try {
            String key = "zhang";
            String path = "E:\\var\\logs\\fiance\\all.2018-04-26.log.new";
            String path1 = "E:\\var\\logs\\fiance\\all.2018-04-26.log.new";
            fos = new FileOutputStream(path1,true);
            fis = new FileInputStream(path);
            int n = 0;
            byte[] b = new byte[1024];
            int offset = 10 * 1024;
            String s = "";
            fos.write(path.getBytes());
            while ((n = fis.read(b)) != -1) {
                s = new String(b,0,n);
                if (s.contains(key)) {
                    System.out.println(s);
                }
            }
            /*FileOutputStream fos = new FileOutputStream(path,true);
            fos.write(sb.toString().getBytes());*/
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (fis != null) {
                    fis.close();
                }
                if (fos != null) {
                    fos.flush();
                    fos.close();
                }
            } catch (Exception e) {

            }
        }
    }

}
