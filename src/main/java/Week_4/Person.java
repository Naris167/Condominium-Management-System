package Week_4;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;

public class Person { //1.2.3 Class
    //1.2.14 Access modifiers (private and public)
    //Instance Field
    private String name;
    private LocalDate birthDate;
    private String bloodType;
    private int age;


    //Static Field
    public static ArrayList<String> BloodType = new ArrayList<String>();
//    public static final double PI;

    static { //Initialization Block
        String BloodTypeUnknown = "N/A";
        BloodType.add(BloodTypeUnknown);
        String BloodTypeA = "A";
        BloodType.add(BloodTypeA);
        String BloodTypeB = "B";
        BloodType.add(BloodTypeB);
        String BloodTypeAB = "AB";
        BloodType.add(BloodTypeAB);
        String BloodTypeO = "O";
        BloodType.add(BloodTypeO);
    }

    // Final fields must be initialized in constructor (1.2.8 Final Instance Variables)
    private final String ID_Number;

    // PI is Static Constant (1.2.10 Static Constants) (1.2.9 Static Variables)
    public static final double PI = 3.14159265358979323846;


    // Default constructor
    public Person() {
        this.name = "";
        this.birthDate = LocalDate.now();
        this.age = 0;
        this.bloodType = BloodType.get(0);
        this.ID_Number = "N/A";
    }

    // Second constructor is overloaded (1.2.7 Overloading)
    // Constructors must not have a return type
    public Person(String name, LocalDate birthDate, int bloodType, String ID) {
        this.name = name;
        this.birthDate = birthDate;
        this.age = Period.between(birthDate, LocalDate.now()).getYears();
        this.bloodType = BloodType.get(bloodType);
        this.ID_Number = ID;
    }

    // 1.2.5 Accessor and Mutator Methods
    // Accessors
    public String getName () {
        return name;
    }
    public LocalDate getBirthDate () {
        return birthDate;
    }
    public int getAge (){
        return age;
    }
    public String getBloodType (){
        return bloodType;
    }
    public String getID_Number (){
        return ID_Number;
    }

    // Mutators:
    public void setName (String name) {
        this.name = name;
    }
    public void setBirthDate (LocalDate birthDate) {
        this.birthDate = birthDate;
    }
    public void setAge (int age) {
        this.age = age;
    }
    public void setBloodType (int bloodType) {
        this.bloodType = BloodType.get(bloodType);
    }
}

