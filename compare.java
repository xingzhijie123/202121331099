package program_h1;
import java.io.*;
public class compare {
    public static void main(String[] args) throws IOException {
        //float ash = repeat.check("D:\\chachongtest\\test\\orig.txt","D:\\chachongtest\\test\\orig_add.txt");
        //float ash = repeat.check("D:\\chachongtest\\test\\orig.txt","D:\\chachongtest\\test\\orig_delete.txt");
        float ash = repeat.check("D:\\chachongtest\\test\\orig.txt","D:\\chachongtest\\test\\orig_same.txt");
        String aout = "D:\\chachongtest\\test\\123.txt";
        System.out.println("查重结果文件 " + aout);
        System.out.println("查重"+ ash);
        File f = new File(aout);
        try {
            if(!f.exists()) {
                f.createNewFile();
            }
            FileWriter fw = new FileWriter(f);
            fw.write("");
            fw.flush();
            fw.write(String.valueOf(ash));
            fw.close();
        }catch(IOException e) {
            e.printStackTrace();
        }
    }
}
