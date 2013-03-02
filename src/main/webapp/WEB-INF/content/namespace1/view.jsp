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
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sjg" uri="/struts-jquery-grid-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<%@ taglib prefix="sb" uri="/struts-bootstrap-tags" %>
<%@ page import="ching.icecreaming.model.DataModel1" %>
<%@ page import="ching.icecreaming.model.DataModel2" %>
<%
pageContext.setAttribute("contextPath", request.getContextPath());
pageContext.setAttribute("remoteUser", request.getRemoteUser());
pageContext.setAttribute("sessionId", session.getId());
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
			locale="%{locale}"
		/>
	    	<sb:head includeScripts="true" includeScriptsValidation="false"/>
		<script type="text/javascript" src="<s:url value="/js/js1.js"/>"></script>
		<link href="${pageContext.request.contextPath}/styles/css1.css" rel="stylesheet" type="text/css"/>
	</head>
<body>
	<s:url action="edit" namespace="/namespace1" portletMode="edit" var="edit0">
		<s:param name="urlString"><s:property value="urlString"/></s:param>
		<s:param name="wsType"><s:property value="wsType"/></s:param>
		<s:param name="timeZone1"><s:property value="timeZone1"/></s:param>
	</s:url>
	<div class="navbar">
		<div class="navbar-inner">
			<ul class="nav">
				<li class="active">
					<s:a href="#"><s:text name="Browse"/></s:a>
				</li>
				<s:if test="#attr.remoteUser != null && !#attr.remoteUser.isEmpty()">
				<li>
					<s:a href="%{edit0}"><s:text name="Preferences"/></s:a>
				</li>
				</s:if>
			</ul>
		</div>
	</div>

<s:if test="#attr.remoteUser != null && !#attr.remoteUser.isEmpty()">
	<s:if test="%{alias1 neq null && alias1 neq ''}">
		<span class="label"><s:text name="Server"/>:&nbsp;<s:property value="alias1"/></span>
	</s:if>
	<span class="label"><s:text name="Time.zone"/>:&nbsp;<s:property value="timeZone1"/></span>
	<span class="label"><s:text name="Time"/>:&nbsp;<s:date name="%{new java.util.Date()}" format="yyyy-MM-dd HH:mm:ss" timezone="%{timeZone1}"/></span>
	<s:if test="%{message1 neq null && message1 neq ''}">
		<span class="label"><s:property value="message1"/></span>
	</s:if>
	<s:url action="view" namespace="/namespace1" portletMode="view" var="view0"/>
	<ul class="breadcrumb"/>
		<s:a class="brand" href="%{view0}"><i class="icon-hdd"></i></s:a>
		<s:if test="#session.breadcrumbs.size>0">
			<li>
				<s:a href="%{view0}">/</s:a><span class="divider">&gt;</span>
			</li>
		</s:if>
		<s:else>
			<li class="active"><a href="#">/</a></li>
		</s:else>
		<s:iterator value="#session.breadcrumbs" status="status1" var="var1">
			<s:if test="#session.breadcrumbs.size>#status1.count">
				<s:url action="view" namespace="/namespace1" portletMode="view" var="url1" >
					<s:param name="urlString"><s:property value="string1"/></s:param>
					<s:param name="sid"><s:property value="sid"/></s:param>
					<s:param name="uid"><s:property value="uid"/></s:param>
					<s:param name="pid"><s:property value="pid"/></s:param>
					<s:param name="timeZone1"><s:property value="timeZone1"/></s:param>
					<s:param name="wsType">folder</s:param>
				</s:url>
				<li><s:a href="%{url1}"><s:property value="string2"/></s:a><span class="divider">&gt;</span></li>
			</s:if>
			<s:else>
				<s:if test="%{wsType=='folder'}">
					<li class="active"><s:property value="string2"/></li>
				</s:if>
				<s:else>
					<s:url action="view" namespace="/namespace1" portletMode="view" var="url1" >
						<s:param name="urlString"><s:property value="string1"/></s:param>
						<s:param name="sid"><s:property value="sid"/></s:param>
						<s:param name="uid"><s:property value="uid"/></s:param>
						<s:param name="pid"><s:property value="pid"/></s:param>
						<s:param name="timeZone1"><s:property value="timeZone1"/></s:param>
						<s:param name="wsType"><s:property value="wsType"/></s:param>
					</s:url>
					<li class="active"><s:a href="%{url1}"><s:property value="string2"/></s:a></li>
				</s:else>
			</s:else>
		</s:iterator>
	</ul>
