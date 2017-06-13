package com.ksyche.web.spider.bll;

import java.util.List;

import com.ksyche.tools.dao.Query;
import com.kysche.web.spider.service.ServiceFactory;
import com.kysche.web.spider.service.dao.IYixiucheCarModelService;
import com.kysche.web.spider.service.entity.YixiucheCarModel;

public class YixiucheCarModelBLL {
	private static IYixiucheCarModelService carModelService = ServiceFactory
			.createService(IYixiucheCarModelService.class);

	public long addModel(YixiucheCarModel carModel) throws Exception {
		return carModelService.add(carModel);
	}

	public List<YixiucheCarModel> getByName(String name) throws Exception {
		Query query = new Query();
		query.column("cnname").equal(name);
		return carModelService.get(query, 1, 9999, "id desc");
	}

	public List<YixiucheCarModel> getByRemark(String remark) throws Exception {
		Query query = new Query();
		query.column("remark").equal(remark);
		return carModelService.get(query, 1, 9999, "id desc");
	}

	public YixiucheCarModel getById(long modelId) throws Exception {
		return carModelService.get(modelId);
	}

	public List<YixiucheCarModel> getByParentId(long parentId) throws Exception {
		Query query = new Query();
		query.column("parentid").equal(parentId);
		return carModelService.get(query, 1, 9999, "id desc");
	}
}
