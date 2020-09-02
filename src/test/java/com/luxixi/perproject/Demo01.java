package com.luxixi.perproject;

import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.io.File;

/**
 * 删除一个文件夹以及子文件夹
 */
@SpringBootTest
public class Demo01 {


    static int flag = 1;//用来判断文件是否删除成功
    public static void main(String[] args) {
        //删除一个文件夹下的所有文件(包括子目录内的文件)
        File file = new File("D:\\temps\\");//输入要删除文件目录的绝对路径
        deleteFile(file);
        if (flag == 1){
            System.out.println("文件删除成功！");
        }
    }
    public static void deleteFile(File file){
        //判断文件不为null或文件目录存在
        if (file == null || !file.exists()){
            return;
        }
        //取得这个目录下的所有子文件对象
        File[] files = file.listFiles();
        //遍历该目录下的文件对象
        for (File f: files){
            //判断子目录是否存在子目录,如果是文件则删除
            if (f.isDirectory()){
                deleteFile(f);
            }
            f.delete();
        }
    }
}
