package com.sugar.common.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public class ModelCopyUtil {
	
    private static Logger logger = LoggerFactory.getLogger(ModelCopyUtil.class);

    private static Logger getLogger(){
        if(logger == null){
            logger = LoggerFactory.getLogger(ModelCopyUtil.class);
        }
        return logger;
    }
    
    public static <K,T> List<T> copyToList(List<K> sourceList, Class<T> targetClazz){
        return copyToList(sourceList, targetClazz, null, true);
    }

    public static <K,T> List<T> copyToList(List<K> sourceList, Class<T> targetClazz, String notCopy, boolean isCopyNull){
        if(sourceList == null || targetClazz == null){
            return null;
        }
        List<T> dtoList = new ArrayList<T>(sourceList.size());
        for(K pObject : sourceList){
            dtoList.add(copy(pObject,targetClazz,notCopy,isCopyNull));
        }
        return dtoList;
    }
    
    /**
     * 
     * @param source
     * @param targetClazz
     * @return source为空时返回null
     */
    public static <T> T copy(Object source,Class<T> targetClazz){
    	return copy(source, targetClazz, null, true);
    }

    /**
     * 
     * @param source
     * @param targetClazz
     * @param notCopy
     * @param isCopyNull
     * @return source为空时返回null
     */
    public static <T> T copy(Object source,Class<T> targetClazz,String notCopy,boolean isCopyNull){
        if (source==null) {
			return null;
		}
    	try {
            T target = targetClazz.newInstance();
            ObjectCopyUtil.copyObjValue(source,target,notCopy,isCopyNull);
            return target;
        } catch (InstantiationException e) {
            getLogger().error("createCopyObject error",e);
        } catch (IllegalAccessException e) {
            getLogger().error("createCopyObject error",e);
        }
        return null;
    }
}
