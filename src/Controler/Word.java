package Controler;

import View.View;

import java.util.ArrayList;
import java.util.List;

public class Word {
    private Letter[] letters = null;
    public Word(){}
    public Word(String word)
    {
        if(word.length()==5)
        {
            letters=new Letter[5];
            char[] s=word.toCharArray();
            for(int i=0; i<5; i++)
            {
                letters[i]=new Letter(s[i]);
            }
        }
    }
    public void setWord(String word){
        letters = new Letter[word.length()];
        char[] s=word.toCharArray();
        if(!word.isEmpty())
        {
            for(int i = 0; i < word.length(); i++)
            {
                if(s[i] != ' ')
                {
                    letters[i]=new Letter(s[i]);
                }
                else {
                    break;
                }
            }
        }
        else {
            letters = null;
        }
    }
    public String getWordString() //pasa la lista de letras a un String
    {
        String wordString="";
        if(letters != null)
        {
            for(int i=0; i<5; i++)
            {
                if(letters[i] != null)
                {
                    wordString+=letters[i].getLetter();
                }
                else {
                    break;
                }
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
    public List<List<Integer>> printAchivements(Word wordExpected, View view)//printea las coincidencias con la palabra esperada
    {
        Letter[] lettersExpected = wordExpected.getLetter();

        List<List<Integer>> mentions = new ArrayList<List<Integer>>();

        mentions=samePosition(lettersExpected, view);
        mentions=lettersInWord(lettersExpected,mentions.get(0),mentions.get(1), view);
        return mentions;
    }
    public List<List<Integer>> samePosition(Letter[] lettersExpected, View view)
    {
        List<Integer> jaMencionatsIntroduced=new ArrayList<Integer>();
        List<Integer> jaMencionatsExpected=new ArrayList<Integer>();
        List<List<Integer>> mentions = new ArrayList<List<Integer>>();
        boolean error=false;
        if(lettersExpected.length == letters.length)
        {
            for(int e = 0; e < lettersExpected.length; e++)//bucle para comprovar que letras estan en la posicion esperada
            {
                if(lettersExpected[e].getLetter()!=' ')
                {
                    boolean res=letters[e].sameLetter(lettersExpected[e].getLetter());
                    if(res)
                    {
                        jaMencionatsIntroduced.add(e);
                        jaMencionatsExpected.add(e);
                        view.letterInPosition(letters[e].getLetter(), (e + 1));
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
        this.letters = l;
    }
    public List<List<Integer>> lettersInWord(Letter[] lettersExpected, List<Integer> jaMencionatsIntroduced, List<Integer> jaMencionatsExpected, View view)
    {
        if(lettersExpected.length == letters.length)
        {
            for(int e = 0; e < lettersExpected.length; e++)//bucle para comprobar que letras estan contenidas en la palabra esperada pero no se han encontrado en la posicion esperada en el bucle anterior
            {
                //need to see if works well
                if(!jaMencionatsIntroduced.contains(e) && letters[e].getLetter() != ' ')
                {
                    for(int i = 0; i < lettersExpected.length; i++)
                    {
                        if(!jaMencionatsExpected.contains(i) && lettersExpected[i].getLetter() != ' ')
                        {
                            boolean res = letters[e].sameLetter(lettersExpected[i].getLetter());
                            if(res && !jaMencionatsIntroduced.contains(e))
                            {
                                jaMencionatsIntroduced.add(e);
                                jaMencionatsExpected.add(i);
                                view.letterInWord(letters[e].getLetter());
                            }
                        }
                        else if(lettersExpected[i].getLetter() == ' ')
                        {
                            break;
                        }
                    }
                }
                else if(letters[e].getLetter() == ' ')
                {
                    break;
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
