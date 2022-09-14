package Week_4;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Random;


public class secondaryApp {
    public static void main(String[] args) {
        /**
         * Week4 Task 1.2.1 to 1.2.10
         */
        //1.2.1 Function (Procedure)
        //1.2.2 Object (Class instance)
        //1.2.6 Object Construction (new keyword)
        Person Ehsan = new Person("Ehsan", LocalDate.of(1986, 1, 12), 1, "125463");
        Person Naris = new Person("Naris", LocalDate.of(2003, 4, 12), 3, "187946");
        Person noName = new Person();
        ArrayList<Person> personList = new ArrayList<Person>();
        personList.add(Ehsan);
        personList.add(Naris);
        personList.add(noName);
        System.out.println("---------------------------Week4 Task 1.2.1 until 1.2.10--------------------------------");
        System.out.printf("%-17s %-20s %-12s %-15s %-10s %n", "Name", "DOB (YYYY/MM/DD)", "Age", "Blood Type", "ID Number");
        for(int i = 0 ; i < personList.size() ; i++){
            System.out.printf("%d) %-14s %-20s %-12s %-15s %-10s %n", i+1,
                    personList.get(i).getName(),
                    personList.get(i).getBirthDate().toString(),
                    personList.get(i).getAge(),
                    personList.get(i).getBloodType(),
                    personList.get(i).getID_Number());
        }
        System.out.println("----------------------------------------------------------------------------------------");

        /**
         * Week4 Task 1.2.11
         */
        System.out.println("\n--------------------------------Week4 Task 1.2.11-------------------------------------");
        CreditCardForm card = new CreditCardForm();
        System.out.printf("Hi Naris, your credit card has been issue on " + LocalDate.now()); //1.2.13 Factory Methods
        System.out.println("\nYou will be able to use your card until " + LocalDate.now().plusYears(card.getExpDate().size() - 1));
        System.out.println("This is all the years that you will be able to use your card:\n" + card.getExpDate());
        System.out.println("----------------------------------------------------------------------------------------");

        /**
         * Week4 Task 1.2.12
         */
        System.out.println("\n--------------------------------Week4 Task 1.2.12-------------------------------------");
        Random gen = new Random();
        int dieToss = RandomNumbers.nextInt(gen, 1, 6);
        System.out.println("A random number is: " + dieToss);
        System.out.println("----------------------------------------------------------------------------------------");

        /**
         * Week4 Task 1.2.15.1 Static Nested Classes
         */
        System.out.println("\n--------------------Week4 Task 1.2.15.1 Static Nested Classes-------------------------");
        Invoice myInvoice = new Invoice();
        Invoice.Item Rice = new Invoice.Item("Rice", 100, 50);
        Invoice.Item Apple = new Invoice.Item("Apple", 120, 10);
        Invoice.Item Fish = new Invoice.Item("Fish", 180, 40);
        Invoice.Item newItem = new Invoice.Item("Blackwell Toaster", 2, 19.95);
        myInvoice.add(Rice);
        myInvoice.add(Apple);
        myInvoice.add(Fish);
        myInvoice.add(newItem);

        System.out.printf("%-23s %-15s %-17s %-17s %n", "Description", "Quantity", "Price per unit", "Net Price");
        for(int i = 0 ; i < myInvoice.getItems().size() ; i++){
            System.out.printf("%d) %-20s %-15s %-17s %-17s %n", i+1,
                    myInvoice.getItems().get(i).getDescription(),
                    myInvoice.getItems().get(i).getQuantity(),
                    myInvoice.getItems().get(i).getUnitPrice(),
                    myInvoice.getItems().get(i).getPrice());
        }
        System.out.println("----------------------------------------------------------------------------------------");

        /**
         * Week4 Task 1.2.15.2 Inner Classe
         */
        System.out.println("\n-------------------------Week4 Task 1.2.15.2 Inner Classes----------------------------");
        Network myNet = new Network();
        Network STIUNet = new Network();
        int i = 0;

        Network.Member ehsan = myNet.enroll("Ehsan");
        Network.Member naris = myNet.enroll("Naris");
        Network.Member mark = myNet.enroll("Mark");
        Network.Member ice = STIUNet.enroll("Ice");
        Network.Member rick = STIUNet.enroll("Rick");
        mark.deactivate();

        System.out.printf("%-23s %-25s %-25s %n", "Member Name", "Belongs to 'myNet'", "Belongs to 'STIUNet'");
        for(; i < myNet.getMembers().size() ; i++){
            System.out.printf("%d) %-20s %-25s %-25s %n", i+1,
                    myNet.getMembers().get(i).getName(),
                    myNet.getMembers().get(i).belongsTo(myNet),
                    myNet.getMembers().get(i).belongsTo(STIUNet)
            );
        }
        for(int j = 0; i < myNet.getMembers().size() + STIUNet.getMembers().size() ; i++, j++){
            System.out.printf("%d) %-20s %-25s %-25s %n", i+1,
                    STIUNet.getMembers().get(j).getName(),
                    STIUNet.getMembers().get(j).belongsTo(myNet),
                    STIUNet.getMembers().get(j).belongsTo(STIUNet)
            );
        }
        System.out.println("----------------------------------------------------------------------------------------");

        /**
         * Week4 Task 1.3.1 Declaring an Interface
         */
        System.out.println("\n----------------------Week4 Task 1.3.1 Declaring an Interface---------------------------");
        int[] myInts = {1, 7, 2, 9};
        SquareSequence mySequence = new SquareSequence(myInts); //Week4 Task 1.3.2 Implementing an Interface
//        SquareSequence mySequence = new SquareSequence(myInts);
        double result = Average.average(mySequence, myInts.length);
        System.out.println("Average number is: " + result);
        System.out.println("----------------------------------------------------------------------------------------");

        /**
         * Week4 Task 1.3.3 Converting to an Interface Type
         */
        System.out.println("\n------------------Week4 Task 1.3.3 Converting to an Interface Type----------------------");
        IntSequence digits = new DigitSequence(1729); //Week4 Task 1.3.3 Converting to an Interface Type
        double avg = Average.average(digits, 100);
        System.out.println("Average number is: " + avg);
        System.out.println("----------------------------------------------------------------------------------------");

        /**
         * Week4 Task 1.3.4 Casts and the instanceof Operator
         */
        System.out.println("\n-----------------Week4 Task 1.3.4 Casts and the instanceof Operator---------------------");
        IntSequence sequence = new DigitSequence(1729);
        DigitSequence numberDigits1 = (DigitSequence) sequence;
        System.out.print("[Cast] The numbers is: ");
        System.out.println(numberDigits1.rest());

        if (sequence instanceof DigitSequence){
            DigitSequence numberDigits2 = (DigitSequence) sequence;
            System.out.print("[instanceof] The numbers is: ");
            System.out.println(numberDigits2.rest());
        }
        System.out.println("----------------------------------------------------------------------------------------");

        /**
         * Week4 Task 1.3.5 Extending Interfaces
         */
        System.out.println("\n-----------------------Week4 Task 1.3.5 Extending Interfaces----------------------------");

        System.out.println("----------------------------------------------------------------------------------------");

        /**
         * Week4 Task 1.3.6 Implementing Multiple Interfaces
         */
        System.out.println("\n----------------Week4 Task 1.3.6 Implementing Multiple Interfaces-----------------------");

        System.out.println("----------------------------------------------------------------------------------------");




    }
}


