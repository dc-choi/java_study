package board.controller;

import java.util.*;

public class ModelAndView {
	// model에서 처리한 결과 데이터를 담기 위한 Map
	private Map<String, Object> model = new HashMap<String, Object>();
	// view의 경로를 저장
	private String viewName;
	
	public ModelAndView() {}
	
	public ModelAndView(String viewName) {
		setViewName(viewName);
	}
	
	public ModelAndView(String viewName, String key, Object value) {
		setViewName(viewName);
		addObject(key, value);
	}
	
	public Map<String, Object> getModel() {
		return model;
	}
	
	public void setModel(Map<String, Object> model) {
		this.model = model;
	}
	
	public String getViewName() {
		return viewName;
	}
	
	public void setViewName(String viewName) {
		this.viewName = viewName;
	}
	
	// model에 key와 value를 저장함.
	public void addObject(String key, Object value) {
		model.put(key, value);
	}
}
