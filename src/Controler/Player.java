package Controler;

import Model.ReadWriteBD;
import View.View;

import java.io.*;

public class Player
{
    private String name;
    public int points;
    public Player(){}
    public void register(View view)
    {
        view.introductionRegisterPlayer();
        String introduced = "";
        boolean correct = false;
        while(!correct)
        {
            introduced= view.readNamePlayer();
            correct = nameIntroducedCorrect(introduced, view);
        }
        this.name = introduced;
    }
    public boolean nameIntroducedCorrect(String introduced, View view)
    {
        if(introduced.equals("") || !introduced.equals(introduced.replaceAll(" ", "")))//word empty or with spaces
        {
            view.emptyName();
            return false;
        }
        else
        {
            return true;
        }
    }
    public void setPoints(int points)
    {
        this.points = points;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getPoints()
    {
        return this.points;
    }
    public String getName()
    {
        return this.name;
    }
    public void save() throws IOException {
        ReadWriteBD.savePlayer(this, "src/Model/Ranking");
    }
}
