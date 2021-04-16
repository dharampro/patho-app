package com.techendear.api.util;

import java.lang.reflect.Field;
import java.util.Map;

import org.springframework.stereotype.Component;
import org.springframework.util.ReflectionUtils;

@Component
public class MapToEntity<T> {

	public T mapToEntity(Map<Object, Object> fields, T t) {
		fields.forEach((k, v) -> {
			Field field = ReflectionUtils.findField(t.getClass(), (String) k);
			field.setAccessible(true);
			ReflectionUtils.setField(field, t, v);
		});
		return t;
	}
}
