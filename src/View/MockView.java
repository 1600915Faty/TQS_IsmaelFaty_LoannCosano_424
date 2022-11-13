package View;

public class MockView extends View{
    public String namePlayer;
    public String dificult;
    public String word;
    public String readNamePlayer()
    {
        return namePlayer;
    }
    public String readDificult()
    {
        return dificult;
    }

    public String readWord()
    {
        return word;
    }
    public void setNamePlayer(String name)
    {
        this.namePlayer = name;
    }
    public void setDificult(String dificult)
    {
        this.dificult = dificult;
    }
    public void setWord(String word)
    {
        this.word = word;
    }
}
