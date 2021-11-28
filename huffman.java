package srcNo21;

import java.io.*;
import java.util.*;


public class huffman {

    public static void main(String[] args) throws IOException {
        List<Node<String>> list = new ArrayList<Node<String>>();
        List<Node<String>> list2 = new ArrayList<Node<String>>();
        List<String> list3 = new ArrayList<String>();
        List<String> list4 = new ArrayList<String>();
        List<String> list5 = new ArrayList<String>();
        String temp2 = "",temp3 = "";
        String result="";
        double num2 = 0;


        File file = new File("D:/input1.txt");
        readtxt read = new readtxt();
        String temp = read.txtString(file);
        System.out.println(temp);
        int[] num = read.getNumber();
        char[] chars = read.getChars();
        for(int i = 0;i<27;i++){
            System.out.print(chars[i]+"："+num[i]+"   ");
            list.add(new Node<String>(chars[i]+"",num[i]));
        }
        Collections.sort(list);

        System.out.println();
        HuffmanTree huffmanTree = new HuffmanTree();
        Node<String> root = huffmanTree.createTree(list);

        list2=huffmanTree.breadth(root);
        for(int i = 0;i<list2.size();i++){
            if(list2.get(i).getData()!=null) {
                list3.add(list2.get(i).getData());
                list4.add(list2.get(i).getCode());
            }
        }


        for(int i = 0;i<list2.size();i++){
            num2 += list2.get(i).getWeight();
        }

        for(int i = 0;i<list3.size();i++){
            System.out.print(list3.get(i) + "出现的概率为" + list2.get(i).getWeight()/num2 + "  ");
        }




        System.out.println();
        for(int i = 0;i<list4.size();i++){
            System.out.print(list3.get(i)+"的编码为"+list4.get(i)+" ");
        }
        System.out.println();

        for(int i = 0;i<temp.length();i++){
            for(int j = 0;j<list3.size();j++){
                if(temp.charAt(i) == list3.get(j).charAt(0))
                    result += list4.get(j);
            }
        }


        System.out.println("编码后为："+ result);


        for(int i = 0;i<result.length();i++){
            list5.add(result.charAt(i)+"");
        }


        while (list5.size()>0){
            temp2 = temp2+"" +list5.get(0);
            list5.remove(0);
            for(int i=0;i<list4.size();i++){
                if (temp2.equals(list4.get(i))) {
                    temp3 = temp3+""+list3.get(i);
                    temp2 = "";
                }
            }
        }
        System.out.println();

        System.out.println("编码前"+temp);
        System.out.println("解码后"+"\n"+temp3);

        File file2 =new File("D:/input2.txt");
        Writer out =new FileWriter(file2);
        out.write(temp3);
        out.close();
    }
}