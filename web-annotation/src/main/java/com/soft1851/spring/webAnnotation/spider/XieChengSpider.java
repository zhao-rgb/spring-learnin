package com.soft1851.spring.webAnnotation.spider;

import com.soft1851.spring.webAnnotation.entity.Travel;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhao
 * @className XieChengSpider
 * @Description TODO
 * @Date 2020/3/27
 * @Version 1.0
 **/
public class XieChengSpider {

    private static final Integer SUCCESS = 200;

    public static List<Travel> getTravels(){
        List<Travel> travels = new ArrayList<>();
        String userAgent = "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/80.0.3987.116 Safari/537.36";
        String url = "https://you.ctrip.com/travels/";
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
                if (entity != null){
                    String res = EntityUtils.toString(entity);
                    Document document = Jsoup.parse(res);
                    Elements elements = document.getElementsByClass("city");

                    for(Element element : elements){
                        Element cityImageEle = element.child(1);
                        Elements image = cityImageEle.select(".pic");
                        //城市图片
                        String cityImage = image.attr("src");

                        Element citySubEle = element.child(2);
                        //城市名字
                        String cityName = citySubEle.select(".city-name").text();
                        //标题
                        String title = citySubEle.select(".cpt").text();
                        //浏览、喜欢、回复
                        String view = citySubEle.select(".numview").text();
                        String want = citySubEle.select(".want").text();
                        String reply = citySubEle.select(".numreply").text();

                        Element authorEle = element.child(3);
                        Elements aImage = authorEle.select(".pic");
                        //作者图片
                        String authorImg = aImage.attr("src");
                        //作者名字
                        String authorName = element.child(3).child(0).child(1).text();
                        //时间
                        String time = authorEle.select(".time").text();

                        Travel travel = Travel.builder().cityImage(cityImage).cityName(cityName).title(title).numView(Integer.parseInt(view))
                                .want(Integer.parseInt(want)).numReply(Integer.parseInt(reply)).authorImg(authorImg).authorName(authorName)
                                .time(time).build();
                        travels.add(travel);
                    }
                }
            }

        } catch (Exception e){
            e.printStackTrace();
        }

        return travels;
    }

    public static void main(String[] args) {
        for (Travel travel : getTravels()){
            System.out.println(travel);
        }
    }
}
