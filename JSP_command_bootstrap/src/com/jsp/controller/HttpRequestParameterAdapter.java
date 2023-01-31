package com.jsp.controller;

import java.lang.reflect.Method;

import javax.servlet.http.HttpServletRequest;

public class HttpRequestParameterAdapter {

	public static <T>T execute(HttpServletRequest request, Class<T> className)throws Exception{
															//클래스로딩. classforName해야하는데, 올때부터 Class로오니까 그냥쓴다.
		//목적 : 주입된 상태로 돌려준다.
		T obj = className.newInstance();
		
		
		Method[] method_arr= className.getMethods();
		
		for(Method method : method_arr) {
			if(method.getName().indexOf("set") == 0) {
				
				String requestParamName = method.getName().replace("set", "");
				requestParamName = (requestParamName.charAt(0)+"").toLowerCase()+ requestParamName.substring(1);
				//변수의 이름인거지.
				String[] paramValues = request.getParameterValues(requestParamName);
				
				//value는 0번지 valuse는 전부 꺼낸거. 원래 String배열로 서버에 넘어온다.
				//setMethod의 매개변수가 배열인경우도 생각한다.
				//setter도 당연히 배열로 만들어질거고. method의 파라미터 확인.
				
				//파라미터가 여러개인경우를 대비해서 getParameter는 배열로 받아와진다.
				//. 받아서 넣기위한것이기때문에 어차피 파라미터가 하나인걸 알고있다. 그냥 배열인지 아닌지 첫번째것만 확인하면된다.
				//규격을 그렇게 만들었으니까.
				//invoke는 배열타입을 줄때 new를 해줬다.
				
				if(paramValues != null && paramValues.length > 0) {
					if(method.getParameterTypes()[0].isArray()) {
						method.invoke(obj, new Object[] {paramValues});
					}else {
						method.invoke(obj, paramValues[0]);
					}
					
				}
				
			}
			
		}
		
		
		return obj;
		
		
	}
	
	
	
}
