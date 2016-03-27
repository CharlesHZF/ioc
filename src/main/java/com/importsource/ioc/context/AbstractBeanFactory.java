package com.importsource.ioc.context;

import java.util.HashMap;
import java.util.Map;

public abstract class AbstractBeanFactory {
	 protected Map<String, Object> beanMap = new HashMap<String, Object>();
	 public abstract void init(String xml);
	 public abstract Object getBean(String beanName);
}
