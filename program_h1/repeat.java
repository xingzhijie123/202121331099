package program_h1;
import java.io.*;
import java.math.*;

public class repeat {
    public static int minpubilqueue(String str1, String str2) {
        // 求最小公共子序列

        // 在两个字符串前面添加字符 '2' 和 '1'，用于构建辅助数组
        String t1 = "2" + str1;
        String t2 = "1" + str2;

        // 创建一个二维数组用于存储最长公共子序列的长度
        int[][] check = new int[str1.length() + 1][str2.length() + 1];

        // 填充辅助数组
        for (int i = 0; i < t1.length(); i++) {
            for (int j = 0; j < t2.length(); j++) {
                if (i == 0 || j == 0) {
                    // 第一个格子初始化为0
                    check[i][j] = 0;
                } else if (t1.charAt(i) == t2.charAt(j)) {
                    check[i][j] = check[i - 1][j - 1] + 1;
                } else {
                    if (check[i - 1][j] > check[i][j - 1])
                        check[i][j] = check[i - 1][j];
                    else
                        check[i][j] = check[i][j - 1];
                }
            }
        }

        // 返回最长公共子序列的长度
        return check[t1.length() - 1][t2.length() - 1];
    }

    // 计算文本相似度的方法
    static float check(String path1, String path2) throws IOException {
        float orirate = 0;
        String filePath = path1;
        System.out.println("原文" + path1);
        System.out.println("抄袭" + path2);
        String comparePath = path2;

        String text1 = new String();
        String text2 = new String();
        BufferedReader in1 = new BufferedReader(new InputStreamReader(new FileInputStream(filePath), "UTF8"));
        BufferedReader in2 = new BufferedReader(new InputStreamReader(new FileInputStream(comparePath), "UTF8"));
        String s;
        while ((s = in1.readLine()) != null) {
            text1 += s;
        }
        while ((s = in2.readLine()) != null) {
            text2 += s;
        }
        // 调用最小公共子序列函数
        int cptext = minpubilqueue(text1, text2);
        int length_1 = text1.length();
        int len2 = text2.length();
        in1.close();
        in2.close();
        if (length_1 > len2) {
            orirate = (float) cptext / length_1;
        } else {
            orirate = (float) cptext / len2;
        }
        // 保留两位小数
        float finalrate = (float) (Math.round(orirate * 100)) / 100;
        return finalrate;
    }
}
