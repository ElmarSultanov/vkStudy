package kz.home.vk;

import com.google.gson.Gson;
import com.vk.api.sdk.client.TransportClient;
import com.vk.api.sdk.client.VkApiClient;
import com.vk.api.sdk.httpclient.HttpTransportClient;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

import java.util.ArrayList;

public class Launcher {


    public static void main(String[] args) {
        TransportClient transportClient = HttpTransportClient.getInstance();
        VkApiClient vk = new VkApiClient(transportClient, new Gson(), 1);
        HttpGet request = null;
            final String[] websiteUrls = {"https://vk.com/arka_club",
                    "https://vk.com/public199537895"};
            HttpClient client = HttpClientBuilder.create().build();
            posts = new ArrayList<>();
            for (String websiteUrl : websiteUrls) {
                System.out.println("URL: " + websiteUrl);
                request = new HttpGet(websiteUrl);

                request.addHeader("User-Agent", "Apache HTTPClient");
                HttpResponse response = client.execute(request);

                HttpEntity entity = response.getEntity();
                String content = EntityUtils.toString(entity);
                VKParser parser = new VKParser();
                posts.addAll(parser.getPostFromContent(content));
    }
}
