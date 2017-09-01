package com.zhaoziqian.phoneInfo.controller;

import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zhaoziqian.phoneInfo.domain.Imformation;
import com.zhaoziqian.phoneInfo.domain.Reply;
import com.zhaoziqian.phoneInfo.service.ImformationService;
import com.zhaoziqian.phoneInfo.service.ReplyService;

@Controller
public class SystemController {
	
	/**
	 * 主题服务
	 */
	@Autowired
	private ImformationService ims;
	/**
	 * 回复服务
	 */
	@Autowired
	private ReplyService res;
	
	@RequestMapping(value="index",method=RequestMethod.GET)
	public String showAll(ModelMap map){
		List<Imformation> im = ims.find();
		map.put("imformations", im);
		return "showAll";
	}
	@RequestMapping(value="detial/{infoId}",method=RequestMethod.GET)
	public String detial(@PathVariable("infoId") int infoId,ModelMap map){
		
		List<Reply> r = res.findById(infoId);
		Imformation imf = ims.findById(infoId);
		
		for (Reply reply : r) {
			System.out.println(reply);
		}
		
		map.put("replys", r);
		map.put("imformation", imf);
		
		return "imformation";
	}
	
	@RequestMapping(value="newReply",method=RequestMethod.POST)
	@ResponseBody
	public Object newReply( @RequestParam("content") String content,
							@RequestParam("infoId") String id){
		int infoId = Integer.parseInt(id);
		Reply tempReply = res.create(content, infoId);
		
		System.out.println(id + "\t" + content);
		Reply reply;
		Map<String,Object> result = new HashMap<>();
		String resultMsg = "error";
		SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-dd");
		if (content.trim().length() > 0 && content.trim().length() <= 200 && res.save(tempReply) == 1) {
			reply = res.findMax();
			resultMsg = "success";
			
			System.out.println(sdf.format(reply.getReplyTime()) + " \t" + reply.getContent());
			result.put("msg", resultMsg);
			result.put("replyTime", sdf.format(reply.getReplyTime()));
			result.put("content", reply.getContent());
			
//			resultMsg = ""+"<li>"
//						  +"<div class='zz-time'> 发表于:<span class='time'>"+ sdf.format(reply.getReplyTime()) +"</span></div>"
//						  +"<div class='zz-text'>"+ reply.getContent() +"</div>"
//						  +"</li>" + "<br>";
		}
		
		return result;
	}
}
