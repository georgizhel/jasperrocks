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
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.LinkedList;
import java.util.Map;
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
import java.net.URLDecoder;
import java.net.NoRouteToHostException;
import java.net.MalformedURLException;
import java.net.UnknownHostException;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerException;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Attr;
import org.w3c.dom.CDATASection;
import org.w3c.dom.CharacterData;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException; 

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.annotations.SerializedName;
import com.google.gson.reflect.TypeToken;

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.joda.time.LocalTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.joda.time.format.ISODateTimeFormat;

import org.apache.commons.beanutils.BeanComparator;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.collections.ComparatorUtils;
import org.apache.commons.collections.comparators.ReverseComparator;
import org.apache.commons.collections.comparators.ComparableComparator;
import org.apache.commons.collections.ListUtils;
import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.ConfigurationUtils;
import org.apache.commons.configuration.PropertiesConfiguration;
import org.apache.commons.configuration.XMLConfiguration;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.apache.commons.lang3.math.NumberUtils;
import org.apache.commons.lang3.StringEscapeUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

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

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.SessionAware;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Actions;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.ResultPath;
import com.opensymphony.xwork2.ActionSupport;
import ching.icecreaming.model.GridModel1;

@Namespace("/namespace1")
@ParentPackage(value = "package2")
@ResultPath("/WEB-INF/content")
public class ResourceDescriptors extends ActionSupport {
	private static final long serialVersionUID = 201210142031L;
	private String jsonData = null;
	private Integer rows = 10;
	private Integer page = 1;
	private String sord;
	private String sidx;
	private String searchField;
	private String searchString;
	private String searchOper = null; 
	private Integer total = 0;
	private Integer records = 0;
	private String id;
	private String sid, uid, pid, timeZone1;
	private String urlString = "/";

