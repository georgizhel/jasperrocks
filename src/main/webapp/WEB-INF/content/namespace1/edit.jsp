<%--
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
--%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<%@ taglib prefix="sb" uri="/struts-bootstrap-tags" %>
<%
pageContext.setAttribute("contextPath", request.getContextPath());
pageContext.setAttribute("remoteUser", request.getRemoteUser());
%>
<html>
	<head>
		<script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
		<sj:head 
			jqueryui="true"
			compressed="true"
			loadAtOnce="false"
			loadFromGoogle="false"
			jquerytheme="flick"
			locale="%{locale}"/>
	    	<sb:head includeScripts="true" includeScriptsValidation="false"/>
	</head>
<body>
<s:if test="#attr.remoteUser != null && !#attr.remoteUser.isEmpty()">
	<s:url action="view" namespace="/namespace1" portletMode="view" var="browse0">
		<s:param name="urlString"><s:property value="urlString"/></s:param>
		<s:param name="wsType"><s:property value="wsType"/></s:param>
		<s:param name="sid"><s:property value="sid"/></s:param>
		<s:param name="uid"><s:property value="uid"/></s:param>
		<s:param name="pid"><s:property value="pid"/></s:param>
	</s:url>
	<div class="navbar">
		<div class="navbar-inner">
			<ul class="nav">
				<li>
					<s:a href="%{browse0}"><s:text name="Browse"/></s:a>
				</li>
				<li class="active">
					<s:a href="#"><s:text name="Preferences"/></s:a>
				</li>
			</ul>
		</div>
	</div>
	<div class="container-fluid">
	<s:form id="formEdit1" action="edit" method="POST" namespace="/namespace1" theme="bootstrap" cssClass="form-horizontal" label="%{getText('Server')}">
		<s:hidden id="urlString" name="urlString" value="%{urlString}"/>
		<s:hidden id="wsType" name="wsType" value="%{wsType}"/>
		<s:textfield name="sid" label="%{getText('Host')}" value="%{sid}" size="50" />
		<s:textfield name="uid" label="%{getText('Username')}" value="%{uid}" size="50" />
		<s:password name="pid" label="%{getText('Password')}" value="%{pid}" size="50" />
		<s:textfield name="alias1" label="%{getText('Alias')}" value="%{alias1}" size="50" tooltip="%{getText('Alias')}"/>
		<hr/>
		<s:select label="%{getText('Locale')}"
			list="#{'en':'English',
				'da':'Dansk',
				'de':'Deutsch',
				'es':'Español',
				'fi':'Suomi',
				'fr':'Français',
				'ga':'Gaeilge',
				'hu':'Magyar',
				'it':'Italiano',
				'ja':'日本語',
				'ko':'한국어',
				'nl':'Nederlands',
				'no':'Norsk',
				'pt':'Português',
				'ro':'Român',
				'se':'Svenska',
				'th':'ภาษาไทย',
				'uk':'Український',
				'vi':'Việt',
				'zh_CN':'简体中文',
				'zh_TW':'繁體中文' }"
			name="request_locale" 
			value="%{locale}"
		/>
		<sj:select label="%{getText('Time.zone')}"
			headerKey="-1" headerValue="%{getText('Select.an.item.below')}"
			emptyOption="true"
			href="%{#attr.contextPath}/namespace1/time-zones"
			name="timeZone1"
			list="timeZones"
			value="%{timeZone1}"
		/>
                <div class="form-actions">
			<s:submit value="%{getText('Save')}" name="button1" cssClass="btn"/>
		</div>
	</s:form>
	</div>
</s:if>
<s:else>
	<div class="alert">
		<strong><s:text name="Warning"/>!</strong>&nbsp;<s:text name="Access.denied"/>
	</div>
</s:else>
<p>
<s:if test="hasActionErrors()">
	<s:actionerror theme="bootstrap"/>
</s:if>
<s:if test="hasActionMessages()">
	<s:actionmessage theme="bootstrap"/>
</s:if>
</p>
<footer class="footer">
	<p class="pull-right"><small>Powered by <a href="http://struts.apache.org" target="_blank">Apache Struts&trade;</a></small></p>
	<p><a href="#"><s:text name="Back.to.top"/></a></p>
</footer>
</body>
</html>
