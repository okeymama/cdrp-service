/**
 * 
 */
package com.abbvie.cdrp.util;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.BeanUtils;
import org.springframework.util.CollectionUtils;

/**
 * @author cchaubey
 *
 */
public class CDRPBeanUtil extends BeanUtils{

	@SuppressWarnings("unchecked")
	public static <T> List<T> copyEntityListToDTOList(Set set,Class clazz) throws InstantiationException, IllegalAccessException {
		List<T> dtoList = null;
		if(!CollectionUtils.isEmpty(set)) {
			dtoList = new ArrayList<>();
			for(Object srcObj : set) {
				T dtoBean = (T) clazz.newInstance();
				BeanUtils.copyProperties(srcObj, dtoBean);
				dtoList.add(dtoBean);
			}
		}
		return dtoList;
	}
	
	@SuppressWarnings("unchecked")
	public static <T> Set<T> copyDTOListToEntityList(List list,Class clazz) throws InstantiationException, IllegalAccessException {
		Set<T> entitySet = null;
		if(!CollectionUtils.isEmpty(list)) {
			entitySet = new HashSet<>();
			for(Object srcObj : list) {
				T entityBean = (T) clazz.newInstance();
				BeanUtils.copyProperties(srcObj, entityBean);
				entitySet.add(entityBean);
			}
		}
		return entitySet;
	}
	
}
