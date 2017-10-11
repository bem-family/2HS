package com.bem;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;


@ControllerAdvice
public class GlobalAdvice {
	private static final Logger LOGGER = LoggerFactory.getLogger(GlobalAdvice.class);

	@Autowired
	private MessageSource messageSource;
	
	@ResponseBody
	@ExceptionHandler(BindException.class)
	public Map<String, Object> validExceptionHandler(BindException ex) {
		System.err.println(ex.getMessage());
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("data", "error");
		return map;
	}
	
	
	@ResponseBody
	@ExceptionHandler(NullPointerException.class)
	@ResponseStatus(HttpStatus.OK)
	public Map<String, Object> nullPointerExceptionHandler(NullPointerException re) {
		return logAndWrapMessage("System data exception.", re);
	}
	
	@ResponseBody
	@ExceptionHandler(RuntimeException.class)
	@ResponseStatus(HttpStatus.OK)
	public Map<String, Object> runtimeExceptionHandler(RuntimeException re) {
		return logAndWrapMessage(re.getMessage(), re);
	}
	
	
	
	private Map<String, Object> logAndWrapMessage(String message, Throwable t) {
		long timestamp = System.currentTimeMillis();
		LOGGER.error("Timestamp: {}, Message: {}", timestamp, message, t);
		return new HashMap<String, Object>() {
			private static final long serialVersionUID = -8863817677230234970L;
			{
				put("timestamp", timestamp);
				put("message", message);
			}
		};
	}
}
