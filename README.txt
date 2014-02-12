#JSPack - Simple tool to packing several JavaScript files to one file

##Description

This tool help you assemble several JS files to one file automatically! This is very necessary thing, when you divide several JS files into logical parts for easy development, but in production you need only one main JS file.


All properties can be set in file prop.properties (folder - resources, package - com.arthurspirke.jspack).

In release 0.1 we have new features for create multi-project properties.

We can create two or more projects with some rules:
Standard options (filesToPack, inputFolder, finalFile, outputFolder) must be divided with project name (project1, for example) using "_".
In property "assembly_project" input you project name. So you plug in a specific project with this option.

#main properties#
assembly_project=project1

#list of JS-files#

#project1 (Project 1)#
filesToPack_project1=js_for_project1.js, etc.......
inputFolder_project1=C:/.....
finalFile_project1=finalFile.js
outputFolder_project1=C:/.......

#project2 (Project 2)#
filesToPack_project2=js_for_project2.js, etc.......
inputFolder_project2=C:.......
finalFile_project2=finalFile.js
outputFolder_project2=C:.........
