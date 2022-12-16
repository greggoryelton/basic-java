/**
 * Created by gregelton on 2017-01-24.
 */
public  class  CellPhone {

    private String model;
    private String Manufacturer;
    private int monthsWarranty;
    private float price;




    public CellPhone(){
        model = null;
        Manufacturer = null;
        monthsWarranty = 0;
        price = 0.0f;
    }

    public CellPhone(String m, String man, int mWar, float p){
        model = m;
        Manufacturer = man;
        monthsWarranty = mWar;
        price = p;
    }






    public void setModel(String m) {
        this.model = m;

    }
    public void setManufacturer(String man){
        this.Manufacturer = man;
    }
    public void setMonthsWarranty(int mWar){
        this.monthsWarranty = mWar;
    }
    public void setPrice(float p){
        this.price = p;
    }

    public  String getModel() {return  model;}
    public String getManufacturer() {return Manufacturer;}
    public int getMonthsWarranty() {return monthsWarranty;}
    public float getPrice() {return price;}








}





