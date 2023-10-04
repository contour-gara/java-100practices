@ECHO OFF
@REM -------------------------------------------------------
@REM java-100practices
@REM answer010.bat
@REM author: jsfkdt
@REM -------------------------------------------------------

SET CLASSES=classes
SET JARFILE=answer010.jar

IF NOT EXIST %CLASSES% (
    MKDIR %CLASSES%
    IF ERRORLEVEL 1 GOTO FAILURE
)
@REM -------------------------------------------------------
@REM �N���X�𐶐�
@REM -------------------------------------------------------
javac -sourcepath src -d %CLASSES% -encoding UTF-8 src\Answer010.java
IF ERRORLEVEL 1 GOTO FAILURE

@REM -------------------------------------------------------
@REM ���s�\jar�t�@�C�����쐬�i�}�j�t�F�X�g�̍쐬�j
@REM -C classes��classes�����Ɉړ����Ă���B
@REM -------------------------------------------------------
jar cfe %JARFILE% Answer010 -C %CLASSES% Answer010.class
IF ERRORLEVEL 1 GOTO FAILURE

@REM -------------------------------------------------------
@REM ���s�\jar�t�@�C���̎��s
@REM -------------------------------------------------------
java -jar %JARFILE%
IF ERRORLEVEL 1 GOTO FAILURE

GOTO SUCCESS

:FAILURE
EXIT /B %ERRORLEVEL%

:SUCCESS
