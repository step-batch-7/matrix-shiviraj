rm -rf out
mkdir -p out
echo "compiling"
javac -d out $(find src -name '*.java')
echo "compiled successfully"