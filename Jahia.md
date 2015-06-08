# Jahia #

Website: http://www.jahia.com

Documentation: http://www.jahia.com/cms/home/download/jahia-academy/documentation.html

## Download ##
  1. Download package Jahia-xCM-661-DEMOPACK.zip from http://www.jahia.com/cms/home/download/download/download-community-distribution.html
  1. Download sources Jahia\_xCM\_v6.6.1.0\_r43343\_src.tar.gz from http://www.jahia.com/public/jahia-6.6.1/src/Jahia_xCM_v6.6.1.0_r43343_src.tar.gz

## Installation ##
### Decompress the package ###
```
cd $HOME
unzip Jahia-xCM-661-DEMOPACK.zip
```

### Unleashed the force of portlet ###
  1. According to page 7 of [Portlet Integration Guide](http://www.jahia.com/cms/home/download/jahia-academy/documentation/guide-des-portlets.html), it is important to enable the display of Portlet Tab
  1. Uncomment the PortletBrowseTabItem in line 470-526 of applicationcontext-editmode.xml
```
cd $HOME
mkdir -p Jahia-xCM-661-DEMOPACK/tomcat/webapps/ROOT/WEB-INF/etc/spring/uicomponents
tar zxvf Jahia_xCM_v6.6.1.0_r43343_src.tar.gz
cp Jahia_xCM_v6.6.1.0_r43343_src/core/src/main/resources/org/jahia/defaults/config/spring/uicomponents/applicationcontext-editmode.xml Jahia-xCM-661-DEMOPACK/tomcat/webapps/ROOT/WEB-INF/etc/spring/uicomponents/
vim Jahia-xCM-661-DEMOPACK/tomcat/webapps/ROOT/WEB-INF/etc/spring/uicomponents/applicationcontext-editmode.xml
```

## Start Jahia ##
```
cd Jahia-xCM-661-DEMOPACK/tomcat
bin/startup.sh
```

---

## Deployment ##
  * open a browser and go to http://localhost:8080/administration
  * Login username "root" and default password is "root".
![http://wiki.jasperrocks.googlecode.com/git/images/Jahia1.png](http://wiki.jasperrocks.googlecode.com/git/images/Jahia1.png)

### War file ###
Copy jasperrocks.war to default deployment directory of Jahia:
```
cp jasperrocks.war $HOME/Jahia-xCM-661-DEMOPACK/tomcat/webapps
```

### Jahia Administration ###
At the tab "Server settings", click button "Manage portlets"
![http://wiki.jasperrocks.googlecode.com/git/images/Jahia2.png](http://wiki.jasperrocks.googlecode.com/git/images/Jahia2.png)

### Manage portlets ###
Click button "Refresh" at the window 'Manage portlets"
![http://wiki.jasperrocks.googlecode.com/git/images/Jahia3.png](http://wiki.jasperrocks.googlecode.com/git/images/Jahia3.png)

### JasperRocks is ready ###
![http://wiki.jasperrocks.googlecode.com/git/images/Jahia4.png](http://wiki.jasperrocks.googlecode.com/git/images/Jahia4.png)

## Sample site ##
### Web project management ###
Click button "Create" under window "Web Project management"
![http://wiki.jasperrocks.googlecode.com/git/images/Jahia5.png](http://wiki.jasperrocks.googlecode.com/git/images/Jahia5.png)

### Step 1 New Web Project properties ###
  * Enter project title, web project host name, key and description.
  * Click button "Next step"
![http://wiki.jasperrocks.googlecode.com/git/images/Jahia6.png](http://wiki.jasperrocks.googlecode.com/git/images/Jahia6.png)

### Step 2 Please choose a template set ###
  * Choose a template set
  * Click button "Next step"
![http://wiki.jasperrocks.googlecode.com/git/images/Jahia7.png](http://wiki.jasperrocks.googlecode.com/git/images/Jahia7.png)

### Step 3: Create your Web Project ###
Click button "Create your Web Project"
![http://wiki.jasperrocks.googlecode.com/git/images/Jahia8.png](http://wiki.jasperrocks.googlecode.com/git/images/Jahia8.png)

### Edit mode ###
Chick tab "Go to Edit Mode"
![http://wiki.jasperrocks.googlecode.com/git/images/Jahia9.png](http://wiki.jasperrocks.googlecode.com/git/images/Jahia9.png)

### My Site ###
![http://wiki.jasperrocks.googlecode.com/git/images/Jahia10.png](http://wiki.jasperrocks.googlecode.com/git/images/Jahia10.png)

### Portlet Manager ###
![http://wiki.jasperrocks.googlecode.com/git/images/Jahia11.png](http://wiki.jasperrocks.googlecode.com/git/images/Jahia11.png)

### New portlet ###
![http://wiki.jasperrocks.googlecode.com/git/images/Jahia12.png](http://wiki.jasperrocks.googlecode.com/git/images/Jahia12.png)

### Step 1: Portlet definition ###
![http://wiki.jasperrocks.googlecode.com/git/images/Jahia13.png](http://wiki.jasperrocks.googlecode.com/git/images/Jahia13.png)

### Step 2: Parameters ###
Field: Enter title
![http://wiki.jasperrocks.googlecode.com/git/images/Jahia14.png](http://wiki.jasperrocks.googlecode.com/git/images/Jahia14.png)

### Step 3: Save as ###
Field: Save as
![http://wiki.jasperrocks.googlecode.com/git/images/Jahia15.png](http://wiki.jasperrocks.googlecode.com/git/images/Jahia15.png)

### JasperServer rocks ###
Close Portlet Manager
![http://wiki.jasperrocks.googlecode.com/git/images/Jahia16.png](http://wiki.jasperrocks.googlecode.com/git/images/Jahia16.png)

### Drag and drop ###
![http://wiki.jasperrocks.googlecode.com/git/images/Jahia17.png](http://wiki.jasperrocks.googlecode.com/git/images/Jahia17.png)

### Add: Portlet reference ###
![http://wiki.jasperrocks.googlecode.com/git/images/Jahia18.png](http://wiki.jasperrocks.googlecode.com/git/images/Jahia18.png)


### Preview ###
![http://wiki.jasperrocks.googlecode.com/git/images/Jahia19.png](http://wiki.jasperrocks.googlecode.com/git/images/Jahia19.png)


## Preferences ##
![http://wiki.jasperrocks.googlecode.com/git/images/Jahia20.png](http://wiki.jasperrocks.googlecode.com/git/images/Jahia20.png)


## Browse ##
![http://wiki.jasperrocks.googlecode.com/git/images/Jahia21.png](http://wiki.jasperrocks.googlecode.com/git/images/Jahia21.png)

Installation has suspended here because of the above issues about field "Time zone" display and browse windows.

I have reported it to Jahia [forum](http://www.jahia.com/cms/home/download/forum/general/jahia-in-english/does-jahia-work-at-jasperrocks.html).

I don't wish Jahia fails me or I fail Jahia.

To be continued ...