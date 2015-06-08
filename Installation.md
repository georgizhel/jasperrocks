# Installation #
Please note that the following installation steps are for my Linux environment only.


### Kill Bill ###
![http://wiki.jasperrocks.googlecode.com/git/images/Installation2.png](http://wiki.jasperrocks.googlecode.com/git/images/Installation2.png)

In theory, Java works at Windows and Apple platforms. I intend **not** to test this project at Internet Explorer or Safari because I am jealous of Bill and Steve's wealth. I cannot show you the Windows,  you're the one that has to walk through it<sup>1</sup>.

Here is my environment:
| OSes | Debian or Ubuntu |
|:-----|:-----------------|
| Browsers | Firefox & Chrome |

## Prerequisite ##
### JDK 7 ###
  1. Download Java SE Development Kit 7 from [Oracle](http://www.oracle.com/technetwork/java/javase/downloads/index.html)
  1. Login as root, and run the following commands once:
```
cd /opt
tar zxvf jdk-7u21-linux-x64.tar.gz
ln -s /opt/jdk1.7.0_21 /opt/jdk
sudo update-alternatives --install "/usr/bin/java" "java" "/opt/jdk/bin/java" 1
sudo update-alternatives --install "/usr/bin/javac" "javac" "/opt/jdk/bin/javac" 1 
sudo update-alternatives --install "/usr/bin/javaws" "javaws" "/opt/jdk/bin/javaws" 1
export JAVA_HOME=/opt/jdk
export PATH=$JAVA_HOME/bin:$PATH
```

### JasperReports Server 4.7 or above ###
JasperReports Server is the core of the system. It must be ready before installations of portals. 'Cause when it's all ready for one JasperServer, it's one ready for all portals<sup>2</sup>.


![http://wiki.jasperrocks.googlecode.com/git/images/Installation1.png](http://wiki.jasperrocks.googlecode.com/git/images/Installation1.png)
  1. Download JasperReports server community edition from http://community.jaspersoft.com/project/jasperreports-server/releases
  1. Follow the installation instructions from http://community.jaspersoft.com/project/jasperreports-server/resources#Installation


## Portals ##
Below installations are using community versions as examples. I don't have their enterprise editions cause I am a _poor and cheap_<sup>3</sup> guy.
I introduce portals according to their names in alphabetical order (in order to avoid any misunderstanding over top billing).
  * [Apache Jetspeed](Jetspeed.md)
  * [Apache Pluto](Pluto.md)
  * [eXo Platform](eXo.md)
  * [Jasig uPortal](uPortal.md)
  * [JBoss GateIn](GateIn.md)
  * [Liferay](Liferay.md)



---

<sup>1</sup>The Matrix: I can only show you the door. You're the one that has to walk through it. https://www.youtube.com/watch?v=gABS8a4wm9o

<sup>2</sup>All for love: 'Cause when it's all for one, it's one for all. http://www.youtube.com/watch?v=ofA3URC1wyk

<sup>3</sup>Poor and cheap: Poor in English and cheap means frugal or being unwilling to spend money.