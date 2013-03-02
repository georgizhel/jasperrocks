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
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLEncoder;
import java.net.URLDecoder;
import java.net.NoRouteToHostException;
import java.net.MalformedURLException;
import java.net.UnknownHostException;
import java.nio.charset.Charset;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;  
import java.util.regex.Pattern;
import java.util.TimeZone;
import javax.portlet.PortletContext;
import javax.portlet.PortletRequest;
import javax.portlet.PortletPreferences;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
import org.apache.http.entity.mime.HttpMultipartMode;
import org.apache.http.entity.mime.MultipartEntity;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.entity.mime.content.StringBody;
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

import org.apache.commons.beanutils.BeanComparator;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.collections.ComparatorUtils;
import org.apache.commons.collections.comparators.ReverseComparator;
import org.apache.commons.collections.comparators.ComparableComparator;
import org.apache.commons.collections.ListUtils;
import org.apache.commons.compress.archivers.ArchiveOutputStream;
import org.apache.commons.compress.archivers.ArchiveStreamFactory;
import org.apache.commons.compress.archivers.zip.ZipArchiveEntry;
import org.apache.commons.configuration.Configuration;
import org.apache.commons.configuration.HierarchicalConfiguration;
import org.apache.commons.configuration.PropertiesConfiguration;
import org.apache.commons.configuration.XMLConfiguration;
import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.ConfigurationUtils;
import org.apache.commons.configuration.HierarchicalConfiguration;
import org.apache.commons.configuration.PropertiesConfiguration;
import org.apache.commons.configuration.XMLConfiguration;
import org.apache.commons.io.filefilter.TrueFileFilter;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.BooleanUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.apache.commons.lang3.math.NumberUtils;
import org.apache.commons.lang3.StringEscapeUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.commons.validator.GenericValidator;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.SessionAware;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.portlet.interceptor.PortletPreferencesAware;
import org.apache.struts2.portlet.interceptor.PortletContextAware;
import org.apache.struts2.portlet.interceptor.PortletRequestAware;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Actions;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.joda.time.format.DateTimeFormatter;
import org.joda.time.format.PeriodFormatter;
import org.joda.time.format.PeriodFormatterBuilder;
import org.joda.time.Period;

import com.opensymphony.xwork2.ActionSupport;
import ching.icecreaming.model.DataModel1;
import ching.icecreaming.model.DataModel2;

@Namespace("/namespace1")
@ParentPackage(value = "package1")
public class ViewAction extends ActionSupport implements PortletPreferencesAware, PortletRequestAware, SessionAware, ServletRequestAware {
	private static final long serialVersionUID = 201207081418L;
	private PortletRequest portletRequest;
	private PortletPreferences portletPreferences;
	private String sid, uid, pid, urlString, wsType, format1, button1, locale2, label1, page1, result1, timeZone1, alias1, message1;
	private List<DataModel2> listObject2 = null;
	private Map<String, String> map1 = null;
	protected Map<String, Object> session = null;
	private HttpServletRequest httpServletRequest;
	private boolean bugfixGateIn;

	public void validate(){
		int int1 = 0, int2 = 0;
		DataModel2 dataObject2 = null;
		if (StringUtils.equals(wsType, "reportUnit") && StringUtils.equals(button1, getText("Print"))){
			if (listObject2!=null){
				int2 = listObject2.size();
				for (int1 = 0; int1 < int2; int1++){
					dataObject2 = (DataModel2)listObject2.get(int1);
					switch (dataObject2.getType1()){
						case "singleValueDateTime":
							if (!GenericValidator.isDate(dataObject2.getValue1(), "yyyy-MM-dd HH:mm", false)){
								addFieldError(String.format("listObject2[%d].value1", int1), getText("Error"));
							}	
							break;
						case "singleValueDate":
							if (!GenericValidator.isDate(dataObject2.getValue1(), "yyyy-MM-dd", false)){
								addFieldError(String.format("listObject2[%d].value1", int1), getText("Error"));	
							}
							break;
						case "singleValueNumber":
							if (!NumberUtils.isNumber(dataObject2.getValue1())){
								addFieldError(String.format("listObject2[%d].value1", int1), getText("Error"));	
							}
							break;
						default: break;
					}
				}
			}
		}
	}

