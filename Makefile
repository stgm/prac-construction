CLASSPATH = src:lib/*
JFLAGS = -cp $(CLASSPATH)

# Main targets
all: RunRats TestExpressions

# Runnable classes
RunRats: src/nl/stgm/ql/parser/rats/RunRats.class
TestExpressions: src/nl/stgm/ql/parser/rats/QLParser.class src/nl/stgm/ql/parser/test/TestExpressions.class
TestForms: src/nl/stgm/ql/parser/rats/QLParser.class src/nl/stgm/ql/parser/test/TestForms.class

# Utilities
run/rats: RunRats
	java -cp $(CLASSPATH) nl.stgm.ql.parser.rats.RunRats
run/testexpr: TestExpressions
	java -cp $(CLASSPATH) org.junit.runner.JUnitCore nl.stgm.ql.parser.test.TestExpressions
run/testform: TestForms
	java -cp $(CLASSPATH) org.junit.runner.JUnitCore nl.stgm.ql.parser.test.TestForms

# Helpers
%.class: %.java
	javac $(JFLAGS) $<
clean:
	find . -name "*.class" -delete
