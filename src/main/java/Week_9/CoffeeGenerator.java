//
//// CoffeeGenerator.java
//
//package Week_9;
//import org.stamford.Generator;
//import java.util.Random;
//public class CoffeeGenerator implements Generator<Coffee>, Iterable<Coffee> {
//    private Class[] types = {
//            Latte.class, Cappuccino.class, Americano.class};
//    private static Random rand = new Random(58);
//
//    public CoffeeGenerator() {
//    }
//
//    // For iteration:
//    private int size = 0;
//
//    public CoffeeGenerator(int sz) {
//        size = sz;
//    }
//
//    public Coffee next() {
//        try {
//// In generic code, the question mark (?), called the wildcard,
//// represents an unknown type.
//            Class<?> randomCoffeeClass = types[rand.nextInt(types.length)];
//            return (Coffee) randomCoffeeClass.getDeclaredConstructor().
//                    newInstance();
//// Report programmer errors at run time:
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        }
//    }
//}
