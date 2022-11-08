package Controler;

import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

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
        Word w=new Word("willy");
        String res=w.getWordString();
        assertEquals(res,"willy");
        w=new Word("notw");
        res=w.getWordString();
        assertEquals(res,"");
        w=new Word("outOfWords");
        res=w.getWordString();
        assertEquals(res,"");
    }
}