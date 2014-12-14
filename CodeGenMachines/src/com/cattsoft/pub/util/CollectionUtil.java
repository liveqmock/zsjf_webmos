
package com.cattsoft.pub.util;

import java.util.Collection;
import java.util.Iterator;

public class CollectionUtil {
	
	
	public static String toString(Collection collection){
		if(collection == null) return null;
		
		StringBuffer str = new StringBuffer(collection.getClass().toString());
		str.append(collection.hashCode());
		str.append("[");
		Iterator itor = collection.iterator();
		while(itor.hasNext()){
			str.append(itor.next());
			str.append(",");
		}
		
		str.append("]");
		
		
		return str.toString();
	}

}
