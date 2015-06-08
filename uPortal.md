# Jasig uPortal #
Website: http://www.jasig.org/uportal

Documentation: http://www.jasig.org/uportal/documentation

## Download ##

Download uPortal-4.0.11-quick-start.tar.gz from http://downloads.jasig.org/uportal/uPortal-4.0.11

## Installation ##
```
cd $HOME
tar zxvf uPortal-4.0.11-quick-start.tar.gz
```

## Start uPortal ##
```
export ANT_HOME=$HOME/uPortal-4.0.11-quick-start/apache-ant-1.8.2
ant start
```

---

## Deployment ##
### War file ###
Copy jasperrocks.war to directory of web applications.
```
cp jasperrocks.war $TOMCAT_HOME/webapps
```
Browse: http://localhost:8080/uPortal
![http://wiki.jasperrocks.googlecode.com/git/images/uPortal1.png](http://wiki.jasperrocks.googlecode.com/git/images/uPortal1.png)

### Sign in ###
Default username is admin and password is admin.
![http://wiki.jasperrocks.googlecode.com/git/images/uPortal2.png](http://wiki.jasperrocks.googlecode.com/git/images/uPortal2.png)

### Administration ###
At windows "Portal Administration Tools", go to "Portal Entity Administration" and select "Manage portlets"
![http://wiki.jasperrocks.googlecode.com/git/images/uPortal3.png](http://wiki.jasperrocks.googlecode.com/git/images/uPortal3.png)

### Portlet Registry ###
Click the button "Register New portlets"
![http://wiki.jasperrocks.googlecode.com/git/images/uPortal4.png](http://wiki.jasperrocks.googlecode.com/git/images/uPortal4.png)

### Register New Portlet ###
Click option "Portlet"
![http://wiki.jasperrocks.googlecode.com/git/images/uPortal5.png](http://wiki.jasperrocks.googlecode.com/git/images/uPortal5.png)

### Summary Information ###
Select "/jasperrocks" and then "JasperServer Rocks" from pulldown menu.

![http://wiki.jasperrocks.googlecode.com/git/images/uPortal6.png](http://wiki.jasperrocks.googlecode.com/git/images/uPortal6.png)

### Portlet Functional Name ###
You must fill in the blank of "Portlet Functional Name"
![http://wiki.jasperrocks.googlecode.com/git/images/uPortal7.png](http://wiki.jasperrocks.googlecode.com/git/images/uPortal7.png)

### Miscellaneous ###
It is optional to fill in the following fields:
  * portlet.xml Preferences
  * Portlet Descriptor
  * Portlet Titles
  * Portlet Preferences
  * Display Settings
![http://wiki.jasperrocks.googlecode.com/git/images/uPortal8.png](http://wiki.jasperrocks.googlecode.com/git/images/uPortal8.png)

### Categories ###
Select categories
![http://wiki.jasperrocks.googlecode.com/git/images/uPortal9.png](http://wiki.jasperrocks.googlecode.com/git/images/uPortal9.png)

### People and Groups ###
Select people and groups
![http://wiki.jasperrocks.googlecode.com/git/images/uPortal10.png](http://wiki.jasperrocks.googlecode.com/git/images/uPortal10.png)

### Optional fields ###
Fill in the remaining fields:
  * Lifecycle Management
  * Automatic Publishing (optional)
  * Automatic Expiration (optional)
![http://wiki.jasperrocks.googlecode.com/git/images/uPortal11.png](http://wiki.jasperrocks.googlecode.com/git/images/uPortal11.png)

### Review and save ###
Save Configuration
![http://wiki.jasperrocks.googlecode.com/git/images/uPortal12.png](http://wiki.jasperrocks.googlecode.com/git/images/uPortal12.png)

### JasperRocks portlet is registered ###
![http://wiki.jasperrocks.googlecode.com/git/images/uPortal13.png](http://wiki.jasperrocks.googlecode.com/git/images/uPortal13.png)

### Example ###
Go to a page and customize it. I choose "Testing" as example, search portlet "JasperServerRocks" and click add at the top right corner of the box.
![http://wiki.jasperrocks.googlecode.com/git/images/uPortal14.png](http://wiki.jasperrocks.googlecode.com/git/images/uPortal14.png)

### Preferences ###
To connect JasperRocks Server, host address, username and password are required.
![http://wiki.jasperrocks.googlecode.com/git/images/uPortal15.png](http://wiki.jasperrocks.googlecode.com/git/images/uPortal15.png)

### Operation ###
Browse window
![http://wiki.jasperrocks.googlecode.com/git/images/uPortal16.png](http://wiki.jasperrocks.googlecode.com/git/images/uPortal16.png)

Select output format and enter parameters (if you report requires)
![http://wiki.jasperrocks.googlecode.com/git/images/uPortal17.png](http://wiki.jasperrocks.googlecode.com/git/images/uPortal17.png)

See result
![http://wiki.jasperrocks.googlecode.com/git/images/uPortal18.png](http://wiki.jasperrocks.googlecode.com/git/images/uPortal18.png)