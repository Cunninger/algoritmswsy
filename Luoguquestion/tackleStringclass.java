package Luoguquestion;
import java.util.*;

public class tackleStringclass {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int q = sc.nextInt();
        sc.nextLine();

        StringBuilder sb = new StringBuilder(sc.nextLine());

        while(q-- > 0) {
            int n = sc.nextInt();

            if (n == 1) {
                sc.nextLine(); // Consume the newline
                String s1 = sc.nextLine();
                sb.append(s1);
                System.out.println(sb.toString());
            }
            else if (n == 2) {
                int start = sc.nextInt();
                int len = sc.nextInt();
                sb = new StringBuilder(sb.substring(start, start + len));
                System.out.println(sb.toString());
            }
            else if (n == 3) {
                int pos = sc.nextInt();
                sc.nextLine(); // Consume the newline
                String s3 = sc.nextLine();
                sb.insert(pos, s3);
                System.out.println(sb.toString());
            }
            else if (n == 4) {
                sc.nextLine(); // Consume the newline
                String searchStr = sc.nextLine();
                int index = sb.indexOf(searchStr);
                System.out.println(index == -1 ? -1 : index);
            }
        }
        sc.close();
    }
}
