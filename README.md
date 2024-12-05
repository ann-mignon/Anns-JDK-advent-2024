## Anns JDK-advent 2024

Lösningsförslag till [Advent of Code 2024](https://adventofcode.com/2024), rolig pysselkalender på nätet.  

### Bygga och köra

#### Sökvägar
`{src.dir}`  &emsp;= &emsp;källmapp (./src)  
`{build.dir}` = &emsp;målmapp  
`{java.home}` = &emsp;`JAVA_HOME`, alt sökväg till JDK

#### Inparametrar
`{lucka}` = &emsp;&nbsp;Luckan att lösa, siffra + ev bokstav (exv `12`, `7b`).  
&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;Måste motsvaras av någon javaklass i paketet [aoc24.luckor](src/aoc24/luckor) på detta sätt:  
&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;Ex. `{aoc.lucka}` är 4 -> kör aoc24/luckor/lucka_4.java  
&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;Ex. `{aoc.lucka}` är 5b -> kör aoc24/luckor/lucka_5b.java  
`{infil}?` =&emsp;Läser input från `{src.dir}/res/SIFFRA/{aoc.infil}` där `SIFFRA`n är  
&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;den numeriska delen av parametern `{lucka}`.  
&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;(dvs, lösningar 5 och 5b använder samma mapp)  
&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;Parametern är <u>inte tvingande</u>, så om inget filnamn anges läses input från  
&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;Advent of Codes domän: `//adventofcode.com/2024/day/SIFFRA`.  
&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;För att det ska fungera behöver en giltig session-kaka anges för propertyn  
&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;`pepparkaka` i [aoc24.properties](src/aoc24/res/aoc.properties)


### Bygg
###### Bash mfl. (coreutils *find*)
```shell
find -name "*.java" > sources.txt && {java.home}/bin/javac -d {build.dir} -cp {build.dir} -sourcepath {src.dir} @sources.txt
```

###### Windows (cmd *dir*)
```shell
dir /B /S /A-D *.java > sources.txt && {java.home}/bin/javac -d {build.dir} -cp {build.dir} -sourcepath {src.dir} @sources.txt
```

### Kör

```shell
{java.home}/bin/java -cp {build.dir};{src.dir}/aoc24/res aoc24.AOC {lucka} {infil}
```
