import Controler.Letter;
import Controler.Word;
import View.View;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

class WordTest {
    @Test
    void correctLettersTest()
    {
        Letter[] letters=new Letter[5];
        letters[0]=new Letter('e');
        letters[1]=new Letter('r');
        letters[2]=new Letter('t');
        letters[3]=new Letter('y');
        letters[4]=new Letter('u');
        Word w=new Word("ertyu");
        Letter[] l=w.getLetter();
        assertEquals(l[0].getLetter(),letters[0].getLetter());
        assertEquals(l[1].getLetter(),letters[1].getLetter());
        assertEquals(l[2].getLetter(),letters[2].getLetter());
        assertEquals(l[3].getLetter(),letters[3].getLetter());
        assertEquals(l[4].getLetter(),letters[4].getLetter());

    }
    @Test
    void getWordStringTest() {
        Word w = new Word("willy");
        String res = w.getWordString();
        assertEquals(res,"willy");
        w = new Word("notw");
        res=w.getWordString();
        assertEquals(res,"");
        w=new Word("outOfWords");
        res=w.getWordString();
        assertEquals(res,"");
    }
    @Test
    void sameWordTest()
    {
        Word w1=new Word("Wordl");
        Word w2=new Word("Wordl");
        boolean res=w1.sameWord(w2);
        assertEquals(res,true);
        Word w3=new Word("lordl");
        res=w1.sameWord(w3);
        assertEquals(res,false);
        Word w4=new Word("Wordle");
        res=w1.sameWord(w4);
        assertEquals(res,false);
    }
    @Test
    void samePositionTest()
    {
        Word w1 = new Word("Wordl");
        Letter[] ls = new Letter[4];
        ls[0] = new Letter('W');
        ls[1] = new Letter('o');
        ls[2] = new Letter('r');
        ls[3] = new Letter('d');
        List<List<Integer>> mentions = new ArrayList<List<Integer>>();
        mentions = w1.samePosition(ls, new View());
        assertEquals(true, mentions.isEmpty());
        ls=new Letter[5];
        ls[0] = new Letter('W');
        ls[1] = new Letter(' ');
        ls[2] = new Letter('r');
        ls[3] = new Letter('d');
        ls[4] = new Letter('l');
        mentions = w1.samePosition(ls, new View());
        assertEquals(mentions.isEmpty(), true);
        ls[1] = new Letter('o');
        ls[2] = new Letter(' ');
        mentions = w1.samePosition(ls, new View());
        assertEquals(mentions.isEmpty(), true);

        ls[2] = new Letter('r');
        ls[3] = new Letter(' ');
        mentions = w1.samePosition(ls, new View());
        assertEquals(mentions.isEmpty(), true);
    }

    @Test
    void letterInWordTest()
    {
        Word w1 = new Word("Wordl");
        Word w2 = new Word("ldtoW");
        List<List<Integer>> mentions = new ArrayList<List<Integer>>();
        mentions = w1.samePosition(w2.getLetter(), new View());
        mentions = w1.lettersInWord(w2.getLetter(), mentions.get(0), mentions.get(1), new View());
        List<Integer> l1 = mentions.get(0);
        List<Integer> l2 = mentions.get(1);
        List<Integer> l3 = Arrays.asList(0,1,3,4);
        assertEquals(l1,l3);
        l3 = Arrays.asList(4,3,1,0);
        assertEquals(l2,l3);
    }

    @Test
    void printAchivementsTest()
    {
        Word w1 = new Word("wordl");
        Word w2 = new Word("ppppp");
        boolean res = w1.printAchivements(w2, new View());
        assertEquals(res,false);
        Word w3 = new Word("wordl");
        res = w1.printAchivements(w3, new View());
        assertEquals(res, true);
    }

    @Test
    void setLetterTest()
    {
        Word w1 = new Word();
        Letter[] ls1 = new Letter[5];
        w1.setLetters(ls1);
        assertTrue(w1.getLetter()!=null);
        Letter[] ls2 = new Letter[3];
        w1.setLetters(ls2);
        assertTrue(w1.getLetter() ==null);
    }
}