# JBoss GateIn #
Website: http://www.jboss.org/gatein

Documentation: https://docs.jboss.org/author/display/GTNPORTALDOC/Home

## Download ##
Download GateIn-3.5.0.Final-tomcat7.zip from http://www.jboss.org/gatein/download
## Installation ##
```
unzip GateIn-3.5.0.Final-tomcat7.zip
```
## Start GateIn ##
```
cd GateIn-3.5.0.Final-tomcat7/bin
./gatein.sh start
```

---

## Deployment ##
### War file ###
Copy jasperrocks.war to web applcation directory of GateIn.
```
cp jasperrocks.war GateIn-3.5.0.Final-tomcat7/webapps
```

### Configuration ###
Set value of "bugfixGateIn" as true of configuration file "system.properties".
```
vim GateIn-3.5.0.Final-tomcat7/webapps/jasperrocks/WEB-INF/classes/system.properties
bugfixGateIn=true
```

### Login ###
Login as administrator, default username is root and password is gtn.
![http://wiki.jasperrocks.googlecode.com/git/images/GateIn1.png](http://wiki.jasperrocks.googlecode.com/git/images/GateIn1.png)

### Administration ###
Go to top menu, choose "Group", and then side menu "Administration" and then "Application Registry"

![http://wiki.jasperrocks.googlecode.com/git/images/GateIn2.png](http://wiki.jasperrocks.googlecode.com/git/images/GateIn2.png)

### Import Applications ###
Click "Import Application" at the top right corner of window "Categories"
![http://wiki.jasperrocks.googlecode.com/git/images/GateIn4.png](http://wiki.jasperrocks.googlecode.com/git/images/GateIn4.png)

### Categories ###
Click "Portlet" at the top right corner of window "Categories" and select "JasperServer Rocks" at left side menu.
![http://wiki.jasperrocks.googlecode.com/git/images/GateIn3.png](http://wiki.jasperrocks.googlecode.com/git/images/GateIn3.png)

### Pages ###
Now JasperRocks is ready. For an example page, go to "Group", "User's Pages", "My Link", and then "Blog"
![http://wiki.jasperrocks.googlecode.com/git/images/GateIn11.png](http://wiki.jasperrocks.googlecode.com/git/images/GateIn11.png)

### Layout ###
At the top menu, go to "Group Editor" and then "Edit Layout".
![http://wiki.jasperrocks.googlecode.com/git/images/GateIn10.png](http://wiki.jasperrocks.googlecode.com/git/images/GateIn10.png)

### Inline Composer ###
To add a portlet into page, drag and drop "JasperServer rocks" of "Ice-creaming" at the "Inline Composer"
![http://wiki.jasperrocks.googlecode.com/git/images/GateIn5.png](http://wiki.jasperrocks.googlecode.com/git/images/GateIn5.png)

### Preferences ###
To connect JasperReports Server, host address, user name and password are required.
![http://wiki.jasperrocks.googlecode.com/git/images/GateIn6.png](http://wiki.jasperrocks.googlecode.com/git/images/GateIn6.png)

### Operation ###
Browse reports
![http://wiki.jasperrocks.googlecode.com/git/images/GateIn7.png](http://wiki.jasperrocks.googlecode.com/git/images/GateIn7.png)

Choose output format and enter parameters if required.
![http://wiki.jasperrocks.googlecode.com/git/images/GateIn8.png](http://wiki.jasperrocks.googlecode.com/git/images/GateIn8.png)

Print result
![http://wiki.jasperrocks.googlecode.com/git/images/GateIn9.png](http://wiki.jasperrocks.googlecode.com/git/images/GateIn9.png)