REFERENCE=1.53
VERSION=1.54

CLASSPATH=../SuperCSV-${VERSION}.jar:.
REF_CLASSPATH=../SuperCSV-${REFERENCE}.jar:.

all:
	javac -classpath ${CLASSPATH} *.java

ref:
	java -classpath ${REF_CLASSPATH} Benchmark

run:
	java -classpath ${CLASSPATH} Benchmark

clean:
	rm *.class benchmark.csv
