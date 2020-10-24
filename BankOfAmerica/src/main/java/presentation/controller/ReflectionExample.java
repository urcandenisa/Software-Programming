package presentation.controller;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.swing.text.View;

public class ReflectionExample{
	public static void retrieveProperties(Object object) {

		for (Field field : object.getClass().getDeclaredFields()) {
			field.setAccessible(true);
			Object value;
			try {
				value = field.get(object);
				System.out.println(field.getName() + "=" + value);
			} catch (IllegalArgumentException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			}
		}
	}

	public static int retrieveId(List<? extends Object> objects) {

		int id = 0, i = objects.isEmpty() == true ? objects.size() - 1 : 0;
		if (objects.isEmpty() == true)
			return 0;
		for (Field field : objects.get(i).getClass().getDeclaredFields()) {
			field.setAccessible(true);
			Object value;
			try {
				value = field.get(objects.get(i));
				if (field.getName().compareTo("id") == 0) {
					id = Integer.parseInt(value.toString());
					break;
				}
			} catch (IllegalArgumentException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			}
		}
		return id;
	}

	public static int retrieveQuantity(Object object) {
		Object value = null;
		if(object == null) return 0;
		for (Field field : object.getClass().getDeclaredFields()) {
			field.setAccessible(true);
			try {
				if (field.getName().toString().compareTo("quantity") == 0) {
					value = field.get(object);
					System.out.println(field.getName() + "=" + value);
				}
			} catch (IllegalArgumentException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			}
		}
		return Integer.parseInt(value.toString());
	}

	public static List<Object> retrievePropertiesFromArray(List<? extends Object> objects) {
		int i = 0;
		List<Object> list = new ArrayList<Object>();
		while (i < objects.size()) {
			for (Field field : objects.get(i).getClass().getDeclaredFields()) {
				field.setAccessible(true);
				Object value = null;
				try {
					value = field.get(objects.get(i));
					list.add(value);
				} catch (IllegalArgumentException e) {
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					e.printStackTrace();
				}
			}
			i++;
		}
		return list;
	}
}
