import Controler.Player;
import View.View;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {


    @Test
    public void nameIntroducedCorrectTest() {
        Player p = new Player();
        boolean res = p.nameIntroducedCorrect("pa u", new View());
        assertEquals(res,false);

    }
}