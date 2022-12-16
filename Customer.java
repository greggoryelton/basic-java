import javafx.scene.control.Cell;

/**
 * Created by gregelton on 2017-01-28.
 */
public class Customer extends PhonePlan {

    String name;
    int callsMade;
    float balance = 0.0f;
    float overCharge;
    float overDataCharge;
    PhonePlan phonePlan = new PhonePlan();
    CellPhone cellModel = new CellPhone();



    public Customer(String n, CellPhone model, PhonePlan plan) {

        name = n;
        cellModel  = model;
        phonePlan  = plan;


    }

    public Customer() {
        if (phonePlan.getPlanType()) {
            balance = 0.40f * phonePlan.getMinutesAllowed();


        } else
            balance = 0.0f;


    }

    public void phone(Customer c, int cLen){
       if (phonePlan.getPlanType() == true || c.phonePlan.getPlanType() == true){
           if (phonePlan.getMinutesRemaining() < cLen || c.phonePlan.getMinutesRemaining() < cLen){

           }
           else {
               phonePlan.setMinutesUsed((cLen + phonePlan.getMinutesUsed()));
               setCallsMade(getCallsMade()+1);
               c.phonePlan.setMinutesUsed((cLen + c.phonePlan.getMinutesUsed()));
               c.setCallsMade(c.getCallsMade()+1);
           }



       }

       else {
           phonePlan.setMinutesUsed(cLen + phonePlan.getMinutesUsed());
           setCallsMade(getCallsMade()+1);
           if (phonePlan.getMinutesUsed()> phonePlan.getMinutesAllowed()){
               overCharge = (phonePlan.getMinutesUsed() - phonePlan.getMinutesAllowed()) *0.15f;

           }
           c.phonePlan.setMinutesUsed(cLen + c.phonePlan.getMinutesUsed());
           c.setCallsMade(c.getCallsMade()+1);
       }





    }

