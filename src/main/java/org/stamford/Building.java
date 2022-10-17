package org.stamford;

import java.time.LocalDate;

public class Building {
    private final int ID = BuildingGenerator.counter;
    private String name;
    private String location;
    private double conBudget;
    private LocalDate conDate;
    private LocalDate completeDate;
    private int numberOfUnit;
    private int ownedUnit;
    private int emptyUnit;
    private String size;


    public Building(){
        this.name = "none";
        this.location = "none";
        this.conBudget = 0;
        this.conDate = LocalDate.of(1900, 1, 1);
        this.completeDate = LocalDate.of(1900, 1, 1);
        this.numberOfUnit = 0;
        this.ownedUnit = 0;
        this.emptyUnit = 0;
        this.size = "null";
    }

    public Building(String name, String location, int budget, LocalDate conDate, LocalDate completeDate, int numberOfUnit, int ownedUnit) {
        this.name = name;
        this.location = location;
        this.conBudget = budget;
        this.conDate = conDate;
        this.completeDate = completeDate;
        this.numberOfUnit = numberOfUnit;
        this.ownedUnit = ownedUnit;
        this.emptyUnit = numberOfUnit - ownedUnit;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void setLocation(String location) {
        this.location = location;
    }
    public void setNumberOfUnit(int numberOfUnit) {
        this.numberOfUnit = numberOfUnit;
    }
    public void setEmptyUnit() {
        this.emptyUnit = numberOfUnit - ownedUnit;
    }
    public void setOwnedUnit(int ownedUnit) {
        this.ownedUnit = ownedUnit;
    }
    public void setSize(String size) {
        this.size = size;
    }
    public void setConBudget(double conBudget) {
        this.conBudget = conBudget;
    }
    public void setConDate(LocalDate conDate) {
        this.conDate = conDate;
    }
    public void setCompleteDate(LocalDate completeDate) {
        this.completeDate = completeDate;
    }

    public String getName() {
        return name;
    }
    public String getLocation() {
        return location;
    }
    public int getNumberOfUnit() {
        return numberOfUnit;
    }
    public int getEmptyUnit() {
        return numberOfUnit - ownedUnit;
    }
    public int getOwnedUnit() {
        return ownedUnit;
    }
    public String getSize() {
        return size;
    }
    public int getID() {
        return ID;
    }
    public double getConBudget() {
        return conBudget;
    }
    public LocalDate getConDate() {
        return conDate;
    }
    public LocalDate getCompleteDate() {
        return completeDate;
    }
}
