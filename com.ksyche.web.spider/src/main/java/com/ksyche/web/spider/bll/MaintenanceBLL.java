package com.ksyche.web.spider.bll;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ksyche.tools.dao.Query;
import com.kysche.web.spider.service.ServiceFactory;
import com.kysche.web.spider.service.dao.ICarMaintenaceJDService;
import com.kysche.web.spider.service.dao.IChangeMaintenaceJDService;
import com.kysche.web.spider.service.dao.IMaintenanceItemJDService;
import com.kysche.web.spider.service.dao.IYixiucheMaintenaceService;
import com.kysche.web.spider.service.entity.CarMaintenaceJD;
import com.kysche.web.spider.service.entity.ChangeMaintenaceJD;
import com.kysche.web.spider.service.entity.MaintenanceItemJD;
import com.kysche.web.spider.service.entity.ModelEntity;
import com.kysche.web.spider.service.entity.YixiucheMaintenace;

public class MaintenanceBLL {
	private static ICarMaintenaceJDService carMaintenaceService = ServiceFactory.createService(ICarMaintenaceJDService.class);
	private static IChangeMaintenaceJDService changeService = ServiceFactory.createService(IChangeMaintenaceJDService.class);
	private static IMaintenanceItemJDService itemService = ServiceFactory.createService(IMaintenanceItemJDService.class);
	private static IYixiucheMaintenaceService yixiucheService = ServiceFactory.createService(IYixiucheMaintenaceService.class);
	
	
	public long getOrAddMaintenaceItemJDID(String name) throws Exception{
		if(name==null||"".equals(name)){
			return 0L;
		}
		MaintenanceItemJD m = get(name);
		if(m==null){
			m = add(name);
		}
		return m.getId();
		
	}
	
	
	public MaintenanceItemJD get(String name) throws Exception{
		if(name==null||"".equals(name)){
			return null;
		}
		name = name.trim();
		Map<String, Object> condition = new HashMap<String, Object>();
		condition.put("name", name);
		List<MaintenanceItemJD> list = itemService.get(condition, "id desc");
		if(list!=null&&list.size()>0){
			return list.get(0);
		}
		return null;
	}
	
	public MaintenanceItemJD add(String name) throws Exception{
		if(name==null||"".equals(name)){
			return null;
		}
		name = name.trim();
		MaintenanceItemJD maintenace = new MaintenanceItemJD();
		maintenace.setName(name);
		long add = itemService.add(maintenace);
		maintenace.setId(add);
		return maintenace;
	}
	
	public long addCarMaintenaceItem(long carid,long mainid,double count) throws Exception{
		if(carid>0&&mainid>0){
			CarMaintenaceJD carm = new CarMaintenaceJD();
			carm.setCarId(carid);
			carm.setCount(count);
			carm.setMaintenaceId(mainid);
			return carMaintenaceService.add(carm);
		}
		return 0L;
	}
	
	public long addChangeMaintenace(long carMainId,long distanceName) throws Exception{
		if(carMainId>0&&distanceName>0){
			ChangeMaintenaceJD cm = new ChangeMaintenaceJD();		
			cm.setCarMintenaceId(carMainId);
			cm.setDistanceName(distanceName);
			return changeService.add(cm);
		}
		return 0L;
	}
	
	public long addYixiucheMaintenace(YixiucheMaintenace maintenace) throws Exception{
		if(maintenace!=null){
			return yixiucheService.add(maintenace);
		}
		return 0;
	}
	public long addYixiucheMaintenace(List<YixiucheMaintenace> maintenaces) throws Exception{
		if(maintenaces!=null&&!maintenaces.isEmpty()){
			return yixiucheService.add(maintenaces);
		}
		return 0;
	}
	public boolean isHave(String modelName) throws Exception{
		Query query = new Query();
		
		query.column("modelName").equal(modelName);
		List<YixiucheMaintenace> list = yixiucheService.get(query, 1, 999, null);
		if(list==null||list.isEmpty()){
			return false;
		}
		return true;
	}
}