	@Action( value = "resource-descriptors", results = {
		@Result(name = "success", location = "json.jsp")
	} )
	public String execute() throws Exception {
		int int1 = 401, int0 = 0;
		String string1 = null;
		URL url1 = null;
		URI uri1 = null;
		HttpGet httpGet1 = null;
		HttpResponse httpResponse1 = null;
		HttpEntity httpEntity1 = null;
		HttpPost httpPost1 = null;
        	HttpHost httpHost1 = null;
	        DefaultHttpClient httpClient1 = null;
		File file1 = null;
		InputStream inputStream1 = null;
		OutputStream outputStream1 = null;
		BeanComparator beanComparator1 = null;
		List<Map<String, Object>> list1 = null, list2 = null;
		Map<String, Object> map1 = null;
		Object object1 = null;
		int toIndex = rows * page;
		int fromIndex = toIndex - rows;
		GridModel1 jsonObject1 = null;
		Gson gson = null;
		Long long1 = -1L;
		java.util.Date date1 = null;
		URIBuilder uriBuilder1 = null;
		Node node1 = null;
		Element element1 = null;
		NodeList nodeList1 = null;
		Document document1 = null;
		DocumentBuilder documentBuilder1 = null;
		DocumentBuilderFactory documentBuilderFactory1 = null;
		org.joda.time.DateTime dateTime1 = null, dateTime2 = null;
		
		try {
			if (StringUtils.isNotEmpty(sid) && StringUtils.isNotEmpty(uid) && StringUtils.isNotEmpty(pid)){
				sid = new String(Base64.decodeBase64(sid.getBytes()));
				uid = new String(Base64.decodeBase64(uid.getBytes()));
				pid = new String(Base64.decodeBase64(pid.getBytes()));
        			httpClient1 = new DefaultHttpClient();
				url1 = new URL(sid);
				uriBuilder1 = new URIBuilder(sid);
				uriBuilder1.setParameter("j_username", uid);
				uriBuilder1.setParameter("j_password", pid);
				uriBuilder1.setPath(url1.getPath()+"/rest/resources"+urlString);
				uriBuilder1.setUserInfo(uid, pid);
				uri1 = uriBuilder1.build();
				httpGet1 = new HttpGet(uri1);
				httpResponse1 = httpClient1.execute(httpGet1);
				int1 = httpResponse1.getStatusLine().getStatusCode();
				if (int1 == HttpStatus.SC_OK){
					httpEntity1 = httpResponse1.getEntity();
					inputStream1 = httpResponse1.getEntity().getContent();
					if (inputStream1!=null){
						documentBuilderFactory1 = DocumentBuilderFactory.newInstance();
						documentBuilder1 = documentBuilderFactory1.newDocumentBuilder();
						document1 = documentBuilder1.parse(inputStream1);
			            		document1.getDocumentElement().normalize();
						nodeList1 = document1.getElementsByTagName("resourceDescriptor");
						int1 = nodeList1.getLength();
						list1 = new ArrayList<Map<String, Object>>();
						for (int0 = 0; int0 < int1; int0++) {
							node1 = nodeList1.item(int0);
							if (node1.getNodeType() == Node.ELEMENT_NODE){
								element1 = (Element)node1;
								map1 = new HashMap<String, Object>();
								map1.put("wsType", element1.getAttribute("wsType"));
								map1.put("uriString", element1.getAttribute("uriString"));
								string1 = getTagValue("label", element1);
								map1.put("label1", StringUtils.defaultString(string1));
								string1 = getTagValue("description", element1);
								map1.put("description", StringUtils.defaultString(string1));
								string1 = getTagValue("creationDate", element1);
								long1 = (string1==null)?-1L:NumberUtils.toLong(StringUtils.trim(string1), -1L);
								if (long1>0){
									if (StringUtils.isNotBlank(timeZone1)){
										dateTime1 = new org.joda.time.DateTime(long1);
										dateTime2 = dateTime1.withZone(DateTimeZone.forID(timeZone1));
										date1 = dateTime2.toLocalDateTime().toDate();
									} else {
										date1 = new java.util.Date(long1);
									}
								} else {
									date1 = null;
								}
								map1.put("creationDate", date1);
								map1.put("type1", getText(element1.getAttribute("wsType")));
								list1.add(map1);
							}
						}
					}
					EntityUtils.consume(httpEntity1);
				}
			}
		} catch (UnsupportedEncodingException | URISyntaxException | ParserConfigurationException | SAXException exception1){
			exception1.printStackTrace();
			return ERROR;
		} catch (org.apache.http.conn.HttpHostConnectException | java.net.NoRouteToHostException | java.net.MalformedURLException | java.net.UnknownHostException exception1){
			exception1.printStackTrace();
			return ERROR;
		} catch (IOException exception1) {
			httpGet1.abort();
			exception1.printStackTrace();
			return ERROR;
		} finally {
			if (httpClient1 != null)
				httpClient1.getConnectionManager().shutdown();
			if (list1!=null){
				records = list1.size();
				if (list1.size()>0){
					if (StringUtils.isNotEmpty(sidx)){
						if (StringUtils.equals(sord, "desc")) {
							beanComparator1 = new BeanComparator(sidx, new ReverseComparator(new ComparableComparator()));
						} else {
							beanComparator1 = new BeanComparator(sidx);
						}
						Collections.sort(list1, beanComparator1);
					}
					if ( StringUtils.isNotBlank(searchField) && StringUtils.isNotEmpty(searchOper) ){
						Iterator iterator1 = list1.iterator();
						while (iterator1.hasNext()) {
							map1 = (Map<String, Object>)iterator1.next();
							for (Map.Entry<String, Object> entry1 : map1.entrySet()) {
								if (StringUtils.equals(entry1.getKey(), searchField)){
									object1 = entry1.getValue();
									if (searchFilter(searchField, searchOper, searchString, object1))
										iterator1.remove();
									break;
								}
							}
						}
						records = list1.size();
					}
					if (toIndex>records) toIndex = records;
					if (fromIndex>toIndex) {
						fromIndex = toIndex - rows;
						if (fromIndex<0) fromIndex = 0;
					}
					if (list1.size()>0 && fromIndex >= 0 && toIndex <= list1.size() && fromIndex <= toIndex)	
						list2 = list1.subList(fromIndex, toIndex);
	
				}
				total = (int)Math.ceil((double)records / (double)rows);
				if (page > total) page = total;
				jsonObject1 = new GridModel1(rows, page, sord, sidx, searchField, searchString, searchOper, total, records, id, list2);
				gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss.SSS").create();
				jsonData = gson.toJson(jsonObject1);
			}
			IOUtils.closeQuietly(inputStream1);
		}
		return SUCCESS;
	}

	public String getJsonData() {
		return jsonData;
	}

	public void setRows(Integer rows){
		this.rows = rows;
	}

	public void setPage(Integer page){
		this.page = page;
	}

	public void setTotal(Integer total){
		this.total = total;
	}

	public void setRecords(Integer records){
		this.records = records;
	}

	public void setSord(String sord){
		this.sord = sord;
	}

	public void setSidx(String sidx){
		this.sidx = sidx;
	}

	public void setSearchField(String searchField){
		this.searchField = searchField;
	}

	public void setSearchString(String searchString){
		this.searchString = searchString;
	}

	public void setSearchOper(String searchOper){
		this.searchOper = searchOper;
	}

	public void setId(String id){
		this.id = id;
	}
	public void setUrlString(String urlString){
		this.urlString = urlString;
	}

	public void setSid(String sid){
		this.sid = sid;
	}
	public void setUid(String uid){
		this.uid = uid;
	}
	public void setPid(String pid){
		this.pid = pid;
	}
	public void setTimeZone1(String timeZone1){
		this.timeZone1 = timeZone1;
	}

