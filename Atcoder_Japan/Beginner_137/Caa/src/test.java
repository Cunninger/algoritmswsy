import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * 功能：
 * 日期：2024/2/18 15:30
 */
public class test {
    public static void main(String[] args) {
        HashMap<String, Integer> map = new HashMap<>();
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        String s1 = sc.next();
        map.put(s, map.getOrDefault(s, 0) + 1);
        map.put(s1, map.getOrDefault(s, 0) + 1);
        for (Map.Entry<String,Integer> c:map.entrySet()){
            System.out.println(c.getKey());
        }
    }


}