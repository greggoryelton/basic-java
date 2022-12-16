/**
 * Created by gregelton on 2017-01-24.
 */
public class PhonePlan  {
    private int minutesAllowed;
    private int minutesUsed;
    private int dataAllowed;
    private int dataUsed;
    private boolean planType;


    public PhonePlan() {
        minutesAllowed = 0;
        minutesUsed = 0;
        dataAllowed = 0;
        planType = false;
        dataUsed = 0;
        dataAllowed= 0;
    }

    public PhonePlan(int m, int dAllowed, boolean pType) {
        dataAllowed = dAllowed;
        minutesAllowed = m;
        planType = pType;


    }


    public void setMinutesAllowed(int m) {
        minutesAllowed = m;
    }

    public void setDataAllowed(int dAllowed) {
        dataAllowed = dAllowed;
    }
    public void setMinutesUsed(int mUsed){
        minutesUsed = mUsed;
    }
    public void setDataUsed(int dUsed){
        dataUsed = dUsed;
    }
    public void setPlanType(boolean p){
        planType = p;
    }

    public  int getMinutesAllowed() {
        return minutesAllowed;
    }

    public int getMinutesUsed() {
        return minutesUsed;
    }

    public int getDataAllowed() {
        return dataAllowed;
    }
    public int getDataUsed() {
        return dataUsed;
    }

    public boolean getPlanType() {
        return planType;
    }


    public int getMinutesRemaining() {
        return (getMinutesAllowed() - getMinutesUsed());
    }

    public int getDataRemaining() {
        return (getDataAllowed() - getDataUsed());
    }

    public String toString() {
        if (getPlanType() == true) {
            return ("Pay-as-you-go Plan with " + getMinutesRemaining() + " minutes and " + getDataRemaining() + "KB" + " remaining");


        } else
            return ("Regular " + "(" + getMinutesAllowed() +  " minute" + ", " + (getDataAllowed()/1000000f + " GB data )" + " Monthy Plan with " +  + getMinutesRemaining() + " and " + getDataRemaining() + "KB" + " remaining"));


    }

}

