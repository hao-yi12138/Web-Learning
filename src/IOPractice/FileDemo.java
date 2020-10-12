package IOPractice;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

/**
 * @program: IntelliJ IDEA
 * @description:
 * @author: HAOYI
 * @date:2020-10-11 16:56
 **/
public class FileDemo {
    public static void main(String[] args) throws IOException {
       /* String path = "E:\\github代码\\Web-Learning\\File测试目录\\h.txt";
        File file = new File(path);     // 路径对应的文件，但文件可能实际上不存在
        //常见属性
        System.out.println(file.isFile()); //判断是不是普通文件
        System.out.println(file.isDirectory());// 判断是不是文件夹
        System.out.println(file.isHidden());  // 判断是不是隐藏文件
        System.out.println(file.exists());   //判断文件实际上是否存在
        System.out.println(file.getName());
        System.out.println(file.getAbsolutePath());  //得到绝对路径
        System.out.println(file.getPath());       //普通路径
        System.out.println(file.getParent());
        System.out.println(file.canExecute());
        System.out.println(file.canRead());
        System.out.println(file.canWrite());   //判断是否可以执行*/
       /*String path = "File测试目录\\hello.txt";
       File file = new File(path);//File file = new File("File测试目录\\hello.txt");
       //创建文件
        // 要创建 hello.txt 文件，要求File测试目录首先存在
        //若 hello.txt文件已存在，则会创建失败
        boolean newFile = file.createNewFile();
        System.out.println(newFile);
        //创建目录
        boolean mkdir = file.mkdir();
        System.out.println(mkdir);

        System.out.println("会把中间没有的目录，循环创建出来");
        boolean mkdirs = file.mkdirs();
        System.out.println(mkdirs);*/

        /*//模拟文件重命名
        File file = new File("File测试目录\\h.txt");
        File file1 = new File("File测试目录\\a.txt");
          boolean b = file.renameTo(file1);
        System.out.println(b);*/

       /* //模拟剪切粘贴
        File file = new File("File测试目录\\a.txt");
        File file1 = new File("h.txt");
        boolean b = file.renameTo(file1);
        System.out.println(b);*/
       //删除文件
        /*File file = new File("File测试目录\\非空文件.txt");
        boolean delete = file.delete();
        System.out.println(delete);*/

        /* Scanner s = new Scanner(System.in);
        {
            File file1 = new File("File测试目录\\a.txt");
            file1.deleteOnExit();//该文件不是立即删除，而是等JVM退出再删除
            System.out.println("等待一会，先观察 a.txt 文件是否已经被删除！");
            s.nextLine();
        }*/
       //下一层目录的遍历
        //非空目录 返回长度不是0的数组
        //空目录 返回长度是0的数组
        //不是目录 返回null
        File file = new File("File测试目录\\空目录");
        /*
        File[] files = file.listFiles();
        for (File f: files) {
            System.out.println(f.getAbsolutePath());
        }
        */

        String[] list = file.list();
        System.out.println(list);
        System.out.println(list.length);
        for (String s: list) {
            System.out.println(s);
        }
    }
}
