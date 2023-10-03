package task3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.*;
public class SortedFile
{
    public static void main(String[] args) {


        try
        {
            String fileName = "words.txt";
            Map<String,Integer> mapWord = countWord(fileName);

            List<Map.Entry<String,Integer>> entryList = new ArrayList<>();

            entryList.sort((a,b)->b.getValue().compareTo(a.getValue()));

            for(Map.Entry<String,Integer> entry : entryList)
            {
                System.out.println(entry.getKey() + " " + entry.getValue());
            }
        }
        catch (IOException ioException)
        {
            ioException.printStackTrace();
        }
    }

    public static Map<String,Integer> countWord(String fileName) throws IOException
    {
    Map<String,Integer> mapWord = new HashMap<>();

    try(BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName)))
    {
        String line ;
        while((line= bufferedReader.readLine())!=null)
        {
            String [] words = line.split(" ");
            for(String word : words)
            {
                mapWord.put(word,mapWord.getOrDefault(word,0)+1);
            }
        }
    }
    return mapWord;

    }



}
