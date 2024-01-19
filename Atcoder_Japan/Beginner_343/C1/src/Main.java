    import java.util.*;

    public class Main {
        static ArrayList<Long> all = new ArrayList<>();

        public static void g(String s, int len, boolean isOdd) {
            if (s.length() == len) {
                long num = Long.parseLong(s);
                long cube = num * num * num;
                if (cube <= 0 || cube > 1e18) return;
                String strCube = Long.toString(cube);
                if (strCube.equals(new StringBuilder(strCube).reverse().toString())) {
                    all.add(cube);
                }
                return;
            }
            for (int i = 0; i <= 9; i++) {
                if (s.length() == 0 && i == 0) continue;
                g(s + i, len, isOdd);
            }
        }

        public static void main(String[] args) {
            for (int len = 1; len <= 6; len++) {
                for (int i = 1; i <= 9; i++) {
                    g(Integer.toString(i), len, len % 2 == 1);
                }
            }
            Collections.sort(all);

            Scanner sc = new Scanner(System.in);
            long N = sc.nextLong();
            int index = Collections.binarySearch(all, N);
            if (index < 0) index = -index - 2;
            System.out.println(all.get(index));
        }
    }
