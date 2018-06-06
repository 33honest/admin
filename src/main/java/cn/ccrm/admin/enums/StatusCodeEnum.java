package cn.ccrm.admin.enums;

import java.util.Map;
import java.util.TreeMap;

public enum StatusCodeEnum {
	
	STATUS_0000("0000", "success"),
	STATUS_4001("4001", "登录账号有误"),
	STATUS_4002("4002", "验证码输入有误"),
	STATUS_4003("4003", "此账号已锁定"),
	STATUS_4004("4004", "账号登录异常"),
	STATUS_9999("9999", "未知错误");

	private String code;
	private String msg;
	
	public static Map<String, StatusCodeEnum> statusCodeMap = new TreeMap<>();
	
	static {
		for(StatusCodeEnum enum_ : StatusCodeEnum.values()) {
			statusCodeMap.put(enum_.getCode(), enum_);
		}
	}

	private StatusCodeEnum(String code, String msg) {
		this.code = code;
		this.msg = msg;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public static Map<String, StatusCodeEnum> getAll() {
		return statusCodeMap;
	}

}
