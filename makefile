#
# makefile 
#
# input file for 'make' build tool ( /usr/bin/make )
# to build solution for JUnit sample
#
# @author Dr. Fenwick
# @version Summer 2018
#

JUNIT_JAR = junit-platform-console-standalone-1.2.0.jar
JUNIT_RUNNER = org.junit.platform.console.ConsoleLauncher
CKSTYLE_COMMAND =  -jar /usr/local/checkstyle-5.5/checkstyle-5.5-all.jar
CKSTYLE_XML = cs_appstate_checks.xml

default: 
	@echo "usage: make target"
	@echo "5 available targets: clean - removes editor tmpfiles and .class files"
	@echo "____________________ compile - builds project"
	@echo "____________________ run - runs with no args"
	@echo "____________________ run2 - runs with an arg"
	@echo "____________________ test - runs JUnit tests"



compile: src/Matrix.java src/MatrixTest.java $(JUNIT_JAR)
	cd src; javac -cp .:../$(JUNIT_JAR) MatrixTest.java
	cd src; javac Matrix.java

clean:
	rm -f *~
	rm -f src/*~
	rm -f src/*.class

test: src/Matrix.class src/MatrixTest.class $(JUNIT_JAR)
	cd src; java -cp .:../$(JUNIT_JAR) $(JUNIT_RUNNER) --scan-class-path

run: src/Matrix.class
	echo "Running Matrix: shouldn't crash"
	cd src; java -cp . Matrix
defchk: src/*.java $(CKSTYLE_XML)
	java $(CKSTYLE_COMMAND) -c $(CKSTYLE_XML) src/*.java
