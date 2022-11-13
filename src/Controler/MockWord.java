package Controler;

public class MockWord extends Word{

    private String w= "aereo";
    public MockWord() {

    }
    public String getWordString()
    {
        return w;
    }
    public void setWordString(String s)
    {
        this.w = s;
    }
    public boolean printAchivements(Word w)
    {
        System.out.println("Correc");
        return true;
    }
    /*public boolean sameWord(MockWord w)
    {
        if(this.w == this.)
    }*/


}
