#!/bin/bash

DIR="Wendela_Graf_labb"

echo "Wendela Grafs program"

mkdir -p "$DIR"
cp *.java "$DIR/"

cd "$DIR" || exit 1
echo "Running game from $(pwd)"

echo "compiling..."
javac *.java

echo "running..."
java GuessingGame

echo "Done!"
echo "Removing class files..."
rm -f *.class

echo "Listing directory:"
ls -1
