@echo off
setlocal enabledelayedexpansion

:: Déclaration des variables
set "work_dir=."
set "temp=%work_dir%\temp"
set "lib=%work_dir%\lib"
set "src=%work_dir%\src"
set "web_xml=%work_dir%\webfournisseur\web.xml"
set "web_apps=C:\Program Files\Apache Software Foundation\Tomcat 10.1\webapps"
set "war_name=pouletFournisseur"

:: Effacer le dossier [temp]
if exist "%temp%" (
    rd /s /q "%temp%"
)

:: Création de la structure de dossier temporaire
mkdir "%temp%\WEB-INF\lib"
mkdir "%temp%\WEB-INF\classes"
mkdir "%temp%\assets"
mkdir "%temp%\forms"

:: Copie de web.xml vers temp/WEB-INF...
xcopy /y "%web_xml%" "%temp%\WEB-INF"

:: Copie des fichiers .jsp vers le dossier temporaire
xcopy /y "%work_dir%\webfournisseur\*.jsp" "%temp%\" /I

:: Copie des dossiers assets et forms vers le dossier temporaire
xcopy "%work_dir%\webfournisseur\assets" "%temp%\assets" /E /I /Y
xcopy "%work_dir%\webfournisseur\forms" "%temp%\forms" /E /I /Y

:: Copie des fichiers .jar dans lib vers le dossier temporaire
xcopy /s /y "%lib%\*.jar" "%temp%\WEB-INF\lib"

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
javac -d "%temp%\WEB-INF\classes" -cp "%classpath%" @sources.txt

:: Nettoyage des fichiers temporaires de compilation
del sources.txt
del libs.txt

:: Création du fichier .war
cd "%temp%"
jar -cvf "%work_dir%\%war_name%.war" *
cd "%work_dir%"

:: Suppression et déploiement du fichier .war
if exist "%web_apps%\%war_name%.war" (
    del /f /q "%web_apps%\%war_name%.war"
)
copy /y "%work_dir%\%war_name%.war" "%web_apps%"
del /f /q "%work_dir%\%war_name%.war"

echo Déploiement terminé.
pause
