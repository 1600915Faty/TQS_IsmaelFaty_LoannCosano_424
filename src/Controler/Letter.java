package Controler;

public class Letter {
    private char letter;
    public Letter() {}
    public Letter(char c)
    {
        this.letter=c;
    }

    public boolean sameLetter(char letter)
    {
        if(letter==this.letter)
        {
            return true;
        }
        return false;
    }

    public char getLetter() {
        return letter;
    }

    public void setLetter(char letter) {
        this.letter = letter;
    }
}
