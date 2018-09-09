package com.arthurbarbosa.helpdesk.api.response;

import java.util.ArrayList;
import java.util.List;

public class Response<T> {
	
	private T data;
	
	private List<String> errors;

	public T getData() {
		return data;
	}

	public void setData(T data) {
		if(this.errors == null) {
			this.errors = new ArrayList<>();
		}
		this.data = data;
	}

	public List<String> getErrors() {
		return errors;
	}

	public void setErrors(List<String> errors) {
		this.errors = errors;
	}

	
	
	
}
