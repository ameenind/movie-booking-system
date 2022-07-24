
package com.example.mbs.impl.data.adaptor;

import org.dozer.DozerBeanMapper;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DozerMappingWrapper extends DozerBeanMapper {

	private static final String DOZER_BEAN_MAPPINGS_XML = "dozer-bean-mappings.xml";

	public DozerMappingWrapper() {
		List<String> mappingFiles = new ArrayList<>();
		mappingFiles.add(DOZER_BEAN_MAPPINGS_XML);
		setMappingFiles(mappingFiles);
	}

	public <T, U> Iterable<U> map(final Iterable<T> source, final Class<U> destType) {
		final List<U> dest = new ArrayList<>();
		if (source == null) {
			return null;
		}
		for (T element : source) {
			if (element == null) {
				continue;
			}
			dest.add(map(element, destType));
		}
		// finally remove all null values if any
		List s1 = new ArrayList<>();
		s1.add(null);
		dest.removeAll(s1);
		return dest;
	}
}
