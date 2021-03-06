package com.taotao.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.taotao.common.pojo.EasyUIDataGridResult;
import com.taotao.common.pojo.TaotaoResult;
import com.taotao.service.ItemParamService;

@Controller
@RequestMapping("/item/param")
public class ItemParamController {

	@Autowired
	private ItemParamService itemParamService;
	
	/**
	 * liubaichuan
	 * @param page
	 * @param rows
	 * @return
	 */
	@RequestMapping("/list")
	@ResponseBody
	public EasyUIDataGridResult getItemList(Integer page, Integer rows) {
		//EasyUIDataGridResult result = itemParamService.getItemParamList(page, rows);
		EasyUIDataGridResult result = itemParamService.getItemParamVOList(page, rows);
		return result;
	}
	
	@RequestMapping("/query/itemcatid/{cid}")
	@ResponseBody
	public TaotaoResult getItemCatById(@PathVariable Long cid) {
		TaotaoResult result = itemParamService.getItemParamByCid(cid);
		return result;
	}
	
	@RequestMapping("/cid/{cid}")
	@ResponseBody
	public TaotaoResult getItemCatFromId(@PathVariable Long cid) {
		TaotaoResult result = itemParamService.getItemParamByCid(cid);
		return result;
	}
	
	@RequestMapping(value = "/save/{cid}", method = RequestMethod.POST)
	@ResponseBody
	public TaotaoResult insertItemParam(@PathVariable Long cid, String paramData) {
		TaotaoResult result = itemParamService.insertItemParam(cid, paramData);
		return result;
	}
	/**
	 * xuezhendong
	 * @param ids
	 * @return
	 */
	@RequestMapping("delete")
	@ResponseBody
	public TaotaoResult Deleteitemparam(String ids){
		String[] array=ids.split(",");
		return itemParamService.Deleteitemparam(array);
	}
	/**
	 * liubaichuan
	 * @param eid
	 * @param paramData
	 * @return
	 */
	@RequestMapping(value = "/update/{eid}", method = RequestMethod.POST)
	@ResponseBody
	public TaotaoResult updateItemParam(@PathVariable Long eid, String paramData) {
		System.err.println(eid);
		System.err.println(paramData);
		TaotaoResult result = itemParamService.updateItemParam(eid, paramData);
		return result;
	}
}
