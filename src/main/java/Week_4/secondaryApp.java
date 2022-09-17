package Week_4;

import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;


public class secondaryApp {
    public static void main(String[] args) {
        /**
         * Week4 Task 1.2.1 to 1.2.10
         */
        //1.2.1 Function (Procedure)
        //1.2.2 Object (Class instance)
        //1.2.6 Object Construction (new keyword)
        PersonClass Ehsan = new PersonClass("Ehsan", LocalDate.of(1986, 1, 12), 1, "125463");
        PersonClass Naris = new PersonClass("Naris", LocalDate.of(2003, 4, 12), 3, "187946");
        PersonClass noName = new PersonClass();
        ArrayList<PersonClass> personList = new ArrayList<PersonClass>();
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
        System.out.println("\n---------------------------------Week4 Task 1.2.11--------------------------------------");
        CreditCardForm card = new CreditCardForm();
        System.out.printf("Hi Naris, your credit card has been issue on " + LocalDate.now()); //1.2.13 Factory Methods
        System.out.println("\nYou will be able to use your card until " + LocalDate.now().plusYears(card.getExpDate().size() - 1));
        System.out.println("This is all the years that you will be able to use your card:\n" + card.getExpDate());
        System.out.println("----------------------------------------------------------------------------------------");

        /**
         * Week4 Task 1.2.12
         */
        System.out.println("\n--------------------------------Week4 Task 1.2.12---------------------------------------");
        Random gen = new Random();
        int dieToss = RandomNumbers.nextInt(gen, 1, 6);
        System.out.println("A random number is: " + dieToss);
        System.out.println("----------------------------------------------------------------------------------------");

        /**
         * Week4 Task 1.2.15.1 Static Nested Classes
         */
        System.out.println("\n---------------------Week4 Task 1.2.15.1 Static Nested Classes--------------------------");
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
        System.out.println("\n-------------------------Week4 Task 1.2.15.2 Inner Classes------------------------------");
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
        System.out.println("\n--------------------------Week4 Task 1.3.5 Extending Interfaces-------------------------");
        FileSequence fileSequence = new FileSequence();
        System.out.println("Calling 'close' method from interface = " + fileSequence.close());
        System.out.println("Calling 'isOpen' method from interface = " + fileSequence.isOpen());
        System.out.println("----------------------------------------------------------------------------------------");

        /**
         * Week4 Task 1.3.6 Implementing Multiple Interfaces
         */
        System.out.println("\n----------------Week4 Task 1.3.6 Implementing Multiple Interfaces-----------------------");
        try {
            System.out.println("Using 'FileSequence' class to reads integers from file:");
            FileSequence.readNumber("W4_FileSequence.txt");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        System.out.println("----------------------------------------------------------------------------------------");

        /**
         * Week4 Task 1.3.7 Constants
         */
        System.out.println("\n----------------------------Week4 Task 1.3.7 Constants----------------------------------");
        System.out.println("Constant for NORTH is: " + SwingConstants.NORTH);
        System.out.println("Constant for NORTH_EAST is: " + SwingConstants.NORTH_EAST);
        System.out.println("Constant for EAST is: " + SwingConstants.EAST);
        System.out.println("Constant for SOUTH_WEST is: " + SwingConstants.SOUTH_WEST);
        System.out.println("Constant for SOUTH is: " + SwingConstants.SOUTH);
        System.out.println("Constant for SOUTH_WEST is: " + SwingConstants.SOUTH_WEST);
        System.out.println("Constant for WEST is: " + SwingConstants.WEST);
        System.out.println("Constant for NORTH_WEST is: " + SwingConstants.NORTH_WEST);
        System.out.println("----------------------------------------------------------------------------------------");

        /**
         * Week4 Task 1.3.8 Static, Default, and Private Methods
         */
        System.out.println("\n-------Week4 Task 1.3.8 Static, Default, and Private Methods and 1.4.7 Interface--------");
        IntSequence digits2 = IntSequence.digitsOf(1729);
        DigitSequence numberDigits3 = (DigitSequence) digits2;
        System.out.println("**Static method**");
        System.out.print("The numbers is: ");
        System.out.println(numberDigits3.rest());

        //Resolving Default Method Conflicts
        // 1.4.7 Interface
        Employee naris2 = new Employee("Naris");
        System.out.println("\n**Resolving Default Method Conflicts**");
        System.out.println("The name of the employee is: " + naris2.getName());
        System.out.println("The ID of the employee is: " + naris2.getId());

        //Private method
        System.out.println("\n**Private method**");
        Private_Methods Demo = new Private_Methods();
        Demo.getPrint();
        Private_Methods_Child Demo1 = new Private_Methods_Child();
        Demo1.print();

        System.out.println("----------------------------------------------------------------------------------------");

        /**
         * Week4 Task 1.3.9 Interface Example
         */
        System.out.println("\n-------------------------Week4 Task 1.3.9 Interface Example-----------------------------");
        Employee ice2 = new Employee("Ice");
        System.out.println("The name of the first employee is: " + naris2.getName());
        System.out.println("The ID of the first employee is: " + naris2.getId());
        System.out.println("The name of the second employee is: " + ice2.getName());
        System.out.println("The ID of the second employee is: " + ice2.getId());
        System.out.println("Compare first employee's ID with another one: " + ice2.compareTo(naris2));

        String[] friends = { "Xie", "Putin", "Hassan" };
        System.out.println("\nBefore sorted: " + Arrays.toString(friends));
        Arrays.sort(friends); // friends is now ["Hassan", "Putin", "Xie"]
        System.out.println("After sorted: " + Arrays.toString(friends));

        System.out.println("----------------------------------------------------------------------------------------");

        /**
         * Week4 Task 1.4.2 Class
         */
        System.out.println("\n-----------------Week4 Task 1.4.1 Object and 1.4.2 Class - BicycleDemo------------------");
        // Create two different
        // Bicycle objects
        Bicycle bike1 = new Bicycle();//1.4.1 Object
        Bicycle bike2 = new Bicycle();
        // Invoke methods on
        // those objects
        bike1.changeCadence(50);
        bike1.speedUp(10);
        bike1.changeGear(2);
        bike1.printStates();
        bike2.changeCadence(50);
        bike2.speedUp(10);
        bike2.changeGear(2);
        bike2.changeCadence(40);
        bike2.speedUp(10);
        bike2.changeGear(3);
        bike2.printStates();
        System.out.println("----------------------------------------------------------------------------------------");

        /**
         * Week4 Task 1.4.4 Data Abstraction
         */
        System.out.println("\n----------------Week4 Task 1.4.4 Data Abstraction and 1.4.6 Inheritance-----------------");
        Shape s1 = new Circle("Red", 2.2);
        Shape s2 = new Rectangle("Yellow", 2, 4);
        System.out.println(s1.toString());
        System.out.println(s2.toString());
        System.out.println("----------------------------------------------------------------------------------------");

        /**
         * Week4 Task 1.4.5 Data Encapsulation
         */
        System.out.println("\n--------------------------Week4 Task 1.4.5 Data Encapsulation---------------------------");
        Encapsulate obj = new Encapsulate();
        // setting values of the variables
        obj.setName("Ehsan");
        obj.setAge(39);
        obj.setRoll(35);
        // Displaying values of the variables
        System.out.println("obj’s name: " + obj.getName());
        System.out.println("obj’s age: " + obj.getAge());
        System.out.println("obj’s roll: " + obj.getRoll());

        // Direct access of obj’s roll is not possible
        // due to encapsulation
        // System.out.println("Geek’s roll: " + obj.name);
        System.out.println("----------------------------------------------------------------------------------------");

        /**
         * Week4 Task 1.4.8 Composition
         */
        System.out.println("\n-----------------------------Week4 Task 1.4.8 Composition-------------------------------");
        // Creating the objects of Book class
        Book b1 = new Book("EffectiveJ Java", "Joshua Bloch");
        Book b2 = new Book("Thinking in Java", "Bruce Eckel");
        Book b3 = new Book("Java: The Complete Reference", "Herbert Schildt");

        // Creating the list which contains the no. of books.
        List<Book> book = new ArrayList<Book>();
        // Adding books to List object using standard add() method
        book.add(b1);
        book.add(b2);
        book.add(b3);

        // Creating an object of Library class
        Library library = new Library(book);
        List<Book> books = library.getListOfBooksInLibrary();
        // Iterating over for each loop
        for (Book bk : books) {
            // Print and display the title and author of
            // books inside List object
            System.out.println("Title : " + bk.title + " and " + " Author : " + bk.author);
        }
        System.out.println("----------------------------------------------------------------------------------------");

        /**
         * Week4 Task 1.4.9 Delegation
         */
        System.out.println("\n-----------------------------Week4 Task 1.4.9 Delegation--------------------------------");
        Printer printer = new Printer();
        printer.printDelegation();

        // Here TicketBookingByAgent class is internally
        // delegating train ticket booking responsibility to other class
        TicketBookingByAgent agent = new TicketBookingByAgent(new TrainBooking());
        agent.bookTicket();
        agent = new TicketBookingByAgent(new AirBooking());
        agent.bookTicket();
        System.out.println("----------------------------------------------------------------------------------------");

        /**
         * Week4 Task 1.4.10 Polymorphism
         */
        System.out.println("\n---------------------------Week4 Task 1.4.10 Polymorphism-------------------------------");
        System.out.println("Method Overloading: ");
        Shapes_MethodOverloading myShape1 = new Shapes_MethodOverloading(); // Create a Shapes object
        myShape1.area();
        myShape1.area(5);
        myShape1.area(6.0,1.2);
        myShape1.area(6,2);

        System.out.println("Method Overriding: ");
        Shapes_MethodOverriding myShape2 = new Shapes_MethodOverriding(); // Create a Shapes object
        Shapes_MethodOverriding myTriangle = new Triangle_MethodOverriding(); // Create a Triangle object
        Shapes_MethodOverriding myCircle = new Circle_MethodOverriding(); // Create a Circle object
        myShape2.area();
        myTriangle.area();
        myShape2.area();
        myCircle.area();
        System.out.println("\n----------------------------------------------------------------------------------------");

        /**
         * Week4 Task 1.4.11 Open recursion
         */
        System.out.println("\n---------------------------Week4 Task 1.4.11 Open recursion-----------------------------");
        A myA = new A();
        //myA.loop(); // will loop indefinitely
        B myB = new B();
        myB.loop(); // Loops 1 time
        System.out.println("----------------------------------------------------------------------------------------");

    }
}


