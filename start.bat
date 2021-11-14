@echo off
SET version=1.17
color 02
echo Starting on %version%
title Spigot %version%
:start
"C:\Program Files\Java\jdk-17.0.1\bin\java.exe" -Xmx1024M -jar spigot.jar nogui
goto start
