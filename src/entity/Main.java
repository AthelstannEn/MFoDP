package entity; 

import java.lang.Math;
import java.util.Random;
import java.io.*;

    public class Main {
    	//функція генерування рандомного значення ключа 
    	int min = 1; 
    	int max = 15; 
    	int offset = min + (int) (Math.random() * max);
  		
       public String encrypt(String s) throws IOException
    {
     //побудова матриці з 26 латинських літер   
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<s.length();i++)
        {
          
            char t=s.charAt(i);
            if(t>='A' && t<='Z')
            {
                int t1=t-'A'+offset;
                //
                t1=t1%26;
                sb.append((char)(t1+'A'));
            }
         
            else if(t>='a' && t<='z')
            {
                int t1=t-'a'+offset;
                t1=t1%26;
                sb.append((char)(t1+'a'));
            }
            else if(t>='a' && t<='z')
            {
                int t1=t-'a'+offset;
                t1=t1%26;
                sb.append((char)(t1+'a'));
            }
            else {
                sb.append(t);
            }
        }
        return sb.toString();
    }

    public String decrypt(String s) throws IOException
    {
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<s.length();i++)
        {
            char t=s.charAt(i);
            if(t>='A' && t<='Z')
            {
                int t1=t-'A'-offset;
                if(t1<0)t1=26+t1;
                sb.append((char)(t1+'A'));
            }
            else if(t>='a' && t<='z')
            {
                int t1=t-'a'-offset;
                if(t1<0)t1=26+t1;
                sb.append((char)(t1+'a'));
            }
            else if(t>='a' && t<='z')
            {
                int t1=t-'a'+offset;
                t1=t1%26;
                sb.append((char)(t1+'a'));
            }
            else {
                sb.append(t);
            }
        }
        return sb.toString();
    }

public static void main(String[] args) {
try
{
    System.out.println("Шифр Плейфера");
    BufferedReader b;
    String oriTxt,encTxt,decTxt;
    System.out.println("Введіть вхідний текст:");
    b=new BufferedReader(new InputStreamReader(System.in));//зчитування вхідного тексту
    oriTxt=b.readLine();
    System.out.println("------------------------");
    

    String str1 = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";//запис у рядок літер алфавіту 
    
    int colCount = 5;
    int strLen = str1.length();
    int rowCoun = (strLen%colCount==0)?strLen/colCount:strLen/colCount+1;//побудова сток

    char[] inputArray = str1.toCharArray();
    char[][] sarray = new char[rowCoun][colCount];

    for (int i=0; i<rowCoun; i++) {
        for (int j=0; j<colCount; j++)
        	sarray[i][j] = (colCount*i+j < strLen)?inputArray[colCount*i+j]:' ';//запис в двувимірняй масив
    }


    for (int i=0; i<rowCoun; i++) {
        for (int j=0; j<colCount; j++)
            System.out.print("|"+sarray[i][j]); //вивід двовимірного масиву
        System.out.println();
    }


   System.out.println("------------------");
    
   	int columCount = 5;
    int strLength = oriTxt.length();
    int rowCount = (strLength%columCount==0)?strLength/columCount:strLength/columCount+1;

    char[] inputCharArray = oriTxt.toCharArray();
    char[][] array = new char[rowCount][columCount];

    for (int i=0; i<rowCount; i++) {
        for (int j=0; j<columCount; j++)
            array[i][j] = (columCount*i+j < strLength)?inputCharArray[columCount*i+j]:' ';
    }
    
    for (int i=0; i<rowCount; i++) {
        for (int j=0; j<columCount; j++)
            System.out.print("|"+array[i][j]);
        System.out.println();
    }
	
    
    Main c=new Main();
    encTxt=c.encrypt(oriTxt);
    System.out.println("Зашифрований текст :"+encTxt);
    System.out.println("---------------------------");
    int colum = 5;
   int sstrLength = encTxt.length();
     rowCount = (sstrLength%columCount==0)?strLength/columCount:sstrLength/columCount+1;

    char[] iinputCharArray = encTxt.toCharArray();
    char[][] iarray = new char[rowCount][colum];

    for (int i=0; i<rowCount; i++) {
        for (int j=0; j<columCount; j++)
            iarray[i][j] = (columCount*i+j < strLength)?iinputCharArray[columCount*i+j]:' ';
    }
    
    for (int i=0; i<rowCount; i++) {
        for (int j=0; j<columCount; j++)
            System.out.print("|"+iarray[i][j]);
        System.out.println();
    }
    
    System.out.println("-----------------------");
    decTxt=c.decrypt(encTxt);
    System.out.println("Дешифрований текст :"+decTxt);
}
catch(Exception e)
{
    System.out.println(e.toString());
    }
    }
}