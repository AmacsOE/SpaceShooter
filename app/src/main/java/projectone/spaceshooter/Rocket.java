package projectone.spaceshooter;

public class Rocket {

    private float x;
    private float y;

    private int irany;


    float sebesseg = 350;

    private int width = 8;
    private int height = 16;

    private boolean isActive;


    public Rocket(int irany) {
        this.irany = irany;

        isActive = false;
    }

    public boolean getStatus(){
        return isActive;
    }

    public void setInactive(){
        isActive =false;
    }



    public boolean shoot(int direction){
        if (!isActive){
            isActive = true;
        }
        return false;
    }


}
