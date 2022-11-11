package Controler;

import Model.ReadWriteBD;
import View.View;

import java.io.IOException;

public class Game {
    private Word wordExpected;
    private int points;
    private int difficulty;
    private Player player;
    private View view;
    private boolean winner;
    public Game(View v)
    {
        points = 0;
        difficulty = 0;
        winner = false;
        this.player = new Player();
        this.view = v;
    }
    public void setView(View v)
    {
        this.view = v;
    }
    public Word dificult() throws IOException//escolleix la dificultat i a partir dels fitxers s'agafa una paraula aleatoria
    {
        return new Word(ReadWriteBD.getWordExpected(nameFile));
    }

    public boolean introductionDificultCorrect(String introduced)
    {
        if(introduced.equals("1") || introduced.equals("2") || introduced.equals("3"))
        {
            return true;
        }
        else
        {
            view.errorInputDificult();
            return false;
        }
    }

    public void play() throws IOException//metode principal del joc, on s'encarrega d'iniciar el joc i cridar els metodes corresponents
    {

    }
    private boolean checkWord(Word wordIntroduced, int tried) throws IOException//metode per comprobar si el jugador ha guanyat
    {
        return false;
    }
    public boolean getCheckWord(Word wordIntroduced, Word wordExpected, Player p) throws IOException {
        return false;
    }
    public Word introduceWord()//metode per introduir la paraula, retorna clase Paraula amb la paraula introduida
    {

        Word intr = new Word("");//es guarda la paraula introduida en una clase Paraula
        return intr;
    }
    public boolean goodIntroduction(String introduced)
    {
        return false;
    }
    private boolean wordWithOnlyLetters(String introduced)//retorna si la paraula pasada per parametres només conté lletres
    {
        return false;
    }
    private static boolean isLetter(char c) //retorna si el char que es pasa per parametres es una lletra
    {
        return false;
    }
    private boolean thereIsSpaces(String word)//retorna si l'String que es pasa per parametres conté espais
    {
        return false;
    }
}
