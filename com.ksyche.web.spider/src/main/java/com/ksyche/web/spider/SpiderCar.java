package com.ksyche.web.spider;

import java.net.URLDecoder;
import java.net.URLEncoder;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.ksyche.tools.util.net.http.HttpClient;
import com.ksyche.tools.util.net.http.HttpResponse;
import com.kysche.web.spider.service.ServiceFactory;
import com.kysche.web.spider.service.dao.ICarService;
import com.kysche.web.spider.service.entity.Car;

public class SpiderCar {

	private static String[] brandArr = new String []{"奥迪","阿斯顿马丁","安驰","奔驰","别克","比亚迪","宝骏","宝马","北京","本田","保时捷","大众","宝龙","宾利","奔腾","北汽","标致","巴博斯","长安","长城","长安商用","昌河","传祺","大通","东风","东风小康","帝豪","DS","东南","大发","大众","道奇","大迪","东风风度","菲亚特","富奇","福迪","丰田","福特","风神","风行","法拉利","福田","观致","华北","恒天","红旗","黄海","哈弗","幻速","海马","华普","汇众","华泰","华阳","海格","哈飞","佳星","解放","江淮","江南","江铃","九龙","吉奥","吉利","金杯","Jeep","捷豹","克莱斯勒","凯翼","卡威","凯迪拉克","开瑞","力帆","劳斯莱斯","路特斯","路虎","铃木","猎豹","林肯","雷诺","兰博基尼","陆风","理念","雷克萨斯","莲花","迈凯伦","马自达","MG","MINI","美亚","玛莎拉蒂","纳智捷","欧朗","欧宝","讴歌","启辰","全球鹰","启腾","起亚","庆铃","奇瑞","日产","瑞麒","RUF","荣威","斯柯达","三菱","思铭","双环","SPRINGO","赛宝","绅宝","双龙","陕汽通家","斯巴鲁","Smart","天马","特斯拉","腾势","通用","通田","五十铃","威兹曼","威旺","万丰","五菱","威麟","沃尔沃","雪铁龙","西雅特","新雅途","现代","雪佛兰","夏利","新凯","云雀","英菲尼迪","英伦","一汽","永源","野马","扬子","英致","依维柯","中顺","中兴","众泰","中华","中欧"};
	
	private static String brandUrl = "http://auto.jd.com/querySeries?brand=";
	
	private static String seriseUrl = "http://auto.jd.com/queryModel?";
	
	
	
	static{
		System.setProperty("dao.root.path", "E:\\kysche\\spider\\");
	}
	private static ICarService carService = ServiceFactory.createService(ICarService.class);
	private static HttpClient httpClient = HttpClient.getInstance(1, 100, 1024*516);
	public  void spider() throws Exception {
		for(String brand : brandArr){
			String decode = URLEncoder.encode(brand, "utf-8");
			long brandid = createID(0,0);
			carService.add(new Car(1,brand,brandid));
			String brandUrl2 = brandUrl+ decode;
			HttpResponse res = httpClient.get(brandUrl2,30000);
			JSONObject json = JSONObject.fromObject(res.getContent());
			JSONArray jsonArray = json.getJSONArray("data");
			System.out.println(res.getContent());
			for(int i=0;!jsonArray.isEmpty()&&i<jsonArray.size();i++){
				JSONObject jsonObject = jsonArray.getJSONObject(i);
				String serise = jsonObject.getString("seriesName");
				long seriseid = createID(brandid,0);
				Car car = new Car(2,serise,brandid,seriseid,0);
				carService.add(car);
				String decode2 = URLEncoder.encode(serise, "utf-8");
				String seriseUrl2 = seriseUrl+"brand="+ decode+"&series="+decode2;
				System.out.println(seriseUrl2);
				res = httpClient.get(seriseUrl2,30000);
				json = JSONObject.fromObject(res.getContent());
				JSONArray jsonArray2 = json.getJSONArray("data");
				for(int j=0;!jsonArray2.isEmpty()&&j<jsonArray2.size();j++){
					jsonObject = jsonArray2.getJSONObject(j);
					Car car3 = new Car(3,jsonObject.getString("modelName"),seriseid,createID(brandid,seriseid),jsonObject.getLong("carModelId"));
					carService.add(car3);
				}
				System.out.println(res.getContent()); //15681151632
			}
			
			
			System.out.println(res.getContent());
		}
	}
	
	private long count = 100;
	private long second = 0;
	private long thrid = 0;
	private  long createID(long baseId,long seriseId){
		if(baseId == 0&&seriseId==0){
			second = 0;
			return count++;
		}
		if(seriseId==0){
			thrid=0;
			second++;
			return baseId*1000+(second);
		}
		thrid++;
		return (seriseId*1000)+thrid;
	}
	
	public static void main(String[] args) throws Exception {
		SpiderCar spiderCar = new SpiderCar();
		spiderCar.spider();
	}

}
