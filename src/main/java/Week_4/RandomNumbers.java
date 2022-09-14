package Week_4;

import java.util.Random;

public class RandomNumbers { //1.2.12 Static Methods
    public static int nextInt(Random generator, int low, int high) {
        return low + generator.nextInt(high - low + 1);
    }
}