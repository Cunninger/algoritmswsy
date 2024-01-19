package camp05;
import java.util.*;

public class wordMinPaths {

    public static List<List<String>> findMinPaths(
          String start,
          String end,
          List<String> list
    ) {
        list.add(start);
        HashMap<String, ArrayList<String>> nexts = getNexts(list);
        // next是一个map，key是当前节点，value是当前节点的下一层节点
       // HashMap<String, Integer> distances = getDistances(start, nexts);
        // distances是一个map，key是当前节点，value是当前节点到start的距离
        // abc - abd - acd
        // abc -> acd = 2

        HashMap<String, Integer> distances = getDistances(start, nexts);
        // 每个节点到start的距离

        LinkedList<String> pathList = new LinkedList<>();
        // pathList是一个双端队列，用来存储当前路径,宽度 优先遍历
        List<List<String>> res = new ArrayList<>();
        // res是一个list，用来存储所有的最短路径

        getShortestPaths(start, end, nexts, distances, pathList, res);
        return res;
    }

    public static HashMap<String, ArrayList<String>> getNexts(List<String> words) {
        // 函数作用：求出每个字符串节点的下一层节点
        // 参数：一个字符串list
        // 返回值：一个map，key是当前节点，value是当前节点的下一层节点

        Set<String> dict = new HashSet<>(words);// 将words转换成set，方便查找
                                                // 比如：words = ["abc","abd","acd"]   dict = {"abc","abd","acd"}

        HashMap<String, ArrayList<String>> nexts = new HashMap<>();
                                                // nexts作用：存储每个节点的下一层节点
        for (int i = 0; i < words.size(); i++) {
            nexts.put(words.get(i), getNext(words.get(i), dict));
        }                                       // 遍历words，将每个节点的下一层节点存入nexts
                                                // 比如：nexts = {"abc":["abd","acd"],"abd":["abc","acd"],"acd":["abc","abd"]}
        return nexts;

    }

    private static ArrayList<String> getNext(String word, Set<String> dict) {
        // 函数作用：求出当前节点的下一层节点
        // 跟getNexts函数的区别是：getNexts函数是遍历words，getNext函数是遍历当前节点的每个字符！！

        // 函数参数：当前节点，字典
        // 比如：word = "abc"  dict = {"abc","abd","acd"}

        // 函数返回值：当前节点的下一层节点
        // 比如：返回值 = ["abd","acd"]


        ArrayList<String> res = new ArrayList<>();// 存储当前节点的下一层节点
        char[] chs = word.toCharArray();// 将当前节点转换成字符数组
        for (char cur = 'a';cur<='z';cur++){
            for (int i = 0;i<chs.length;i++){
                if (chs[i] != cur){
                    char tmp = chs[i];// 将当前字符保存起来，有什么作用？ 用来恢复当前节点
                    chs[i] = cur;
                    if (dict.contains(String.valueOf(chs))){
                        res.add(String.valueOf(chs));
                    }// 如果当前节点的下一层节点在字典中，就将其加入res
                    chs[i] = tmp;// 恢复当前节点
                }

            }
        }            // 遍历当前字符串节点的每个字符，将当前字符换成a-z中的每个字符，看是否在字典中
        return res;
    }

    public static HashMap<String,Integer> getDistances(String start,HashMap<String,ArrayList<String>>nexts){
        // 函数作用：求出每个节点到start的距离
        // 函数参数：start节点，nexts
        // 函数返回值：一个map，key是当前节点，value是当前节点到start的距离

        HashMap<String,Integer> distances = new HashMap<>();

        distances.put(start,0);// 将start节点到start的距离设为0


        Queue<String> queue = new LinkedList<>();// 定义一个队列，用来存储当前节点的下一层节点
        // 宽度优先遍历

        queue.add(start);

        HashSet<String> set = new HashSet<>();// 定义一个set，用来存储已经遍历过的节点

        set.add(start);

        while  (!queue.isEmpty()){
            String cur = queue.poll();
            for (String next : nexts.get(cur)){                 // 遍历当前节点的下一层节点
                if (!set.contains(next)){                       // 如果当前节点没有被遍历过
                    distances.put(next,distances.get(cur)+1);   // 将当前节点到start的距离设为 当前节点的上一层节点到start的距离+1
                    queue.add(next);                            // 将当前节点加入队列
                    set.add(next);                              // 将当前节点加入set,说明已遍历
                }
            }
        }

        return  distances;
    }

    private static void getShortestPaths(
            String cur,                             // 当前节点
            String to,                              // 目标节点
            HashMap<String,ArrayList<String>> nexts,// 每个节点的下一层节点
            HashMap<String,Integer> distances,      // 每个节点到start的距离
            LinkedList<String> path,                // 当前路径
            List<List<String>> res                  // 所有的最短路径
    ){
        path.add(cur);                              // 将当前节点加入当前路径
        if (to.equals(cur)){                        // 如果当前节点是目标节点
            res.add(new LinkedList<>(path));        // 将当前路径加入res
        }else{
            for (String next:nexts.get(cur)){       // 遍历当前节点的下一层节点
                if (distances.get(next)==distances.get(cur)+1){ //  如果当前节点的下一层节点到start的距离是当前节点到start的距离+1
                    getShortestPaths(next,to,nexts,distances,path,res);  // 递归调用
                }
            }

        }
        path.pollLast();                            // 将当前节点从当前路径中删除,回溯
    }

    public static void main(String[] args) {
        String start = "abc";
        String end = "acd";
        List<String> list = new ArrayList<>();
        list.add("abc");
        list.add("abd");
        list.add("acd");
        list.add("bcd");
        list.add("bce");
        list.add("cde");
        list.add("cdd");
        list.add("cda");
        list.add("cdd");
        list.add("cdc");
        list.add("cdd");
        list.add("cde");
        list.add("cdd");
        list.add("cda");
        list.add("cdd");
        list.add("cdc");
        list.add("cdd");
        list.add("cde");
        list.add("cdd");
        list.add("cda");
        list.add("cdd");
        list.add("cdc");
        list.add("cdd");
        list.add("cde");
        list.add("cdd");
        list.add("cda");
        list.add("cdd");
        list.add("cdc");
        list.add("cdd");
        list.add("cde");
        list.add("cdd");
        list.add("cda");
        list.add("cdd");
        list.add("cdc");
        list.add("cdd");
        list.add("cde");
        list.add("cdd");
        list.add("cda");
        list.add("cdd");
        list.add("cdc");
        list.add("cdd");
        list.add("cde");
        list.add("cdd");
        list.add("cda");
        list.add("cdd");
        list.add("cdc");
        list.add("cdd");
        list.add("cde");
        list.add("cdd");
        list.add("cda");
        list.add("cdd");
        list.add("cdc");
        list.add("cdd");
        list.add("cde");
        list.add("cdd");
        list.add("cda");
        list.add("cdd");
        list.add("cdc");
        list.add("cdd");
        list.add("cde");
        List<List<String>> res = findMinPaths(start,end,list);
        System.out.println(res);
    }








}