</s:if>
<s:if test="%{result1!=null}">
	<s:if test="%{bugfixGateIn}">
		<s:url id="download1" value="/namespace1/file-link">
			<s:param name="fileName"><s:property value="urlString"/>.<s:property value="format1"/></s:param>
			<s:param name="sessionId"><s:property value="#attr.sessionId"/></s:param>
		</s:url>
	</s:if>
	<s:else>
		<s:url id="download1" value="/namespace1/file-link">
			<s:param name="fileName"><s:property value="urlString"/>.<s:property value="format1"/></s:param>
		</s:url>
	</s:else>
	<div class="well-small">
		<s:text name="Download"/>:&nbsp;<s:a href="%{download1}"><s:property value="urlString"/>.<s:property value="format1"/></s:a>
	</div>
	<s:if test="%{format1=='html'}">
		<s:property value="result1" escapeHtml="false"/>
	</s:if>
</s:if>
<s:elseif test="%{wsType=='folder'}">
	<s:url id="gridView" value="/namespace1/resource-descriptors" >
		<s:param name="urlString"><s:property value="urlString"/></s:param>
		<s:param name="sid"><s:property value="sid"/></s:param>
		<s:param name="uid"><s:property value="uid"/></s:param>
		<s:param name="pid"><s:property value="pid"/></s:param>
		<s:param name="timeZone1"><s:property value="timeZone1"/></s:param>
		<s:param name="request_locale"><s:property value="locale"/></s:param>
	</s:url>
	<sjg:grid
		id="grid1"
		name="grid1"
		autowidth="true"
		caption="%{getText('Location')}: %{urlString}"
		dataType="json"
	        gridModel="gridModel"
		hiddengrid="false"
		href="%{gridView}"
		multiselect="false"
		navigator="true"
		navigatorAdd="false"
		navigatorEdit="false"
		navigatorDelete="false"
		navigatorSearch="true"
		navigatorSearchOptions="{multipleSearch:false,reloadAfterSubmit:true}"
		navigatorView="true"
		pager="true"
	        rowList="5,10,50,100,500,1000"
	        rowNum="100"
	        rownumbers="false"
	    	viewrecords="true"
		width="1888"
		onSelectRowTopics="grid1OnSelectRowTopics"
	    >
	        <sjg:gridColumn
			id="type1" 
			name="type1" 
			width="5" 
			title="%{getText('Type')}" 
			align="center"
			search="false"
			hidden="false"
		/>
	        <sjg:gridColumn
			id="label1" 
			name="label1" 
			width="15" 
			title="%{getText('Label')}" 
			align="left"
			search="true" 
		/>
	        <sjg:gridColumn
			id="description" 
			name="description" 
			width="50" 
			title="%{getText('Description')}" 
			align="left"
			search="true"
		/>
	        <sjg:gridColumn
			id="creationDate" 
			name="creationDate" 
			width="10" 
			title="%{getText('Creation.date')}" 
			align="left"
			search="false"
			formatter="date"
			formatoptions="{newformat : 'Y-m-d H:i:s', srcformat : 'Y-m-d H:i:s'}"
		/>
	        <sjg:gridColumn
			id="wsType" 
			name="wsType" 
			width="10" 
			title="Type" 
			align="left"
			search="false"
			hidden="true"
		/>
	        <sjg:gridColumn
			id="uriString" 
			name="uriString" 
			width="10" 
			title="Path" 
			align="left"
			search="false"
			hidden="true"
		/>
	</sjg:grid>
	<s:if test="#attr.remoteUser != null && !#attr.remoteUser.isEmpty()">
	<s:form id="formView1" action="view" theme="xhtml"><s:hidden id="urlString" name="urlString" value=""/><s:hidden id="wsType" name="wsType" value=""/>
		<s:hidden id="label1" name="label1" value=""/>
		<s:hidden id="sid" name="sid" value="%{sid}"/>
		<s:hidden id="uid" name="uid" value="%{uid}"/>
		<s:hidden id="pid" name="pid" value="%{pid}"/>
	</s:form>
	</s:if>
