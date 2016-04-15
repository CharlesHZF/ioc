package com.importsource.ioc.context;

import java.util.HashMap;
import java.util.Map;

/**
 * 通用bean工厂。未来可以基于该类添加更多实现。比如基于annotation的实现
 * @author Hezf
 *
 */
public abstract class AbstractBeanFactory {
	 /**
	  * 把读到的bean通通放到里边
	  */
	 protected Map<String, Object> beanMap = new HashMap<String, Object>();
	 public abstract void init(String xml);
	 public abstract Object getBean(String beanName);
}
