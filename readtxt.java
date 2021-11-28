package srcNo21;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class readtxt {
    char[] chars = new char[]{'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s'
                                  ,'t','u','v','w','x','y','z',' '};
    int[] number = new int[]{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
    public String txtString(File file){
        StringBuilder result = new StringBuilder();
        try{
            BufferedReader br = new BufferedReader(new FileReader(file));//构造一个BufferedReader类来读取文件
            String s = null;
            while((s = br.readLine())!=null){//使用readLine方法，一次读一行
                result.append(System.lineSeparator()+s);
                num(s);
            }
            br.close();
        }catch(Exception e){
            e.printStackTrace();
        }
        return result.toString();
    }


    public void num(String string){
        for(int i = 0;i<27;i++){
            int temp = 0;
            for(int j = 0;j<string.length();j++){
                if(string.charAt(j) == chars[i])
                    temp++;
            }
            number[i] += temp;
        }
    }


    public int[] getNumber(){
        return number;
    }

    public char[] getChars(){
        return chars;
    }
}
