package Week_4;

// 1.4.7 Interface
public interface Identified {
    default int getId() {
        return Math.abs(hashCode());
    }
}
