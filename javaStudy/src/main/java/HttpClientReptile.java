import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.conn.HttpClientConnectionManager;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;


import java.io.IOException;

import java.util.ArrayList;
import java.util.List;


/**
 * @projectName: vhr-master
 * @className: HttpClientReptile
 * @author: WenYichong
 * @date: 2019/9/4-16:54
 * @description: Java 爬虫......
 */
public class HttpClientReptile {

//    @Test
    public static void main(String[] args) throws IOException {

        /*1确定url*/
        String url = "https://sou.zhaopin.com/?jl=822&sf=0&st=0";
        /*2发起请求获取数据：httpClient*/
        /*2.1.创建httpclient对象*/
        CloseableHttpClient httpClient = HttpClients.createMinimal();



        /*2.2创建请求方式get*/
        HttpGet httpGet = new HttpGet(url);
        /* 2.3 发起请求获得响应*/
        String html = "";
        CloseableHttpResponse response = null;
        try {
            response = httpClient.execute(httpGet);
            html = EntityUtils.toString(response.getEntity(), "utf-8");
        } catch (IOException e) {
            e.printStackTrace();
        }
        /*3.解析数据: jsoup*/
        Document document = Jsoup.parse(html);
//        Document document = Jsoup.connect(url).userAgent("Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko)Chrome/52.0.2743.116 Safari/537.36").get();

        //2. 从Document中找到id=newlist_list_content_table的element
//        Elements title = document.getElementsByClass("contentpile__content__wrapper__item__info__box__jobname__title");
        Elements title = document.getElementsByClass("contentpile__content__wrapper__item__info__box__jobname__title");
//          直接获取整个table的内容
//          System.out.println("tables="+tables);
        org.jsoup.select.Elements trs = document.select("table").select("tr");
        List<Object[]> list = new ArrayList<>();
    }
}