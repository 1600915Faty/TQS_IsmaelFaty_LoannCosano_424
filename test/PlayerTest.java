import Controler.Player;
import View.View;
import View.MockView;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PlayerTest {

    @Test
    public void nameIntroducedCorrectTest() {
        Player p = new Player();
        boolean res = p.nameIntroducedCorrect("pa u", new View());//incorrect
        assertEquals(res,false);
        res = p.nameIntroducedCorrect("", new View());//incorrect
        assertEquals(res,false);
        res = p.nameIntroducedCorrect("pau", new View());//correct
        assertEquals(res,true);
    }
    @Test
    public void registerTest()
    {
        MockView mv = new MockView();
        mv.setNamePlayer("Loann");
        Player p = new Player();
        p.register(mv);
    }

}
