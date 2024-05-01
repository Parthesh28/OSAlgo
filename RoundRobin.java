import java.util.Scanner;

public class RoundRobin {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of processes: ");
        int np = sc.nextInt();

        int[] BT = new int[np];
        int[] TAT = new int[np];
        int[] WT = new int[np];
        int[] FT = new int[np];
        int[] remainingBurstTime = new int[np];

        System.out.println("Enter the burst time for each process: ");
        for (int i = 0; i < np; i++) {
            BT[i] = sc.nextInt();
            remainingBurstTime[i] = BT[i];
        }
        System.out.println("Enter the time quantum: ");
        int quantum = sc.nextInt();
        int time = 0;
        boolean[] completed = new boolean[np];
        while (true) {
            boolean done = true;
            for (int i = 0; i < np; i++) {
                if (remainingBurstTime[i] > 0) {
                    done = false;
                    if (remainingBurstTime[i] > quantum) {
                        time = time + quantum;
                        remainingBurstTime[i] = remainingBurstTime[i] - quantum;
                    } else {
                        time = time + remainingBurstTime[i];
                        remainingBurstTime[i] = 0;
                        FT[i] = time;
                        TAT[i] = FT[i];
                        completed[i] = true;
                    }
                    WT[i] = TAT[i] - BT[i];
                }
            }
            if (done)
                break;
        }
        System.out.println("Process\t\tTurnaround Time\t\tFinish Time\t\tWaiting Time");
        for (int i = 0; i < np; i++) {
            System.out.println("P-" + i + "\t\t" + TAT[i] + "\t\t\t" + FT[i] + "\t\t" + WT[i]);
        }
    }
}