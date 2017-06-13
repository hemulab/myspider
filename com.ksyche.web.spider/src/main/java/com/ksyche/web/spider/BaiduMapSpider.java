package com.ksyche.web.spider;

import java.net.URLEncoder;
import java.util.Date;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.alibaba.fastjson.JSON;
import com.ksyche.tools.util.net.http.HttpClient;
import com.ksyche.tools.util.net.http.HttpResponse;
import com.ksyche.web.spider.bll.CityBLL;
import com.ksyche.web.spider.vo.BaiduResultList;
import com.kysche.web.spider.service.ServiceFactory;
import com.kysche.web.spider.service.dao.impl.IBaiduWeixiuEntityService;
import com.kysche.web.spider.service.entity.BaiduWeixiuEntity;
import com.kysche.web.spider.service.entity.City;

public class BaiduMapSpider {

	private CityBLL cityBLL = new CityBLL();
	
	private String url = "http://api.map.baidu.com/place/v2/search";
	
	private String ak = "H0HoT7pDEHBW9gIhvsx4ALbI";
	private String sk = "EjCdurFsfIWnh2CpgjUeuRcafAek6zuP";
	private HttpClient client = HttpClient.getInstance();
	private Log log = LogFactory.getLog(BaiduMapSpider.class);
			
	
	public BaiduResultList parseDetail(int page,String city) throws Exception{
		Thread.sleep(3000);
		StringBuffer sbUrl = new StringBuffer(url);
		sbUrl.append("?ak=").append(ak);
		sbUrl.append("&scope=1");
		sbUrl.append("&q=").append(URLEncoder.encode("汽车维修","utf-8"));
		sbUrl.append("&output=json&region=").append(URLEncoder.encode(city,"utf-8"));
		sbUrl.append("&page_size=20&page_num=").append(page);
		HttpResponse res = new HttpResponse();
		try{
			res = client.get(sbUrl.toString(),10*1000);
		}catch(Exception e){
			log.error("res error",e);
			return null;
		}
		System.out.println(res.getContent());
		BaiduResultList list = JSON.parseObject(res.getContent(), BaiduResultList.class);
	
		return list;
	}
	
	private IBaiduWeixiuEntityService baiduService = ServiceFactory.createService(IBaiduWeixiuEntityService.class);
	
	public long save(List<BaiduWeixiuEntity> list ,City city) throws Exception{
		if(list==null||list.isEmpty()){
			return 0;
		}
		for(BaiduWeixiuEntity entity : list){
			entity.setCity(city.getCnname());
			entity.setPid(city.getParentid());
			entity.setDt(new Date());
		}
		return baiduService.add(list);
	}
	
	public void spider() throws Exception{
		List<City> citys = cityBLL.getCitys();
		for(City c: citys){
			if(c.getId()<=15117||c.getCnname().equals("北京")||"天津".equals(c.getCnname())||"上海".equals(c.getCnname())){
				continue;
			}
			BaiduResultList list = parseDetail(0,c.getCnname());
			if(list==null){
				continue;
			}
			int total = list.getTotal();
			save(list.getResults(),c);
			for(int page=1; total>=page*20;page++){
				list = parseDetail(page,c.getCnname());
				if(list==null){
					continue;
				}
				 total = list.getTotal();
				save(list.getResults(),c);
				log.info(page*20 +"  "+ total);
			}
		}
	}
	
}
