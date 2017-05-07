package com.quartz.model;

public class RetObj {

	private boolean flag = true;
	private String msg;
	private Object obj;

	public RetObj() {

	}

	public RetObj(boolean flag, String msg) {
		super();
		this.flag = flag;
		this.msg = msg;
	}

	public RetObj(boolean flag, String msg, Object obj) {
		super();
		this.flag = flag;
		this.msg = msg;
		this.obj = obj;
	}

	public String getMsg() {
		return msg;
	}

	public Object getObj() {
		return obj;
	}

	public boolean isFlag() {
		return flag;
	}

	public void setFlag(boolean flag) {
		this.flag = flag;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public void setObj(Object obj) {
		this.obj = obj;
	}

}
