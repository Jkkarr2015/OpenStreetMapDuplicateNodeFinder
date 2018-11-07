import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class FindDuplicateOSMNodes {

  public static void main(String argv[]) {

    try {
    	
    //User inputs file name to read and file name to output.
    	
    Scanner userInputScanner = new Scanner(System.in);
    System.out.print("Enter name of file to read from(must be xml file): ");
    String readFileName = userInputScanner.nextLine();//Get name of input file
    System.out.println(" ");

    System.out.print("Enter name of file to output to(file must have .txt extension): ");
    String outputFileName = userInputScanner.nextLine();
    
    userInputScanner.close();
    

	File fXmlFile = new File(readFileName);//put path to file here
	DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
	DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
	Document doc = dBuilder.parse(fXmlFile);
			
	//optional, but recommended
	//read this - http://stackoverflow.com/questions/13786607/normalization-in-dom-parsing-with-java-how-does-it-work
	doc.getDocumentElement().normalize();

	
			
	NodeList nList = doc.getElementsByTagName("node");
	
	ArrayList<Element> nodeList = new ArrayList<>();
			

	for (int temp = 0; temp < nList.getLength(); temp++) {

		Node nNode = nList.item(temp);
				
		if (nNode.getNodeType() == Node.ELEMENT_NODE) {

			Element eElement = (Element) nNode;
			nodeList.add(eElement);
		}
	}
	
	//Find duplicate osm nodes
	PrintWriter writer = new PrintWriter(outputFileName, "UTF-8");//Create new file 
	ArrayList<String> latLonAlreadyFound = new ArrayList<>();
	ArrayList<String> duplicateNodeIDs = new ArrayList<>();
	
		
	for(int i = 0; i < nodeList.size(); i++) {
		Element currentNode = nodeList.get(i);
		
		 String currentLat = (String) currentNode.getAttribute("lat");
		 String currentLon = (String) currentNode.getAttribute("lon");
		 
		 String coordinates = currentLat + currentLon;
		 
		 if(!latLonAlreadyFound.contains(coordinates)) {
			 for(int k = 0; k < nodeList.size(); k++) {
				 Element tempNode = nodeList.get(k);
			
			
				 if(currentNode.getAttribute("id") != tempNode.getAttribute("id")) {
			   
			    
					 String tempLat = (String) tempNode.getAttribute("lat");
					 String tempLon = (String) tempNode.getAttribute("lon");
			    
					 if(currentLat.equals(tempLat) && currentLon.equals(tempLon)){
			             String nodeID = (String) tempNode.getAttribute("id");
			             duplicateNodeIDs.add(nodeID);
					 }
				 }
			 }
			 
			 if(duplicateNodeIDs.size() != 0) {
				 writer.println("Nodes with coordinates lat: " + currentLat + " lon: " + currentLon);
				 writer.println(currentNode.getAttribute("id"));
				 
				 for(int y = 0; y < duplicateNodeIDs.size(); y++) {
					 writer.println(duplicateNodeIDs.get(y));
				 }
				 
				 writer.println(" ");
				 writer.println("---------------------------");
			 }
			 
			 duplicateNodeIDs.clear();
			 latLonAlreadyFound.add(coordinates);
		}
	}
	
	writer.close();
	
    } catch (Exception e) {
	e.printStackTrace();
    }
  }

}