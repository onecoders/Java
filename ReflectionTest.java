package com.refrection;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ReflectionTest {

	private static void perform(RefrectionTest test)
			throws NoSuchFieldException, SecurityException,
			NoSuchMethodException, IllegalAccessException,
			IllegalArgumentException, InvocationTargetException {
		Field field = test.getClass().getDeclaredField("field");
		field.setAccessible(true);
		// convert to really field by field.get(where it really is)

		Method method = test.getClass().getDeclaredMethod("method");
		method.setAccessible(true);
		method.invoke(test);
	}

	/**
	 * @param args
	 * @throws InvocationTargetException
	 * @throws IllegalArgumentException
	 * @throws IllegalAccessException
	 * @throws NoSuchMethodException
	 * @throws SecurityException
	 * @throws NoSuchFieldException
	 */
	public static void main(String[] args) throws NoSuchFieldException,
			SecurityException, NoSuchMethodException, IllegalAccessException,
			IllegalArgumentException, InvocationTargetException {
		// TODO Auto-generated method stub
		perform(new RefrectionTest());
	}

}
