## Leave no portal behind ##
Although [there is no secret ingredient](http://www.imdb.com/title/tt0441773/quotes?qt=qt0448742) of open sources, [life doesn't always turn out the way you plan](http://www.imdb.com/title/tt0114924/quotes?qt=qt0421395).

I shall post my unsolved issues to the public forums of the _portal game changers_. I hope that they can give any help. This is what I do and [I've never left any portal behind](https://www.youtube.com/watch?v=JW3WfSFgrVY&t=1m48s). [No portal gets left behind](https://www.youtube.com/watch?v=fCQLF0zR87k&t=6s).

## GateIn ##
**Problem 1**: GateIn creates different sessions but other portals don't ?

> JasperRocks has two packages working together (package1 extended from struts-portlet-default and package2 extended from struts-default). There is nothing wrong with eXo, Liferay, Jetspeed, Pluto and uPortal, but only GateIn creates different sessions.

> Let me reenact the issue in GateIn:

> Step 1: Having browsed and selected a report, choose an output format such as pdf, OpenDocument, Mircosoft word or excel (except html).
> ![http://wiki.jasperrocks.googlecode.com/git/images/Problem2.png](http://wiki.jasperrocks.googlecode.com/git/images/Problem2.png)

> Step 2: Click the download link
> ![http://wiki.jasperrocks.googlecode.com/git/images/Problem3.png](http://wiki.jasperrocks.googlecode.com/git/images/Problem3.png)

> See, the link is broken at GateIn only.
> ![http://wiki.jasperrocks.googlecode.com/git/images/Problem4.png](http://wiki.jasperrocks.googlecode.com/git/images/Problem4.png)

**Solution 1**: Turn on parameter "bugfixGateIn" of system.properties.

> I solve this problem to add a boolean parameter called bugfixGateIn in order to distinguish GateIn. The different session id is passsed as parameter through JSP. A drawback with this approach is the exposure of session id, GateIn makes this portlet insecure.

> I am not sure if it is the same issue at https://community.jboss.org/thread/194734

> References: [ViewAction.java](http://code.google.com/p/jasperrocks/source/browse/src/main/java/ching/icecreaming/action/ViewAction.java) [view.jsp](http://code.google.com/p/jasperrocks/source/browse/src/main/webapp/WEB-INF/content/namespace1/view.jsp) [system.properties](http://code.google.com/p/jasperrocks/source/browse/src/main/resources/system.properties)

---



## Liferay ##
**Problem 1**: Is Liferay backward incompatible with its previous versions ?

> JasperRocks portlet works at Liferay version 6.20 only. Unluckily it is not backward compatible with Liferay version 6.11 or its older versions. Luckily I am not alone to face this problem: http://issues.liferay.com/browse/LPS-25973

> ![http://wiki.jasperrocks.googlecode.com/git/images/Problem1.png](http://wiki.jasperrocks.googlecode.com/git/images/Problem1.png)

> Hi-Fi enthusiasts like to play one single [test CD](http://www.tnt-audio.com/topics/denon_cd_e.html) to measure and test different brands of high fidelity equipments. Similarly I use this portlet to measure and test different versions of portals. Here is some results:

|Portal|Community version|Result|
|:-----|:----------------|:-----|
|Liferay|6.20             |Pass  |
|Liferay|6.11             |Fail  |
|Liferay|6.06             |Fail  |
|eXo Platform|4.0.0            |Pass  |
|eXo Platform|3.5.5            |Pass  |
|JBoss GateIn|3.5.0            |Pass  |
|JBoss GateIn|3.4.0            |Pass  |
|JBoss GateIn|3.3.0            |Pass  |
|JBoss GateIn|3.2.0            |Pass  |
|Jasig uPortal|4.0.11           |Pass  |
|Jasig uPortal|4.0.10           |Pass  |
|Jasig uPortal|4.0.9            |Pass  |
|Pluto |2.1.0            |Pass  |
|Pluto |2.0.3            |Pass  |

> Please note that the above table is unfairly aimed at Liferay. To be fair, I have posted this issue to alert Liferay at its forum: http://www.liferay.com/community/forums/-/message_boards/message/22209630

**Status**: unsolved.

---



## Bootstrap ##
**Problem 1**: Fonts affect portlet display.

> Portlet display has been distorted by fonts since bootstrap plugin introduced.
> ![http://wiki.jasperrocks.googlecode.com/git/images/Feature8.png](http://wiki.jasperrocks.googlecode.com/git/images/Feature8.png)

> But it doesn't have to be that way, the search box should be like this way (Below is my another non-portlet project "[JasperClient](http://jasperclient.googlecode.com)"):
![http://wiki.jasperrocks.googlecode.com/git/images/Step2Search.png](http://wiki.jasperrocks.googlecode.com/git/images/Step2Search.png)

**Status**: unsolved

---



## FreeMarker ##
**Problem 1**: Runtime errors of using https.

> If you build sources by [maven](http://maven.apache.org), errors occur at runtime like below:
```
ERROR [freemarker.runtime] Template processing error: "get(requestURL) failed on instance of org.apache.struts2.portlet.servlet.PortletServletRequest"
get(requestURL) failed on instance of org.apache.struts2.portlet.servlet.PortletServletRequest
The problematic instruction:
-------------
==> ${request.requestURL.substring(0, request.requestURL.indexOf(':'))} [on line 34, column 18 in template/jquery/head.ftl]
```

**Solution 1**: Apply another bug fix to the bug fix.

> The reason is caused by a bug fix: http://code.google.com/p/struts2-jquery/source/detail?r=1727&path=/trunk/struts2-jquery-plugin/src/main/resources/template/jquery/head.ftl

> [struts2-jquery](http://code.google.com/p/struts2-jquery) is right to fix loadFromGoogle using https. The bug fix is a conflict between plugins: struts2-jquery and struts-portlet. I need to do the following modification of Struts2 jQuery plugin core library:
  1. Decompress struts2-jquery-plugin-3.5.1.jar
  1. Open and edit freemarker template file: "template/jquery/head.ftl".
  1. Delete line 34  <#assign schema="${request.requestURL.substring(0, request.requestURL.indexOf(':'))}"> and replace it with <#assign schema="http">

---



## Jahia ##
**Problem 1**: I fail Jahia or Jahia fails me !?

> JasperRocks does not include Jahia because there is two bugs still under investigation (See [here](Jahia#Preferences.md)):
  1. Field list "Time zone" of combobox cannot be displayed at the tab "Preference".
  1. No item in the browse windows.

> Because these problems do not happen at other portals. I am seeking any compromise to solve it. Furthermore I have posted these issues to Jahia forum. http://www.jahia.com/cms/home/download/forum/general/jahia-in-english/does-jahia-work-at-jasperrocks.html

**Status**: unsolved.

---


.

.

.

We're not perfect. **Portals** aren't perfect. We want to make our users happy.

![http://wiki.jasperrocks.googlecode.com/git/images/WeReNotPerfect.png](http://wiki.jasperrocks.googlecode.com/git/images/WeReNotPerfect.png)