	@Action( value = "view", results = {
		@Result(name = "login", location = "edit.jsp" ),
		@Result(name = "input", location = "view.jsp" ),
		@Result(name = "success", location = "view.jsp" ),
		@Result(name = "error", location = "error.jsp" )
	} )
	public String execute() throws Exception {
		Enumeration enumerator = null;
		String[] array1 = null, array2 = null;
		int int1 = -1, int2 = -1, int3 = -1;
		InputStream inputStream1 = null;
		OutputStream outputStream1 = null;
		java.io.File file1 = null, file2 = null, dir1 = null;
		List<File> files = null;
        	HttpHost httpHost1 = null;
		HttpGet httpGet1 = null, httpGet2 = null;
		HttpPut httpPut1 = null;
		URI uri1 = null;
		URL url1 = null;
		DefaultHttpClient httpClient1 = null; 
		URIBuilder uriBuilder1 = null, uriBuilder2 = null;
		HttpResponse httpResponse1 = null, httpResponse2 = null;
		HttpEntity httpEntity1 = null, httpEntity2 = null;
		List<NameValuePair> nameValuePair1 = null;
		String string1 = null, string2 = null, string3 = null, string4 = null, return1 = LOGIN;
		XMLConfiguration xmlConfiguration = null;
		List<HierarchicalConfiguration> list1 = null, list2 = null;
		HierarchicalConfiguration hierarchicalConfiguration2 = null;
		DataModel1 dataModel1 = null; 
		DataModel2 dataModel2 = null;
		List<DataModel1> listObject1 = null, listObject3 = null;
		org.joda.time.DateTime dateTime1 = null, dateTime2 = null;
		org.joda.time.Period period1 = null;
		PeriodFormatter periodFormatter1 = new PeriodFormatterBuilder()
			.appendYears().appendSuffix(String.format(" %s", getText("year")), String.format(" %s", getText("years"))).appendSeparator(" ")
			.appendMonths().appendSuffix(String.format(" %s", getText("month")), String.format(" %s", getText("months"))).appendSeparator(" ")
			.appendWeeks().appendSuffix(String.format(" %s", getText("week")), String.format(" %s", getText("weeks"))).appendSeparator(" ")
			.appendDays().appendSuffix(String.format(" %s", getText("day")), String.format(" %s", getText("days"))).appendSeparator(" ")
			.appendHours().appendSuffix(String.format(" %s", getText("hour")), String.format(" %s", getText("hours"))).appendSeparator(" ")
			.appendMinutes().appendSuffix(String.format(" %s", getText("minute")),String.format(" %s", getText("minutes"))).appendSeparator(" ")
			.appendSeconds().minimumPrintedDigits(2).appendSuffix(String.format(" %s", getText("second")), String.format(" %s", getText("seconds")))
			.printZeroNever()
			.toFormatter();
		if (StringUtils.isBlank(urlString) || StringUtils.isBlank(wsType)){
			urlString = portletPreferences.getValue("urlString", "/");
			wsType = portletPreferences.getValue("wsType", "folder");
		}
		Configuration propertiesConfiguration1 = new PropertiesConfiguration("system.properties");
		timeZone1 = portletPreferences.getValue("timeZone", TimeZone.getDefault().getID());
		enumerator= portletPreferences.getNames();
		if (enumerator.hasMoreElements()){
			array1 = portletPreferences.getValues("server", null);
			if (array1!=null){
				if (ArrayUtils.isNotEmpty(array1)){
					for (int1 = 0; int1 < array1.length; int1++){
						switch (int1){
							case 0:	sid = array1[int1];
								break;
							case 1: uid = array1[int1];
								break;
							case 2: pid = array1[int1];
								break;
							case 3: alias1 = array1[int1];
								break;
							default: break;
						}
					}
					sid = new String(Base64.decodeBase64(sid.getBytes()));
					uid = new String(Base64.decodeBase64(uid.getBytes()));
					pid = new String(Base64.decodeBase64(pid.getBytes()));
				}
					return1 = INPUT;
			} else {
				return1 = LOGIN;
			}
		} else {
			return1 = LOGIN;
		}

		if (StringUtils.equals(urlString, "/")){
			
			if (listObject1!=null){
				listObject1.clear();
			}
			if (session.containsKey("breadcrumbs")){
				session.remove("breadcrumbs");
			}
		} else {
			array2 = StringUtils.split(urlString, "/");
			listObject1 = (session.containsKey("breadcrumbs")) ? (List<DataModel1>)session.get("breadcrumbs") : new ArrayList<DataModel1>();
			int2 = array2.length - listObject1.size();
			if (int2 > 0){
				listObject1.add(new DataModel1(urlString, label1));
			} else {
				int2 += listObject1.size();
				for (int1 = listObject1.size()-1; int1>=int2; int1--){
					listObject1.remove(int1);
				}
			}
			session.put("breadcrumbs", listObject1);
		}
		switch (wsType){
			case "folder":
				break;
			case "reportUnit":
				try {
					dateTime1 = new org.joda.time.DateTime();
					return1 = INPUT;
					httpClient1 = new DefaultHttpClient();
					if (StringUtils.equals(button1, getText("Print"))){
						nameValuePair1 = new ArrayList<NameValuePair>();
						if (listObject2!=null){
							if (listObject2.size()>0){
								for (DataModel2 dataObject2: listObject2){
									listObject3 = dataObject2.getOptions();
									if (listObject3==null){
										string2 = dataObject2.getValue1();
										if (StringUtils.isNotBlank(string2))
											nameValuePair1.add(new BasicNameValuePair(dataObject2.getId(), string2));
									} else {
										for (int1 = listObject3.size()-1; int1>=0; int1--){
											dataModel1 = (DataModel1)listObject3.get(int1);
											string2 = dataModel1.getString2();
											if (StringUtils.isNotBlank(string2))
												nameValuePair1.add(new BasicNameValuePair(dataObject2.getId(), string2));
										}
									}
								}
							}
						}
						url1 = new URL(sid);
						uriBuilder1 = new URIBuilder(sid);
						uriBuilder1.setUserInfo(uid, pid);
						if (StringUtils.isBlank(format1)) format1 = "pdf";
						uriBuilder1.setPath(url1.getPath()+"/rest_v2/reports"+urlString+"."+format1);
						if (StringUtils.isNotBlank(locale2)){
							nameValuePair1.add(new BasicNameValuePair("userLocale", locale2));
						}
						if (StringUtils.isNotBlank(page1)){
							if (NumberUtils.isNumber(page1)){
								nameValuePair1.add(new BasicNameValuePair("page", page1));
							}
						}
						if (nameValuePair1.size()>0){
							uriBuilder1.setQuery(URLEncodedUtils.format(nameValuePair1, "UTF-8"));
						}
						uri1 = uriBuilder1.build();
						httpGet1 = new HttpGet(uri1);
						httpResponse1 = httpClient1.execute(httpGet1);
						int1 = httpResponse1.getStatusLine().getStatusCode();
						if (int1 == HttpStatus.SC_OK){
							string3 = System.getProperty("java.io.tmpdir")+File.separator+httpServletRequest.getSession().getId();
							dir1 = new File(string3);
							if (!dir1.exists()) {
								dir1.mkdir();
							}
							httpEntity1 = httpResponse1.getEntity();
							file1 = new File(string3, StringUtils.substringAfterLast(urlString, "/") +"."+format1);
							if (StringUtils.equalsIgnoreCase(format1, "html")){
								result1 = EntityUtils.toString(httpEntity1);
								FileUtils.writeStringToFile(file1, result1);
								array1 = StringUtils.substringsBetween(result1, "<img src=\"", "\"");
								if (ArrayUtils.isNotEmpty(array1)){
									dir1 = new File(string3+File.separator+FilenameUtils.getBaseName(file1.getName()));
									if (dir1.exists()){
										FileUtils.deleteDirectory(dir1);
									}
									file2 = new File(FilenameUtils.getFullPath(file1.getAbsolutePath())+FilenameUtils.getBaseName(file1.getName())+".zip");
									if (file2.exists()){
										if (FileUtils.deleteQuietly(file2)){
										}
									}
									for (int2=0; int2<array1.length; int2++){
										try {
											string2 = url1.getPath()+"/rest_v2/reports"+urlString+"/"+StringUtils.substringAfter(array1[int2], "/");
											uriBuilder1.setPath(string2);
											uri1 = uriBuilder1.build();
											httpGet1 = new HttpGet(uri1);
											httpResponse1 = httpClient1.execute(httpGet1);
											int1 = httpResponse1.getStatusLine().getStatusCode();
										} finally {
											if (int1 == HttpStatus.SC_OK){
												try {
													string2 = StringUtils.substringBeforeLast(array1[int2], "/");
													dir1 = new File(string3+File.separator+string2);
													if (!dir1.exists()){
														dir1.mkdirs();
													}
													httpEntity1 = httpResponse1.getEntity();
													inputStream1 = httpEntity1.getContent();
												} finally {
													string1 = StringUtils.substringAfterLast(array1[int2], "/");
													file2 = new File(string3+File.separator+string2, string1);
													outputStream1 = new FileOutputStream(file2);
													IOUtils.copy(inputStream1, outputStream1);
												}
											}
										}
									}
									outputStream1 = new FileOutputStream(FilenameUtils.getFullPath(file1.getAbsolutePath())+FilenameUtils.getBaseName(file1.getName())+".zip");
									ArchiveOutputStream archiveOutputStream1 = new ArchiveStreamFactory().createArchiveOutputStream(ArchiveStreamFactory.ZIP, outputStream1);
									archiveOutputStream1.putArchiveEntry(new ZipArchiveEntry(file1, file1.getName()));
									IOUtils.copy(new FileInputStream(file1), archiveOutputStream1);
									archiveOutputStream1.closeArchiveEntry();
									dir1 = new File(FilenameUtils.getFullPath(file1.getAbsolutePath())+FilenameUtils.getBaseName(file1.getName()));
									files = (List<File>) FileUtils.listFiles(dir1, TrueFileFilter.INSTANCE, TrueFileFilter.INSTANCE);
									for (File file3 : files) {
										archiveOutputStream1.putArchiveEntry(new ZipArchiveEntry(file3, StringUtils.substringAfter(file3.getCanonicalPath(), string3+File.separator)));
										IOUtils.copy(new FileInputStream(file3), archiveOutputStream1);
										archiveOutputStream1.closeArchiveEntry();
									}
									archiveOutputStream1.close();
								}
								bugfixGateIn = propertiesConfiguration1.getBoolean("bugfixGateIn", false);
								string4 = bugfixGateIn?String.format("<img src=\"%s/namespace1/file-link?sessionId=%s&fileName=", portletRequest.getContextPath(), httpServletRequest.getSession().getId() ):String.format("<img src=\"%s/namespace1/file-link?fileName=", portletRequest.getContextPath());
								result1 = StringUtils.replace(result1, "<img src=\"", string4);
							} else {
								inputStream1 = httpEntity1.getContent();
								outputStream1 = new FileOutputStream(file1);
								IOUtils.copy(inputStream1, outputStream1);
								result1 = file1.getAbsolutePath();
							}
							return1 = SUCCESS;
						} else {
							addActionError(String.format("%s %d: %s",getText("Error"), int1, getText(Integer.toString(int1))));
						}
						dateTime2 = new org.joda.time.DateTime();
						period1 = new Period(dateTime1, dateTime2.plusSeconds(1));
						message1 =getText("Execution.time") +": " +periodFormatter1.print(period1);
					} else {
						url1 = new URL(sid);
						uriBuilder1 = new URIBuilder(sid);
						uriBuilder1.setUserInfo(uid, pid);
						uriBuilder1.setPath(url1.getPath()+"/rest_v2/reports"+urlString+"/inputControls");
						uri1 = uriBuilder1.build();
						httpGet1 = new HttpGet(uri1);
						httpResponse1 = httpClient1.execute(httpGet1);
						int1 = httpResponse1.getStatusLine().getStatusCode();
						switch (int1){
						case HttpStatus.SC_NO_CONTENT: break;
						case HttpStatus.SC_OK: httpEntity1 = httpResponse1.getEntity();
							if (httpEntity1!=null){
								inputStream1 = httpEntity1.getContent();
								if (inputStream1!=null){
									xmlConfiguration = new XMLConfiguration();
									xmlConfiguration.load(inputStream1);
									list1 = xmlConfiguration.configurationsAt("inputControl");
									if (list1.size()>0){
										listObject2 = new ArrayList<DataModel2>();
										for (HierarchicalConfiguration hierarchicalConfiguration1 : list1){
											string2 = hierarchicalConfiguration1.getString("type");
											dataModel2 = new DataModel2();
											dataModel2.setId(hierarchicalConfiguration1.getString("id"));
											dataModel2.setLabel1(hierarchicalConfiguration1.getString("label"));
											dataModel2.setType1(string2);
											dataModel2.setMandatory(hierarchicalConfiguration1.getBoolean("mandatory"));
											dataModel2.setReadOnly(hierarchicalConfiguration1.getBoolean("readOnly"));
											dataModel2.setVisible(hierarchicalConfiguration1.getBoolean("visible"));
											switch (string2){
											case "bool":
											case "singleValueText":
											case "singleValueNumber":
											case "singleValueDate":
											case "singleValueDatetime":
												hierarchicalConfiguration2 = hierarchicalConfiguration1.configurationAt("state");
												dataModel2.setValue1(hierarchicalConfiguration2.getString("value"));
												break;
											case "singleSelect":
											case "singleSelectRadio":
											case "multiSelect":
											case "multiSelectCheckbox":
												hierarchicalConfiguration2 = hierarchicalConfiguration1.configurationAt("state");
												list2 = hierarchicalConfiguration2.configurationsAt("options.option");
												if (list2.size()>0){
													listObject3 = new ArrayList<DataModel1>();
													for (HierarchicalConfiguration hierarchicalConfiguration3 : list2){
														dataModel1 = new DataModel1(hierarchicalConfiguration3.getString("label"), hierarchicalConfiguration3.getString("value") );
														if (hierarchicalConfiguration3.getBoolean("selected")){
															dataModel2.setValue1(hierarchicalConfiguration3.getString("value"));
														}
														listObject3.add(dataModel1);
													}
													dataModel2.setOptions(listObject3);
												}
												break;
											default: break;
											}
											listObject2.add(dataModel2);
										}
									}
								}
							}
							break;
						default: 
							addActionError(String.format("%s %d: %s", getText("Error"), int1, getText(Integer.toString(int1))));
							break;
						}
						if (httpEntity1!=null){
							EntityUtils.consume(httpEntity1);
						}
						uriBuilder1.setPath(url1.getPath()+"/rest/resource"+urlString);
						uri1 = uriBuilder1.build();
						httpGet1 = new HttpGet(uri1);
						httpResponse1 = httpClient1.execute(httpGet1);
						int2 = httpResponse1.getStatusLine().getStatusCode();
						if (int2 == HttpStatus.SC_OK){
							httpEntity1 = httpResponse1.getEntity();
							inputStream1 = httpEntity1.getContent();
							xmlConfiguration = new XMLConfiguration();
							xmlConfiguration.load(inputStream1);
							list1 = xmlConfiguration.configurationsAt("resourceDescriptor");
							for (HierarchicalConfiguration hierarchicalConfiguration4 : list1){
								if ( StringUtils.equalsIgnoreCase(StringUtils.trim(hierarchicalConfiguration4.getString("[@wsType]")),"prop") ){
									if (map1 == null)
										map1 = new HashMap<String, String>();
									string2 = StringUtils.substringBetween( StringUtils.substringAfter( hierarchicalConfiguration4.getString("[@uriString]"), "_files/" ), "_", ".properties");
									map1.put(string2, StringUtils.isBlank(string2)?getText("Default"):getText(string2) );
								}
							}
						}
						if (httpEntity1!=null){
							EntityUtils.consume(httpEntity1);
						}
					}
				} catch (IOException | ConfigurationException | URISyntaxException exception1){
					exception1.printStackTrace();
					addActionError(exception1.getLocalizedMessage());
					httpGet1.abort();
					return ERROR;
				} finally {
					httpClient1.getConnectionManager().shutdown();
					IOUtils.closeQuietly(inputStream1);
				}
				break;
			default: addActionError(getText("This.file.type.is.not.supported"));
				break;
		}
		if (return1!=LOGIN){
			sid = new String(Base64.encodeBase64(sid.getBytes()));
			uid = new String(Base64.encodeBase64(uid.getBytes()));
			pid = new String(Base64.encodeBase64(pid.getBytes()));
		}
		return return1;
	}


