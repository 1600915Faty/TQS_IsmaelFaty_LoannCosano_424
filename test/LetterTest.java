import Controler.Letter;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;


class LetterTest {

    @Test
    void sameLetterTest() {
        Letter l = new Letter();
        l.setLetter('a');
        Assertions.assertEquals('a',l.getLetter());
        boolean res = l.sameLetter('a');
        assertEquals(res,true);
        res = l.sameLetter('1');
        assertEquals(res,false);
        res = l.sameLetter('A');
        assertEquals(res,false);
        res = l.sameLetter('à');
        assertEquals(res,false);
        res = l.sameLetter('á');
        assertEquals(res,false);
        res = l.sameLetter('*');
        assertEquals(res,false);
        res = l.sameLetter('*');
        assertEquals(res,false);
    }

    @Test
    void constructorsTest()
    {

    }
}