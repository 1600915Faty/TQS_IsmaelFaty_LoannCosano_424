package View;

import Controler.Main;

import java.util.Scanner;

public class View {
    public String readNamePlayer()
    {
        Scanner sc = new Scanner(System.in);
        return  sc.nextLine();
    }
    public String readDificult()
    {
        Scanner sc = new Scanner(System.in);
        return  sc.nextLine();
    }

    public String readWord()
    {
        Scanner sc = new Scanner(System.in);
        return  sc.nextLine();
    }


    //Game class
    public void printWelcome()
    {
        System.out.println(Main.ANSI_PURPLE+"Benvingut a Wordle!"+ Main.ANSI_RESET);
        System.out.println("En aquest joc hauràs d'endevinar quina és la paraula de " + Main.ANSI_RED + "5 lletres" + Main.ANSI_RESET);
        System.out.println("Tens" + Main.ANSI_RED + " 6 intents " + Main.ANSI_RESET + "per endevinar la paraula");
        System.out.println("Cada intent, s'indicarà quines són les lletres de la paraula que has posat que estan en la paraula a endevinar i quines estan en la posició correcta.");
    }
    public void printLine()
    {
        System.out.println("-----------------------------------------");
    }
    public void firstAttempt()
    {
        System.out.print("Primer intent: ");
    }
    public void nextLine()
    {
        System.out.println();
    }
    public void attemptsRemaining(int tried)
    {
        System.out.println("Et queden " + (6-tried) + " intents!");
    }
    public void lastAttempt()
    {
        System.out.print(Main.ANSI_RED + "Últim intent: " + Main.ANSI_RESET);
    }
    public void tryAgain()
    {
        System.out.print("Torna a intentar-ho: ");
    }
    public void winner(int points, String name)
    {
        System.out.println(Main.ANSI_BLUE + "Felicitats " + name+ " has guanyat!" + Main.ANSI_RESET);
        System.out.println(Main.ANSI_BLUE + points + " punts obtinguts." + Main.ANSI_RESET);
    }
    public void gameOver(String wordExpected)
    {
        System.out.println(Main.ANSI_RED + "T'has quedat sense intents!" + Main.ANSI_RESET);
        System.out.println(Main.ANSI_BLUE + "La paraula correcte era: "+ wordExpected + Main.ANSI_RESET);
        System.out.println(Main.ANSI_RED + "GAME OVER" + Main.ANSI_RESET);
    }
    public void printTop3(String n1, String n2, String n3)
    {
        System.out.println(Main.ANSI_PURPLE + "Top 3 actual: " + Main.ANSI_RESET);
        System.out.println("1. " + n1 + " punts");
        System.out.println("2. " + n2 + " punts");
        System.out.println("3. " + n3 + " punts");
    }
    public void errorSpacesAndCharacters()
    {
        System.out.println(Main.ANSI_RED +"La paraula només pot contenir lletres del diccionari català i sense espais"+ Main.ANSI_RESET);
        System.out.print("Torna a intentar-ho: ");
    }
    public void errorLengthWord()
    {
        System.out.println(Main.ANSI_RED +"La paraula ha de ser de 5 lletres"+ Main.ANSI_RESET);
        System.out.print("Torna a intentar-ho: ");
    }

    public void introductionDificult()
    {
        System.out.println("Primer de tot, escolleix la dificultat a la que vols jugar: ");
        System.out.println("1-Fàcil");
        System.out.println("2-Mitjà");
        System.out.println("3-Difícil");
        System.out.print("Dificultat: ");
    }
    public void errorInputDificult()
    {
        System.out.println(Main.ANSI_RED+"Número introduït incorrecte, només pots introduïr: 1, 2 o 3"+ Main.ANSI_RESET);
        System.out.print("Dificultat: ");
    }



    //Word class
    public void letterInPosition(char letter, int pos)
    {
        System.out.println(Main.ANSI_GREEN + "La lletra '" + letter + "' esta en la posició " + pos + " en la paraula esperada" + Main.ANSI_RESET);
    }
    public void letterInWord(char letter)
    {
        System.out.println(Main.ANSI_YELLOW+ "La lletra '"+ letter + "' esta contiguda en la paraula esperada" + Main.ANSI_RESET);
    }



    //Player class
    public void introductionRegisterPlayer()
    {
        System.out.println("La teva partida quedarà registrada en una Base de Dades.");
        System.out.print("Introdueix el teu nom: ");
    }
    public void emptyName()
    {
        System.out.println("Paraula buida o amb espais! Has d'introduïr el teu nom i sense espais");
        System.out.print("Introdueix el teu nom: ");
    }

}
