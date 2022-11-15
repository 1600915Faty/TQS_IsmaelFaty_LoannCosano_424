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
        boolean res = l.sameLetter('a');//vàlid
        assertEquals(res,true);
        res = l.sameLetter('1');//no vàlid
        assertEquals(res,false);
        res = l.sameLetter('A');//no vàlid
        assertEquals(res,false);
        res = l.sameLetter('à');//no vàlid
        assertEquals(res,false);
        res = l.sameLetter('á');//no vàlid
        assertEquals(res,false);
        res = l.sameLetter('*');//no vàlid
        assertEquals(res,false);
        res = l.sameLetter('*');//no vàlid
        assertEquals(res,false);
    }

}