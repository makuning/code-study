package top.marken.test.io;

/**
 * @author makun
 * @project test001
 * @description 输入输出测试，启动类
 * @date 2022/08/16 10:26:55
 * version 1.0
 */
public class Main {
    public static void main(String[] args) {
        String source = "D:\\study\\code\\Java\\xdclass\\test001\\io2\\test.txt";
        String target = "D:\\study\\code\\Java\\xdclass\\test001\\io2\\target.txt";

        boolean flag = CopyTool.textCopy(source,target);
        System.out.println(flag ? "success" : "fail");
    }
}
