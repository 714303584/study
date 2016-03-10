package study.beanInfo;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;

public class BeanInfoTest {
	
	
	public static void main(String[] args) throws IntrospectionException {
		
		BeanInfo  beanInfo = Introspector.getBeanInfo(BeanInfoTest.class);
		
		System.out.println(beanInfo.toString());
		System.out.println(beanInfo.getBeanDescriptor());
		
	}

}
