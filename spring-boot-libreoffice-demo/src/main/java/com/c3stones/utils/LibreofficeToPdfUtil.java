package com.c3stones.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author sukang
 * @version 1.0
 * @description: TODO
 * @date 2022/8/9 11:01
 */
public class LibreofficeToPdfUtil {

    /**
     *
     * @param srcFile
     * @param outPath
     * @return
     * @throws IOException
     * @throws InterruptedException
     */
    public static String officeToPdf(String execFile, String srcFile,String outPath) throws IOException, InterruptedException {
        String command = execFile+" --headless --convert-to pdf %s --outdir %s";
        Process process = Runtime.getRuntime().exec(String.format(command,srcFile,outPath));
        BufferedReader in = new BufferedReader(new InputStreamReader(process.getInputStream()));
        StringBuffer sb = new StringBuffer();
        String line = null;
        while ((line = in.readLine()) != null) {
            sb.append(line);
        }
        in.close();
        process.waitFor();
        return sb.toString();
    }
}
