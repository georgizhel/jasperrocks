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
package ching.icecreaming.actions;
import java.io.BufferedReader;
import java.io.BufferedInputStream;
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
import javax.portlet.PortletContext;
import javax.portlet.PortletRequest;
import javax.portlet.PortletPreferences;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanComparator;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.collections.ComparatorUtils;
import org.apache.commons.collections.comparators.ReverseComparator;
import org.apache.commons.collections.comparators.ComparableComparator;
import org.apache.commons.collections.ListUtils;
import org.apache.commons.configuration.Configuration;
import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.ConfigurationUtils;
import org.apache.commons.configuration.HierarchicalConfiguration;
import org.apache.commons.configuration.PropertiesConfiguration;
import org.apache.commons.configuration.XMLConfiguration;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.apache.commons.lang3.math.NumberUtils;
import org.apache.commons.lang3.StringEscapeUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.SessionAware;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Actions;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.ResultPath;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormatter;

import com.opensymphony.xwork2.ActionSupport;

@Namespace("/namespace1")
@ParentPackage(value = "package2")
@ResultPath("/WEB-INF/content")
public class FileLink extends ActionSupport implements ServletRequestAware {
	private static final long serialVersionUID = 201212091326L;
	private HttpServletRequest httpServletRequest;
	private HttpServletResponse httpServletResponse;
	private InputStream imageStream;
	private String fileName, contentType, fileExtension, sessionId;

	@Action(value = "file-link", results = {
		@Result(name = "success", type = "stream",
			params={"inputName", "imageStream",
				"contentType", "${contentType}", 
				"contentDisposition", "attachment;filename=${fileName}",
				"allowCaching", "false",
				"bufferSize", "1024"
			}),
		@Result(name = "error", location = "errors.jsp")
	} )
	public String execute() throws Exception {
		Configuration propertiesConfiguration1 = new PropertiesConfiguration("mimeTypes.properties");
		File file1 = null, file2 = null;
		String string1 = null, fileExtension = null;
		fileExtension = FilenameUtils.getExtension(fileName);
		contentType = "application/octet-stream";
		if (!StringUtils.isBlank(fileExtension)){
			if (propertiesConfiguration1.containsKey(fileExtension))
				contentType = propertiesConfiguration1.getString(fileExtension);
		} else {
			contentType="image/png";
		}
		try {
			if (StringUtils.isBlank(sessionId)){
				sessionId = httpServletRequest.getSession().getId();
			}
			string1 = System.getProperty("java.io.tmpdir") +File.separator +sessionId;
			if (StringUtils.isBlank(fileExtension))
				string1+= File.separator+FilenameUtils.getPath(fileName);
			fileName = FilenameUtils.getName(fileName);
			if (StringUtils.equalsIgnoreCase(fileExtension, "html")){
				file2 = new File(string1, FilenameUtils.getBaseName(fileName)+".zip");
				if (file2.exists()){
					file1 = file2;
					contentType = "application/zip";
					fileName = file2.getName();
				} else {
					file1 = new File(string1, fileName);
				}
			} else {
				file1 = new File(string1, fileName);
			}
			if (file1.exists()){
				imageStream = new BufferedInputStream(FileUtils.openInputStream(file1));
			}
		} catch (IOException exception1){
			addActionError(exception1.getMessage());
			return ERROR;
		}
		return SUCCESS;
	}

	public String getFileName(){
		return fileName;
	}
	public void setFileName(String fileName){
		this.fileName = fileName;
	}
	public String getContentType(){
		return contentType;
	}
	public InputStream getImageStream(){
		return imageStream;
	}
	public void setServletRequest(HttpServletRequest httpServletRequest) {
		this.httpServletRequest = httpServletRequest;
	}
	public void setServletResponse(HttpServletResponse httpServletResponse) {
		this.httpServletResponse = httpServletResponse;
	}
	public void setSessionId(String sessionId){
		this.sessionId = sessionId;
	}
}
