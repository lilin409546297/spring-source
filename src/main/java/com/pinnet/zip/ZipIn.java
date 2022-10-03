package com.pinnet.zip;

import java.io.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

/**
 * Funtion: TODO.
 * <p>
 * Author: lWX559685
 * Date: 2018/7/19 16:19
 */
public class ZipIn {

    public static void main(String[] args) throws IOException {
        decompressionFile("D:\\srv.zip", "D:\\test");
    }

    /**
     * 提供给用户使用的解压工具
     * @param srcPath
     * @param outPath
     * @throws IOException
     */
    public static void decompressionFile(String srcPath, String outPath) throws IOException {
        //简单判断解压路径是否合法
        if (!new File(srcPath).isDirectory()) {
            //判断输出路径是否合法
            if (new File(outPath).isDirectory()) {
                if (!outPath.endsWith(File.separator)) {
                    outPath += File.separator;
                }
                //zip读取压缩文件
                FileInputStream fileInputStream = new FileInputStream(srcPath);
                ZipInputStream zipInputStream = new ZipInputStream(fileInputStream);
                //解压文件
                decompressionFile(outPath, zipInputStream);
                //关闭流
                zipInputStream.close();
                fileInputStream.close();
            } else {
                throw new RuntimeException("输出路径不合法!");
            }
        } else {
            throw new RuntimeException("需要解压的文件不合法!");
        }
    }

    /**
     * ZipInputStream是逐个目录进行读取，所以只需要循环
     * @param outPath
     * @param inputStream
     * @throws IOException
     */
    private static void decompressionFile(String outPath, ZipInputStream inputStream) throws IOException {
        //读取一个目录
        ZipEntry nextEntry = inputStream.getNextEntry();
        //不为空进入循环
        while (nextEntry != null) {
            String name = nextEntry.getName();
            File file = new File(outPath, name);
            if (!file.toPath().normalize().startsWith(outPath)) {
                throw new IOException("Bad zip entry");
            }
            //如果是目录，创建目录
            if (name.endsWith("/")) {
                file.mkdir();
            } else {
                //文件则写入具体的路径中
                FileOutputStream fileOutputStream = new FileOutputStream(file);
                BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(fileOutputStream);
                int n;
                byte[] bytes = new byte[1024];
                while ((n = inputStream.read(bytes)) != -1) {
                    bufferedOutputStream.write(bytes, 0, n);
                }
                //关闭流
                bufferedOutputStream.close();
                fileOutputStream.close();
            }
            //关闭当前布姆
            inputStream.closeEntry();
            //读取下一个目录，作为循环条件
            nextEntry = inputStream.getNextEntry();
        }
    }
}
