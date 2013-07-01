JSPack - Simple tool to packing several JavaScript files to one file


This tool help you assemble several JS files to one file automatically! This is very necessary thing, when you divided several JS files into logical parts for easy development, but in production you need only one main JS file.



All properties can be set in file prop.properties (folder - resources, package - com.arthurspirke.jspack).

filesToPack = (List of js files. Should be written separated by commas). Example: example_1.js,example_2.js
inputFolder= (Folder, where your files). Example: c:/myfolder_input
finalFile= (Name of the final JS file). Example: theOne.js
outputFolder=(Folder, where JSPack save you one final JS file). Example: c:/myfolder_output
