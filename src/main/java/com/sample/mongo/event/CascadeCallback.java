package com.sample.mongo.event;

import java.lang.reflect.Field;
import java.util.List;

import org.springframework.data.mapping.model.MappingException;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.util.ReflectionUtils;

import com.sample.mongo.annotation.CascadeSave;


public class CascadeCallback implements ReflectionUtils.FieldCallback {

	private Object source;
	private MongoOperations mongoOperations;

	CascadeCallback(final Object source, final MongoOperations mongoOperations) {
		this.source = source;
		this.setMongoOperations(mongoOperations);
	}

	@Override
	public void doWith(final Field field) throws IllegalArgumentException, IllegalAccessException {
		ReflectionUtils.makeAccessible(field);

		if (field.isAnnotationPresent(DBRef.class) && field.isAnnotationPresent(CascadeSave.class)) {
			final Object fieldValue = field.get(getSource());

			if (fieldValue instanceof List<?>) {
				for (Object item : (List<?>) fieldValue) {
					checkNSave(item);
				}
			} else {
				checkNSave(fieldValue);
			}
		}

	}

	private void checkNSave(Object fieldValue) {
		FieldCallback callback = new FieldCallback();
		ReflectionUtils.doWithFields(fieldValue.getClass(), callback);

		if (!callback.isIdFound()) {
			throw new MappingException("Oops, something went wrong. Child doesn't have @Id?");
		}

		getMongoOperations().save(fieldValue);
	}

	private Object getSource() {
		return source;
	}

	public void setSource(final Object source) {
		this.source = source;
	}

	private MongoOperations getMongoOperations() {
		return mongoOperations;
	}

	private void setMongoOperations(final MongoOperations mongoOperations) {
		this.mongoOperations = mongoOperations;
	}
}
