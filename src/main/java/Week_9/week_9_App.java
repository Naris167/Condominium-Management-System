package Week_9;

public class week_9_App {
    public static void main(String[] args) {


        /**
         * Week9 Assignment
         */
        System.out.println("\n------------------------------------Week9 Assignment----------------------------------");
        GenericMethods gm = new GenericMethods();
        gm.method("", 1, 1.0);
        gm.method(1.0F, "c", gm);
        System.out.println("----------------------------------------------------------------------------------------");

        System.out.println("\n------------------------------------Week9 Task 3--------------------------------------");
        Stack<Integer> stack = new Stack <> ();
        stack.push(45);
        stack.push(100);
        stack.push(3);
        // Let's pop an item
        Integer item = (Integer) stack.pop();
        System.out.println("Successfully Build");
        System.out.println("----------------------------------------------------------------------------------------");

        System.out.println("\n------------------------------------Week9 Question 6----------------------------------");
        Favorites f = new Favorites();
        f.putFavorite(Integer.class, 2106010007);
        f.putFavorite(String.class, "Naris");
        f.putFavorite(Float.class, 4.00f);

        int favoriteInteger = f.getFavorite(Integer.class);
        String favoriteString = f.getFavorite(String.class);
        Float favoriteFloat = f.getFavorite(Float.class);
//        System.out.printf("%s %x %s%n", favoriteString, favoriteInteger, favoriteClass.getName());

        System.out.printf("%-17s %-23s %-12s %n", "Student ID", "Student Name", "GPA");
        System.out.printf("%-17s %-23s %-12s %n",
                favoriteInteger,
                favoriteString,
                favoriteFloat);

//        for(int i = 0 ; i < f.sizeFavorite() ; i++){
//            System.out.printf("%d) %-14s %-23s %-12s %n", i+1,
//                    favoriteInteger,
//                    favoriteString,
//                    favoriteDouble);
//        }

        System.out.println("----------------------------------------------------------------------------------------");


        polymorphismGeneralization pG = new polymorphismGeneralization();
        A myA = new A();
        B myB = new B();
        // sampleMethod() can receive any class that extends Base
        // such as A or B classes:
        pG.sampleMethod(myA);
        pG.sampleMethod(myB);
        // sampleMethod() is a bit more general as now it supports many
        // classes such as A or B


        Holder2 h2 = new Holder2(new Automobile());
        Automobile a = (Automobile) h2.get();
        h2.set("Not an Automobile");
        System.out.println("h2 = " + h2);
        System.out.println("h2 = " + h2.get());
        String s = (String) h2.get();
        h2.set(1); // Autoboxes to Integer
        System.out.println("h2 = " + h2);
        System.out.println("h2 = " + h2.get());
        Integer x = (Integer) h2.get();



//
//        Holder3<Automobile> h3 = new Holder3<Automobile>(new Automobile());
//        Automobile a = h3.get(); // No cast needed
        // h3.set("Not an Automobile"); // Error
        // h3.set(1); // Error




    }
}
