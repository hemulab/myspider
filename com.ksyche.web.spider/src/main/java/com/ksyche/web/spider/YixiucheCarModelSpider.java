package com.ksyche.web.spider;

import java.util.List;

import com.kysche.web.spider.service.entity.ModelEntity;
import com.kysche.web.spider.service.entity.YixiucheCarModel;

public class YixiucheCarModelSpider {
	private YixiucheSpider spider = new YixiucheSpider();
	public void start() throws Exception{
		String homeContent = spider.getHome();
		List<ModelEntity> brands = spider.getBrands(homeContent);
	}
	public void parse2Model(ModelEntity en,YixiucheCarModel parentModel){
		if(en==null){
			return;
		}
		YixiucheCarModel ycm = new YixiucheCarModel();
		ycm.setCnname(en.getName());
		ycm.setRemark(en.getInfo());
		if(parentModel==null){
			ycm.setPath(0);
			ycm.setParentid(0);
		}else{
			ycm.setPath(parentModel.getPath()+1);
			ycm.setParentid(parentModel.getId());
		}
	}
	
}
