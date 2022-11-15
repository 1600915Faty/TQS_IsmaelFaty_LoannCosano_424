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
    void getWordStringTest() {
        Word w = new Word("willy");
        String res = w.getWordString();
        assertEquals(res,"willy");
        w = new Word("notw");
        res = w.getWordString();
        assertEquals(res,"");
        w = new Word("outOfWords");
        res = w.getWordString();
        assertEquals(res,"");
    }
    @Test
    void sameWordTest()
    {
        Word w1 = new Word("Wordl");
        Word w2 = new Word("Wordl");
        boolean res = w1.sameWord(w2);
        assertEquals(res,true);
        Word w3 = new Word("lordl");
        res = w1.sameWord(w3);
        assertEquals(res,false);
        Word w4 = new Word("Wordle");
        res = w1.sameWord(w4);
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
        ls[3] = new Letter('d');
        ls[4] = new Letter(' ');
        mentions = w1.samePosition(ls, new View());
        assertEquals(mentions.isEmpty(), true);
        ls[4] = new Letter('l');
        mentions = w1.samePosition(ls, new View());
        assertEquals(mentions.isEmpty(), false);

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


        Word wExpected = new Word();
        List<Integer> jaMencionatsIntroduced=new ArrayList<Integer>();
        List<Integer> jaMencionatsExpected=new ArrayList<Integer>();
        Letter[] ls = new Letter[4];
        ls[0] = new Letter('W');
        ls[1] = new Letter('d');
        ls[2] = new Letter('r');
        ls[3] = new Letter('d');
        Word wIntroduced = new Word("a iou");
        wExpected.setLetters(ls);
        mentions = wIntroduced.lettersInWord(wExpected.getLetter(),jaMencionatsIntroduced,jaMencionatsExpected, new View());
        assertEquals(mentions.get(0).isEmpty(), true);
        assertEquals(mentions.get(1).isEmpty(), true);
        ls = new Letter[5];
        ls[0] = new Letter(' ');
        ls[1] = new Letter('r');
        ls[2] = new Letter('r');
        ls[3] = new Letter('d');
        ls[4] = new Letter('l');
        wExpected.setLetters(ls);
        jaMencionatsIntroduced.removeAll(jaMencionatsIntroduced);
        jaMencionatsExpected.removeAll(jaMencionatsExpected);
        mentions = wIntroduced.lettersInWord(wExpected.getLetter(),jaMencionatsIntroduced,jaMencionatsExpected, new View());
        assertEquals(mentions.get(0).isEmpty(), true);
        assertEquals(mentions.get(1).isEmpty(), true);
        ls[0] = new Letter('a');
        ls[1] = new Letter(' ');
        ls[2] = new Letter('i');
        ls[3] = new Letter('o');
        ls[4] = new Letter('u');
        wExpected.setLetters(ls);
        jaMencionatsIntroduced.removeAll(jaMencionatsIntroduced);
        jaMencionatsExpected.removeAll(jaMencionatsExpected);
        mentions = wIntroduced.lettersInWord(wExpected.getLetter(),jaMencionatsIntroduced,jaMencionatsExpected, new View());
        int resIntroduced = mentions.get(0).get(0);
        assertEquals(resIntroduced , 0);
        int resExpected = mentions.get(1).get(0);
        assertEquals(resExpected, 0);

        ls[0] = new Letter('a');
        ls[1] = new Letter('e');
        ls[2] = new Letter(' ');
        ls[3] = new Letter('o');
        ls[4] = new Letter('u');
        wExpected.setLetters(ls);
        jaMencionatsIntroduced.removeAll(jaMencionatsIntroduced);
        jaMencionatsExpected.removeAll(jaMencionatsExpected);
        mentions = wIntroduced.lettersInWord(wExpected.getLetter(),jaMencionatsIntroduced,jaMencionatsExpected, new View());
        resIntroduced = mentions.get(0).get(0);
        assertEquals(resIntroduced , 0);
        resExpected = mentions.get(1).get(0);
        assertEquals(resExpected, 0);

        ls[0] = new Letter('a');
        ls[1] = new Letter('e');
        ls[2] = new Letter('i');
        ls[3] = new Letter('o');
        ls[4] = new Letter(' ');
        wExpected.setLetters(ls);
        jaMencionatsIntroduced.removeAll(jaMencionatsIntroduced);
        jaMencionatsExpected.removeAll(jaMencionatsExpected);
        mentions = wIntroduced.lettersInWord(wExpected.getLetter(),jaMencionatsIntroduced,jaMencionatsExpected, new View());
        resIntroduced = mentions.get(0).get(0);
        assertEquals(resIntroduced , 0);

        resExpected = mentions.get(1).get(0);
        assertEquals(resExpected, 0);


        ls[0] = new Letter('a');
        ls[1] = new Letter('e');
        ls[2] = new Letter('i');
        ls[3] = new Letter('o');
        ls[4] = new Letter('u');
        wExpected.setLetters(ls);
        jaMencionatsIntroduced.removeAll(jaMencionatsIntroduced);
        jaMencionatsExpected.removeAll(jaMencionatsExpected);
        mentions = wIntroduced.lettersInWord(wExpected.getLetter(),jaMencionatsIntroduced,jaMencionatsExpected, new View());
        resIntroduced = mentions.get(0).get(0);
        assertEquals(resIntroduced , 0);
        resExpected = mentions.get(1).get(0);
        assertEquals(resExpected, 0);


        wIntroduced = new Word("aeiou");
        ls = new Letter[4];
        ls[0] = new Letter('a');
        ls[1] = new Letter('e');
        ls[2] = new Letter('i');
        ls[3] = new Letter('o');

        wExpected.setLetters(ls);
        jaMencionatsIntroduced.removeAll(jaMencionatsIntroduced);
        jaMencionatsExpected.removeAll(jaMencionatsExpected);
        mentions = wIntroduced.lettersInWord(wExpected.getLetter(),jaMencionatsIntroduced,jaMencionatsExpected, new View());
        assertEquals(mentions.get(0).isEmpty(), true);
        assertEquals(mentions.get(1).isEmpty(), true);

        //need to test from here
        wExpected = new Word("aeiou");
        wIntroduced = new Word(" eiou");
        mentions = wIntroduced.lettersInWord(wExpected.getLetter(),jaMencionatsIntroduced,jaMencionatsExpected, new View());
        assertEquals(mentions.get(0).isEmpty(), true);
        assertEquals(mentions.get(1).isEmpty(), true);

        wIntroduced = new Word("a iou");
        mentions = wIntroduced.lettersInWord(wExpected.getLetter(),jaMencionatsIntroduced,jaMencionatsExpected, new View());
        resIntroduced = mentions.get(0).get(0);
        assertEquals(resIntroduced , 0);
        resExpected = mentions.get(1).get(0);
        assertEquals(resExpected, 0);

        wIntroduced = new Word("ae ou");
        mentions = wIntroduced.lettersInWord(wExpected.getLetter(),jaMencionatsIntroduced,jaMencionatsExpected, new View());
        resIntroduced = mentions.get(0).get(0);
        assertEquals(resIntroduced , 0);
        resIntroduced = mentions.get(0).get(1);
        assertEquals(resIntroduced , 1);
        resExpected = mentions.get(1).get(0);
        assertEquals(resExpected, 0);
        resExpected = mentions.get(1).get(1);
        assertEquals(resExpected, 1);

        wIntroduced = new Word("aei u");
        mentions = wIntroduced.lettersInWord(wExpected.getLetter(),jaMencionatsIntroduced,jaMencionatsExpected, new View());
        resIntroduced = mentions.get(0).get(0);
        assertEquals(resIntroduced , 0);
        resIntroduced = mentions.get(0).get(1);
        assertEquals(resIntroduced , 1);
        resIntroduced = mentions.get(0).get(2);
        assertEquals(resIntroduced , 2);
        resExpected = mentions.get(1).get(0);
        assertEquals(resExpected, 0);
        resExpected = mentions.get(1).get(1);
        assertEquals(resExpected, 1);
        resExpected = mentions.get(1).get(2);
        assertEquals(resExpected, 2);


        wIntroduced = new Word("aeio ");
        mentions = wIntroduced.lettersInWord(wExpected.getLetter(),jaMencionatsIntroduced,jaMencionatsExpected, new View());
        resIntroduced = mentions.get(0).get(0);
        assertEquals(resIntroduced , 0);
        resIntroduced = mentions.get(0).get(1);
        assertEquals(resIntroduced , 1);
        resIntroduced = mentions.get(0).get(2);
        assertEquals(resIntroduced , 2);
        resIntroduced = mentions.get(0).get(3);
        assertEquals(resIntroduced , 3);
        resExpected = mentions.get(1).get(0);
        assertEquals(resExpected, 0);
        resExpected = mentions.get(1).get(1);
        assertEquals(resExpected, 1);
        resExpected = mentions.get(1).get(2);
        assertEquals(resExpected, 2);
        resExpected = mentions.get(1).get(3);
        assertEquals(resExpected, 3);


        wIntroduced = new Word("aeiou");
        mentions = wIntroduced.lettersInWord(wExpected.getLetter(),jaMencionatsIntroduced,jaMencionatsExpected, new View());
        resIntroduced = mentions.get(0).get(0);
        assertEquals(resIntroduced , 0);
        resIntroduced = mentions.get(0).get(1);
        assertEquals(resIntroduced , 1);
        resIntroduced = mentions.get(0).get(2);
        assertEquals(resIntroduced , 2);
        resIntroduced = mentions.get(0).get(3);
        assertEquals(resIntroduced , 3);
        resIntroduced = mentions.get(0).get(4);
        assertEquals(resIntroduced , 4);
        resExpected = mentions.get(1).get(0);
        assertEquals(resExpected, 0);
        resExpected = mentions.get(1).get(1);
        assertEquals(resExpected, 1);
        resExpected = mentions.get(1).get(2);
        assertEquals(resExpected, 2);
        resExpected = mentions.get(1).get(3);
        assertEquals(resExpected, 3);
        resExpected = mentions.get(1).get(4);
        assertEquals(resExpected, 4);

    }

    @Test
    void setWordTest()
    {
        Word w = new Word();
        w.setWord("");
        String str = w.getWordString();
        assertEquals(str, "");
        w.setWord(" eiou");
        str = w.getWordString();
        assertEquals(str, "");
        w.setWord("a iou");
        str = w.getWordString();
        assertEquals(str, "a");
        w.setWord("ae ou");
        str = w.getWordString();
        assertEquals(str, "ae");
        w.setWord("aei u");
        str = w.getWordString();
        assertEquals(str, "aei");
        w.setWord("aeio ");
        str = w.getWordString();
        assertEquals(str, "aeio");
        w.setWord("aeiou");
        str = w.getWordString();
        assertEquals(str, "aeiou");
    }

    @Test
    void pairWiseTesting()
    {
        Word wExpected = new Word();
        wExpected.setWord("pot");
        Word wIntroduced = new Word();//1
        wIntroduced.setWord("set");
        List<List<Integer>> mentions = new ArrayList<List<Integer>>();
        mentions = wIntroduced.printAchivements(wExpected, new View());
        List<Integer> mentionsIntroduced = mentions.get(0);
        List<Integer> mentionsExpected = mentions.get(1);
        List<Integer> resultsExpected = Arrays.asList(2);
        assertEquals(mentionsIntroduced,resultsExpected);
        resultsExpected = Arrays.asList(2);
        assertEquals(mentionsExpected, resultsExpected);

        wIntroduced.setWord("son");//2
        mentions = wIntroduced.printAchivements(wExpected, new View());
        mentionsIntroduced = mentions.get(0);
        mentionsExpected = mentions.get(1);
        resultsExpected = Arrays.asList(1);
        assertEquals(mentionsIntroduced,resultsExpected);
        resultsExpected = Arrays.asList(1);
        assertEquals(mentionsExpected, resultsExpected);

        wIntroduced.setWord("eto");//3
        mentions = wIntroduced.printAchivements(wExpected, new View());
        mentionsIntroduced = mentions.get(0);
        mentionsExpected = mentions.get(1);
        resultsExpected = Arrays.asList(1,2);
        assertEquals(mentionsIntroduced,resultsExpected);
        resultsExpected = Arrays.asList(2,1);
        assertEquals(mentionsExpected, resultsExpected);

        wIntroduced.setWord("tep");//4
        mentions = wIntroduced.printAchivements(wExpected, new View());
        mentionsIntroduced = mentions.get(0);
        mentionsExpected = mentions.get(1);
        resultsExpected = Arrays.asList(0,2);
        assertEquals(mentionsIntroduced,resultsExpected);
        resultsExpected = Arrays.asList(2,0);
        assertEquals(mentionsExpected, resultsExpected);

        wIntroduced.setWord("pot");//5
        mentions = wIntroduced.printAchivements(wExpected, new View());
        mentionsIntroduced = mentions.get(0);
        mentionsExpected = mentions.get(1);
        resultsExpected = Arrays.asList(0,1,2);
        assertEquals(mentionsIntroduced,resultsExpected);
        resultsExpected = Arrays.asList(0,1,2);
        assertEquals(mentionsExpected, resultsExpected);

        wIntroduced.setWord("ots");//6
        mentions = wIntroduced.printAchivements(wExpected, new View());
        mentionsIntroduced = mentions.get(0);
        mentionsExpected = mentions.get(1);
        resultsExpected = Arrays.asList(0,1);
        assertEquals(mentionsIntroduced,resultsExpected);
        resultsExpected = Arrays.asList(1,2);
        assertEquals(mentionsExpected, resultsExpected);

        wIntroduced.setWord("per");//7
        mentions = wIntroduced.printAchivements(wExpected, new View());
        mentionsIntroduced = mentions.get(0);
        mentionsExpected = mentions.get(1);
        resultsExpected = Arrays.asList(0);
        assertEquals(mentionsIntroduced,resultsExpected);
        resultsExpected = Arrays.asList(0);
        assertEquals(mentionsExpected, resultsExpected);

        wIntroduced.setWord("pot");//8
        mentions = wIntroduced.printAchivements(wExpected, new View());
        mentionsIntroduced = mentions.get(0);
        mentionsExpected = mentions.get(1);
        resultsExpected = Arrays.asList(0,1,2);
        assertEquals(mentionsIntroduced,resultsExpected);
        resultsExpected = Arrays.asList(0,1,2);
        assertEquals(mentionsExpected, resultsExpected);

        wIntroduced.setWord("pot");//9
        mentions = wIntroduced.printAchivements(wExpected, new View());
        mentionsIntroduced = mentions.get(0);
        mentionsExpected = mentions.get(1);
        resultsExpected = Arrays.asList(0,1,2);
        assertEquals(mentionsIntroduced,resultsExpected);
        resultsExpected = Arrays.asList(0,1,2);
        assertEquals(mentionsExpected, resultsExpected);


    }
}