    public void buyMinutes(int numMin){
        if (phonePlan.getPlanType() == true ){
            balance = balance + (numMin * 0.4f);
            phonePlan.setMinutesAllowed(getMinutesAllowed() + numMin);
        }



    }
    public void accessInternet(int dUse) {
        if (phonePlan.getPlanType() == false);
            phonePlan.setDataUsed(dUse + phonePlan.getDataUsed());
            if(phonePlan.getDataUsed() > phonePlan.getDataRemaining()){
                overDataCharge += (phonePlan.getDataAllowed() - phonePlan.getDataUsed()*0.00005f);
            }

        else {
            if (phonePlan.getDataRemaining()>dUse){
                phonePlan.setDataUsed(dUse + phonePlan.getDataUsed());

            }
            else{
                phonePlan.setDataUsed(phonePlan.getDataRemaining()+ phonePlan.getDataUsed());

            }




        }

    }
    public void printMonthlyStatement() {
        if (phonePlan.getPlanType() == true) {
            System.out.println("\nName: " + getName());
            System.out.println("Plan Type: Pay-as-you-go");
            System.out.println("Minutes Used: " + phonePlan.getMinutesUsed());
            System.out.println("Minutes Remaining: "+ phonePlan.getMinutesRemaining());
            System.out.println("Data Used: " + phonePlan.getDataUsed());
            System.out.println("Data Remaining: " + phonePlan.getDataRemaining());
            System.out.println("Calls Made: " + getCallsMade());
            System.out.println("Monthly Charges: $" + balance);
            System.out.println("HST: "+ (balance * 0.13f));
            System.out.println("Total Due: " + (balance *1.13f));
        }
        else if(phonePlan.getPlanType() == false){
            if (phonePlan.getMinutesAllowed() ==100) {
                if (phonePlan.getMinutesUsed() > 100) {
                    System.out.println("\nName: " + getName());
                    System.out.println("Plan Type: Regular Monthly " + "(100 minutes" + ", " + (phonePlan.getDataAllowed() / 1000000f) + "GB data)");
                    System.out.println("Minutes Used: " + phonePlan.getMinutesUsed());
                    System.out.println("Data Used: " + phonePlan.getDataUsed());
                    System.out.println("Calls Made: " + getCallsMade());
                    System.out.println("Monthly Charges: " + (15.00f + (phonePlan.getDataAllowed() / 1000000f) * 10f));
                    System.out.println("Voice Overtime Charges: " + ((phonePlan.getMinutesUsed() - 100f) * 0.15f));
                    System.out.println("Data Overusage Charges: 0");
                    System.out.println("HST: " + (15.00f + ((phonePlan.getDataAllowed() / 1000000f) * 10f)) * 0.13f);
                    System.out.println("Total Due: " + ((15.00f + ((phonePlan.getDataAllowed() / 1000000f) + (phonePlan.getMinutesUsed() - phonePlan.getDataAllowed()) * 0.00005) * 10)) * 1.13);

                } else if (phonePlan.getMinutesUsed() > 100 && phonePlan.getDataUsed() > phonePlan.getDataAllowed()) {
                    System.out.println("\nName: " + getName());
                    System.out.println("Plan Type: Regular Monthly " + "(100 minutes" + ", " + (phonePlan.getDataAllowed() / 1000000f) + "GB data)");
                    System.out.println("Minutes Used: " + phonePlan.getMinutesUsed());
                    System.out.println("Data Used: " + phonePlan.getDataUsed());
                    System.out.println("Calls Made: " + getCallsMade());
                    System.out.println("Monthly Charges: " + (15.00f + (phonePlan.getDataAllowed() / 1000000f) * 10f));
                    System.out.println("Voice Overtime Charges: " + ((phonePlan.getMinutesUsed() - 100f) * 0.15f));
                    System.out.println("Data Overusage Chargers: " + ((phonePlan.getDataUsed() - phonePlan.getDataAllowed()) * 0.00005));
                    System.out.println("HST: " + (((15.00f + ((phonePlan.getDataAllowed() / 1000000f) * 10f) + phonePlan.getMinutesUsed() - 100f) * 0.15f) + ((phonePlan.getDataUsed()) - phonePlan.getDataAllowed()) * 0.00005) * 0.13f);
                    System.out.println("Total Due: " + (((15.00f + ((phonePlan.getDataAllowed() / 1000000f) * 10f) + phonePlan.getMinutesUsed() - 100f) * 0.15f) + ((phonePlan.getDataUsed()) - phonePlan.getDataAllowed()) * 0.00005) * 1.13f);

                } else {
                    System.out.println("\nName: " + getName());
                    System.out.println("Plan Type: Regular Monthly (200 minutes, " + (phonePlan.getDataAllowed() / 1000000f) + "GB Data");
                    System.out.println("Minutes Used: " + phonePlan.getMinutesUsed());
                    System.out.println("Data Used: " + phonePlan.getDataUsed());
                    System.out.println("Calls Made: " + getCallsMade());
                    System.out.println("Monthly Charges: " + (25.00f + ((phonePlan.getDataAllowed() / 1000000f) * 0.15f)));
                    System.out.println("Voice Overtime Charges: " + ((phonePlan.getMinutesUsed() - 100f) * 0.15f));
                    System.out.println("Data Overusage Charges: 0");
                    System.out.println("HST: " + ((25.00f + (phonePlan.getDataAllowed() / 1000000f) * 10f) * 0.13f));
                    System.out.println("Total Due: " + ((25.00f + ((phonePlan.getDataAllowed() / 1000000f) + (phonePlan.getMinutesUsed() - 100f) * 0.15f) * 10f)) * 1.13);


                }
            }
                else if (phonePlan.getDataUsed()>phonePlan.getDataAllowed()){
                System.out.println("\nName: " + getName());
                System.out.println("Plan Type: Regular Monthly (100 minutes, " + (phonePlan.getDataAllowed() / 1000000f) + "GB Data");
                System.out.println("Minutes Used: " + phonePlan.getMinutesUsed());
                System.out.println("Data Used: " + phonePlan.getDataUsed());
                System.out.println("Calls Made: " + getCallsMade());
                System.out.println("Monthly Charges: " + (25.00f + ((phonePlan.getDataAllowed()/1000000f)*10)));
                System.out.println("Voice Overtime Charge: 0");
                System.out.println("Data Overusage Charge: " +((phonePlan.getDataUsed()-phonePlan.getDataAllowed())*0.00005));
                System.out.println("HST:  " + ((25.00f + ((phonePlan.getDataAllowed()/1000000f)+(phonePlan.getDataUsed() - phonePlan.getDataAllowed()) * 0.00005)*10))*0.13);
                System.out.println("Total Due:  " + ((25.00f + ((phonePlan.getDataAllowed()/1000000f)+(phonePlan.getDataUsed() - phonePlan.getDataAllowed()) * 0.00005)*10))*1.13);


                }

                else if ((phonePlan.getMinutesUsed()>100) && (phonePlan.getDataUsed()>phonePlan.getDataAllowed())){
                System.out.println("\nName: " + getName());
                System.out.println("Plan Type: Regular Monthly " + "(100 minutes" + ", " + (phonePlan.getDataAllowed() / 1000000f) + "GB data)");
                System.out.println("Minutes Used: " + phonePlan.getMinutesUsed());
                System.out.println("Data Used: " + phonePlan.getDataUsed());
                System.out.println("Calls Made: " + getCallsMade());
                System.out.println("Monthly Charges: " + (25.00f +((phonePlan.getDataAllowed()/1000000f)*10f)));
                System.out.println("Voice Overtime Charge: " + ((phonePlan.getMinutesUsed()-100f)*0.15f));
                System.out.println("Data Overusage Charge: "+ ((phonePlan.getDataUsed()- phonePlan.getDataAllowed())*0.00005));
                System.out.println("HST: " + (((25.00f +((phonePlan.getDataAllowed()/1000000f)*10f)+(phonePlan.getMinutesUsed()-100f)*0.15f)+ (phonePlan.getDataUsed() - phonePlan.getDataAllowed())*0.00005)*0.13f));





            }
            else {
                System.out.println("\nName: " + getName());
                System.out.println("Plan Type: Regular Monthly (200 minutes, " + (phonePlan.getDataAllowed() / 1000000f) + "GB Data");
                System.out.println("Minutes Used: " + phonePlan.getMinutesUsed());
                System.out.println("Data Used: " + phonePlan.getDataUsed());
                System.out.println("Calls Made: " + getCallsMade());
                System.out.println("Monthly Charges: " + (25.00f + ((phonePlan.getDataAllowed()/1000000f)*10f)));
                System.out.println("Voice Ovetime Charge: 0");
                System.out.println("Data Overusage Charge: 0");
                System.out.println("HST: " + ((25.00f + ((phonePlan.getDataAllowed()/1000000f)*10f)*0.13))) ;
                System.out.println("Total Due: " + ((25.00f + ((phonePlan.getDataAllowed()/1000000f)*10f)*1.13))) ;
            }
            }

        }
    public String getName() {
        return name;
    }

