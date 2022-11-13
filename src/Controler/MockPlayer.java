package Controler;

public class MockPlayer extends Player{
    private int points=5;
    private String name = "Pol";
    public void setPoints(int points)
    {
        this.points=points;
    }
    public void register() {

    }
    public int getPoints()
    {
        return this.points;
    }
    public String getName()
    {
        return this.name;
    }
    public void setName(String name) {
        this.name= name;
    }
}
