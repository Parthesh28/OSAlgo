import java.util.Scanner;

public class LRU_PR {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the no. frames");
        int frames = sc.nextInt();
        System.out.println("Enter the no. of pages ");
        int pages = sc.nextInt();
        int[] incomingStream = new int[pages];
        int[] temp = new int[frames];
        int[] timestamp = new int[frames];
        System.out.println("Enter the pages");
        for (int i = 0; i < pages; i++) {
            incomingStream[i] = sc.nextInt();
        }
        for (int i = 0; i < frames; i++) {
            temp[i] = -1;
            timestamp[i] = 0;
        }
        int s, PageFault = 0;
        System.out.println("PAGES\tFRAME1\tFRAME2\tFRAME3");
        for (int i = 0; i < pages; i++) {
            s = 0;
            for (int j = 0; j < frames; j++) {
                if (incomingStream[i] == temp[j]) {
                    s++;
                    PageFault--;
                    timestamp[j] = i + 1;
                }
            }
            PageFault++;
            if (PageFault <= frames && s == 0) {
                for (int j = 0; j < frames; j++) {
                    if (temp[j] == -1) {
                        temp[j] = incomingStream[i];
                        timestamp[j] = i + 1;
                        break;
                    }
                }
            } else if (s == 0) {
                int leastRecent = timestamp[0];
                int ReplaceIndex = 0;
                for (int j = 1; j < frames; j++) {
                    if (timestamp[j] < leastRecent) {
                        leastRecent = timestamp[j];
                        ReplaceIndex = j;
                    }
                }
                temp[ReplaceIndex] = incomingStream[i];
                timestamp[ReplaceIndex] = i + 1;
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
        System.out.println("the page fault is " + PageFault);
    }
}