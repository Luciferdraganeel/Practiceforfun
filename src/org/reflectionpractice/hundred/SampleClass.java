package org.reflectionpractice.hundred;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

public class SampleClass {

	public static void main(String[] args) {

		sturctureOftheClass(Employee.class);

	}

	private static void sturctureOftheClass(Class<?> clazz) {

		Field[] fields = clazz.getFields();

		for (Field field : fields)
			System.out.println(field.getType().getSimpleName() + "  " + field.getName());

		Method[] methods = clazz.getMethods();

		for (Method method : methods)
			System.out.println(method.getName() + "  " + method.getParameterCount() + " ");

		Constructor<?>[] declaredConstructors = clazz.getDeclaredConstructors();
		for (Constructor<?> constructor : declaredConstructors) {
			StringBuffer sb = new StringBuffer();
			if (constructor.getParameterCount() == 0)
				sb.append(constructor.getName());
			Parameter[] parameters = constructor.getParameters();

			for (Parameter parameter : parameters)
				sb.append(parameter.toString() + " -->");

			System.out.println(sb.toString());
		}

	}
}
