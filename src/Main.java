//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.

public class Main {
    public static int highestRevenue(int[] A) {
        int i = 1;
        int j = 2;
        int min_temp = 0;
        int length = A.length;

        for(int curr = 1; curr < length; curr++) {
            if (A[curr] > A[j]) {
                j = curr;
            }
            if (A[curr] < A[i] && A[curr] < A[min_temp]) {
                min_temp = curr;
            }
            if (A[j] - A[i] < A[curr] - A[min_temp]) {
                i = min_temp;
                j = curr;
            }
        }

        if(A[j] - A[i] < 0) {
            return Integer.MIN_VALUE;
        } else {
            return A[j] - A[i]; // corrected line
        }
    }
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        System.out.printf("Hello and welcome!");

        for (int i = 1; i <= 5; i++) {
            //TIP Press <shortcut actionId="Debug"/> to start debugging your code. We have set one <icon src="AllIcons.Debugger.Db_set_breakpoint"/> breakpoint
            // for you, but you can always add more by pressing <shortcut actionId="ToggleLineBreakpoint"/>.
            System.out.println("i = " + i);
        }
        System.out.printf(highestRevenue(new int[]{1,4, 44, 2, 100}) + "\n");
    }
}