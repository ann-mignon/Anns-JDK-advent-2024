#!bash

if [ -z "$1" ]; then
	echo Ange en lucka.
	exit 1
else
	lucka=$1
fi

if [ -z "$2" ]; then
	infil=""
else
	infil=$2
fi

JAVALOC="$(which java)"

if [ -z "$5" ]; then
	if [ -z "$JAVALOC" ]; then
		echo Java saknas.
		exit 1
	else
		java=$JAVALOC
	fi
else
	java=$3/bin/java
fi

if [ -z "$4" ]; then
	src_dir=./src
else 
	src_dir=$2
fi

if [ -z "$3" ]; then
	if [ -d ./build/ ]; then
		build_dir=./build/
	else 
		mkdir build
	fi
else 
	build_dir=$1
fi

if [ ! -d "$build_dir" ]; then 
	echo Hittar inget bygge, har du provat bygg_aoc24.sh?
	exit 1
fi

$java -cp $build_dir:$src_dir/aoc24/res/ aoc24.AOC $lucka $infil
