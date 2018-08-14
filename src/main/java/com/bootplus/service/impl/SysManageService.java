package com.bootplus.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bootplus.core.base.BaseServiceImpl;
import com.bootplus.dao.ISysManageDao;
import com.bootplus.model.SysConfig;
import com.bootplus.model.User;
import com.bootplus.model.UserLogin;
import com.bootplus.service.ISysManageService;
/**
 * 	@EnableCaching 启用缓存配置
	@Cacheable 指定某个方法的返回值是可以缓存的。在注解属性中指定缓存规则。
		参数：value、cacheNames：两个等同的参数
		key:#p0表示第一个参数（第一个参数是对象的话可以调用对象的属性如#p0.id），或者用#+第一个参数名与#p0等同，要使用SpEL表达式#fx.id
		condition：condition="#name.length() < 32"
		unless="#result.hardback"
	@Cacheput 将方法的返回值缓存到指定的key中
	@CacheEvict 删除指定的缓存数据
		参数：与@cacheable相同，多出2个参数：
		allEntries：非必需，默认为false。当为true时，会移除所有数据
		beforeInvocation：非必需，默认为false，会在调用方法之后移除数据。当为true时，会在调用
	@Cacheable和@Cacheput都会将方法的执行结果按指定的key放到缓存中，
	@Cacheable在执行时，会先检测缓存中是否有数据存在，如果有，直接从缓存中读取。
	如果没有，执行方法，将返回值放入缓存，而@Cacheput会先执行方法，然后再将执行结果写入缓存。
	使用@Cacheput的方法一定会执行
 * @author liulu
 *
 */
@Service
@Transactional
@CacheConfig(cacheNames = {"cache_user"})
public class SysManageService extends BaseServiceImpl implements ISysManageService {
	@Autowired
	private ISysManageDao sysManageDao;
	@Override
	public void saveSysConfig(SysConfig sc) {
		// TODO Auto-generated method stub
		sysManageDao.save(sc);
	}
	@Override
	@CacheEvict(cacheNames = "cache_user",allEntries=true)
	public void delSysConfig(String id) {
		// TODO Auto-generated method stub
		sysManageDao.deleteById(SysConfig.class, id);
	}
	@Override
	@CacheEvict(cacheNames = "cache_user",allEntries=true)
	public void updateSysConfig(SysConfig sc) {
		// TODO Auto-generated method stub
		sysManageDao.update(sc);
	}
	@Override
	public List<SysConfig> querySysConfigList() {
		// TODO Auto-generated method stub
		return sysManageDao.querySysConfigList();
	}
	@Override
	public List<SysConfig> querySysConfigListByKey(String key) {
		// TODO Auto-generated method stub
		return sysManageDao.querySysConfigListByKey(key);
	}
	@Override
	@Cacheable(cacheNames="cache_user",sync = true)
	public SysConfig getSysConfigById(String id) {
		// TODO Auto-generated method stub
		return (SysConfig)sysManageDao.get(SysConfig.class, id);
	}


}
