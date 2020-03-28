package com.soft1851.spring.webAnnotation.spider;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.soft1851.spring.webAnnotation.entity.Rank;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhao
 * @className BiLiBiLiSpider
 * @Description TODO
 * @Date 2020/3/27
 * @Version 1.0
 **/
public class BiLiBiLiSpider {

    private static final Integer SUCCESS = 200;

    public static List<Rank> getRanks(){
        List<Rank> ranks = new ArrayList<>();
        String userAgent = "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/80.0.3987.116 Safari/537.36";
        String url = "https://www.bilibili.com/ranking";
        CloseableHttpClient httpClient = HttpClients.createDefault();
        try {
            Thread.sleep(4000);
            HttpGet httpget = new HttpGet(url);
            httpget.setHeader("User-Agent",userAgent);
            HttpClientContext context = HttpClientContext.create();
            CloseableHttpResponse response = httpClient.execute(httpget,context);
            System.out.println(response.getStatusLine());

            int statusCode = response.getStatusLine().getStatusCode();
            if (statusCode == SUCCESS){
                HttpEntity entity = response.getEntity();
                if (entity != null){
                    String res = EntityUtils.toString(entity);
                    Document document = Jsoup.parse(res);
//                    Elements elements = document.getElementsByClass("rank-item");
//                    for (Element element : elements){
//                        String num = element.child(0).text();
//                        Element contentEle = element.child(1);
//                        String title = contentEle.select(".title").text();
//                        Elements img = contentEle.select(".lazy-img img");
//                        String cover = img.attr("src");
//                        Rank rank = Rank.builder().id(Integer.parseInt(num)).title(title).cover(cover).build();
//                        ranks.add(rank);
//                    }

                    Elements scripts = document.getElementsByTag("script");
                    String wholeDate = scripts.get(5).html();
                    String data = wholeDate.substring(wholeDate.indexOf("rankList") + 10,wholeDate.indexOf("rankRouteParams") - 2);
                    JSONArray jsonArray = JSONArray.parseArray(data);
                    jsonArray.forEach(o ->{
                        JSONObject json = JSONObject.parseObject(o.toString());
                        Rank rank = Rank.builder()
                                .title(json.getString("title"))
                                .author(json.getString("author"))
                                .pic(json.getString("pic"))
                                .duration(json.getString("duration"))
                                .build();
                        ranks.add(rank);
                    });
                }
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        return ranks;
    }

    public static void main(String[] args) {
//        for (Rank rank : getRanks()){
//            System.out.println(rank);
//        }
        List<Rank> ranks = getRanks();
        ranks.forEach(System.out::println);
    }
}
