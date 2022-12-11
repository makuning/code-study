package top.marken.test.io;

import java.io.*;

/**
 * @author makun
 * @project test001
 * @description 用于复制的工具类
 * @date 2022/08/15 11:33:09
 * version 1.0
 */
public class CopyTool {
    private CopyTool() {
        super();
    }

    public static boolean filesCopy(String sourceDir, String targetDir) {
        boolean flag = true;
        File sDir = new File(sourceDir);
        File tDir = new File(targetDir);

        if (!(sDir.isDirectory() && tDir.mkdir())) {
            return false;
        }
        File[] sources = sDir.listFiles();

        if (sources != null) {
            FileInputStream in;
            FileOutputStream out;
            BufferedInputStream bIn = null;
            BufferedOutputStream bOut = null;
            byte[] buffer = new byte[1024];
            int length = -1;

            try {
                for (File source : sources) {
                    String fileName = source.getName();
                    in = new FileInputStream(sourceDir + "\\" + fileName);
                    out = new FileOutputStream(targetDir + "\\" + fileName);
                    bIn = new BufferedInputStream(in);
                    bOut = new BufferedOutputStream(out);

                    while ((length = bIn.read(buffer)) != -1) {
                        bOut.write(buffer,0,length);
                    }
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
                flag = false;
            } catch (IOException e) {
                e.printStackTrace();
                flag = false;
            } finally {
                try {
                    if (bIn != null) {
                        bIn.close();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }

                try {
                    if (bOut != null) {
                        bOut.close();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return flag;
    }

    /**
     * 用于复制单个文件
     * @param source
     * @param target
     * @return
     */
    public static boolean fileCopy(String source, String target) {
        boolean flag = true;

        try {
            FileInputStream in = new FileInputStream(source);
            FileOutputStream out = new FileOutputStream(target);
            BufferedInputStream bIn = new BufferedInputStream(in);
            BufferedOutputStream bOut = new BufferedOutputStream(out);

            byte[] buffer = new byte[in.available()];

            while (bIn.read(buffer) != -1) {
                bOut.write(buffer);
            }

            bOut.flush();

            bIn.close();
            bOut.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            flag = false;
        } catch (IOException e) {
            e.printStackTrace();
            flag = false;
        }

        return flag;
    }
}
