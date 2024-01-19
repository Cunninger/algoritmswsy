package camp05;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StreamTokenizer;

import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;

public class Code04_TopKSumCrossTwoArrays_Set_String {

        static class heapNode {
            public int row;
            public int col;
            public int sum;

            public heapNode(int r, int c, int s) {
                row = r;
                col = c;
                sum = s;

            }
        }
        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            // 将 字节流转为字符流
            StreamTokenizer in = new StreamTokenizer(br);
            // 读取标记流，将输入流中的数据按Tab or 空格 or 换行符 分割
            PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out),true);
            // 打印流，把数据打印到 目的地，目的地：由打印流的构造方法决定（屏幕），自动flush

            while (in.nextToken() != StreamTokenizer.TT_EOF) {
                int N = (int)in.nval;

                in.nextToken();// 解析新的标记
                int K = (int)in.nval;// 整型nval 字符串类型sval

                int []arr1 = new int[N];
                int []arr2 = new int[N];

                for (int i = 0; i < N; i++) {
                    in.nextToken();
                    arr1[i] = (int)in.nval;
                }

                for (int i = 0; i < N; i++) {
                    in.nextToken();
                    arr2[i] = (int)in.nval;
                }
                int[]topK = topKSum(arr1, arr2, K);

                for (int i = 0; i < K; i++) {
                    out.print(topK[i] + " ");
                }
                out.println();




            }
        }

        public static int[] topKSum(int[]arr1, int []arr2, int topK) {
            if (arr1 == null || arr2 == null || topK < 1) {
                return null;
            }
            int []res = new int[topK];
            PriorityQueue<heapNode> maxHeap = new PriorityQueue<>((o1,
                                                                   o2)->o2.sum - o1.sum);
            HashSet<String> set = new HashSet<>();
            int N = arr1.length;
            int K = arr2.length;
            maxHeap.add(new heapNode(N - 1, K - 1, arr1[N - 1] + arr2[K - 1]));


            set.add((N - 1) + "_" + (K - 1));
            int resIndex = 0;
            while (resIndex < topK) {
                heapNode curNode = maxHeap.poll();
                res[resIndex++] = curNode.sum;
                int r = curNode.row;
                int c = curNode.col;

                if (r - 1 >= 0 && !set.contains((r - 1) + "_" + c)) {
                    maxHeap.add(new heapNode(r - 1, c, arr1[r - 1] + arr2[c]));
                    set.add((r - 1) + "_" + c);
                }
                if (c - 1 >= 0 && !set.contains(r  + "_" + (c - 1)) ) {
                    maxHeap.add(new heapNode(r, c - 1, arr1[r] + arr2[c - 1]));
                    set.add(r + "_" + (c - 1));
                }

            }

            return res;
        }

    }


























