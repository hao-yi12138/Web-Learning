package IOPractice;

import java.io.*;

/**
 * @program: IntelliJ IDEA
 * @description:
 * @author: HAOYI
 * @date:2020-10-13 14:40
 **/
public class FileStreamDemo {
    public static void main(String[] args) {
        //inputDemo();
        outputDemo();
    }

    private static void inputDemo() throws FileNotFoundException {
        // 构造的方式：
        // 1. 参数是 File 对象
        // 2. 参数是 String 类型的路径

        // 可以转化为 try-with-resource 的形式
        /*
        InputStream is1 = null;
        try {
             is1 = new FileInputStream("测试目录\\a.txt");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (is1 != null) {
                    is1.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        */

        // 基本使用这种形式
        // FileInputStream 就是 InputStream 的一个子类
        // InputStream 是一种 输入 字节 流
        // FileInputStream 是一种 输入 字节 来自文件 流
        /*
        try (InputStream is = new FileInputStream("File测试目录\\hello.txt")) {
            // 返回数据流中的下一个字节
            // 为什么要返回 int，因为返回值需要返回 -1，这个和真正的数据做区分
            // 通过返回 -1，通知你，已经读到文件结尾了
            // -1 被称为 EOS（End Of Stream）

            // 统计读到的有效字节数
            int count = 0;
            while (true) {
                int b = is.read();
                if (b == -1) {
                    // 代表文件的内容全部读完了
                    // 所以退出循环
                    break;
                }
                count++;
                System.out.printf("%d%n", b);
                System.out.printf("%02x%n", b);
                System.out.printf("%c%n", b);
                System.out.println("===================");
            }
            System.out.println(count);
        } catch (IOException e) {
            e.printStackTrace();
        }
        */

       /* try (InputStream is = new FileInputStream("File测试目录\\hello.txt")) {
            byte[] buffer = new byte[16];

            int count = 0;      // read 的调用次数
            while (true) {
                // 最多一次读取 8 个字节，不够 8 个也可以，读到 buffer 的 [0, 8)
                int n = is.read(buffer);
                //is.read(buffer, 0, buffer.length);
                System.out.println("n = " + n);
                // n 代表最终读到的字节个数
                // 区分： 最多读 8 个   vs 实际读到 n 个
                // 可能出现比要求读的个数少的情况：这种情况不代表一定就是读到 EOS
                // EOS: -1
                count++;
                if (n == -1) {
                    break;
                }

                for (int i = 0; i < n; i++) {
                    int b = buffer[i];

                    System.out.printf("%d%n", b);
                    System.out.printf("%02x%n", b);
                    System.out.printf("%c%n", b);
                    System.out.println("===================");
                }

            }

            System.out.println("read() 一共被调用" + count + "次");
        } catch (IOException e) {
            e.printStackTrace();
        }*/
        // 带有中文字符的读写
        /*try (InputStream is = new FileInputStream("测试目录\\中文.txt")) {
            byte[] buf = new byte[1024];
            int n;
            // 效果和上面完全一样
            // 无法直接根据数据，100% 确定数据的编码形式
            while ((n = is.read(buf)) != -1) {

                for (int i = 0; i < n; i++) {
                    System.out.printf("|%d|%02x|%n", buf[i], buf[i]);
                }

                // 假设 buf 中读取的中文，没有出现被拆断的形式
                String s = new String(buf, 0, n, "UTF-8");
                System.out.println(s);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }*/
        try (InputStream is = new FileInputStream("File测试目录\\中文.txt")) {
            // 2. 利用字节流作为构造方法，构造出字符流
            try (Reader reader = new InputStreamReader(is, "utf-8")) {
                // 读取的单位变成了 字符 char
                // 已经完成了字符集解析的工作了
                // 单字符读取 vs 批量读取
                //int c = reader.read();  // -1 代表 EOS

                char[] buf = new char[1024];
                int n;
                while ((n = reader.read(buf)) != -1) {
                    for (int i = 0; i < n; i++) {
                        System.out.println(buf[i]);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        /*// 字符集默认按照项目的字符集编码来（utf-8）
        try (Reader reader = new FileReader("File测试目录\\中文.txt")) {
            char[] buf = new char[1024];
            int n;
            while ((n = reader.read(buf)) != -1) {
                for (int i = 0; i < n; i++) {
                    System.out.println(buf[i]);
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }*/
    }
    private static void outputDemo(){
        //字节流
        // 1. 如果文件不存在，会进行文件的创建（失败的条件等同于平时创建文件失败的条件）
        // 2. 如果文件存在，会进行“覆盖”方式的写入
        try (OutputStream os = new FileOutputStream("File测试目录\\world.txt")) {
            // 1. 单字节的写入
            /*
            os.write('H');
            os.write('\r');
            os.write('\n');
            os.write('W');
            */

            // 2. 批量的方式写入
            byte[] buf = new byte[8];
            buf[0] = 'H';
            buf[1] = '\r';
            buf[2] = '\n';
            buf[3] = 'W';

            os.write(buf, 0, 4);
            //os.write(buf); == os.write(buf, 0, buf.length);

            // 3. 无论是哪种方式写入，一定需要做 flush() 操作
            os.flush();     // 强制要求把系统（软件部分 JVM/OS) 中缓冲的数据，刷新到真正的硬件中
            // 为了提升速度，很多Output的类实现中，都会包含缓冲区
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
