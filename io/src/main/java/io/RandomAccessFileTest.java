package io;

import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * @Author Tmind
 * @Date 2021/10/28
 */
public class RandomAccessFileTest {

    /**
     * 文件内容abcdefghijk中d后边插入jkl
     */
    @Test
    public void randomAccessFileTest() throws IOException {
        RandomAccessFile randomAccessFile = null;
        try {
            // 读取文件内容
            randomAccessFile = new RandomAccessFile("helloWorld.txt", "rw");
            // 新建字符串接收截取后的内容defghijk
            StringBuilder stringBuilder = new StringBuilder(((int) new File("helloWorld.txt").length()));
            // 设置读取指针，从d开始读写
            randomAccessFile.seek(3);
            // 新建数组，接收读取的内容
            byte[] bytes = new byte[20];
            int len;
            while ((len = randomAccessFile.read(bytes)) != -1) {
                stringBuilder.append(new String(bytes, 0, len));
            }
            System.out.println(stringBuilder);
            // 调回指针，从d开始写入xyz，写入后指针在z后边，写入defghijk
            randomAccessFile.seek(3);
            randomAccessFile.write("xyz".getBytes());
            randomAccessFile.write(stringBuilder.toString().getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (randomAccessFile != null) {
                randomAccessFile.close();
            }
        }
    }
}