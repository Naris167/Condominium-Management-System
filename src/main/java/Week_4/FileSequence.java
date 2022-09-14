package Week_4;

public class FileSequence implements IntSequence, Closeable {
    @Override
    public void close() {

    }

    @Override
    public boolean hasNext() {
        return false;
    }

    @Override
    public int next() {
        return 0;
    }
}
