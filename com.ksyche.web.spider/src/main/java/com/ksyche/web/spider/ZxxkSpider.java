package com.ksyche.web.spider;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.ksyche.tools.util.net.http.HttpClient;
import com.ksyche.tools.util.net.http.HttpRequest;
import com.ksyche.tools.util.net.http.HttpResponse;
import com.kysche.web.spider.service.entity.ZxxkPaper;

public class ZxxkSpider {

  static String url = "http://high.school.zxxk.com/jc/channel-13/class-32.html?department=3";
  
  String downloadUrl = "http://m.zxxk.com/DownloadSoft/%s/null";
  
  String mobileDetailUrl = "http://m.zxxk.com/soft/%s.html";
  
  private static final HttpClient client = HttpClient.getInstance(10, 100, 1024*1024*100);

  private static Log log = LogFactory.getLog(Main.class);
  

  public List<ZxxkPaper> getList(String content){
    if(StringUtils.isBlank(content)){
      return null;
    }
    Document document = Jsoup.parse(content);
    Elements elements = document.select("div[class=list_h border]");
    List<ZxxkPaper> list = new ArrayList<ZxxkPaper>();
    for(Element element :elements ){
      ZxxkPaper zxxkPaper = new ZxxkPaper();
      
      Elements lis = element.select("div[class=left attribute] > ul > li");
      for(Element e : lis){
        Element eStrong = e.select("strong").first();
        if(eStrong.text().contains("教材")){
          Elements aElements = e.select("a");
          for(Element a : aElements){
            zxxkPaper.setType(a.attr("title"));
          }
        }
        
        if(eStrong.text().contains("分类")){
          Elements aElements = e.select("a");
          for(Element a : aElements){
            zxxkPaper.setCategory(a.attr("title"));
          }
        }
      }
      
        
      Element aName = element.select("a[name=btnFavorite]").first();
      zxxkPaper.setName(aName.attr("xkw-fav-title"));
      
      String id = aName.attr("id");
      if(StringUtils.isNotBlank(id)&&id.indexOf("_")>-1){
        zxxkPaper.setId(Long.parseLong(id.split("[_]")[1]));
        zxxkPaper.setDetailUrl(String.format(mobileDetailUrl, zxxkPaper.getId()));
      } 
      Object json = JSON.toJSON(zxxkPaper);
      System.out.println(json.toString());
      list.add(zxxkPaper);
    }
    
    
    return list;
  } 
  
