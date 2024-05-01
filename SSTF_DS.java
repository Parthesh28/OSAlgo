
import java.util.Scanner;
public class SSTF_DS {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the IO REQUEST");
        int NIOR = sc.nextInt();
        int[] IOR = new int[NIOR + 1];
        int[] THM = new int[NIOR + 1];
        System.out.println("Enter the IO REQUEST");
        for (int i = 1; i <= NIOR; i++) {
            IOR[i] = sc.nextInt();
        }
        System.out.println("Enter the Starting Cylinder");
        int SCY = sc.nextInt();

        for (int i = 1; i <= NIOR; i++) {
            for (int j = 1; j < NIOR; j++) {
                if (Math.abs(IOR[j] - SCY) > Math.abs(IOR[j + 1] - SCY)) {
                    int temp = IOR[j + 1];
                    IOR[j + 1] = IOR[j];
                    IOR[j] = temp;
                }
            }
        }
        IOR[0] = SCY;
        double sum = 0;
        for (int i = 1; i <= NIOR; i++) {
            THM[i] = Math.abs(IOR[i - 1] - IOR[i]);
            sum += THM[i];
        }
        System.out.println("IO REQUEST\tTHM");
        for (int i = 1; i <= NIOR; i++) {
            System.out.println(IOR[i] + "\t\t" + THM[i]);
        }
        System.out.println("AVERAGE SEEK TIME IS " +(sum / NIOR));
    }
}