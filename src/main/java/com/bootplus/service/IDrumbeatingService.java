package com.bootplus.service;

import java.util.List;

import com.bootplus.dto.StructModel;
import com.bootplus.model.Drumbeating;

public interface IDrumbeatingService {
	public List<Drumbeating> queryDrumbList(Drumbeating db);
	public void save(Drumbeating db);
	public void delete(Drumbeating db);
	public void update(Drumbeating db);
	public Drumbeating getDrumbeatingById(String id);
	/**
	 * 封装网站的各个推广模块的信息
	 * @return
	 */
	public StructModel getStructModel();
}
