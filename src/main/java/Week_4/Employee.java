package Week_4;

import java.time.LocalDate;
// 1.3.10 Implements versus Extends
// 1.4.7 Interface
public class Employee implements PersonInterface, Identified, Comparable<Employee> {
    private String name;

    public Employee(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }
    @Override
    //Resolving Default Method Conflicts
    public int getId() {
        return Identified.super.getId();
    }

    public int compareTo(Employee other) {
        // Ok if IDs always greater or equal to 0
        return getId() - other.getId();
    }
}
