package com.ksyche.web.spider;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.Test;

import com.ksyche.tools.util.net.http.HttpClient;
import com.ksyche.web.spider.bll.MaintenanceBLL;
import com.kysche.web.spider.service.entity.ModelEntity;
import com.kysche.web.spider.service.entity.YixiucheMaintenace;
import com.kysche.web.spider.service.enums.YixiucheTypeEnum;

public class YixiucheSpider {
	
	private static MaintenanceBLL maintenanceBLL = new MaintenanceBLL();
	private static final HttpClient client = HttpClient.getInstance();
	String seriesUrl = "http://www.yixiuche.com/ac/carmodel.html?action=selectcar&ajaxcardata=ajaxcardata&getserieses=ADQC&ajax=ajax";
	
	public String getHome() throws Exception{
		String mainUrl = "http://www.yixiuche.com/";
		String content = client.get(mainUrl,20000).getContent();
		return content;
	}
	
	public List<ModelEntity> getBrands(String content){
		//#td > div > div.ppdiv > div.pinpai > ul:nth-child(1) > a > li > span:nth-child(1)
		List<ModelEntity> list = new ArrayList<ModelEntity>();
		String brand_A_Path = "html body div#bottom div#carbox div#td.baisebeijing div.carStepLayer div.ppdiv div.pinpai ul";
//		String brand_A_Path = "#td > div > div.ppdiv > div.pinpai > ul >a";
		Document doc = Jsoup.parse(content); 
		Elements eles = doc.select(brand_A_Path);
		for(Element ele : eles){
			String info = ele.select("a").attr("keyvalue");
			String name = ele.select("li > span:nth-child(1)").html();
			ModelEntity me = new ModelEntity();
			me.setName(name);
			me.setInfo(info);
			me.setPath(0);
			list.add(me);
		}
		return list;
	}
	public List<ModelEntity> getSeries(ModelEntity brand) throws Exception{
		List<ModelEntity> list = new ArrayList<ModelEntity>();
		String seriesUrl = "http://www.yixiuche.com/ac/carmodel.html?action=selectcar&ajaxcardata=ajaxcardata&getserieses="+brand.getInfo()+"&ajax=ajax";
		String content = client.get(seriesUrl,20000).getContent();
		Document doc = Jsoup.parse(content); 
		String path = " a";
		Elements eles = doc.select(path);
		for(Element ele : eles){
			String info = ele.attr("keyvalue");
			String name = ele.select("li > span:nth-child(1)").html();
			ModelEntity me = new ModelEntity();
			me.setName(name);
			me.setInfo(info);
			me.setPath(1);
			list.add(me);
		}
		return list;
	}
	public List<ModelEntity> getCarModel(ModelEntity series) throws Exception{
		List<ModelEntity> list = new ArrayList<ModelEntity>();
		String modelUrl = "http://www.yixiuche.com/ac/carmodel.html?action=selectcar&ajaxcardata=ajaxcardata&getengines="+series.getInfo()+"&selectmycar=&ajax=ajax";
		String content = client.get(modelUrl,20000).getContent();
		Document doc = Jsoup.parse(content); 
		String path = " a";
		Elements eles = doc.select(path);
		for(Element ele : eles){
			String tempinfo = ele.attr("onclick");
			String info = tempinfo.substring(tempinfo.indexOf("(")+1,tempinfo.indexOf(")"));
			String name = ele.select("li > span:nth-child(1)").html();
			ModelEntity me = new ModelEntity();
			me.setName(name);
			me.setInfo(info);
			me.setPath(2);
			list.add(me);
		}
		return list;
	}
	
