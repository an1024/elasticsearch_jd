package com.elasticsearch.utils;

import com.elasticsearch.pojo.Content;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class HtmlParesUtil {

    public List<Content> parseJD(String keywords) throws IOException {
        //获取请求
        String url = "https://search.jd.com/Search?keyword=" + keywords +"&enc=utf-8";
        //解析网页，返回的就是浏览器的document对象
        Document document = Jsoup.parse(new URL(url), 30000);
        Element element = document.getElementById("J_goodsList");
        Elements elements = element.getElementsByTag("li");

        ArrayList<Content> goodsList = new ArrayList<>();
        for (Element el : elements) {
            String img = el.getElementsByTag("img").eq(0).attr("src");
            String price = el.getElementsByTag("strong").eq(0).text();
            String title = el.getElementsByClass("p-name").eq(0).text();

            Content content = new Content();
            content.setTitle(title);
            content.setImg(img);
            content.setPrice(price);
            goodsList.add(content);
        }
        return goodsList;
    }

    //测试
//    public static void main(String[] args) throws IOException {
//        new HtmlParesUtil().parseJD("技术").forEach(System.out::println);
//    }
}
