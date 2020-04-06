package com.soft1851.spring.mybatis.splider;

import com.soft1851.spring.mybatis.entity.Music;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhao
 * @className MusicSplider
 * @Description TODO
 * @Date 2020/4/2
 * @Version 1.0
 **/
public class MusicSplider {
    private static final Integer SUCCESS = 200;

    public static List<Music> getMusics(){
        List<Music> musics = new ArrayList<>();
        String userAgent = "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/80.0.3987.116 Safari/537.36";
        String url = "https://music.163.com/#/discover/toplist?id=3779629";
        CloseableHttpClient httpClient = HttpClients.createDefault();

        try{
            Thread.sleep(4000);
            HttpGet httpget = new HttpGet(url);
            httpget.setHeader("User-Agent",userAgent);
            HttpClientContext context = HttpClientContext.create();
            CloseableHttpResponse response = httpClient.execute(httpget,context);
            System.out.println(response.getStatusLine());

            int statusCode = response.getStatusLine().getStatusCode();
            if (statusCode == SUCCESS){
                HttpEntity entity = response.getEntity();
                if (entity != null) {
                    String res = EntityUtils.toString(entity);
                    Document document = Jsoup.parse(res);
//                    Elements elements = document.;
                }


            }

        } catch (Exception e){
            e.printStackTrace();
        }

        return musics;
    }
    public static void main(String[] args) {
        System.out.println(getMusics());
    }
}
