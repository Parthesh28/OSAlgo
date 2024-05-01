import java.util.Scanner;
public class BankerAlgo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the No. of Process");
        int np = sc.nextInt();
        int[] Maxneed = new int[np];
        int[] need = new int[np];
        int[] allocation = new int[np];
        boolean[] status = new boolean[np];

        System.out.println("Enter the maximum need array: ");
        for (int i = 0; i < np; i++) {
            Maxneed[i] = sc.nextInt();
        }
        System.out.println("Enter the allocation array: ");
        for (int i = 0; i < np; i++) {
            allocation[i] = sc.nextInt();
        }
        System.out.println("Enter the available resources: ");
        int avail = sc.nextInt();

        for (int i = 0; i < np; i++) {
            need[i] = Maxneed[i] - allocation[i];
        }
        int work = avail;
        System.out.print("the Safe squence is  : ");
        for (int i = 0; i < np; i++) {
            for (int j = 0; j < np; j++) {
                if (need[j] <= work && status[j] != true) {
                    status[j] = true;
                    work = work + allocation[j];
                    System.out.print("Process " + (j) + "-> ");
                }
            }
        }
        System.out.println("\nProcess Name\tMAX\tALLOCATION\tNEED");
        for (int i = 0; i < np; i++) {
            System.out.println((i) + "\t\t" + Maxneed[i] + "\t\t" + allocation[i] + "\t\t" + need[i]);
        }
    }
}