package edu.ssafy.chap11;
import javax.xml.parsers.*;
import org.w3c.dom.*;
public class DOMTest01 {
   public static void main(String args[]) throws Exception {
      DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
      DocumentBuilder parser = dbf.newDocumentBuilder();
      Document xmldoc = parser.parse("addr.xml");
      Element root = xmldoc.getDocumentElement();
      
      				
      // name으로도 뽑아보고, value로도 뽑아본거.
      // node element의 value는 null이라고했지!
      System.out.println(root.getNodeName()+root.getNodeValue());
   }
}