    public void setName(String n) {
        this.name = n;

    }
    public void setCallsMade(int cMade){
        this.callsMade = cMade;
    }
    public int getCallsMade() {
        return callsMade;
    }
    public PhonePlan getPlan(){
        return phonePlan;
    }
    public CellPhone getCellPhone() {
        return cellModel;
    }
    public float getBalance(){
        return balance;
    }
    public float getOverCharge(){
        return overCharge;
    }
    public float getOverDataCharge(){
        return overDataCharge;
    }
    public void setCellModel(CellPhone c) {
        cellModel = c;
    }
    public void setBalance(float bal){
        balance = bal;
    }
    public void setOverCharge(float ovMin){
        overCharge = ovMin;


    }
    public void setOverDataCharge(float ovDat){
        overDataCharge = ovDat;
    }


    public String toString() {
        String planSettings = null;
        if (phonePlan.getPlanType() == true) {
            planSettings = (getName() + " with a " + cellModel.getManufacturer() + " " + cellModel.getModel() + " on a Pay-as-you-go Plan with " + phonePlan.getMinutesRemaining() + " and " + phonePlan.getDataRemaining() + "KB remaining");

        } else if (phonePlan.getPlanType() == false) {
            planSettings = (getName() + " with a " + cellModel.getManufacturer() + " " + cellModel.getModel() + " on a Regular " + "(" + phonePlan.getMinutesAllowed() + ", " + (phonePlan.getDataAllowed()/1000000f) + "GB data)" + " Monthy plan with " + phonePlan.getMinutesRemaining() + " minutes remaining and " + phonePlan.getDataRemaining() + "KB remaining");


        }
        return planSettings;


    }
}