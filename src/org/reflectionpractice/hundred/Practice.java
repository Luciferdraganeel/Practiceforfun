package org.reflectionpractice.hundred;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class Practice {

	public static void main(String[] args) throws InstantiationException, IllegalAccessException,
			IllegalArgumentException, In
			
			vocationTargetException, NoSuchMethodException, NoSuchFieldException, SecurityException, ClassNotFoundException {

		try {
			Object instanceOfClass = createInstanceOfClass(Employee.class);
			String name = instanceOfClass.getClass().getName();
			System.out.println(name);
		} catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException
				| NoSuchMethodException e) {
			e.printStackTrace();
		}
		
		try {
            Employee employee = new Employee();
            accessingPrivateVaribales(employee, "companyName");
        } catch (NoSuchFieldException | SecurityException | IllegalAccessException e) {
            e.printStackTrace();
        }
		
		invokePrivateMethod(Object obj, String methodName, Class<?>[] paramTypes, Object[] params)
	}

	private static void accessingPrivateVaribales(Object object, String property) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException  {

		                           Class<? extends Object> clazz = object.getClass();
		                           Field soughtfield = clazz.getDeclaredField(property);
		                           soughtfield.setAccessible(true);
		                           String fieldname = soughtfield.getName();
		                           Object value = soughtfield.get(object);
		                           System.out.println(fieldname+" name of the variable with the vlaue is : "+value);
		                           
	}


	private static Object createInstanceOfClass(Class<?> className) throws InstantiationException,
			IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException {

		Constructor<?>[] declaredConstructors = className.getDeclaredConstructors();
		Constructor<?> noArgConstructor = null;

		for (Constructor<?> declaredConstructor : declaredConstructors) {
			if (declaredConstructor.getParameterCount() == 0) {
				noArgConstructor = declaredConstructor;
				break;
			}
		}

		if (noArgConstructor == null) {
			throw new NoSuchMethodException("No no-argument constructor found for class: " + className.getName());
		}

		noArgConstructor.setAccessible(true);
		return noArgConstructor.newInstance();

	}

}
