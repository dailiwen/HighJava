package org.simpletomcat;

import java.util.HashMap;
import java.util.Map;

public class Mapper {
	private  Mapper()
	{
		
	}
	private static Mapper mapper; 
	private static Map<String,ServletWrapper> servletWrappers = new HashMap<String,ServletWrapper> ();
	public static Mapper getMapper()
	{
		if(mapper == null)
		{
			mapper = new Mapper();
		}
		
		return mapper;
	}
	public void addPattern(String pattern, ServletWrapper servletWrapper)
	{
		servletWrappers.put(pattern, servletWrapper); 
	}
	/**
	 * 查找与URL相匹配的ServletWrapper
	 * 本方法与映射配置中的每一个模式进行匹配，如果相匹配，则停止查找
	 * @param url 查找的URL
	 * @return 相匹配的ServletWrapper
	 */
	public  ServletWrapper map(String url)
	{
		ServletWrapper servletWrapper = null; 
		for(String pattern : servletWrappers.keySet())
		{
			if(this.mapPattern(url, pattern))
			{
				servletWrapper = servletWrappers.get(pattern);
				break;
			}
		}
		return servletWrapper; 
	}
	/**
	 * 判断URL是否与映射模式相匹配
	 * @param url
	 * @param pattern
	 * @return
	 */
	private boolean  mapPattern(String url,String pattern)
	{
		boolean isMapped = false;
		
		//判断模式中是否包含通配符,如果不包含， 就进行精确匹配
		int asteriskIndex = pattern.indexOf("*"); 
		if ( asteriskIndex == -1)
		{
			if(pattern.equals(url))
			{
				isMapped = true; 
			}
		}
		else
		{
			//如果包含通配符，则进行部分匹配。
			//分别对通配符前面部分和后面的部分与URL进行前缀匹配和后缀匹配，只有两种匹配都成功，
			//才能判定URL与模式相匹配
			String firstPart = pattern.substring(0, asteriskIndex);
			//前缀匹配
			if( url.startsWith(firstPart) )
			{
				//如果通配符后面无字符，则不进行后缀匹配
				if(asteriskIndex ==  pattern.length()-1)
				{
					isMapped = true; 
				}
				else
				{
					String lastPart  = pattern.substring(asteriskIndex +1);
					//后缀匹配
					if( url.endsWith(lastPart) )
					{
						isMapped = true; 						
					}
				}
			}				
		}
		return isMapped;
	}
}
