package Controler;

import View.View;

import java.io.IOException;

public class Player {
    private String name;
    public int points;
    public Player(){}
    public void register(View view)
    {
    }
    public boolean nameIntroducedCorrect(String introduced, View view)
    {
        return false;
    }
    public void setPoints(int points) {}
    public void setName(String name){}
    public int getPoints() {return 0;}
    public String getName(){return "";}
    public void save() throws IOException {}
}
