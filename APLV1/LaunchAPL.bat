@echo off
set PROJECT_PATH=C:\Users\guilhem\git\APLV3\APLV1

set OPENORB_PATH=%PROJET_PATH%\openorb

set CLASSPATH=%PROJET_PATH%\bin;%PROJET_PATH%\lib\junit-4.11.jar;%PROJET_PATH%\lib\mysql-connector-java-5.1.30-bin.jar;%PROJET_PATH%\lib\openorb\lib\avalon-framework.jar;%PROJET_PATH%\lib\openorb\lib\excalibur-configuration.jar;%PROJET_PATH%\lib\openorb\lib\logkit.jar;%PROJET_PATH%\lib\openorb\lib\openorb_examples-1.3.1.jar;%PROJET_PATH%\lib\openorb\lib\openorb_test-1.3.1.jar;%PROJET_PATH%\lib\openorb\lib\openorb-1.3.1.jar;%PROJET_PATH%\lib\openorb\lib\xerces.jar;%PROJET_PATH%\lib\openorb\lib\junit.jar;%PROJET_PATH%\lib\hamcrest-core-1.3.jar;%PROJET_PATH%\lib\jaxen-1.1.6.jar;%PROJET_PATH%\lib\jdom-2.0.5-contrib.jar;%PROJET_PATH%\lib\jdom-2.0.5-javadoc.jar;%PROJET_PATH%\lib\jdom-2.0.5-junit.jar;%PROJET_PATH%\lib\jdom-2.0.5-sources.jar;%PROJET_PATH%\lib\jdom-2.0.5.jar;%PROJET_PATH%\lib\xercesImpl.jar;%PROJET_PATH%\lib\xml-apis.jar

echo Lancement du NamingService
start "Naming Service" /min "%PROJECT_PATH%\launcher\scriptsAPL\Launch_NamingService.bat"
pause

echo Lancement du Ministere
start "Ministere" /min "%PROJECT_PATH%\Launch_Ministere.bat" 
pause

echo Lancement du rectorat Midi-Pyrenees
start "Midi-Pyrenees" /min "%PROJECT_PATH%\Launch_Rectorat.bat" Midi-Pyrenees
pause

echo Lancement du rectorat Aquitaine
start "Aquitaine" /min "%PROJECT_PATH%\Launch_Rectorat.bat" Aquitaine
pause

echo Lancement du rectorat Ile-De-France
start "Ile-De-France" /min "%PROJECT_PATH%\Launch_Rectorat.bat" Ile-De-France
pause

echo Lancement de l'universite Paul Sabatier
start "Paul Sabatier" /min "%PROJECT_PATH%\Launch_Universite.bat" PaulSabatier Midi-Pyrenees route
pause

echo Lancement de l'universite de l'application Etudiant
start "Etudiant" /min "%PROJECT_PATH%\Launch_GestionVoeuxEtudiant.bat" 
pause






