package com.pinnet.zip;

import com.github.junrar.Archive;
import com.github.junrar.exception.RarException;
import com.github.junrar.rarfile.FileHeader;

import java.io.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

/**
 * Funtion: 文件操作.
 * <p>
 * Author: lWX559685
 * Date: 2018/8/27 15:31
 */
public class FileUtils {

    public static void main(String[] args) throws IOException, RarException {
        decompressionFile(new File("D:/DevTools/maven-3.0.3.zip"), "/t");
    }


    /**
     * 提供给用户使用的解压工具
     * @param inFile
     * @param outPath
     * @throws IOException
     */
    public static void decompressionFile(File inFile, String outPath) throws IOException, RarException {
        File out = new File(outPath);
        if (!out.isDirectory()) {
            out.mkdirs();
        }
        if (!outPath.endsWith(File.separator)) {
            outPath += File.separator;
        }
        //zip读取压缩文件
        FileInputStream fileInputStream = new FileInputStream(inFile);
        ZipInputStream zipInputStream = new ZipInputStream(fileInputStream);
        //检测文件类型
        boolean fileType = checkFile(zipInputStream);
        //解压文件
        if (fileType) {
            unzip(outPath, zipInputStream);
        } else {
            unrar(outPath, inFile);
        }
        //关闭流
        zipInputStream.close();
    }

    /**
     * ZipInputStream是逐个目录进行读取，所以只需要循环
     * @param outPath
     * @param inFile
     * @throws IOException
     */
    private static void unrar(String outPath, File inFile) throws IOException, RarException {
        Archive archive = new Archive(inFile, null);
        FileHeader fileHeader = archive.nextFileHeader();
        while (fileHeader != null) {
            String name = fileHeader.getFileNameString();
            File file = new File(outPath+name);
            file.getParentFile().mkdirs();
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(fileOutputStream);
            archive.extractFile(fileHeader, bufferedOutputStream);
            //关闭流
            bufferedOutputStream.close();
            fileOutputStream.close();
            //读取下一个目录，作为循环条件
            fileHeader = archive.nextFileHeader();
        }
    }

    /**
     * @param outPath
     * @param inputStream
     * @throws IOException
     */
    private static void unzip(String outPath, ZipInputStream inputStream) throws IOException {
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

    /**
     * 检测文件类型
     * @param zipInputStream
     * @return
     * @throws IOException
     */
    private static boolean checkFile(ZipInputStream zipInputStream) throws IOException {
        if (zipInputStream.getNextEntry() == null) {
            //rar
            return false;
        }
        //zip
        return true;
    }
}
