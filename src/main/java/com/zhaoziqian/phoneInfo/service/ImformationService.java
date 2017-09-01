package com.zhaoziqian.phoneInfo.service;

import java.util.List;

import com.zhaoziqian.phoneInfo.domain.Imformation;
/**
 * 
* @ClassName: ImformationService
* @Description: 主题的业务接口
* @author zhaoziqian
* @date 2017年9月1日 下午1:11:22
*
 */
public interface ImformationService {

	/**
	 * 查找全部的资讯信息
	 * @return 成功返回找到的主题集合，失败返回null
	 */
	List<Imformation> find();
	/**
	 * 根据资讯id查找资讯数据
	 * @param id 需要查找资讯的id
	 * @return 找到返回该对象，失败返回null
	 */
	Imformation findById(int id);
	/**
	 * 指定id资讯的浏览次数加1，
	 * @param id 需要增加浏览次数的资讯Id
	 * @return 成功返回1 失败返回0 错误返回-1
	 */
	int viewCountUp(int id);
	
}
