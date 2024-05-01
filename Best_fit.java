import java.util.Scanner;

public class Best_fit {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the No of process");
        int np = sc.nextInt();
        System.out.println("Enter the No. of Memory Block");
        int mb = sc.nextInt();
        int[] process = new int[np];
        int[] MB = new int[mb];
        System.out.println("Enter the Process Size ");
        for (int i = 0; i < np; i++) {
            process[i] = sc.nextInt();
        }
        System.out.println("Enter the Memory Block Size ");
        for (int i = 0; i < mb; i++) {
            MB[i] = sc.nextInt();
        }
        boolean[] status = new boolean[np];
        System.out.println("Process Name\tProcess Size\tBlock Alocated");
        for (int i = 0; i < np; i++) {
            int pos = -1;
            for (int j = 0; j < mb; j++) {
                if (process[i] <= MB[j] && status[i] != true && pos == -1) {
                    pos = j;
                    status[i] = true;
                    for (int k = j + 1; k < mb; k++) {
                        if (MB[k] <= MB[j] && process[i] <= MB[k]) {
                            pos = k;
                        }
                    }
                    System.out.println("P" + (i + 1) + "\t\t" + process[i] + "\t\t" + (pos + 1));
                    MB[pos] = MB[pos] - process[i];
                    break;
                }
            }
        }
    }
}