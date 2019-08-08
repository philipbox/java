package edu.ssafy.chap11;
import javax.xml.parsers.*;
import org.w3c.dom.*;

public class DOMTest05 {
   public static void main(String args[]) throws Exception {
      DocumentBuilderFactory dbf
         = DocumentBuilderFactory.newInstance();
      DocumentBuilder parser = dbf.newDocumentBuilder();
      Document xmldoc = parser.parse("addr.xml");
      Element root = xmldoc.getDocumentElement();
      getNode(root);
   }

   //����� �ڽ�(child)��带 ã�ư���
   public static void getNode(Node n) {
      for(Node ch = n.getFirstChild();ch != null;ch = ch.getNextSibling()){
         //��Ҹ� ó���Ѵ�
         if(ch.getNodeType() == Node.ELEMENT_NODE){
            System.out.println(ch.getNodeName());
            getNode(ch); //��� ȣ��
         }
      }
   }
}


