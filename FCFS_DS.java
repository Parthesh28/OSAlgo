import java.util.Scanner;
public class FCFS_DS{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the no. of IO Request");
        int NIOR = sc.nextInt();
        int[] IOR = new int[NIOR+1];
        int[] THM = new int[NIOR+1];
        double sum =0;
        System.out.println("Enter the IO Request");
        for (int i = 1; i <= NIOR; i++) {
            IOR[i] = sc.nextInt(); 
        }
        System.out.println("Enter the starting head position");
        int SCY = sc.nextInt();
        IOR[0]=SCY;
        for (int i = 1; i <= NIOR; i++) {
            THM[i] = Math.abs(IOR[i-1] - IOR[i]);
            sum += THM[i];
        }
        System.out.println("IO REQUEST\tTHM");
        for (int i = 1; i <= NIOR; i++) {
            System.out.println(IOR[i]+"\t\t"+THM[i]);    
        }
        System.out.println("AVERAGE SEEK TIME IS "+(sum/NIOR));
    }
}