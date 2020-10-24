set -eu

rm -rf out
mkdir -p out

echo "Compiling"

javac -d out -cp .:testLib/junit-4.13.1.jar:testLib/hamcrest-core-1.3.jar $(find . -name '*.java')

echo "Running Test"

TESTNAMES=`find test -name '*Test.java' | sed 's/test\///g' | sed 's/\.java//g' | sed 's/\//./g'`;

java -cp out:testLib/junit-4.13.1.jar:testLib/hamcrest-core-1.3.jar org.junit.runner.JUnitCore com.step.matrix.MatrixTest $TESTNAMES
