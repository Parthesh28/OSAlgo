import java.util.Scanner;
public class First_fit {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the no. of process");
        int np = sc.nextInt();
        System.out.println("Enter the no. of Memory Block");
        int mb = sc.nextInt();
        int[] process = new int[np];
        int[] MS = new int[mb];
        System.out.println("Enter the size of process");
        for (int i = 0; i < np; i++) {
            process[i] = sc.nextInt();
        }
        System.out.println("Enter the size of Memory block");
        for (int i = 0; i < mb; i++) {
            MS[i] = sc.nextInt();
        }

        System.out.println("Process Name\tProcess Size\tBlock Alocated");
        for (int i = 0; i < np; i++) {
            for (int j = 0; j < mb; j++) {
                if (process[i] <= MS[j]) {
                    System.out.println("P" + (i + 1) + "\t\t" + process[i] + "\t\t" + (j + 1));
                    MS[j] = MS[j] - process[i];
                    break;
                }
            }
        }
    }
}