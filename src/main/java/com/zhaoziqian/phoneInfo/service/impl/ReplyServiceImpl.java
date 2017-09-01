package com.zhaoziqian.phoneInfo.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhaoziqian.phoneInfo.domain.Reply;
import com.zhaoziqian.phoneInfo.mapper.ReplyMapper;
import com.zhaoziqian.phoneInfo.service.ReplyService;

@Service
public class ReplyServiceImpl implements ReplyService{

	@Autowired
	private ReplyMapper replyMapper;
	
	@Override
	public List<Reply> find() {
		return null;
	}

	@Override
	public List<Reply> findById(int infoId) {
		return replyMapper.findById(infoId);
	}

	@Override
	public int save(Reply reply) {
		return replyMapper.save(reply);
	}

	@Override
	public Reply create(String content, int infoId) {
		Reply reply = new Reply();
		reply.setContent(content);
		reply.setInfoId(infoId);
		reply.setReplyTime(new Date());
		return reply;
	}

	@Override
	public Reply findMax() {
		return replyMapper.findMax();
	}

}
