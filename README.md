# OpenStreetMapDuplicateNodeFinder
The following project is for users of osm to find duplicate nodes in a small area easily. This is a VERY simple and easy to use Java application in which the sole purpose is to identify any nodes that share the same latitude and longitude coordinates. This application is meant to narrow the nodes to search for if you suspect duplicate nodes. Just because a node is a duplicate doesn't mean that it is wrong, so use your best judgement when dealing with duplicate nodes. 


<h1>How to Use</h1>

First Method: Clone this repository and open the project in your favorite java compiler and run the application

Second method: 
  Windows: Open the command prompt and be sure that your java folder location is in your PATH environment. Download the executable jar file located in this repository and navigate to its location using the comman prompt. Once there type java -jar FindDuplicateOSMNodes.jar and press enter. 
  
  
  
Once you have done one of the above methods you will be prompted to enter the file name for the file you wish to read from. That file must be an xml file. To get this file I highly sugguest going to openstreetmap.org locating the area you want to check for duplicate nodes and click export. If you are only wanting a single building I sugguest clickig the Manually Select a different size option from the export window and fitting the box as close as you can around the building.

Once you have the file downloaded open it in a text editor and save it as a .xml file. If you are using the executable jar option it will be easiest to have the xml file in the same folder. Depending on your method of choice you may need to enter the full file address for both the input and output file. If you use the executable you can put all files in the same folder and just enter in the file names. The output file that you enter will be created and if it already exists it will be overwriten with the output data. The output file needs to be a txt file type.

The data that is output from this program will look like this:

Nodes with coordinates lat: 38.2568955 lon: -85.7529850
<br/>3383404449
<br/>4755754587
 
---------------------------
Nodes with coordinates lat: 38.2583104 lon: -85.7544394
<br/>5720896342
<br/>5720930701
 
---------------------------
Nodes with coordinates lat: 38.2583264 lon: -85.7534096
<br/>5724054917
<br/>5728532353
 
---------------------------
Nodes with coordinates lat: 38.2584043 lon: -85.7536722
<br/>5724055723
<br/>5728891624
 
---------------------------


the numbers in the data correspond with the node id.  

