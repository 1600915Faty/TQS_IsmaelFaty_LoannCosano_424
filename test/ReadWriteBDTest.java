import Controler.MockPlayer;
import Model.ReadWriteBD;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.*;

class ReadWriteBDTest {

    @Test
    void savePlayer() throws IOException {
        PrintWriter pw = new PrintWriter("src/Model/RankingTest1");
        pw.close();
        BufferedWriter writer = new BufferedWriter(new FileWriter("src/Model/RankingTest1", true));
        writer.write("theBest 16");
        writer.newLine();
        writer.write("IA 10");
        writer.newLine();
        writer.write("elPelos 6");
        writer.newLine();
        writer.write("hacker 4");
        writer.newLine();
        writer.write("paco13 3");
        writer.newLine();
        writer.write("arono 2");
        writer.newLine();
        writer.close();
        MockPlayer p = new MockPlayer();
        ReadWriteBD.savePlayer(p, "src/Model/RankingTest1");
        p.setPoints(0);
        p.setName("Joel");
        ReadWriteBD.savePlayer(p, "src/Model/RankingTest1");
        Path filePath1 = Path.of("src/Model/RankingTest1");
        Path filePath2 = Path.of("src/Model/RankingTest2");
        long mismatch = Files.mismatch(filePath1, filePath2);
        assertEquals(mismatch,-1);
    }
}