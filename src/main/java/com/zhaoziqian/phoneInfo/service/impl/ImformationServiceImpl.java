package com.zhaoziqian.phoneInfo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhaoziqian.phoneInfo.domain.Imformation;
import com.zhaoziqian.phoneInfo.mapper.ImformationMapper;
import com.zhaoziqian.phoneInfo.service.ImformationService;
@Service
public class ImformationServiceImpl implements ImformationService {

	@Autowired
	private ImformationMapper imformationMapper;
	
	@Override
	public List<Imformation> find() {
		return imformationMapper.find();
	}

	@Override
	public Imformation findById(int id) {
		return imformationMapper.findById(id);
	}

	@Override
	public int viewCountUp(int id) {
		return imformationMapper.viewCountUp(id);
	}

}
