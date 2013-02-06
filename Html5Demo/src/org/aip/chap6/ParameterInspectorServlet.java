package org.aip.chap6;

import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ParameterInspectorServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request,HttpServletResponse response){
		StringBuilder result = new StringBuilder();
		Map<String, String[]> entries = new TreeMap<String, String[]>();
		entries.putAll(request.getParameterMap());
		for (Map.Entry<String, String[]> entry : entries.entrySet()) {
			result.append(entry.getKey()).append("=<br/>");
			for (String value : entry.getValue()) {
				result.append("&nbsp;").append(value).append("<br/>");
			}
		}
		response.setContentType("text/html");
		try {
			response.getWriter().write(result.toString());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	protected void doGet(HttpServletRequest request,HttpServletResponse response){
		
		System.out.println("Get");
		this.doPost(request, response);
	}
}
