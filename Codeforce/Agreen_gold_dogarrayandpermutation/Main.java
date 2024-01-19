package Codeforce.Agreen_gold_dogarrayandpermutation;

import java.util.*;
import java.io.*;

public class Main {
    static class Node{
        int value;
        int index;

        public Node(int value, int index) {
            this.value = value;
            this.index = index;
        }


    }

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);
        int cnt = in.nextInt();


        while (cnt-- > 0) {
            int n = in.nextInt();
            Node[] nodes = new Node[n];
            for (int i = 0; i < n; i++) {
                nodes[i] = new Node(in.nextInt(), i);
            }

            Arrays.sort(nodes,(o1,o2)->(o1.value-o2.value));
            // 看看

            int[] ranks = new int[n];
            for (int i = 0; i < n; i++) {
                ranks[nodes[i].index] = n - i;
            }

            for (int i = 0; i < n; i++) {
                out.print(ranks[i] + " ");
            }
            out.println();
        }

        out.flush();
        out.close();
    }
}
