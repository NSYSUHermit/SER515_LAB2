@echo off
echo Compiling Java files...
javac -cp "lib/json-simple-1.1.1.jar" -d classes src\*.java

echo.
echo Running AltMain...
java -cp "classes;lib/json-simple-1.1.1.jar" -Ddata=data.json -Dvi=test AltMain

pause
