#TriangleWordsFunctional

In this project I have looked into use of records and stream for searching for words where the sum of their alphabetic position becomes a triangle number. It takes one input, the filename of the input and outputs a JSON structure to command-line. 

Example usage in Powershell:
java -jar TriangleWordsfunctional.jar "..\words.txt" | convertFrom-Json | ConvertTo-Json

Build on OpenJdk 16, Maven and Jackson. Tested with Jupiter framework. 