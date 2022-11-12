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
        view.introductionDificult();
        String introduced="";
        boolean correct = false;
        String nameFile = "";
        while(!correct)
        {
            introduced = view.readDificult();
            correct = introductionDificultCorrect(introduced);
        }
        if(introduced.equals("1"))
        {
            correct = true;
            difficulty = 1;
            nameFile = "src/Model/paraulesFàcil";
        }
        else if(introduced.equals("2"))
        {
            correct = true;
            difficulty = 2;
            nameFile = "src/Model/paraulesMitjà";
        }
        else if(introduced.equals("3"))
        {
            difficulty = 3;
            nameFile = "src/Model/paraulesDifícil";
        }
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
        view.printWelcome();
        view.printLine();
        wordExpected = dificult();
        System.out.println(wordExpected.getWordString());
        view.printLine();
        player.register(this.view);
        view.printLine();
        view.firstAttempt();
        Word wordIntroduced= introduceWord();//primer intent d'endevinar la paraula
        view.nextLine();
        int tried=0;

        while(!checkWord(wordIntroduced,tried) && tried<5)//while the player doesn't win, or the attempts run out, the loop continues
        {
            tried++;
            view.attemptsRemaining(tried);
            if(tried == 5)
            {
                view.lastAttempt();
            }
            else
            {
                view.tryAgain();
            }
            wordIntroduced = introduceWord();
            view.nextLine();
        }

        if(!winner)//since there is no winner, it means that he has run out of attempts
        {
            view.nextLine();
            view.gameOver(wordExpected.getWordString());
        }
        //Show the top 3
        String n1=ReadWriteBD.getPlayer(0);
        String n2=ReadWriteBD.getPlayer(1);
        String n3=ReadWriteBD.getPlayer(2);
        view.nextLine();
        view.printTop3(n1,n2,n3);
    }
    private boolean checkWord(Word wordIntroduced, int tried) throws IOException//metode per comprobar si el jugador ha guanyat
    {
        if(wordIntroduced.sameWord(wordExpected))//si és la mateixa paraula haurà guanyat
        {
            this.winner = true;
            this.player.setPoints((6-tried)*difficulty);
            this.view.winner(player.getPoints(), player.getName());
            this.player.save();
            return true;
        }
        else//no es la mateixa paraula, s'escriura per pantalla les lletres que han coincidit
        {
            wordIntroduced.printAchivements(wordExpected, this.view);
            return false;
        }
    }
    public boolean getCheckWord(Word wordIntroduced, Word wordExpected, Player p) throws IOException {
        this.wordExpected = new Word(wordExpected.getWordString());
        this.player.setPoints(p.getPoints());
        this.player.setName(p.getName());
        this.difficulty = 1;
        return checkWord(wordIntroduced, 0);
    }
    public Word introduceWord()//metode per introduir la paraula, retorna clase Paraula amb la paraula introduida
    {
        String introduced = "";
        boolean correct = false;
        while(!correct)
        {
            introduced = view.readWord();

            //Falta comprovar numeros
            correct = goodIntroduction(introduced);
        }
        introduced = introduced.toLowerCase();
        Word intr = new Word(introduced);//es guarda la paraula introduida en una clase Paraula
        return intr;
    }
    public boolean goodIntroduction(String introduced)
    {
        if(thereIsSpaces(introduced) || !wordWithOnlyLetters(introduced))
        {
            view.errorSpacesAndCharacters();
            return false;
        }
        else if(introduced.length()<5 || introduced.length()>5)
        {
            view.errorLengthWord();
            return false;
        }
        else
        {
            return true;
        }
    }
    private boolean wordWithOnlyLetters(String introduced)//retorna si la paraula pasada per parametres només conté lletres
    {

        char[] letters = introduced.toCharArray();
        int i=0;
        boolean haveCharacters = true;
        while(haveCharacters && i < letters.length)
        {
            haveCharacters = isLetter(letters[i]);
            i++;
        }

        return haveCharacters;
    }
    private static boolean isLetter(char c) //retorna si el char que es pasa per parametres es una lletra
    {
        return (c >= 'a' && c <= 'z') ||
                (c >= 'A' && c <= 'Z') || (c == 'à' || c == 'À') || (c == 'í' || c == 'Í')
                || (c == 'ú'|| c == 'Ú') || (c == 'é'|| c == 'É')
                || (c == 'è' || c == 'È') || (c == 'ó' || c == 'Ó') || (c == 'ò' || c == 'Ò')
                || (c == 'ç'|| c == 'Ç') || (c == 'ï' || c == 'Ï') || (c == '·');
    }
    private boolean thereIsSpaces(String word)//retorna si l'String que es pasa per parametres conté espais
    {
        String wordNoSpaces = word.replaceAll(" ", "");
        return !word.equals(wordNoSpaces);
    }
}
