package ACMrule;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

/**
 * 功能：
 * 日期：2024/2/21 8:26
 */

public class Translator {

    public static void main(String[] args) throws Exception {

        // 创建一个HttpClient对象
        CloseableHttpClient httpclient = HttpClients.createDefault();

        // 创建一个HttpPost对象
        HttpPost httpPost = new HttpPost("https://api.deepl.com/v2/translate");

        // 设置请求头
        httpPost.addHeader("Authorization", "DeepL-Auth-Key [2a9c6a95-2fdf-432f-a443-d9700f2af3b5]");
        httpPost.addHeader("User-Agent", "YourApp/1.2.3");
        httpPost.addHeader("Content-Type", "application/x-www-form-urlencoded");

        // 设置请求体
        StringEntity entity = new StringEntity("text=Hello%2C%20world!&target_lang=DE");
        httpPost.setEntity(entity);

        // 发送请求
        CloseableHttpResponse response = httpclient.execute(httpPost);

        try {
            // 打印响应状态
            System.out.println(response.getStatusLine());

            // 打印响应内容
            System.out.println(EntityUtils.toString(response.getEntity()));
        } finally {
            response.close();
        }
    }
}
