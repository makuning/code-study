package top.marken.test.io;

public class Main {
    public static void main(String[] args) {
        String sourceCDir = "D:\\study\\code\\Java\\xdclass\\test001\\io\\college_images";
        String targetDir = "D:\\study\\code\\Java\\xdclass\\test001\\io\\images_of_mine";

        boolean flag = CopyTool.filesCopy(sourceCDir,targetDir);


        System.out.println(flag ? "success" : "fail");

       /*
        String source = "D:\\study\\code\\Java\\xdclass\\test001\\io\\test.txt";
        String target = "D:\\study\\code\\Java\\xdclass\\test001\\io\\target.txt";

        boolean flag = CopyTool.fileCopy(source,target);


        System.out.println(flag ? "success" : "fail");*/
    }
}











