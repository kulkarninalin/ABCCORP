package com.abc.corp.modal;

public class Response {
	
	private Long count;
	private boolean responseStatus;
	public long getCount() {
		return count;
	}
	public void setCount(Long count) {
		this.count = count;
	}
	public boolean isResponseStatus() {
		return responseStatus;
	}
	public void setResponseStatus(boolean responseStatus) {
		this.responseStatus = responseStatus;
	}
	public Response() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Response(Long count, boolean responseStatus) {
		super();
		this.count = count;
		this.responseStatus = responseStatus;
	}
	@Override
	public String toString() {
		return "Response [count=" + count + ", responseStatus=" + responseStatus + "]";
	}
	

}
