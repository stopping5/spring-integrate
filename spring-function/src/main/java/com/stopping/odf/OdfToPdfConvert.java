package com.stopping.odf;

import org.ofdrw.converter.ConvertHelper;

import java.io.File;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

public class OdfToPdfConvert {
    public static void main(String[] args) {
        String ofdFilePath = "/Users/stopping/code/stopping/spring-integrate/spring-function/src/main/resources/static/test.ofd";
        String pdf = "/Users/stopping/code/stopping/spring-integrate/spring-function/src/main/resources/static/inout.pdf";

        try {
            // 创建URL对象
            URL url = new URL("https://tw-doc.xforceplus.com/o/VFhaUGF6UGxScWQ0KzBQTk53Y2hxQzlxMkNzVFQrVGpJS1JKZlh0bjFsRT0=");

            // 打开连接
            URLConnection connection = url.openConnection();

            // 获取输入流
            InputStream inputStream = connection.getInputStream();
            File input = new File("https://tw-doc.xforceplus.com/o/VFhaUGF6UGxScWQ0KzBQTk53Y2hxQzlxMkNzVFQrVGpJS1JKZlh0bjFsRT0=");
            System.out.println("fileName = "+ input.getPath());
            // 在这里可以对输入流进行处理，例如读取文件内容或进行其他操作
            File file = new File(pdf);
            ConvertHelper.toPdf(inputStream,file);

            // 关闭输入流
            inputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void ofdToPdf(){
        String ofdFilePath = "/Users/stopping/code/stopping/spring-integrate/spring-function/src/main/resources/static/test.ofd";
        String pdf = "/Users/stopping/code/stopping/spring-integrate/spring-function/src/main/resources/static/output.pdf";

        try {
            ConvertHelper.ofd2pdf(ofdFilePath, pdf);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
