package net.antra.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ReflectionDemo {
	public static void main(String[] args) throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
		Class aClass = Apple.class;
		Constructor[] cstrctList = aClass.getConstructors();
		Apple a = (Apple) cstrctList[0].newInstance();
	//	System.out.println(a.aPublicVar);
		
		Field[] fields = aClass.getDeclaredFields();//all fields
		//Field[] fields = aClass.getFields(); //public fields
		for(Field f : fields){
			f.setAccessible(true);
			System.out.println(f.getName()+" value : "+f.get(a));
		}
//		fields[0].set(a, "Blue");
//		fields[1].set(a, 123);
//		
//		for(Field f : fields){
//			f.setAccessible(true);
//			System.out.println(f.getName()+" value : "+f.get(a));
//		}
		
		//Method[] methods = aClass.getMethods();//get all public methods
		Method[] methods = Apple.class.getDeclaredMethods();//all methods declared in class
		for(Method m : methods){
//			System.out.println(m.getName());
//			m.setAccessible(true);
//			m.invoke(a);
		}
		
	}
}
