@echo off
setlocal enabledelayedexpansion

:: Déclaration des variables
set "work_dir=."
set "temp1=%work_dir%\temp1"
set "lib=%work_dir%\lib"
set "src=%work_dir%\src"
set "web_xml1=%work_dir%\web\web.xml"
set "web_apps=C:\Program Files\Apache Software Foundation\Tomcat 10.1\webapps"
set "war_name1=pouletAdmin"

:: Effacer le dossier [temp1]
if exist "%temp1%" (
    rd /s /q "%temp1%"
)

:: Création de la structure de dossier temporaire
mkdir "%temp1%\WEB-INF\lib"
mkdir "%temp1%\WEB-INF\classes"
mkdir "%temp1%\assets"
mkdir "%temp1%\forms"

:: Copie de web.xml vers temp1/WEB-INF...
xcopy /y "%web_xml1%" "%temp1%\WEB-INF"

:: Copie des fichiers .jsp vers le dossier temporaire
xcopy /y "%work_dir%\web\*.jsp" "%temp1%\" /I

:: Copie des dossiers assets et forms vers le dossier temporaire
xcopy "%work_dir%\web\assets" "%temp1%\assets" /E /I /Y
xcopy "%work_dir%\web\forms" "%temp1%\forms" /E /I /Y

:: Copie des fichiers .jar dans lib vers le dossier temporaire
xcopy /s /y "%lib%\*.jar" "%temp1%\WEB-INF\lib"

:: Compilation des fichiers .java
dir /s /B "%src%\*.java" > sources.txt
if not exist sources.txt (
    echo Aucun fichier .java trouvé dans le répertoire src.
    exit /b 1
)

:: Création du classpath pour la compilation
dir /s /B "%lib%\*.jar" > libs.txt
set "classpath="
for /F "delims=" %%i in (libs.txt) do set "classpath=!classpath!.;%%i;"

:: Vérification de l'existence de javac
where javac >nul 2>nul
if %errorlevel% neq 0 (
    echo Erreur: javac n'est pas trouvé dans le PATH.
    exit /b 1
)

:: Exécution de la compilation
javac -d "%temp1%\WEB-INF\classes" -cp "%classpath%" @sources.txt

:: Nettoyage des fichiers temporaires de compilation
del sources.txt
del libs.txt

:: Création du fichier .war
cd "%temp1%"
jar -cvf "%work_dir%\%war_name1%.war" *
cd "%work_dir%"

:: Suppression et déploiement du fichier .war
if exist "%web_apps%\%war_name1%.war" (
    del /f /q "%web_apps%\%war_name1%.war"
)
copy /y "%work_dir%\%war_name1%.war" "%web_apps%"
del /f /q "%work_dir%\%war_name1%.war"

echo Déploiement terminé.
pause
