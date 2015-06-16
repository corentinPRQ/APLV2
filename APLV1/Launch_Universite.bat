set OPENORB_PATH=C:\Users\guilhem\git\APLV3\APLV1\lib\openorb

set CLASSPATH=%OPENORB_PATH%\lib\openorb-1.3.1.jar;%OPENORB_PATH%\lib\openorb_tools-1.3.1.jar;%OPENORB_PATH%\lib\xerxes.jar;%OPENORB_PATH%\lib\avalon-framework.jar;%OPENORB_PATH%\lib\logkit.jar;.

cd "C:\Users\guilhem\git\APLV3\APLV1\bin"
"C:\Program Files (x86)\Java\jdk1.8.0\bin\java" -classpath %CLASSPATH% -Dorg.omg.CORBA.ORBClass=org.openorb.CORBA.ORB Applications.ApplicationUniversite %1 %2 %3

pause