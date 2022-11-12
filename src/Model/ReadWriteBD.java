package Model;

import Controler.Player;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

public class ReadWriteBD {
    public static String getWordExpected(String nameFile) throws IOException {
        String guess = "";
        Path path = Paths.get(nameFile);
        Random rand = new Random(); //instance of random class
        try{
            int upperbound = (int) Files.lines(path).count();//file length
            //generate random values from 0-(upperbound-1)
            int int_random = rand.nextInt(upperbound);
            guess = Files.readAllLines(path).get(int_random);//get the word of the line int_random
            //System.out.println(guess);//to comment, is the wordExpected
        }
        catch(IOException e)//Cambiar a una funcion que te cree el fichero
        {
            File myObj = new File(nameFile);
            myObj.createNewFile();
        }
        return guess;
    }
    public static void savePlayer(Player p, String nameFile) throws IOException {
        //We will put into two arrayList all players of the rankings an add into the good position the actual player, to have a sorted file
        BufferedReader reader = new BufferedReader(new FileReader(nameFile));
        ArrayList<String> namesList = new ArrayList<String>();
        ArrayList<Integer> pointsList = new ArrayList<Integer>();
        String currentLine = reader.readLine();
        boolean introduced=false;
        while (currentLine != null)
        {
            String[] nameAndPointsLine = currentLine.split(" ");

            String name = nameAndPointsLine[0];

            int marks = Integer.valueOf(nameAndPointsLine[1]);


            if(marks<=p.getPoints() && !introduced)//We will put the actual player at this position
            {
                namesList.add(p.getName());
                pointsList.add(p.getPoints());
                introduced=true;
            }
            namesList.add(name);
            pointsList.add(marks);

            currentLine = reader.readLine();
        }
        if(!introduced)//means that the actual player is the last of the Ranking
        {
            namesList.add(p.getName());
            pointsList.add(p.points);
            introduced=true;
        }
        reader.close();
        Iterator<String> it1=namesList.iterator();
        Iterator<Integer> it2=pointsList.iterator();
        //with this we will empty the file
        PrintWriter pw = new PrintWriter(nameFile);
        pw.close();
        //we rewrite the file
        BufferedWriter writer = new BufferedWriter(new FileWriter(nameFile, true));
        while(it1.hasNext() && it2.hasNext())
        {
            writer.write(it1.next());
            writer.write(" " + it2.next());
            writer.newLine();
        }
        writer.close();
    }
    public static String getPlayer(int pos) throws IOException {
        Path path = Paths.get("src/Model/Ranking");
        return Files.readAllLines(path).get(pos);
    }
}
