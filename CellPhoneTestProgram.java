/**
 * Created by gregelton on 2017-01-24.
 */
public class CellPhoneTestProgram {


    public static void main(String[] args) {
        CellPhone iPhone, galaxy, priv;

        iPhone = new CellPhone("iPhone 6 Plus", "Apple", 12, 915.00f);
        galaxy = new CellPhone("Galaxy S7", "Samsung", 18, 900.00f);
        priv = new CellPhone("PRIV", "BlackBerry", 24, 890.00f);


        System.out.println("\nHere is the Apple phone information: ");
        System.out.println(iPhone.getModel());
        System.out.println(iPhone.getManufacturer());
        System.out.println(iPhone.getMonthsWarranty());
        System.out.println(iPhone.getPrice());


        System.out.println("\nHere is the Samsung phone information: ");
        System.out.println(galaxy.getModel());
        System.out.println(galaxy.getManufacturer());
        System.out.println(galaxy.getMonthsWarranty());
        System.out.println(galaxy.getPrice());


        System.out.println("\nHere is the BlackBerry phone information: ");
        System.out.println(priv.getModel());
        System.out.println(priv.getManufacturer());
        System.out.println(priv.getMonthsWarranty());
        System.out.println(priv.getPrice());

        iPhone.setModel("iPhone SE");
        iPhone.setPrice(595f);

        System.out.println("\nHere is the Apple phone's new information: ");
        System.out.println(iPhone.getModel());
        System.out.println(iPhone.getManufacturer());
        System.out.println(iPhone.getMonthsWarranty());
        System.out.println(iPhone.getPrice());

        System.out.println("\nThe total cost of all phones is $" + (iPhone.getPrice() + priv.getPrice() + galaxy.getPrice()));

        if (iPhone.getMonthsWarranty() > priv.getMonthsWarranty() && iPhone.getMonthsWarranty() > galaxy.getMonthsWarranty())
            System.out.println("The Apple phone has the longest warranty.");

        else if (galaxy.getMonthsWarranty() > priv.getMonthsWarranty() && galaxy.getMonthsWarranty() > iPhone.getMonthsWarranty())
            System.out.println("The Samsung phone has the longest warranty.");

        else if (priv.getMonthsWarranty() > iPhone.getMonthsWarranty() && priv.getMonthsWarranty() > galaxy.getMonthsWarranty())
            System.out.println("The BlackBerry has the longest warranty.");

    }
}


