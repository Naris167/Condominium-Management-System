package Week_4;

public class Bicycle {
    // cadence is the number of revolutions your pedals
    // make per minute as you ride (unit: rpm)
    // 1.4.2 Class
    int cadence = 0;
    int speed = 0;
    int gear = 1;
    void changeCadence(int newValue) {
        cadence = newValue;
    }
    void changeGear(int newValue) {
        gear = newValue;
    }
    void speedUp(int increment) {
        speed = speed + increment;
    }
    void applyBrakes(int decrement) {
        speed = speed - decrement;
    }
    void printStates() {
        System.out.println("cadence:" + cadence + "rpm speed:" + speed + "m/s gear:" + gear);
    }
}