	public String getWeiXiuDetailUrl(ModelEntity model,int distance) throws Exception{
		String weixiuPath = "http://www.yixiuche.com/diymaintenance/maintenanceform/"+model.getInfo()+"-0-0-0-0-0-2.html?maintenanceform[action]=maintenancelist&wndname=maintenanceform&maintenanceform[onecar_carmodelnumber]=156632&maintenanceform[clientcar_carmodelsname]=&maintenanceform[roadhaul]=120000&maintenanceform[onecar_buytime]=";
		String content = client.get(weixiuPath,20000).getContent();
		Document doc = Jsoup.parse(content); 
		//html body div.panel div.panel2_3 div.mainwnd div.wnd_content div.infownd div.infownd-box div.filtrate-list div.product-content div.product-dis table.tbid tbody tr td.dis-right div.product-intro-1 div.product-intro-1-content div.product-main div.product-price-1 a
		String path = "html body div.panel div.panel2_3 div.mainwnd div.wnd_content div.infownd div.infownd-box div.filtrate-list div.product-content div.product-dis table.tbid tbody tr td.dis-right div.product-intro-1 div.product-intro-1-content div.product-main div.product-price-1 a";
		Elements eles = doc.select(path);
		for(Element ele : eles){
			String id = ele.attr("id");
			if(id.endsWith(String.valueOf(distance))){
				return "http://www.yixiuche.com"+ele.attr("href");
			}
		}
		return null;
	}
	public String getTypeUrl(String detailUrl,String type) throws Exception{
		String path = "html body div.main div.main-left div div.product_show div.product_detail div.product_describe p a";
//		String path = "body > div.main > div > div:nth-child(2) > div:nth-child(2) > div.product_detail > div.product_describe > p:nth-child(2) > a";
		String content = client.get(detailUrl,20000).getContent();
		Document doc = Jsoup.parse(content); 
		Elements eles = doc.select(path);
		for(Element ele : eles){
			String htmlType = ele.html();
			if(htmlType==null||htmlType.trim().isEmpty()){
				return null;
			}
			if( type.equals(htmlType.trim())){
				return "http://www.yixiuche.com"+ele.attr("href");
			}
		}
		return null;
	}
	public List<Map<Integer,String>> getMaintenance(String maintenanceUrl) throws Exception{
		String content = client.get(maintenanceUrl,20000).getContent();
		Document doc = Jsoup.parse(content); 
		String path = "html body div.main div.main-left div div.product_show table.pp_details_table tbody tr";
//		String path = "body > div.main > div > div:nth-child(2) > div:nth-child(3) > table > tbody > tr";
		Elements eles = doc.select(path);
		List<Map<Integer,String>> list = new ArrayList<Map<Integer,String>>();
		for(int i=1;i<eles.size();i++){
			
			Element tr = eles.get(i);
			Elements tds = tr.select("td");
			Map<Integer,String> map = new HashMap<Integer,String>();
			if(tds.size()<6){
				Map<Integer,String> lastMap = list.get(list.size()-1);
				for(int x=0;x<6-tds.size();x++){
					map.put(x,lastMap.get(x));
				}
				int y = 6-tds.size();
				for(int j=0;j<tds.size();j++){
					Element td = tds.get(j);
					map.put(y,td.text());
					y++;
				}
			}else{
				for(int j=0;j<6;j++){
					Element td = tds.get(j);
					map.put(j,td.text());
				}
			}
			
			list.add(map);
		}
		return list;
	}
	
	public String getModelName(ModelEntity model) throws Exception{
		String weixiuPath = "http://www.yixiuche.com/diymaintenance/maintenanceform/"+model.getInfo()+"-0-0-0-0-0-2.html?maintenanceform[action]=maintenancelist&wndname=maintenanceform&maintenanceform[onecar_carmodelnumber]=156632&maintenanceform[clientcar_carmodelsname]=&maintenanceform[roadhaul]=120000&maintenanceform[onecar_buytime]=";
		String content = client.get(weixiuPath,20000).getContent();
		Document doc = Jsoup.parse(content); 
		String namePath = "html body div.panel div.panel2_3 div.mainwnd div.wnd_content div.infownd div.infownd-box div.filtrate-list div#filtrate-content-1.filtrate-content div.about-car form div.diy_form_main fieldset input.cartype";
		String modelName = doc.select(namePath).val();
		return modelName;
	}

