
import java.util.Scanner;

public class FIFO_PR {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of frames");
        int frames = sc.nextInt();
        System.out.println("Enter the number of pages");
        int pages = sc.nextInt();
        int[] temp = new int[frames];
        int[] incomingStream = new int[pages];
        int PageFault = 0, s;
        System.out.println("Enter the page incoming stream");
        for (int i = 0; i < pages; i++) {
            incomingStream[i] = sc.nextInt();
        }
        for (int i = 0; i < frames; i++) {
            temp[i] = -1;
        }
        System.out.println("PAGES\tFRAME1\tFRAME2\tFRAME3");
        for (int i = 0; i < pages; i++) {
            s = 0;
            for (int j = 0; j < frames; j++) {
                if (incomingStream[i] == temp[j]) {
                    s++;
                    PageFault--;
                }
            }
            PageFault++;
            if (PageFault <= frames && s == 0) {
                temp[i] = incomingStream[i];
            } else if (s == 0) {
                temp[(PageFault - 1) % frames] = incomingStream[i];
            }
            System.out.print(incomingStream[i]);
            for (int j = 0; j < frames; j++) {
                if (temp[j] != -1) {
                    System.out.print("\t" + temp[j]);
                } else {
                    System.out.print("\t-");
                }
            }
            System.out.println("");
        }
        System.out.println("The pages fault is" + PageFault);
    }
}