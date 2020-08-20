package 不关心编码传输文件;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

/**
 * des:
 * created by miapoeng on 2020/4/30 21:52
 */
public class TestMain {
    public static void main(String[] args) {

    }

    public static void saveFileWithStream (File file, byte[] stream) {
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream(file);
            fos.write(stream);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (fos != null) {
                try {
                    fos.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * 文件转成字节数组
     * @return
     */
    public static byte[] fileToByteArray (File file) {
        byte[] data = null;
        try {
            FileInputStream fis = new FileInputStream(file);
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            int len;
            byte[] buffer = new byte[1024];
            while ((len = fis.read(buffer)) != -1) {
                baos.write(buffer, 0, len);
            }
            data = baos.toByteArray();
            fis.close();
            baos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return data;
    }
}
