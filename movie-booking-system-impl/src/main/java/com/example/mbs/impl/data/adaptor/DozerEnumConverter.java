
package com.example.mbs.impl.data.adaptor;

import org.dozer.CustomConverter;
import org.dozer.MappingException;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;


public class DozerEnumConverter implements CustomConverter {

	public Object convert(Object destination, Object source, Class<?> destinationClass, Class<?> sourceClass) {
		if (source == null)
			return null;
		if (destinationClass != null) {
			try {
				if (destinationClass.getSimpleName().equalsIgnoreCase("Integer")) {
					return getInteger(source);
				} else if (destinationClass.getSimpleName().equalsIgnoreCase("String")) {
					return source.toString();
				} else if (destinationClass.isEnum()) {
					return this.getEnum(destinationClass, source);
				} else {
					throw new MappingException("");
				}
			} catch (Exception e) {
				throw new MappingException(new StringBuilder("Converter ").append(this.getClass().getSimpleName())
						.append(" was used incorrectly. Arguments were: ").append(destinationClass.getName())
						.append(" and ").append(source).toString());
			}
		}
		return null;
	}

	private Integer getInteger(Object source)
			throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		Method[] ms = source.getClass().getMethods();
		for (Method m : ms) {
			if (m.getName().equalsIgnoreCase("getValue")) {
				return (Integer) m.invoke(source);
			}
		}
		return null;
	}

	private Object getEnum(Class<?> destinationClass, Object source)
			throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		Method[] ms = destinationClass.getMethods();
		for (Method m : ms) {
			if (m.getName().equalsIgnoreCase("get")) {
				return m.invoke(destinationClass.getClass(), source);
			}
		}
		return null;

	}
}
