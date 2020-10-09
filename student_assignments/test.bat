@echo off 
echo Starting Java program ...
java TestExit
goto answer%ERRORLEVEL%
:answer0
echo Program had return code 0 - SUCCESS!
:answer1
echo Program had return code 1 - FAILED!
echo done.
