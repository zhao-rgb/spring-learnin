package com.soft1851.spring.mybatis.splider;

import com.alibaba.fastjson.JSONObject;
import com.soft1851.spring.mybatis.entity.Music;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author zhao
 * @className lp
 * @Description TODO
 * @Date 2020/4/3
 * @Version 1.0
 **/
public class lp {
    private static final Integer SUCCESS = 200;

    public static List<Music> getMusics(){
            List<Music> musics = new ArrayList<>();
            //网易云音乐链接请求头
            String userAgent = "Mozilla/5.0 (Linux; Android 6.0; Nexus 5 Build/MRA58N) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/80.0.3987.162 Mobile Safari/537.36";
            String url = "https://music.163.com/m/discover/toplist?id=991319590";
            CloseableHttpClient httpClient = HttpClients.createDefault();
            HttpPost httpPost = new HttpPost(url);
            //设置请求头
            httpPost.setHeader("User-Agent", userAgent);
            HttpClientContext context = HttpClientContext.create();
            try {
                CloseableHttpResponse response = httpClient.execute(httpPost, context);
                int statusCode = response.getStatusLine().getStatusCode();
                if(statusCode==SUCCESS){
                    HttpEntity entity = response.getEntity();
                    String res= null;
                    res = EntityUtils.toString(entity, "UTF-8");
                    Document document = Jsoup.parse(res);
                    Elements elements = document.getElementsByClass("m-sglst");
                    for(Element element :elements){
                        for(int i=0;i<element.childNodeSize();i++){
                            //获取每首音乐的id
                            String musicId =element.child(i).attr("href").replace("//music.163.com/m/song?id=","");
                            //获取每首音乐的名字
                            String musicName = element.child(i).child(1).child(0).getElementsByClass("f-thide sgtl").text();
                            //获取每首音乐的作者
                            String author =element.child(i).child(1).child(0).getElementsByClass("f-thide sginfo").text();
                            //获取MKOnlinePlayer的对应json链接
                            String musicUrl = "http://music.uixsj.cn/api.php?callback=jQuery1113034466587161790607_1585798563762&types=url&id="+musicId+"&source=netease";
                            //获取音乐的下载链接
                            String downloadUrl=getUrl(musicUrl);
                            Music music = Music.builder().id(Integer.parseInt(musicId))
                                    .url(downloadUrl)
                                    .musicName(musicName)
                                    .build();
                            musics.add(music);


                        }
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        return musics;
    }

    public static String getUrl(String url){
        HttpGet get = new HttpGet(url);
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpClientContext context = HttpClientContext.create();
        CloseableHttpResponse response = null;
        try {
            response = httpClient.execute(get, context);
        } catch (IOException e) {
            e.printStackTrace();
        }
        if(response.getStatusLine().getStatusCode()==SUCCESS){
            HttpEntity entity = response.getEntity();
            String res = null;
            try {
                res = EntityUtils.toString(entity, "UTF-8");
            } catch (IOException e) {
                e.printStackTrace();
            }
            String[]  str=res.replace(")","(").split("\\(");
            String jsonContent = str[1];
            JSONObject jsonObject = JSONObject.parseObject(jsonContent);
            return jsonObject.get("url").toString();
        }
        System.out.println("获取失败");
        return null;
    }

    public static void main(String[] args) {
        System.out.println(getMusics());
    }
}