	@Override
	public void setSession(Map<String, Object> session){
		this.session = session;
	}
	public void setPortletPreferences(PortletPreferences portletPreferences){
		this.portletPreferences = portletPreferences;
	}
	public String getUrlString(){
		return urlString;
	}
	public void setUrlString(String urlString){
		this.urlString = urlString;
	}
	public String getWsType(){
		return wsType;
	}
	public void setWsType(String wsType){
		this.wsType = wsType;
	}
	public String getSid(){
		return sid;
	}
	public String getUid(){
		return uid;
	}
	public String getPid(){
		return pid;
	}
	public String getFormat1(){
		return format1;
	}
	public void setFormat1(String format1){
		this.format1 = format1;
	}
	public void setButton1(String button1){
		this.button1 = button1;
	}
	public String getResult1(){
		return result1;
	}
	public void setListObject2(List<DataModel2>listObject2){
		this.listObject2 = listObject2;
	}
	public List<DataModel2> getListObject2(){
		return listObject2;
	}
	public Map<String, String> getMap1(){
		return map1;
	}
	public void setLocale2(String locale2){
		this.locale2 = locale2;
	}
	public void setLabel1(String label1){
		this.label1 = label1;
	}
	public String getPage1(){
		return page1;
	}
	public void setPage1(String page1){
		this.page1 = page1;
	}
	public void setServletRequest(HttpServletRequest httpServletRequest) {
		this.httpServletRequest = httpServletRequest;
	}   
	public String getTimeZone1(){
		return timeZone1;
	}
	public void setTimeZone1(String timeZone1){
		this.timeZone1 = timeZone1;
	}
	public String getAlias1(){
		return alias1;
	}
	public String getMessage1(){
		return message1;
	}
	public void setPortletRequest(PortletRequest portletRequest){
		this.portletRequest = portletRequest;
	}
	public boolean getBugfixGateIn(){
		return bugfixGateIn;
	}
}
