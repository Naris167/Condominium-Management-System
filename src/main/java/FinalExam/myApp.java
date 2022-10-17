package FinalExam;

import java.util.Arrays;

class myApp {
    public static void main(String[] args) {
        Object[] myList = new Object[3];
        myList[0] = "item0";
        myList[1] = "item1";
        myList[2] = "item2";

        SwapUtil swapUtil = new SwapUtil();
        System.out.println(Arrays.toString(myList));
        Object[] swappedList = swapUtil.swapElements(myList, 0, 2);
        System.out.println(Arrays.toString(swappedList));
    }
}
