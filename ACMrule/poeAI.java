package ACMrule;

import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * 功能：
 * 日期：2024/2/20 16:06
 */
public class poeAI {

    public static void main(String[] args) throws Exception {
        // 创建URL对象
        URL url = new URL("https://api.freegpt4.tech/v1/chat/completions");

        // 打开连接并强制转换为HttpURLConnection
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();

        // 设置请求方法为POST
        conn.setRequestMethod("POST");

        // 设置请求头
        conn.setRequestProperty("Content-Type", "application/json");
        conn.setRequestProperty("Authorization", "Bearer fg4-rKJD1K0Iy9dlRnJlZUdQVDQflaEknqgt-59");

        // 设置可以发送数据
        conn.setDoOutput(true);

        // 发送数据
        String data = "{ \"model\": \"gpt-4\", \"messages\": [ { \"role\": \"user\", \"content\": \"鲁迅为什么打周树人？\" } ], \"stream\": false }";
        try (OutputStream os = conn.getOutputStream()) {
            byte[] input = data.getBytes("utf-8");
            os.write(input, 0, input.length);
        }

        // 获取响应码
        int responseCode = conn.getResponseCode();
        System.out.println("POST Response Code :: " + responseCode);

        conn.disconnect();
    }
}

