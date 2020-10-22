rm -rf out
mkdir -p out
echo "Compiling"
javac -d out -cp .:lib/junit-4.13.1.jar:lib/hamcrest-core-1.3.jar $(find src "test" -name '*.java')
echo "Running Test"
java -cp out:lib/junit-4.13.1.jar:lib/hamcrest-core-1.3.jar org.junit.runner.JUnitCore com.step.matrix.MatrixTest com.step.matrix.ArrayTest
