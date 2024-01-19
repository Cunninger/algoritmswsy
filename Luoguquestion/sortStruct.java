package Luoguquestion;
import java.util.*;
public class sortStruct {

        static class peopleInfo {
            private String name;
            private int year;
            private int month;
            private int day;
            private int order;
        }

        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            int n = sc.nextInt();
            sc.nextLine();

            PriorityQueue<peopleInfo> pq = new PriorityQueue<>((o1, o2) -> o2.year != o1.year
                    ? o1.year - o2.year
                    : o2.month != o1.month ? o1.month - o2.month
                    : o2.day != o1.day ? o1.day - o2.day
                    : o2.order - o1.order);

            peopleInfo[] peo = new peopleInfo[n];
            for (int i = 0; i < n; i++) {
                peo[i] = new peopleInfo();
                String[] info = sc.nextLine().split(" ");
                peo[i].name = info[0];
                peo[i].year = Integer.parseInt(info[1]);
                peo[i].month = Integer.parseInt(info[2]);
                peo[i].day = Integer.parseInt(info[3]);
                peo[i].order = i;
                pq.offer(peo[i]);
            }

            while (!pq.isEmpty()) {
                peopleInfo pp = pq.poll();
                System.out.println(pp.name);
            }
            sc.close();
        }

    }
