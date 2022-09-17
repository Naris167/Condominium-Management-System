package Week_4;

// 1.4.7 Interface
public interface PersonInterface {
    String getName();
    default int getId() {
        return 0;
    }
}
