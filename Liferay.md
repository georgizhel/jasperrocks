# Liferay #

Website: http://www.liferay.com

Documentation: http://www.liferay.com/documentation

## Download ##
Download from liferay-portal-tomcat-6.2.0-ce-m4-20130219141333087.zip from http://sourceforge.net/projects/lportal/files/Liferay%20Portal/

## Installation ##
```
cd $HOME
unzip liferay-portal-tomcat-6.2.0-ce-m4-20130219141333087.zip
```

## Start Liferay ##
```
cd liferay-portal-6.2.0-ce-m4/tomcat-7.0.34
bin/startup.sh
```

---

## Protect yourself ##
Although this is an optional step, it may be important to <b>protect your intellectual property legally</b>.

We advise you to change default value of field "Portal Name" to your company name.
![http://wiki.jasperrocks.googlecode.com/git/images/Liferay8.png](http://wiki.jasperrocks.googlecode.com/git/images/Liferay8.png)


Otherwise you will read the term 9 of "Use of Information" as below:
![http://wiki.jasperrocks.googlecode.com/git/images/Liferay9.png](http://wiki.jasperrocks.googlecode.com/git/images/Liferay9.png)
![http://wiki.jasperrocks.googlecode.com/git/images/Liferay10.png](http://wiki.jasperrocks.googlecode.com/git/images/Liferay10.png)


Disabling the "Terms of Use" is another alternative.

Modify $TOMCAT\_HOME/webapps/ROOT/WEB-INF/class/portal-ext.properties as below:
```
terms.of.use.required=false
```

---

## Deployment ##
### War file ###
Copy jasperrocks.war to default deployment directory of Liferay:
```
cp jasperrocks.war $HOME/liferay-portal-6.2.0-ce-m4/deploy
```
### Login ###
Login as Joe Bloggs, username is test@liferay.com and password is test.

![http://wiki.jasperrocks.googlecode.com/git/images/Liferay1.png](http://wiki.jasperrocks.googlecode.com/git/images/Liferay1.png)

### Top menu ###
Go to top menu, click "Add" and "More"
![http://wiki.jasperrocks.googlecode.com/git/images/Liferay2.png](http://wiki.jasperrocks.googlecode.com/git/images/Liferay2.png)

### Portlet ###
Select Ice-creaming and add "JasperServer Rocks", drag and drop to your page.
![http://wiki.jasperrocks.googlecode.com/git/images/Liferay3.png](http://wiki.jasperrocks.googlecode.com/git/images/Liferay3.png)

### Preferences ###
To connect JasperReport Server, host address, username and password are required.
![http://wiki.jasperrocks.googlecode.com/git/images/Liferay4.png](http://wiki.jasperrocks.googlecode.com/git/images/Liferay4.png)


### Operation ###
Browse reports
![http://wiki.jasperrocks.googlecode.com/git/images/Liferay5.png](http://wiki.jasperrocks.googlecode.com/git/images/Liferay5.png)

Choose output format and enter parameters if required.
![http://wiki.jasperrocks.googlecode.com/git/images/Liferay6.png](http://wiki.jasperrocks.googlecode.com/git/images/Liferay6.png)

Print result
![http://wiki.jasperrocks.googlecode.com/git/images/Liferay7.png](http://wiki.jasperrocks.googlecode.com/git/images/Liferay7.png)