	public List<YixiucheMaintenace> parse(List<Map<Integer,String>> list,ModelEntity brand,ModelEntity series,ModelEntity model,String modelName,int distance,long modelid,int type,String url){
		List<YixiucheMaintenace> result = new ArrayList<YixiucheMaintenace>();
		for(Map<Integer,String> map : list){
			YixiucheMaintenace ym = new YixiucheMaintenace();
			ym.setBrand(brand.getName().substring(brand.getName().lastIndexOf(";")+1).trim());
			ym.setSeries(series.getName().substring(series.getName().lastIndexOf(";")+1).trim());
			ym.setModel(model.getName().substring(model.getName().lastIndexOf(";")+1).trim());
			ym.setModelInfo(model.getInfo());
			ym.setSeriesInfo(series.getInfo());
			ym.setBrandInfo(brand.getInfo());
			ym.setModelName(modelName.trim());
			ym.setModelid(modelid);
			ym.setDistance(distance);
			ym.setUrl(url);
			ym.setType(type);
			for(int i = 0; i<map.size();i++){
				String content = null;
				try {
					content = new String(map.get(i).getBytes(),"UTF-8");
				} catch (UnsupportedEncodingException e) {
					e.printStackTrace();
				}
				if(content == null){
					continue;
				}
				if(i==0){
					ym.setServiceName(content.trim());
				}else if(i==1){
					String str = content.replace("￥", "").replace(" ","");
					String[] strs = str.split("~");
					if(strs.length==1){
						ym.setServicePriceMin(Double.parseDouble(strs[0]));
					}else if(strs.length==2){
						ym.setServicePriceMin(Double.parseDouble(strs[0]));
						ym.setServicePriceMax(Double.parseDouble(strs[1]));
					}
				}else if(i==2){
					ym.setAccessoriesName(content.trim());
				}else if(i==3){
					String str = content.replace("￥", "").replace(" ","");
					ym.setAccessoriesPrice(Double.parseDouble(str));
				}else if(i==4){
					String str = content.replace(" ","");
					ym.setAccessoriesCount(Integer.parseInt(str));
				}
			}
			result.add(ym);
		}
		return result;
	}
	
	@Test
	public static void main(String[] args){
		YixiucheSpider ys = new YixiucheSpider();
		try {
			ys.spider();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
		
	public void spider() throws Exception{
		String homeContent = getHome();
		List<ModelEntity> brands = getBrands(homeContent);
		try {
			for(ModelEntity brand : brands){
				List<ModelEntity> seriess = getSeries(brand);
				try {
					for(ModelEntity series : seriess){
						List<ModelEntity> models = getCarModel(series);
						try {
							for(ModelEntity model : models){
								String modelName = null;
								long modelid = 0L;
								try {
									modelName = getModelName(model);
									if(maintenanceBLL.isHave(modelName)){
										continue;
									}
									
								} catch (Exception e1) {
									System.out.println("数据重复验证错误");
									e1.printStackTrace();
								}
								
								//TODO 查询 carmodel中的Modelid
								modelid = 0L;
								
								String detailPageUrl = null;
								int distance = 120000;
								try {
									detailPageUrl = getWeiXiuDetailUrl(model,distance);
									
									if(detailPageUrl!=null){
										String detailUrl = getTypeUrl(detailPageUrl,YixiucheTypeEnum.original.getName());
										List<Map<Integer,String>> list = getMaintenance(detailUrl);
										List<YixiucheMaintenace> result = parse(list, brand, series, model, modelName, distance, modelid, YixiucheTypeEnum.original.getType(), detailUrl);
										if(!result.isEmpty()){
											maintenanceBLL.addYixiucheMaintenace(result);
											System.out.println("SUCCESS "+modelName+" : "+result.get(0).getServicePriceMax());
										}
										
									}
								} catch (Exception e) {
									System.out.println("存储报错,URL:"+detailPageUrl);
									e.printStackTrace();
								}
							}
						} catch (Exception e) {
							System.out.println("车型报错,series info:"+series.getInfo());
							e.printStackTrace();
						}
					}
				} catch (Exception e) {
					System.out.println("车系报错,brand info:"+brand.getInfo());
					e.printStackTrace();
				}
			}
		} catch (Exception e) {
			System.out.println("品牌报错");
			e.printStackTrace();
		}
	}
}
