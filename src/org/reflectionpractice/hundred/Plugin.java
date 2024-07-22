package org.reflectionpractice.hundred;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Iterator;

public interface Plugin {
	void execute();
}

class firstplugindriver implements Plugin {

	@Override
	public void execute() {
		System.out.println(" i am in the firstdriver class");
	}

}

class SecondDriver implements Plugin {

	@Override
	public void execute() {
		// TODO Auto-genera""ted method stub
		System.out.println("I am in the second Driver class");
	}

}

class DriverFunction {
	public static void main(String[] args) {

		try {
			try {
				loadExecuteThePlugin("SecondDriver");
			} catch (InstantiationException | IllegalAccessException | IllegalArgumentException
					| InvocationTargetException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private static void loadExecuteThePlugin(String driverName) throws ClassNotFoundException, InstantiationException,
			IllegalAccessException, IllegalArgumentException, InvocationTargetException {

		Class<?> driver = Class.forName(driverName);
		if (Plugin.class.isAssignableFrom(driver)) {

			Constructor<?>[] declaredConstructors = driver.getDeclaredConstructors();
			Constructor<?> noargconstructor = null;

			for (Constructor<?> declaredConstructor : declaredConstructors) {
				if (declaredConstructor.getParameterCount() == 0) {
					noargconstructor = declaredConstructor;
					break;
				}
			}

			if (noargconstructor != null) {
				Plugin driverplugin = (Plugin) noargconstructor.newInstance();
				driverplugin.execute();
			} else {
				System.out.println("No no arg constructor in the following driver class :" + driver);
			}

		}

	}
}