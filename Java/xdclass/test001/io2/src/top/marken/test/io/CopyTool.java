package top.marken.test.io;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @author makun
 * @project test001
 * @description 文件复制工具
 * @date 2022/08/16 10:27:43
 * version 1.0
 */
public class CopyTool {
    private CopyTool() {
        super();
    }

    public static boolean textCopy(String source, String target) {
        boolean flag = true;

        FileReader reader = null;
        FileWriter writer = null;
        char[] buffer = new char[1024];
        int length;

        try {
            reader = new FileReader(source);
            writer = new FileWriter(target);

            while ((length = reader.read(buffer)) != -1) {
                writer.write(buffer,0,length);
            }

        } catch (IOException e) {
            e.printStackTrace();
            flag = false;
        } finally {
            if (writer != null) {
                try {
                    writer.flush();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

           if (reader != null) {
               try {
                   reader.close();
               } catch (IOException e) {
                   e.printStackTrace();
               }
           }

           if (writer != null) {
               try {
                   writer.close();
               } catch (IOException e) {
                   e.printStackTrace();
               }
           }
        }

        return flag;
    }
}
