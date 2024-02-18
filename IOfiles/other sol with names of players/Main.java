import java.io.*;
import java.net.SocketTimeoutException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.concurrent.ForkJoinPool;

public class Main {
    public static void main(String[] args) {
        Scanner s= new Scanner(System.in);
        String answer;
        String lastWord;
        int counter;
        String name = null;
        int max = 0;
        ArrayList <String>names=new ArrayList<>();
        ArrayList <Integer>arr=new ArrayList<>();
        ArrayList <String>lastword=new ArrayList<>();
        String line,last = null;
        int score=0;
        try (FileReader reader=new FileReader("winner.txt");BufferedReader prr=new BufferedReader(reader))
        {
            while ((line = prr.readLine()) != null){last=line;
               lastWord = line.substring(line.lastIndexOf(" ")+1);
               if(lastWord.equals("3")){
                   System.out.println(line);
               }
               lastword.add(lastWord);
            }
            System.out.println("\n"+last);
            counter=Collections.frequency(lastword,"3");
            System.out.println("highest players : "+counter);
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }

        for (int x = 0; x <2; x++) {
            String []cities={"cairo", "alex", "aswan", "giza"};
            System.out.println("player"+(x+1));
            System.out.println("enter your name");
            name=s.nextLine();
            System.out.println("Guess 3 cities in egypt?");
            for (int i = 0; i < 3; i++) {
                answer= s.nextLine();
                for (int j = 0; j < cities.length; j++) {
                    if (answer.equalsIgnoreCase(cities[i])){
                        cities[i]="";
                        score++;
                        break;
                    }
                }
                names.add(name);
            }
            arr.add(score);
        }
            max=Collections.max(arr);

        try (FileWriter winer=new FileWriter("winner.txt",true);
            BufferedWriter pr=new BufferedWriter(winer);)
        {

            pr.write(names.get(arr.indexOf(max)+1) +(arr.indexOf(max)+1)+"  "+"score " +max+"\n");
            pr.newLine();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}