package Week_4;

import java.time.LocalDate;
import java.util.ArrayList;

public class CreditCardForm { //1.2.11 Static Initialization Blocks
    private static final ArrayList<Integer> expirationYear = new ArrayList<>();
    static {
        // Add the next twenty years to the array list
        int year = LocalDate.now().getYear();
        for (int i = year; i <= year + 20; i++){
            expirationYear.add(i);
        }
    }

    public ArrayList<Integer> getExpDate(){return expirationYear;}
//...
}

