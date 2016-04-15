package com.importsource.ioc.context;

import com.importsource.conf.PropertiesTools;

public class AnnotationBeanFactory extends AbstractBeanFactory {

	@Override
	public void init(String xml) {
		//读取到一个value
		com.importsource.conf.Properties p = com.importsource.conf.Properties.newInstance("conf.xml");
		 String driverClassName = PropertiesTools.get(p, "dbcp.driverClassName", null);

	}

	@Override
	public Object getBean(String beanName) {
		// TODO Auto-generated method stub
		return null;
	}

}