</s:elseif>
<s:elseif test="%{wsType=='reportUnit'}">
	<s:form id="formView2" action="view" method="POST" namespace="/namespace1" theme="bootstrap" cssClass="form-horizontal" label="%{getText('Report')+': '+#session.breadcrumbs[#session.breadcrumbs.size-1].string2}">
		<s:hidden id="urlString" name="urlString" value="%{urlString}"/>
		<s:hidden id="wsType" name="wsType" value="reportUnit"/>
		<s:hidden id="sid" name="sid" value="%{sid}"/>
		<s:hidden id="uid" name="uid" value="%{uid}"/>
		<s:hidden id="pid" name="pid" value="%{pid}"/>
		<s:radio label="%{getText('Format')}" 
			list="#{
				'pdf':'pdf - Portable Document Format',
				'html':'html - HyperText Markup Language',
				'odt':'odt - OpenDocument Text',
				'ods':'ods - OpenDocument spreadsheet',
				'docx':'docx - Microsoft Word',
				'xlsx':'xlsx - Microsoft Excel'
			}" name="format1" />
		<s:textfield name="page1" label="%{getText('Page')}" value="%{getText('All')}" size="3" />
		<s:if test="%{map1!=null}">
			<s:select list="map1" name="locale2" label="%{getText('Locale')}" headerKey="" headerValue = "%{getText('Select.an.item.below')}"/>
		</s:if>
		<s:if test="%{listObject2!=null}">
			<legend><s:text name="Parameters"/></legend>
			<s:iterator value="listObject2" status="status2" var="var2">
				<s:hidden name="listObject2[%{#status2.index}].id" value="%{#var2.id}"/>
				<s:hidden name="listObject2[%{#status2.index}].type1" value="%{#var2.type1}"/>
				<s:if test="%{#var2.type1=='bool'}">
					<s:checkbox name="listObject2[%{#status2.index}].value1" fieldValue="%{#var2.value1}" value="%{#var2.value1}" label="%{#var2.label1}"/>
				</s:if>
				<s:elseif test="%{#var2.type1=='singleSelect'}">
					<s:select key="listObject2[%{#status2.index}].options.string2" list="options" listKey="string2" listValue="string1" label="%{#var2.label1}" value="%{#var2.value1}" />

				</s:elseif>
				<s:elseif test="%{#var2.type1=='singleSelectRadio'}">
					<s:radio key="listObject2[%{#status2.index}].options.string2" list="options" listKey="string2" listValue="string1" label="%{#var2.label1}" value="%{#var2.value1}" />
				</s:elseif>
				<s:elseif test="%{#var2.type1=='multiSelect'}">
					<s:select key="listObject2[%{#status2.index}].options.string2" list="options" listKey="string2" listValue="string1" label="%{#var2.label1}" value="%{#var2.value1}" multiple="true" />
				</s:elseif>
				<s:elseif test="%{#var2.type1=='multiSelectCheckbox'}">
					<s:checkboxlist key="listObject2[%{#status2.index}].options.string2" list="options" listKey="string2" listValue="string1" label="%{#var2.label1}" value="%{#var2.value1}" />
				</s:elseif>
				<s:elseif test="%{#var2.type1=='singleValueDate'}">
					<sj:datepicker name="listObject2[%{#status2.index}].value1" label="%{#var2.label1}" value="%{#var2.value1}" displayFormat="yy-mm-dd" timepicker="false"/>
				</s:elseif>
				<s:elseif test="%{#var2.type1=='singleValueDatetime'}">
					<sj:datepicker name="listObject2[%{#status2.index}].value1" label="%{#var2.label1}" value="%{#var2.value1}" displayFormat="yy-mm-dd" timepicker="true"/>
				</s:elseif>
				<s:elseif test="%{listObject2.type1=='singleValueText'}">
					<s:textfield name="listObject2[%{#status2.index}].value1" label="%{#var2.label1}" value="%{#var2.value1}" size="20"/>
				</s:elseif>
				<s:elseif test="%{#var2.type1=='singleValueNumber'}">
					<s:textfield name="listObject2[%{#status2.index}].value1" label="%{#var2.label1}" value="%{#var2.value1}" size="20"/>
				</s:elseif>
				<s:else>
					<s:textfield name="listObject2[%{#status2.index}].value1" label="%{#var2.label1}" value="%{#var2.value1}" size="20"/>
				</s:else>
			</s:iterator>
		</s:if>
		<div class="form-actions">
			<s:submit key="Print" name="button1"/>
		</div>
	</s:form>
</s:elseif>
<s:else>
	<s:property value="urlString"/><s:property value="wsType"/>
</s:else>
<p>
<s:if test="hasActionErrors()">
	<s:actionerror theme="jquery"/>
</s:if>
<s:if test="hasActionMessages()">
	<s:actionmessage theme="jquery"/>
</s:if>
</p>
<footer class="footer">
	<p class="pull-right"><small>Powered by <a href="http://struts.apache.org" target="_blank">Apache Struts&trade;</a></small></p>
	<p><a href="#"><s:text name="Back.to.top"/></a></p>
</footer>
</body>
</html>
