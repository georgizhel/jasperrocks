# Apache Jetspeed #
> Website: http://portals.apache.org/jetspeed-2/

> Documentation: http://portals.apache.org/jetspeed-2/usersguide/index.html

## Download ##
> Download jetspeed-installer-2.2.2.jar from http://portals.apache.org/jetspeed-2/

## Installation ##
> The following installation steps are for my linux environment, you vary them depending on your requirement:
  1. Command in console: java -jar jetspeed-installer-2.2.2.jar text
  1. License agreement: view and accept the license agreement.
  1. Operation: choose number 1 to install Jetspeed Portal.
  1. Installation location: Select an installation directory.
  1. Installation type: choose default number 1, Demo.
  1. Pipeline type: choose number 2, Classic.
  1. Enter default not to store PSML in the database
  1. Database type:  choose default number 2, Derby.
  1. Installation progress: until it will be finished.

## Start Jetspeed ##
```
cd $HOME/Jetspeed-2.2.2
bin/startup.sh
```

---

## Deployment ##
### Login Portlet ###
  * Sample link: http://localhost:8080
  * Default username is admin and password is admin
![http://wiki.jasperrocks.googlecode.com/git/images/Jetspeed1.png](http://wiki.jasperrocks.googlecode.com/git/images/Jetspeed1.png)

### Deploy ###
Go to "Jetspeed Administration", choose "Portlet Application Manager", and click "Deploy..."
![http://wiki.jasperrocks.googlecode.com/git/images/Jetspeed2.png](http://wiki.jasperrocks.googlecode.com/git/images/Jetspeed2.png)

### Upload ###
Under "Registry Applications List", browse and upload file jasperrocks.war.
![http://wiki.jasperrocks.googlecode.com/git/images/Jetspeed3.png](http://wiki.jasperrocks.googlecode.com/git/images/Jetspeed3.png)

### Add Portlet ###
Edit a page and "Add Portlet"
![http://wiki.jasperrocks.googlecode.com/git/images/Jetspeed8.png](http://wiki.jasperrocks.googlecode.com/git/images/Jetspeed8.png)

### Search Portlet ###
Under "Portlet Selector", search and add a portlet called "JasperServer rocks".
![http://wiki.jasperrocks.googlecode.com/git/images/Jetspeed4.png](http://wiki.jasperrocks.googlecode.com/git/images/Jetspeed4.png)

### Preferences ###
Having done above steps, JasperRocks portlet will be ready. You need to provide username, password and host address to connect with JasperReports Server.
![http://wiki.jasperrocks.googlecode.com/git/images/Jetspeed5.png](http://wiki.jasperrocks.googlecode.com/git/images/Jetspeed5.png)

### Operation ###
Go and read [operation](Operation.md) for more information
![http://wiki.jasperrocks.googlecode.com/git/images/Jetspeed6.png](http://wiki.jasperrocks.googlecode.com/git/images/Jetspeed6.png)

Here is a sample of end result:
![http://wiki.jasperrocks.googlecode.com/git/images/Jetspeed7.png](http://wiki.jasperrocks.googlecode.com/git/images/Jetspeed7.png)