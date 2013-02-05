package org.aip.chap5;

import java.io.IOException;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ParameterInspectorServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws IOException {

		StringBuilder result = new StringBuilder();

		Map<String, String[]> requestMap = new TreeMap<String, String[]>();

		requestMap.putAll(request.getParameterMap());// request.getParameterMap()得到的map是不可改的;

		Set<Entry<String, String[]>> entries = requestMap.entrySet();

		for (Entry<String, String[]> entry : entries) {
			result.append(entry.getKey()).append("=<br/>");
			for (String value : entry.getValue()) {
				result.append("<strong>" + value + "</strong>").append("<br/>");
			}
		}

		response.getWriter().write(result.toString());
	}
}
