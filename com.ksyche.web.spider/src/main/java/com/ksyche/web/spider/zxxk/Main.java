package com.ksyche.web.spider.zxxk;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSON;
import com.bj58.wf.util.StringUtil;
import com.ksyche.web.spider.zxxk.impl.ClearFixItemParse;
import com.ksyche.web.spider.zxxk.impl.ListHClearFixParse;
import com.kysche.web.spider.service.ServiceFactory;
import com.kysche.web.spider.service.dao.IZxxkPaperService;
import com.kysche.web.spider.service.dao.impl.IZxxkIndexService;
import com.kysche.web.spider.service.entity.ZxxkPaper;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.ksyche.tools.util.net.http.GZip;
import com.ksyche.tools.util.net.http.HttpClient;
import com.ksyche.tools.util.net.http.HttpRequest;
import com.ksyche.tools.util.net.http.HttpResponse;
import com.kysche.web.spider.service.entity.ZxxkIndexEntity;

public class Main {
  private static final HttpClient client = HttpClient.getInstance(10, 100, 1024*1024*100);

  private static ParseDetail clearFixItemParse = new ClearFixItemParse();
  private static ParseDetail listHClearFixParse = new ListHClearFixParse();

  private static IZxxkIndexService zxxkIndexService= ServiceFactory.createService(IZxxkIndexService.class);
  private static IZxxkPaperService zxxkPaperService = ServiceFactory.createService(IZxxkPaperService.class);
  private static Log log = LogFactory.getLog(Main.class);

//  private static long[] indexIds = {79,90,148,158,211,224,275,283,334,340,380,384,436,439,487,492};
   private static long[] indexIds = {148,158,211,224,275,283,334,340,380,384,436,439,487,492};

  private static int maxCount = 50;
  /**
   * 获得解析数据的parse
   * @param content
   * @return
   */
  public static ParseDetail getParse(String content){
    if(clearFixItemParse.isRightPasre(content)){
      return clearFixItemParse;
    }

    if(listHClearFixParse.isRightPasre(content)){
      return listHClearFixParse;
    }
    return null;
  }