  private String getDownloadUrl(String detailContent,ZxxkPaper paper) throws Exception{
    if(StringUtils.isBlank(detailContent)){
      return null;
    }
    String downUrl = null;
    Document document = Jsoup.parse(detailContent);
    Elements elements = document.select("input#SIsoftId");
    if(elements!=null&&elements.size()>0){
     String id = elements.get(0).attr("value");
     downUrl = String.format(downloadUrl, id);
    }
    Element first = document.select("input#SIsoftTitleWithSuffix").first();
    paper.setName(first.attr("value"));
    return downUrl;
  }
  
  
  public static void main(String[] args) {
    ZxxkSpider zs = new ZxxkSpider();
    try {
      HttpRequest request = new HttpRequest(url);
      request.addHeader("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8");
      request.addHeader("Cookie", "UM_distinctid=15c7207564930-0e9368db7437a8-1263684a-100200-15c7207564c93; UT1=ut-19093-94i3tJfMKm; CNZZDATA1759807=cnzz_eid%3D419242744-1496581336-%26ntime%3D1496759551; softCartList=6323554; 66334___317315_KS_66334___317315=474d25e6c68048c6ae315409feffc8b2; Hm_lvt_0e522924b4bbb2ce3f663e505b2f1f9c=1496584496; Hm_lpvt_0e522924b4bbb2ce3f663e505b2f1f9c=1496766404; 66334___317315_curPageNum=1; xk.school.schooluser=false; cn_1759807_dplus=%7B%22distinct_id%22%3A%20%2215c7207564930-0e9368db7437a8-1263684a-100200-15c7207564c93%22%2C%22%24_sessionid%22%3A%200%2C%22%24_sessionTime%22%3A%201496764772%2C%22%24dp%22%3A%200%2C%22%24_sessionPVTime%22%3A%201496764772%7D; cn_e016df0f58546c3fa10b_dplus=%7B%22distinct_id%22%3A%20%2215c7207564930-0e9368db7437a8-1263684a-100200-15c7207564c93%22%2C%22initial_view_time%22%3A%20%221496557516%22%2C%22initial_referrer%22%3A%20%22%24direct%22%2C%22initial_referrer_domain%22%3A%20%22%24direct%22%2C%22%24recent_outside_referrer%22%3A%20%22%24direct%22%2C%22%24_sessionid%22%3A%200%2C%22%24_sessionTime%22%3A%201496764180%2C%22%24dp%22%3A%200%2C%22%24_sessionPVTime%22%3A%201496764180%7D; xk.passport=230AB3AFFE1CE17988C9AE1C11AD11B1A4552D1661691B9BE3CF5CCD146DD3C5BF90F2283EACB8902BAF4C400E3F322AD1FFEED2A25F4A47117FAA7FDD0448E7A2FBB6174F5FF2CFA8C4942DC864365FC8E68E2EF14357F6400C0CA3D5B77795C617CB5F84615E435D2912D38F4D13209F0401995B16CFA90A55165AA2327E38A4541660DBADCF884AFC6CDE02541B1E7CB46A699E81A8D69FCED0F2A00E94682555AFCC6A7354F82B28AC1B621C27BD0AA77B0882C797A7B54C4BE2D4B7E28029C9E8BEBC8C69551699E026043986229B8268A1632CF41DF6D0F4B44F88F30FBA55DE77DA641B9842C74253D8D528D75D3D46A6B84AADC07A37C57E06319209E8219C9E0230A461699A91C6D5F48C96EB406822651F84A49D1F17F5BC0708FAFACEB6A1EAF72883D664A0CBA5AB0C33551A306C627B2EB8405A514DE105CF9C195E0196868B169F89FBFF091E5DEE19C7C48592FD3B4AA88B4CF6A292540BD853A509AD7D83B79ADE4A24DBFC79AF53E50646326593DA6CFA886ABFF4D313AA8D91D8A3109C944A4ADDD6B905B97FFC20361C6F4AAAB538A9F0B69447302138FC1DC8D35BB0E1922C3529672ACA21DD689901617ACF1A110A0BF608; xk.passport.uid=26444591; xk.passport.info=%7b%22UserId%22%3a26444591%2c%22UserName%22%3a%22xkw_026444591%22%2c%22Identity%22%3a0%2c%22UserGroupID%22%3a8%2c%22SchoolId%22%3a0%7d");
      request.addHeader("User-Agent", "Mozilla/5.0 (Windows NT 10.0; WOW64; rv:53.0) Gecko/20100101 Firefox/53.0");

      HttpResponse res = client.request(request, 60000);
      List<ZxxkPaper> list = zs.getList(res.getContent());
      for(ZxxkPaper paper:list){
        request.setUrl(paper.getDetailUrl());
        res =  client.request(request, 60000);
        String downloadUrl2 = zs.getDownloadUrl(res.getContent(),paper);
        request.setUrl(downloadUrl2);
        res =  client.request(request, 60000);
        
        String donwContent = res.getContent();
        JSONObject jo = JSONObject.parseObject(donwContent);
        if(jo==null||jo.get("Data")==null||StringUtils.isBlank(jo.getString("Data"))){
          System.out.println("-----"+jo);
          continue;

        }
        String data = jo.getString("Data");
        System.out.println(data);
        
        request.setUrl(data);
        res =  client.request(request, 100000);
        zs.writer2File(res.getBody(),paper.getName());
      }
      
    } catch (Exception e) {
      // TODO Auto-generated catch block
      log.info("download error",e);

    }
  }
  
  public void writer2File(byte[] body,String name) {
    FileOutputStream fos = null;
    try{
    File f = new File("D:/home/paper/"+name);
      if(!f.exists()){
        f.createNewFile();
      }
      fos = new FileOutputStream(f);
      fos.write(body);
    }catch(Exception e){
      log.info("download error",e);
    }finally{
      try {
        fos.close();
      } catch (IOException e) {
        // TODO Auto-generated catch block
        log.info("download error",e);

      }
    }
  }
  
}
