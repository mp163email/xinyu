package 自动辨别文件编码;

import java.io.*;
import java.nio.charset.Charset;

/**
 * des:
 * created by miapoeng on 2020/4/28 18:41
 */
public class MainTest {
    public static void main(String[] args) throws Exception {
        File f  = new File("D:"+ File.separator+"test.txt");
        FileInputStream in = new FileInputStream(f);
        String code = getTxtEncode(in);
        System.out.println(code);
    }

    public static String getTxtEncode(FileInputStream in) throws IOException {

        String dc = Charset.defaultCharset().name();
        UnicodeInputStream uin = new UnicodeInputStream(in, dc);

        if ("UTF-8".equals(uin.getEncoding())) {
            uin.close();
            return "UTF-8";
        }
        uin.close();

        byte[] head = new byte[3];
        in.read(head);
        String code = "GBK";
        if (head[0] == -1 && head[1] == -2)
            code = "UTF-16";
        if (head[0] == -2 && head[1] == -1)
            code = "Unicode";
        //带BOM
        if (head[0] == -17 && head[1] == -69 && head[2] == -65)
            code = "UTF-8";
        if ("Unicode".equals(code)) {
            code = "UTF-16";
        }
        return code;
    }
}
