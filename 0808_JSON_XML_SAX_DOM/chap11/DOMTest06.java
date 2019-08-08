package edu.ssafy.chap11;

import javax.xml.parsers.*;
import org.w3c.dom.*;

public class DOMTest06 {
   public static void main(String args[]) throws Exception {
      DocumentBuilderFactory dbf
         = DocumentBuilderFactory.newInstance();
      DocumentBuilder parser = dbf.newDocumentBuilder();
      Document xmldoc = parser.parse("addr.xml");
      Element root = xmldoc.getDocumentElement();
      getNode(root);
   }
   public static void getNode(Node n) {
      for(Node ch = n.getFirstChild();ch != null;ch = ch.getNextSibling()) {
         //��Ҹ� ó���Ѵ�
         if(ch.getNodeType() == Node.ELEMENT_NODE) {
            System.out.println(ch.getNodeName());
            getNode(ch);
         }
         //�ؽ�Ʈ�� ó���Ѵ�
         else if(ch.getNodeType() == Node.TEXT_NODE
                     && ch.getNodeValue().trim().length() != 0){
            System.out.println(ch.getNodeValue());
         }
      }
   }
}


