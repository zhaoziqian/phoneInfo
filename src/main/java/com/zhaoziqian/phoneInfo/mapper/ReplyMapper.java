package com.zhaoziqian.phoneInfo.mapper;

import java.util.List;

import com.zhaoziqian.phoneInfo.domain.Reply;
/**
 * 
* @ClassName: ReplyMapper
* @Description: 处理回复的数据库mapper
* @author zhaoziqian
* @date 2017年9月1日 下午1:15:27
*
 */
public interface ReplyMapper {

	/**
	 * 查找全部的回复信息
	 * @return 成功返回找到的集合，失败返回null
	 */
	List<Reply> find();
	/**
	 * 根据主题的id找到所属的全部回复信息
	 * @param infoId 需要查找的主题的Id
	 * @return 成功返回找到的集合，失败返回null
	 */
	List<Reply> findById(int infoId);
	/**
	 * 保存一条回复数据
	 * @param reply 需要保存的回复对象
	 * @return 成功返回1 失败返回0 错误返回-1
	 */
	int save(Reply reply);
	/**
	 * 创建一个回复对象
	 * @param content 回复对象的 回复内容
	 * @param infoId 回复对象的 资讯Id
	 * @return 返回创建好的回复对象
	 */
	Reply create(String content,int infoId);
	/**
	 * 查找最后一条回复
	 * @return 成功返回找到的对象，失败返回null
	 */
	Reply findMax();
}
