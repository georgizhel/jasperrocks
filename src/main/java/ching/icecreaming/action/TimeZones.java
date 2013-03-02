/*
 Copyright (c) 2013 ching@icecreaming.com
 All rights reserved.

 This source is subject to the GNU General Public License.
 Please see the License.txt file for more information.
 All other rights reserved.

 THIS CODE AND INFORMATION ARE PROVIDED "AS IS" WITHOUT WARRANTY OF ANY 
 KIND, EITHER EXPRESSED OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE
 IMPLIED WARRANTIES OF MERCHANTABILITY AND/OR FITNESS FOR A
 PARTICULAR PURPOSE.
*/
package ching.icecreaming.action;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.annotations.SerializedName;
import com.google.gson.reflect.TypeToken;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Actions;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.ResultPath;
import org.apache.struts2.interceptor.SessionAware;
import com.opensymphony.xwork2.ActionSupport;

@Namespace("/namespace1")
@ParentPackage(value = "package2")
@ResultPath("/WEB-INF/content")
public class TimeZones extends ActionSupport {
	private static final long serialVersionUID = 201212102014L;
	private String jsonData = null;

	@Action(value = "time-zones", results = {
		@Result(name = "success", location = "json.jsp")
	} )
	public String execute(){
		String[] array1 = TimeZone.getAvailableIDs();
		List<String> list1 = Arrays.asList(array1);
		Arrays.sort(array1);
		Map<String, List<String>> map0 = new HashMap<String, List<String>>();
		map0.put("timeZones", list1);
		Gson gson = new GsonBuilder().create();
		jsonData = gson.toJson(map0);
		return SUCCESS;
	}
	public String getJsonData() {
		return jsonData;
	}
}