	private boolean searchFilter(String searchField, String searchOper, String searchString, Object object1) {
		boolean result1 = true;
		String string1 = null;
		Integer integer1 = null;
		java.sql.Timestamp timestamp1 = null;
		org.joda.time.DateTime dateTime1 = null, dateTime2 = null;
		DateTimeFormatter dateTimeFormatter = DateTimeFormat.forPattern("yyyy-MM-dd HH:mm");
		java.util.Date date1 = null;

		if (object1 instanceof String){
			string1 = (String)object1;
			switch (searchOper){
				case "eq":
					result1 = StringUtils.equals(string1, searchString);
					break;
				case "ne":
					result1 = !StringUtils.equals(string1, searchString);
					break;
				case "bw":
					result1 = StringUtils.startsWith(string1, searchString);
					break;
				case "bn":
					result1 = !StringUtils.startsWith(string1, searchString);
					break;
				case "ew":
					result1 = StringUtils.endsWith(string1, searchString);
					break;
				case "en":
					result1 = !StringUtils.endsWith(string1, searchString);
					break;
				case "cn":
					result1 = StringUtils.contains(string1, searchString);
					break;
				case "nc":
					result1 = !StringUtils.contains(string1, searchString);
					break;
				case "nu":
					result1 = StringUtils.isBlank(string1);
					break;
				case "nn": 
					result1 = StringUtils.isNotBlank(string1);
					break;
				case "in":
				case "ni": 
				case "lt": 
				case "le":  
				case "gt":  
				case "ge":  
				default: break; 
			}
		} else if (object1 instanceof Integer){
			if (NumberUtils.isNumber(searchString)){
				integer1 = (Integer)object1;
				switch (searchOper){
					case "eq": 
						result1 = (NumberUtils.toInt(searchString, 0) == integer1.intValue());
						break;
					case "ne": 
						result1 = (NumberUtils.toInt(searchString, 0) != integer1.intValue());
						break;
					case "lt": 
						result1 = (NumberUtils.toInt(searchString, 0) > integer1.intValue());
						break;
					case "le":  
						result1 = (NumberUtils.toInt(searchString, 0) >= integer1.intValue());
						break;
					case "gt":  
						result1 = (NumberUtils.toInt(searchString, 0) < integer1.intValue());
						break;
					case "ge":  
						result1 = (NumberUtils.toInt(searchString, 0) <= integer1.intValue());
						break;
					case "bw": 
					case "bn": 
					case "ew": 
					case "en": 
					case "cn": 
					case "nc":
					case "in": 
					case "ni": 
					case "nu":
					case "nn":
					default: break; 
				}
			}
		} else if (object1 instanceof java.sql.Timestamp || object1 instanceof java.util.Date){
			if (object1 instanceof java.sql.Timestamp){
				timestamp1 = (java.sql.Timestamp)object1;
				dateTime1 = new org.joda.time.DateTime(timestamp1.getTime());
			} else if (object1 instanceof java.util.Date){
				date1 = (java.util.Date)object1;
				if (date1 != null)
					dateTime1 = new org.joda.time.DateTime(date1);
			}
			try {
				dateTime2 = dateTimeFormatter.parseDateTime(searchString);
			} catch (java.lang.IllegalArgumentException exception1){
				dateTime2 = null;
			}
			if (dateTime2!=null && dateTime1!=null){
				switch (searchOper){
					case "eq": 
						result1 = dateTime1.equals(dateTime2);
						break;
					case "ne":
						result1 = !dateTime1.equals(dateTime2);
						break; 
					case "lt":
						result1 = dateTime1.isBefore(dateTime2);
						break;
					case "le":
						result1 = (dateTime1.isBefore(dateTime2) || dateTime1.equals(dateTime2));
						break;
					case "gt":
						result1 = dateTime1.isAfter(dateTime2);
						break;
					case "ge":
						result1 = (dateTime1.isAfter(dateTime2) || dateTime1.equals(dateTime2));
						break; 
					case "bw": 
					case "bn": 
					case "ew": 
					case "en": 
					case "cn": 
					case "nc":
					case "in": 
					case "ni":
						break;
					case "nu":
						result1 = (timestamp1 == null);
						break;
					case "nn":
						result1 = (timestamp1 != null);
						break;
					default: break; 
				}
			}
		}
		return !result1;
	}

	private static String getTagValue(String tagName1, Element element1) {
		String tagValue1 = null;
		Node node1 = null;
		Element element2 = null;
		NodeList nodeList1 = element1.getElementsByTagName(tagName1);
		if(nodeList1 != null && nodeList1.getLength() > 0) {
			node1 = nodeList1.item(0);
			if (node1.hasChildNodes()){
				if (node1.getNodeType() == Node.ELEMENT_NODE){
					element2 = (Element)node1;
					tagValue1 = element2.getFirstChild().getNodeValue();
				}
			}
		}
		return tagValue1;
	}
}
