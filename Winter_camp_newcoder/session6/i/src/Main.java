import java.util.Scanner;

public class Main {

    private static long f(int[] arr) {
        long sf = arr[0], e = arr[0];
        for (int i = 1; i < arr.length; i++) {
            e = Math.max(arr[i], e + arr[i]);
            sf = Math.max(sf, e);
        }
        return sf;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[] a = new int[n];
        int[] b = new int[m];

        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }

        for (int i = 0; i < m; i++) {
            b[i] = scanner.nextInt();
        }


        long msa = f(a);
        long msb = f(b);

        long msm = msa * msb;

        System.out.println(msm);
    }
}
