## Anns JDK-advent 2024

Lösningsförslag till [Advent of Code 2024](https://adventofcode.com/2024), rolig pysselkalender på nätet.  

### Bygga och köra

##### Bash
```shell
bash bygg_aoc24.sh {build.dir}? {src.dir}? {java.home}?
bash kor_aoc24.sh {lucka} {infil}? {build.dir}? {src.dir}? {java.home}?
```
###### exempel:
```shell
bash bygg_aoc24.sh
bash kor_aoc24.sh 4b test.txt
```

##### Windows (cmd *dir*)
```shell
bygg_aoc24.cmd {src.dir}? {build.dir}? {java.home}?
bygg_aoc24.cmd {lucka} {infil}? {build.dir}? {src.dir}? {java.home}?
```
###### exempel:
```shell
bygg_aoc24
kor_aoc24 4b test.txt
```

#### Parametrar: _sökvägar (ej tvingande)_
`{build.dir}?` = &emsp;målmapp  (./build)  
`{src.dir}?`  &emsp;= &emsp;källmapp (./src)
`{java.home}?` = &emsp;sökväg java

#### Parametrar: programargument
`{lucka}` = &emsp;&nbsp;Luckan att lösa, siffra + ev bokstav (exv `12`, `7b`).  
&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;Måste motsvaras av någon javaklass i paketet [aoc24.luckor](src/aoc24/luckor) på detta sätt:  
&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;Ex. `{aoc.lucka}` är 4 -> kör aoc24/luckor/lucka_4.java  
&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;Ex. `{aoc.lucka}` är 5b -> kör aoc24/luckor/lucka_5b.java  
`{infil}?` =&emsp;Läser input från `{src.dir}/res/SIFFRA/{aoc.infil}` där `SIFFRA`n är  
&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;den numeriska delen av parametern `{lucka}`.  
&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;(dvs, lösningar 5 och 5b använder samma mapp)  
&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;Parametern är <u>inte tvingande</u>, så om inget filnamn anges läses input från  
&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;Advent of Codes domän: `//adventofcode.com/2024/day/SIFFRA/input`.  
&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;För att det ska fungera behöver en giltig session-kaka anges för propertyn  
&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;`pepparkaka` i [aoc24.properties](src/aoc24/res/aoc.properties)

