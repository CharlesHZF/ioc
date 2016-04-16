package com.importsource.ioc.context;

import java.beans.IntrospectionException;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.Set;

import com.importsource.common.io.ScannerUtil;
import com.importsource.conf.Properties;
import com.importsource.conf.PropertiesTools;
import com.importsource.log.client.LogManager;
import com.importsource.log.core.Logger;
public class AnnotationBeanFactory extends AbstractBeanFactory {
	Logger logger = LogManager.getLogger(AnnotationBeanFactory.class);
    protected String scope=null;
	@Override
	public void init(String xml) {
		//读取到一个value
		Properties p = Properties.newInstance(xml);
		if(p!=null){
			logger.i("有屁了");
		}
		scope = PropertiesTools.get(p, "scope", scope);
		//扫描包里的东西
		Set<Class<?>> classes=ScannerUtil.getClasses(scope);
		     logger.i("共加载了"+classes.size()+"个类。");
             //遍历bean
             for (Iterator i = classes.iterator(); i.hasNext();) {  
                    
                    //利用Java反射机制，通过class的名称获取Class对象
                    Class<?> bean = (Class<?>) i.next();
                   
                    //获取对应class的信息
                    java.beans.BeanInfo info=null;
					try {
						info = java.beans.Introspector.getBeanInfo(bean);
					} catch (IntrospectionException e) {
						throw new RuntimeException(e);
					}
                    //获取其属性描述
                    java.beans.PropertyDescriptor pd[] = info.getPropertyDescriptors();
                    //设置值的方法
                    Method mSet = null;
                    //创建一个对象
                    Object obj;
					try {
						obj = bean.newInstance();
					} catch (InstantiationException e) {
						throw new RuntimeException(e);
					} catch (IllegalAccessException e) {
						throw new RuntimeException(e);
					}
                    
                    //遍历该bean的property属性
                   /* for (Iterator ite = foo.elementIterator("property"); ite.hasNext();) {  
                           Element foo2 = (Element) ite.next();
                           //获取该property的name属性
                           Attribute name = foo2.attribute("name");
                           String value = null;
                          
                           //获取该property的子元素value的值
                           for(Iterator ite1 = foo2.elementIterator("value"); ite1.hasNext();) {
                                  Element node = (Element) ite1.next();
                                  value = node.getText();
                                  break;
                           }
                          
                           for (int k = 0; k < pd.length; k++) {
                                  if (pd[k].getName().equalsIgnoreCase(name.getText())) {
                                         mSet = pd[k].getWriteMethod();
                                         //利用Java的反射极致调用对象的某个set方法，并将值设置进去
                                         mSet.invoke(obj, value);
                                  }
                           }
                    }*/
                   
                    //将对象放入beanMap中，其中key为id值，value为对象
                    beanMap.put(obj.getClass().getName(), obj);
             }
   

	}

	@Override
	public Object getBean(String beanName) {
		return beanMap.get(beanName);
	}
	
	
	  /**
     * 测试方法.
     * @param args
     */
     public static void main(String[] args) {
          /*  AbstractBeanFactory factory = new XmlBeanFactory();
            factory.init("config.xml");
            JavaBean javaBean1 = (JavaBean) factory.getBean("javaBean1");
            System.out.println("userName=" + javaBean1.getUserName());
            System.out.println("password=" + javaBean1.getPassword());*/
            
            AbstractBeanFactory factory1 = new AnnotationBeanFactory();
            factory1.init("ilog.xml");
            com.importsource.ioc.sample.bean.JavaBean javaBean2 = (com.importsource.ioc.sample.bean.JavaBean) factory1.getBean("com.importsource.ioc.sample.bean.JavaBean");
            System.out.println("userName=" + javaBean2.getUserName());
            System.out.println("password=" + javaBean2.getPassword());
     }

}
