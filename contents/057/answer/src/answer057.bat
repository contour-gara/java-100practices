@ECHO OFF
@REM ------------------------------------------------------------------------------
@REM java-100practices
@REM answer057.bat
@REM author: jsfkdt
@REM ------------------------------------------------------------------------------

SET word="Answer057.txt"

@REM �R���p�C��
javac Answer057.java

@REM �v���O�����̎��s
java Answer057 %word%

IF ERRORLEVEL 1 GOTO FAILURE

GOTO SUCCESS

:FAILURE
EXIT /B %ERRORLEVEL%

:SUCCESS
