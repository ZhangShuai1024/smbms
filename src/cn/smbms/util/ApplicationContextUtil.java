package cn.smbms.util;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class ApplicationContextUtil {
	public static ApplicationContext createApplicationContext(){
		return new ClassPathXmlApplicationContext("applicationContext-*.xml");
	}
}
