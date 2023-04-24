package org.example;

import java.io.*;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException {
        String path="C:\\Users\\ajay kumar\\Desktop\\sqlData.txt";

        FileReader fr=new FileReader(path);

        BufferedReader br =new BufferedReader(fr);

        String line=br.readLine();

        ArrayList<String>arr=new ArrayList<>();

        while(line!=null){

            line=line.replaceAll("`","");
            line=line.replaceAll("CURDATE\\(\\)","CURRENT_DATE");
            line=line.replaceAll("Open","open");
            arr.add(line);
            line= br.readLine();

        }

        path="C:\\Users\\ajay kumar\\Desktop\\sqlData_output.txt";

        FileWriter fw=new FileWriter(path);

        for(String str:arr){
            fw.write(str+System.lineSeparator());
        }

        fr.close();
        fw.close();

    }
}