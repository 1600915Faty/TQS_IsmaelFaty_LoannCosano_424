import Controler.Game;
import Controler.MockPlayer;
import Controler.MockWord;
import View.MockView;
import View.View;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class GameTest {
    @Test
    void checkWordTest() throws IOException {
        MockWord m1 = new MockWord();
        MockWord m2 = new MockWord();
        Game g=new Game(new View());
        MockPlayer player1 = new MockPlayer();
        boolean res = g.getCheckWord(m1,m2, player1);
        assertEquals(res,true);
        /*m2.setWordString("eeeee");
        res = g.getCheckWord(m1,m2);
        assertEquals(res,false);*/
    }
    @Test
    void goodIntroductionTest()
    {
        Game g = new Game(new View());
        boolean res = g.goodIntroduction("longword");//Path2
        assertEquals(res,false);
        res = g.goodIntroduction("shor");//Path2
        assertEquals(res,false);
        res = g.goodIntroduction(" sp*c");//Path1
        assertEquals(res,false);
        res = g.goodIntroduction(" se s");//Path1
        assertEquals(res,false);
        res = g.goodIntroduction("*1234");//Path1
        assertEquals(res,false);
        res = g.goodIntroduction("aereo");//Path3
        assertEquals(res,true);
    }
    @Test
    void introductionDificultCorrectTest()
    {
        Game g = new Game(new View());
        boolean res = g.introductionDificultCorrect("");//Path1
        assertEquals(res,false);
        res = g.introductionDificultCorrect("1");//Path2
        assertEquals(res,true);
        res = g.introductionDificultCorrect("2");//Path2
        assertEquals(res,true);
        res = g.introductionDificultCorrect("3");//Path2
        assertEquals(res,true);
    }

    @Test
    void dificultTest() throws IOException {
        MockView mv = new MockView();
        mv.setDificult("1");
        Game g = new Game(mv);
        g.dificult();
        mv.setDificult("2");
        g.setView(mv);
        g.dificult();
        mv.setDificult("3");
        g.setView(mv);
        g.dificult();
    }

    @Test
    void introduceWordTest()
    {
        MockView mv = new MockView();
        mv.setWord("aereo");
        Game g = new Game(mv);
        g.introduceWord();
    }

    @Test
    void playTest() throws IOException {
        MockView mv1 = new MockView();
        mv1.setNamePlayer("Emilio");
        mv1.setDificult("1");
        mv1.setWord("aereo");
        Game g1 = new Game(mv1);
        g1.play();
        MockView mv2 = new MockView();
        mv2.setWord("eeeee");
        mv2.setNamePlayer("Ahmed");
        mv2.setDificult("1");
        Game g2 = new Game(mv2);
        g2.play();
    }
}