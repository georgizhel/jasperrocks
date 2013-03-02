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
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.UnsupportedEncodingException;
import java.lang.IllegalArgumentException;
import java.lang.NullPointerException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLDecoder;
import java.net.NoRouteToHostException;
import java.net.MalformedURLException;
import java.net.UnknownHostException;
import java.nio.charset.Charset;
import java.nio.charset.UnsupportedCharsetException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.List;
import java.util.Map;
import java.util.TimeZone;

import javax.portlet.PortletPreferences;
import javax.portlet.PortletContext;
import javax.portlet.PortletRequest;
import javax.portlet.ReadOnlyException;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.BooleanUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.commons.validator.routines.UrlValidator;

import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.AuthCache;
import org.apache.http.client.protocol.ClientContext;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.client.utils.URIUtils;
import org.apache.http.conn.HttpHostConnectException;
import org.apache.http.impl.auth.BasicScheme;
import org.apache.http.impl.client.BasicAuthCache;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.protocol.BasicHttpContext;
import org.apache.http.HttpException;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Actions;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.interceptor.SessionAware;
import org.apache.struts2.portlet.interceptor.PortletPreferencesAware;
import org.apache.struts2.portlet.interceptor.PortletContextAware;
import org.apache.struts2.portlet.interceptor.PortletRequestAware;
import org.apache.struts2.ServletActionContext;
import com.opensymphony.xwork2.ActionSupport;
import org.xml.sax.SAXException;
import org.joda.time.DateTime;

@Namespace("/namespace1")
@ParentPackage(value = "package1")
public class EditAction extends ActionSupport implements PortletPreferencesAware {
	private static final long serialVersionUID = 201208251345L;
	private PortletPreferences portletPreferences;
	private String sid, uid, pid, urlString, wsType, timeZone1, alias1;

	public void validate(){
		String[] schemes = {"http","https"};
		UrlValidator urlValidator = new UrlValidator(schemes);
		if (StringUtils.isNotBlank(sid)){
			if (!urlValidator.isValid(sid))
				addFieldError("sid", getText("URL.is.invalid"));
			if (StringUtils.isBlank(uid))
				addFieldError("uid", getText("Username.is.required"));
			if (StringUtils.isBlank(pid))
				addFieldError("pid", getText("Password.cannot.be.empty"));
		}
	}

	@Action( value = "edit", results = {
		@Result(name = "login", location = "edit.jsp" ),
		@Result(name = "success", location = "view.jsp" ),
		@Result(name = "error", location = "error.jsp" )
	} )
	public String execute() throws Exception {
		URL url1 = null;
		URI uri1 = null;
		HttpGet httpGet1 = null;
		DefaultHttpClient httpClient1 = new DefaultHttpClient();
		HttpResponse httpResponse1 = null;
		int int1 = 0, int2 = 401;
		String[] array1 = null;
		String string1 = getText("Error")+" %d: %s", result1 = LOGIN;
		byte[] bytes1 = null;
		if (StringUtils.isBlank(timeZone1))
			timeZone1 = portletPreferences.getValue("timeZone", TimeZone.getDefault().getID());
		if ( StringUtils.isNotBlank(sid) && StringUtils.isNotBlank(uid) && StringUtils.isNotBlank(pid) ){
			try {
				url1 = new URL(sid);
				URIBuilder uriBuilder = new URIBuilder(sid);
				uriBuilder.setParameter("j_username", uid);
				uriBuilder.setParameter("j_password", pid);
				uriBuilder.setPath(url1.getPath()+"/rest/login");
				uri1 = uriBuilder.build();
				httpGet1 = new HttpGet(uri1);
				httpResponse1 = httpClient1.execute(httpGet1);
				int2 = httpResponse1.getStatusLine().getStatusCode();
			} catch (IOException exception1) {
				exception1.printStackTrace();
			} catch (URISyntaxException exception1) {
				exception1.printStackTrace();
			} finally {
				httpClient1.getConnectionManager().shutdown();
				if (int2 == HttpStatus.SC_OK){
					sid = new String(Base64.encodeBase64(sid.getBytes()));
					uid = new String(Base64.encodeBase64(uid.getBytes()));
					pid = new String(Base64.encodeBase64(pid.getBytes()));
					urlString = "/";
					wsType = "folder";
					array1 = new String[]{sid, uid, pid, StringUtils.defaultString(alias1)};
					portletPreferences.setValue("urlString", urlString);
					portletPreferences.setValue("wsType", wsType);
					portletPreferences.setValue("timeZone", timeZone1);
					portletPreferences.setValues("server", array1);
					portletPreferences.store();
					result1 = SUCCESS;
				} else {
					array1 = portletPreferences.getValues("server", null);
					if (array1 != null)
					if (ArrayUtils.isNotEmpty(array1)){
						for (int1 = 0; int1 < array1.length; int1++){
							switch (int1){
								case 0: sid = array1[int1]; break;
								case 1: uid = array1[int1]; break;
								case 2: pid = array1[int1]; break;
								case 3: alias1 = array1[int1]; break;
								default: break;
							}
						}
						sid = new String(Base64.decodeBase64(sid.getBytes()));
						uid = new String(Base64.decodeBase64(uid.getBytes()));
						pid = new String(Base64.decodeBase64(pid.getBytes()));
					}
					addActionError(String.format(string1, int2, getText(Integer.toString(int2))));
				}
			}
		} else {
			array1 = portletPreferences.getValues("server", null);
			if ( StringUtils.isBlank(urlString) || StringUtils.isBlank(wsType) ){
				urlString = portletPreferences.getValue("urlString", "/");
				wsType = portletPreferences.getValue("wsType", "folder");
			}
			if (array1!=null){
				if (ArrayUtils.isNotEmpty(array1)){
					for (int1 = 0; int1 < array1.length; int1++){
						switch (int1){
							case 0: sid = array1[int1]; break;
							case 1: uid = array1[int1]; break;
							case 2: pid = array1[int1]; break;
							case 3: alias1 = array1[int1]; break;
							default: break;
						}
					}
					sid = new String(Base64.decodeBase64(sid.getBytes()));
					uid = new String(Base64.decodeBase64(uid.getBytes()));
					pid = new String(Base64.decodeBase64(pid.getBytes()));
				}
			}
		}
		return result1;
	}

	public void setPortletPreferences(PortletPreferences portletPreferences){
		this.portletPreferences = portletPreferences;
	}
	public String getUrlString() {
		return urlString;
	}
	public void setUrlString(String urlString){
		this.urlString = urlString;
	}
	public String getWsType() {
		return wsType;
	}
	public void setWsType(String wsType){
		this.wsType = wsType;
	}
	public String getSid() {
		return sid;
	}
	public void setSid(String sid){
		this.sid = sid;
	}
	public String getUid() {
		return uid;
	}
	public void setUid(String uid){
		this.uid = uid;
	}
	public String getPid() {
		return pid;
	}
	public void setPid(String pid){
		this.pid = pid;
	}
	public String getTimeZone1() {
		return timeZone1;
	}
	public void setTimeZone1(String timeZone1){
		this.timeZone1 = timeZone1;
	}
	public String getAlias1() {
		return alias1;
	}
	public void setAlias1(String alias1){
		this.alias1 = alias1;
	}
}
