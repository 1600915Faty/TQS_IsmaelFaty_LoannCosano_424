package Controler;

import Controler.Letter;
import View.View;

import java.util.ArrayList;
import java.util.List;

public class Word {
    private Letter[] letters=new Letter[5];
    public Word(){}
    public Word(String word)
    {
        if(word.length()==5)
        {
            char[] s=word.toCharArray();
            for(int i=0; i<5; i++)
            {
                letters[i]=new Letter(s[i]);
            }
        }
    }

    public String getWordString() //pasa la lista de letras a un String
    {
        String wordString="";

        for(int i=0; i<5; i++)
        {
            if(letters[i]!=null)
            {
                wordString+=letters[i].getLetter();
            }
            else{
                return "";
            }

        }
        return wordString;
    }
    public boolean sameWord(Word p)//comprueba si la palabra pasada por parametro es igual a la palabra de esta clase
    {
        if(p.getWordString().equals(getWordString()))
        {
            return true;
        }
        return false;
    }
    public boolean printAchivements(Word wordExpected)//printea las coincidencias con la palabra esperada
    {
        Letter[] lettersExpected=wordExpected.getLetter();

        List<List<Integer>> mentions = new ArrayList<List<Integer>>();

        mentions=samePosition(lettersExpected);
        mentions=lettersInWord(lettersExpected,mentions.get(0),mentions.get(1));
        if(mentions.get(0).isEmpty() && mentions.get(1).isEmpty())
        {
            return false;
        }
        return true;
    }
    public List<List<Integer>> samePosition(Letter[] lettersExpected)
    {
        List<Integer> jaMencionatsIntroduced=new ArrayList<Integer>();
        List<Integer> jaMencionatsExpected=new ArrayList<Integer>();
        List<List<Integer>> mentions = new ArrayList<List<Integer>>();
        boolean error=false;
        if(lettersExpected.length==letters.length)
        {
            for(int e=0; e<5; e++)//bucle para comprovar que letras estan en la posicion esperada
            {
                if(lettersExpected[e].getLetter()!=' ')
                {
                    boolean res=letters[e].sameLetter(lettersExpected[e].getLetter());
                    if(res)
                    {
                        jaMencionatsIntroduced.add(e);
                        jaMencionatsExpected.add(e);
                        View.letterInPosition(letters[e].getLetter(), (e + 1));
                    }
                }
                else {
                    error=true;
                    break;
                }
            }
            if(!error)
            {
                mentions.add(jaMencionatsIntroduced);
                mentions.add(jaMencionatsExpected);
            }
        }

        return mentions;
    }
    public void setLetters(Letter[] l)
    {
        if(l.length == 5)
        {
            this.letters = l;
        }
    }
    public List<List<Integer>> lettersInWord(Letter[] lettersExpected, List<Integer> jaMencionatsIntroduced, List<Integer> jaMencionatsExpected)
    {
        for(int e = 0; e < 5; e++)//bucle para comprobar que letras estan contenidas en la palabra esperada pero no se han encontrado en la posicion esperada en el bucle anterior
        {
            //need to see if works well
            if(!jaMencionatsIntroduced.contains(e))
            {
                for(int i = 0; i < 5; i++)
                {
                    if(!jaMencionatsExpected.contains(i))
                    {
                        boolean res = letters[e].sameLetter(lettersExpected[i].getLetter());
                        if(res && !jaMencionatsIntroduced.contains(e))
                        {
                            jaMencionatsIntroduced.add(e);
                            jaMencionatsExpected.add(i);
                            View.letterInWord(letters[e].getLetter());
                        }
                    }
                }
            }
        }
        List<List<Integer>> mentions = new ArrayList<List<Integer>>();
        mentions.add(jaMencionatsIntroduced);
        mentions.add(jaMencionatsExpected);
        return mentions;
    }

    public Letter[] getLetter() {
        return letters;
    }

}
