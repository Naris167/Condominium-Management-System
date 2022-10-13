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
