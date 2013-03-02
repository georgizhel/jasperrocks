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
<%@ taglib prefix="s" uri="/struts-tags"%>
<head>
	<title>Errors</title>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
</head>
<s:if test="hasActionErrors()">
	<s:actionerror/>
</s:if>
<s:if test="hasFieldErrors()">  
	<s:fielderror />
</s:if>
<s:if test="hasActionMessages()">
	<s:actionmessage/>
</s:if>
