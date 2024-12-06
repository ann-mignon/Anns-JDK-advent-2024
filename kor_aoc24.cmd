@echo off
@chcp 1252 > nul

set lucka=%1
set infil=%2
set build.dir=%3
set src.dir=%4
set java.home=%5

if [%lucka%]==[] (
	echo Ange en lucka.
	goto end
)

if [%java.home%]==[] (
	if [%JAVA_HOME%]==[] (
		echo JAVA_HOME saknas.
		goto end		
	) else (
		set java.home=%JAVA_HOME%
	)
)

if [%src.dir%]==[] (
	set src.dir=.\src
)

if [%build.dir%]==[] (
	if not exist ".\build\" (
		echo Hittar inget bygge, har du provat bygg_aoc24.cmd?
		goto end
	) else (
		set build.dir=.\build\
	)
)

%java.home%/bin/java -cp %build.dir%;%src.dir%\aoc24\res\ aoc24.AOC %lucka% %infil%

:end
