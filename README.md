# ioc


###sample code
```java
AbstractBeanFactory factory1 = new AnnotationBeanFactory();
            factory1.init("ilog.xml");
            com.importsource.ioc.sample.bean.JavaBean javaBean2 = (com.importsource.ioc.sample.bean.JavaBean) factory1.getBean("com.importsource.ioc.sample.bean.JavaBean");
            System.out.println("userName=" + javaBean2.getUserName());
            System.out.println("password=" + javaBean2.getPassword());
```
