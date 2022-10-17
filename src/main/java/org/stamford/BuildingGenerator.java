package org.stamford;

import java.time.LocalDate;

public class BuildingGenerator implements Generator<Building> {
    public static int counter = 0;
    private String[] sizeList = {"Large", "Medium", "Small"};
    public static void increaseCounter(){
        counter++;
    }
    public static void decreaseCounter(){
        counter--;
    }

    @Override
    public Building next() {
        try {
            increaseCounter();
            Building building = new Building();
            building.setName("Building-" + building.getID());
            building.setLocation("Bangkok-" + building.getID());
            building.setConBudget(100000 * building.getID());
            building.setOwnedUnit(building.getID());
            building.setNumberOfUnit(building.getID() + 10);
            building.setEmptyUnit();
            building.setSize(sizeList[building.getID() % 3]);

            int day = (building.getID() % 28) + 1;
            building.setConDate(LocalDate.of(1980, 3, day));
            building.setCompleteDate(LocalDate.of(2000, 5, day));
            return building;
            // Report programmer errors at run time:
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}