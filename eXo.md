# eXo Platform #
Website: http://www.exoplatform.com

Documentation: http://community.exoplatform.com/portal/classic/documentation-public
## Download ##
Download eXo-Platform-community-3.5.5.zip from http://download.forge.objectweb.org/exoplatform
## Installation ##
```
unzip eXo-Platform-community-3.5.5.zip
```
## Start eXo Platform ##
```
cd tomcat-bundle
./start-eXo.sh  
```

For example: browse http://localhost:8080/portal/
![http://wiki.jasperrocks.googlecode.com/git/images/eXo1.png](http://wiki.jasperrocks.googlecode.com/git/images/eXo1.png)

---

## Deployment ##
### War file ###
```
cp jasperrocks.war tomcat-bundle/webapps
```
### Login ###
I have just used default user accounts provided by eXo Platform:
  * Browse http://localhost:8080/portal/login
  * Login as John Smith (administrator)
|username|john|
|:-------|:---|
|password|gtn |

![http://wiki.jasperrocks.googlecode.com/git/images/eXo2.png](http://wiki.jasperrocks.googlecode.com/git/images/eXo2.png)

### Applications ###
Go to top menu and click Applications
![http://wiki.jasperrocks.googlecode.com/git/images/eXo3.png](http://wiki.jasperrocks.googlecode.com/git/images/eXo3.png)

### Portlets ###
Go to top right corner of window "Manage applications" and choose "Portlets"
![http://wiki.jasperrocks.googlecode.com/git/images/eXo4.png](http://wiki.jasperrocks.googlecode.com/git/images/eXo4.png)

### Categories ###
  * Go to left menu "LOCAL" to select "JasperServer rocks"
  * **You must add this portlet to a category before using it in a page.** Click here to add this portlet to a category.
![http://wiki.jasperrocks.googlecode.com/git/images/eXo5.png](http://wiki.jasperrocks.googlecode.com/git/images/eXo5.png)

I choose category "Content" as my example and save the settings.
![http://wiki.jasperrocks.googlecode.com/git/images/eXo6.png](http://wiki.jasperrocks.googlecode.com/git/images/eXo6.png)

### Page ###
Next step I go to a page, for example: Go to top menu "My Sites", choose side menu "intranet" and select "Home"
![http://wiki.jasperrocks.googlecode.com/git/images/eXo7.png](http://wiki.jasperrocks.googlecode.com/git/images/eXo7.png)

### Layout ###
Each page has its layout.
Go to top menu and select "Edit", then "Page" and choose "Layout" at side menu.
![http://wiki.jasperrocks.googlecode.com/git/images/eXo8.png](http://wiki.jasperrocks.googlecode.com/git/images/eXo8.png)

### Page Editor ###
Drag and drop "JasperServer rocks" at the box of page editor and save the setting.
![http://wiki.jasperrocks.googlecode.com/git/images/eXo9.png](http://wiki.jasperrocks.googlecode.com/git/images/eXo9.png)

### Preferences ###
To connect JasperReports Server, host address, user name and password are required.
![http://wiki.jasperrocks.googlecode.com/git/images/eXo10.png](http://wiki.jasperrocks.googlecode.com/git/images/eXo10.png)

### Operation ###
Browse and select a report
![http://wiki.jasperrocks.googlecode.com/git/images/eXo11.png](http://wiki.jasperrocks.googlecode.com/git/images/eXo11.png)

Choose output format and enter parameters (if your report require).
![http://wiki.jasperrocks.googlecode.com/git/images/eXo12.png](http://wiki.jasperrocks.googlecode.com/git/images/eXo12.png)

Voila

![http://wiki.jasperrocks.googlecode.com/git/images/eXo13.png](http://wiki.jasperrocks.googlecode.com/git/images/eXo13.png)