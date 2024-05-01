
import java.util.Scanner;

public class FCFS_PS {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the no. of process: ");
        int np = sc.nextInt();
        int[] BT = new int[np + 1];
        int[] FT = new int[np + 1];
        int[] TAT = new int[np + 1];
        int[] WT = new int[np + 1];
        FT[0] = 0;
        System.out.println("Enter the BURST TIME");
        for (int i = 1; i <= np; i++) {
            BT[i] = sc.nextInt();
        }
        for (int i = 1; i <= np; i++) {
            FT[i] = FT[i - 1] + BT[i];
            TAT[i] = FT[i];
            WT[i] = FT[i] - BT[i];
        }

        System.out.println("Process\tAT\tBT\tFT\tTAT\tWT");
        for (int i = 1; i <= np; i++) {
            System.out.println(i + "\t" + (0) + "\t" + BT[i] + "\t" + FT[i] + "\t" + TAT[i] + "\t" + WT[i]);
        }
        System.out.println("GANTT CHART");
        for (int i = 1; i <= np; i++) {
            System.out.print("| P" + (i));
        }
        System.out.print("|\n");
        System.out.print("0");
        for (int i = 1; i <= np; i++) {
            System.out.print("  " + FT[i]);
        }
    }
}