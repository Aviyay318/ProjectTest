package org.example;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        try {
            Document document = Jsoup.connect("https://www.rsssf.org/tablesi/isra2022.html").get();
            Element element=document.body();
            String str = element.text();
            str= str.substring(str.indexOf("Round 1"),str.indexOf("Round 2"));
            Scanner scanner = new Scanner(System.in);
            System.out.println("choose team");
            String myD="";
            String team = scanner.nextLine();
            String [] myData = str.split("\n");
           for (int i=0;i<myData.length;i++){
               if (myData[i].contains(team)){
                   String [] temp = myData[i].split(" ");
                   for (int j=0;j<temp.length;j++){
                       if (!temp[j].equals("")){
                           myD+=temp[j]+" ";
                       }
                   }
                   System.out.println(myD);
                   break;
               }
           }
           String [] str1= myD.split(" ");
           String name = str1[0]+" "+str1[1];
           int first = Integer.parseInt(str1[2].substring(0,1));
           int second =  Integer.parseInt(str1[2].substring(2));
           if (name.equals(team)){
               if (first>second){
                   System.out.println("win");
               } else if (second>first) {
                   System.out.println("lose");
               }else {
                   System.out.println("draw");
               }
           }else {
               if (first<second){
                   System.out.println("win");
               } else if (second<first) {
                   System.out.println("lose");
               }else {
                   System.out.println("draw");
               }
           }
            System.out.println(str);
        }catch (IOException e){
            System.out.println("dkd");
        }
    }
}