  public static void main(String[] args) throws Exception{
    String baseUrl = "http://www.zxxk.com/";
    HttpRequest request = new HttpRequest(baseUrl);
    request.addHeader("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8");
    request.addHeader("Cookie", "UM_distinctid=15c7207564930-0e9368db7437a8-1263684a-100200-15c7207564c93; softCartList=; Hm_lvt_0e522924b4bbb2ce3f663e505b2f1f9c=1497368445,1497447719,1497667795,1497786587; cn_e016df0f58546c3fa10b_dplus=%7B%22distinct_id%22%3A%20%2215c7207564930-0e9368db7437a8-1263684a-100200-15c7207564c93%22%2C%22initial_view_time%22%3A%20%221496557516%22%2C%22initial_referrer%22%3A%20%22%24direct%22%2C%22initial_referrer_domain%22%3A%20%22%24direct%22%2C%22%24recent_outside_referrer%22%3A%20%22%24direct%22%2C%22%24_sessionid%22%3A%200%2C%22%24_sessionTime%22%3A%201496764180%2C%22%24dp%22%3A%200%2C%22%24_sessionPVTime%22%3A%201496764180%7D; xk.passport=230AB3AFFE1CE17988C9AE1C11AD11B1A4552D1661691B9BE3CF5CCD146DD3C5BF90F2283EACB8902BAF4C400E3F322AD1FFEED2A25F4A47117FAA7FDD0448E7A2FBB6174F5FF2CFA8C4942DC864365FC8E68E2EF14357F6400C0CA3D5B77795C617CB5F84615E435D2912D38F4D13209F0401995B16CFA90A55165AA2327E38A4541660DBADCF884AFC6CDE02541B1E7CB46A699E81A8D69FCED0F2A00E94682555AFCC6A7354F82B28AC1B621C27BD0AA77B0882C797A7B54C4BE2D4B7E28029C9E8BEBC8C69551699E026043986229B8268A1632CF41DF6D0F4B44F88F30FBA55DE77DA641B9842C74253D8D528D75D3D46A6B84AADC07A37C57E06319209E8219C9E0230A461699A91C6D5F48C96EB406822651F84A49D1F17F5BC0708FAFACEB6A1EAF72883D664A0CBA5AB0C33551A306C627B2EB8405A514DE105CF9C195E0196868B169F89FBFF091E5DEE19C7C48592FD3B4AA88B4CF6A292540BD853A509AD7D83B79ADE4A24DBFC79AF53E50646326593DA6CFA886ABFF4D313AA8D91D8A3109C944A4ADDD6B905B97FFC20361C6F4AAAB538A9F0B69447302138FC1DC8D35BB0E1922C3529672ACA21DD689901617ACF1A110A0BF608; xk.passport.uid=26444591; xk.passport.info=%7b%22UserId%22%3a26444591%2c%22UserName%22%3a%22xkw_026444591%22%2c%22Identity%22%3a0%2c%22UserGroupID%22%3a8%2c%22SchoolId%22%3a0%7d; CNZZDATA1759807=cnzz_eid%3D1054771610-1496764951-http%253A%252F%252Fwww.zxxk.com%252F%26ntime%3D1497791098; Hm_lpvt_0e522924b4bbb2ce3f663e505b2f1f9c=1497794250; ASP.NET_SessionId=j5vlokn4dclaqzq0k0xliazu; cn_1759807_dplus=%7B%22distinct_id%22%3A%20%2215c7207564930-0e9368db7437a8-1263684a-100200-15c7207564c93%22%2C%22%24_sessionid%22%3A%200%2C%22%24_sessionTime%22%3A%201497794281%2C%22%24dp%22%3A%200%2C%22%24_sessionPVTime%22%3A%201497794281%7D");
    request.addHeader("User-Agent", "Mozilla/5.0 (Windows NT 10.0; WOW64; rv:53.0) Gecko/20100101 Firefox/53.0");

    HttpResponse res = client.request(request, 60000);
    List<ZxxkIndexEntity> listUrl = getListUrl(res);
    for(ZxxkIndexEntity index : listUrl){
      Map<String, Object> condition = new HashMap<String,Object>();
      condition.put("url", index.getUrl());
      List<ZxxkIndexEntity> list = zxxkIndexService.get(condition , "id desc");
      if(list==null||list.isEmpty()){
        long id = zxxkIndexService.add(index);
        index.setId(id);
      }else{
        index.setId(list.get(0).getId());
      }
    }
    String listUlr = "";
    for(ZxxkIndexEntity entity : listUrl){
      boolean isSpider = false;
      for(int i=0;i<indexIds.length-1;i=i+2){
        if(indexIds[i]<=entity.getId()&&entity.getId()<=indexIds[i+1]){
          isSpider = true;
        }
      }
      if(!isSpider){
        continue;

      }

      int count = 0;
      for(int i=0;;i++){
        if(count>maxCount){
          break;
        }
        listUlr = entity.getUrl();
        if(i>0){
          listUlr = listUlr+"?page="+i;
        }

        request.setUrl(listUlr);
        try {
          res = client.request(request, 60000);
        } catch (Exception e) {
          log.error("request error :"+listUrl,e);
        }
        ParseDetail parse = getParse(res.getContent());
        if(parse==null){
          break;
        }
        List<ZxxkPaper> list = parse.paserFromContent(entity.getId(),res.getContent());
        if(list==null|| list.isEmpty()){
          continue;
        }
        int nullCount = 0;
        for(ZxxkPaper paper : list) {
          //数据库查询一下 看是否已经下载

          ZxxkPaper zxxkPaper = getZxxkPaper(paper.getExamId());
          if(zxxkPaper!=null&&StringUtils.isNotBlank(zxxkPaper.getLocalPath())){
            if(zxxkPaper.getParentId()==0){
                zxxkPaper.setParentId(entity.getId());
                zxxkPaper.setDetailUrl(listUlr);
                zxxkPaper.setParentUrl(entity.getUrl());
                zxxkPaperService.saveOrUpadate(zxxkPaper);
            }
            continue;
          }
          if(paper.getKnowledge1()==null){
            log.info("know ledge null " +JSON.toJSONString(paper));
            continue;
          }
          if("flv".equals(paper.getExt())||"视频".equals(paper.getCategory1())){
            continue;
          }
          paper.setParentUrl(entity.getUrl());
          paper.setDetailUrl(listUlr);
          paper.setParentId(entity.getId());
          String path = DownloadParser.downLoad(paper);
          if(StringUtil.isBlank(path)){
           if(nullCount++ > 10){
             return;
           }
          }else{
            nullCount = 0;
          }
          count ++;
          zxxkPaperService.saveOrUpadate(paper);

        }

      }
    }
    
     
    
  }



  private static List<ZxxkIndexEntity> getListUrl(HttpResponse res) throws UnsupportedEncodingException, Exception {
    List<ZxxkIndexEntity> list = new ArrayList<ZxxkIndexEntity>();
    String body =  new String(GZip.unzip(res.getBody()), "gbk");
    Document document = Jsoup.parse(body);
    Elements elements = document.select("div#navWrapper > div > div.submenu > ul > li");
    for(Element eil : elements){
      ZxxkIndexEntity entity = new ZxxkIndexEntity();
      Element ea = eil.select("h3 > a").first();
      entity.setSubject(ea.text());
      
      Elements divItems = eil.select("div.item");
      for(Element item : divItems){
        Element title = item.select("div.title").first();
        entity.setCategory(title.text());
        Elements ahref = item.select("a[href]");
        for(Element a : ahref){
          ZxxkIndexEntity clone = (ZxxkIndexEntity)entity.clone();
          clone.setIssuse(a.text());
          clone.setUrl(a.attr("href"));
          list.add(clone);
        }
        
      }
      
    }
    return list;
  }

  private static ZxxkPaper getZxxkPaper(String examId){
    if(StringUtil.isBlank(examId)){
      return null;
    }
    Map<String,Object> condition = new HashMap<>();
    condition.put("examId",examId);
    try {
      List<ZxxkPaper> zxxkPapers = zxxkPaperService.get(condition, "id desc");
      if(zxxkPapers!=null&&zxxkPapers.size()>0){
        return zxxkPapers.get(0);
      }
    } catch (Exception e) {
      log.error("get paper error " ,e);
    }
    return null;
  }

  
}
