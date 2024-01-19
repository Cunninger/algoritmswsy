import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static class peoInfo {
        String email;
        int score;

        public peoInfo() {

        }

        public peoInfo(String e, int s) {
            email = e;
            score = s;
        }
    }


    public static void main(String[] args) {

        Q in = new Q();
        PrintWriter out = new PrintWriter(System.out);
        int N = in.nextInt();
        int G = in.nextInt();
        int k = in.nextInt();
        peoInfo[] peoInfos = new peoInfo[N];
        for (int i = 0; i < N; i++) {

            String e = in.next();
            int s = in.nextInt();
            peoInfos[i] = new peoInfo(e, s);


        }
        int sum = 0;
        for (peoInfo p : peoInfos) {
            if (p.score >= 60 && p.score < G) {
                sum += 20;
            } else if ((p.score >= G && p.score <= 100)) {
                sum += 50;
            }
        }

        Arrays.sort(peoInfos, ((o1, o2) -> o1.score != o2.score ? o2.score - o1.score : o1.email.compareTo(o2.email)));

        out.println(sum);
        int rank = 0;
        int lastScore = -1;
        int count = 0;
        for (int i = 0; i < peoInfos.length && count<k; i++) {
            if (lastScore!=peoInfos[i].score){
                rank = i+1;
                lastScore= peoInfos[i].score;
            }

            out.println(rank+" "+peoInfos[i].email+" "+peoInfos[i].score);
            count++;

            while (i+1<peoInfos.length && peoInfos[i+1].score==peoInfos[i].score){
                i++;
                out.println(rank+" "+peoInfos[i].email+" "+peoInfos[i].score);
                count++;
            }
        }

        out.close();


    }


    static class Q {
        BufferedReader buf;
        StringTokenizer tok;

        Q() {
            buf = new BufferedReader(new InputStreamReader(System.in));
        }

        boolean hasNext() {
            while (tok == null || !tok.hasMoreElements()) {
                try {
                    tok = new StringTokenizer(buf.readLine());
                } catch (Exception e) {
                    return false;
                }
            }
            return true;
        }


        String next() {
            if (hasNext()) {
                return tok.nextToken();
            }
            return null;
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        String nextLine() {
            try {
                return buf.readLine();
            } catch (Exception e) {
                return null;
            }
        }

    }
}