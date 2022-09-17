package Week_4;

public interface Channel extends Closeable { //1.3.10 Implements versus Extends
    boolean isOpen();
}
