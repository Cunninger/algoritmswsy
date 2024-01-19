package draft;

public class xorTest {

    public static void main(String[] args) {
        int num = 10;
        for (int i = 31;i>=0;i--) {
            System.out.print(((num >> i) & 1) + " ");

        }

    }
}
