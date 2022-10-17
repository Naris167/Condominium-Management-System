package FinalExam;

public class SwapUtil {
    public static <E> E[] swapElements(E[] array, int firstIndex, int secondIndex){
        E[] clonedArray = array.clone();
        E e = clonedArray[firstIndex];
        clonedArray[firstIndex] = clonedArray[secondIndex];
        clonedArray[secondIndex] = e;

        return clonedArray;
    }
}