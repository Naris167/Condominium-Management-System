package Week_4;

public class SquareSequence implements IntSequence { //Week4 Task 1.3.2 Implementing an Interface
    private final int[] sequence;
    private int ind = 0;

    @Override
    public boolean hasNext() {
        return this.ind < this.sequence.length;
    }

    @Override
    public int next() {
        int indexed = this.sequence[ind];
        ind++;
        return indexed;
    }

    public SquareSequence(int[] arr) {
        this.sequence = arr;
    }

//    private int i;
//    public boolean hasNext() {
//        return true;
//    }
//    public int next() {
//        i++;
//        return i * i;
//    }
}
