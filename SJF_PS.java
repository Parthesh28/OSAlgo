
import java.util.*;

public class SJF_PS {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the no. of process");
        int np = sc.nextInt();
        int[] BT = new int[np];
        int[] FT = new int[np];
        int[] TAT = new int[np];
        int[] WT = new int[np];
        int[] process_name = new int[np];
        int[] temp_pn = new int[np];
        int[] temp_BT = new int[np];

        for (int i = 0; i < np; i++) {
            System.out.print("\nP[" + (i + 1) + "]: ");
            process_name[i] = sc.nextInt();
            System.out.print("\nP[" + (i + 1) + "] BURST TIME: ");
            BT[i] = sc.nextInt();
            temp_BT[i] = BT[i];
        }

        Arrays.sort(temp_BT);

        for (int i = 0; i < np; i++) {
            for (int j = 0; j < np - 1; j++) {
                if (temp_BT[i] == BT[j]) {
                    temp_pn[i] = j;
                    break;
                }
            }
        }

        for (int i = 0; i < np; i++) {
            if (i == 0) {
                FT[i] = temp_BT[i];
            } else {
                FT[i] = temp_BT[i] + FT[i - 1];
            }
            TAT[i] = FT[i];
            WT[i] = TAT[i] - temp_BT[i];
        }
        System.out.println("PROCESS NAME\tAT\tBT\tFT\tTAT\tWT");
        for (int i = 0; i < np; i++) {
            System.out.println("P[" + (temp_pn[i] + 1) + "]\t\t" + (0) + "\t\t" + temp_BT[i] + "\t\t" + FT[i] + "\t\t"
                    + TAT[i] + "\t\t" + WT[i]);
        }
    }
}