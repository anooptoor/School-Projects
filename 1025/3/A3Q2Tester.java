
import java.util.*;
import java.io.*;
public class A3Q2Tester {

	 public static void main(String args[]) throws  FileNotFoundException, UnsupportedEncodingException{
         A3Q2DNAExtractor a = new A3Q2DNAExtractor("Mitochondrion.txt");
         String b = a.getDNA();
         System.out.print(a.getDNA());
         PrintWriter writer = new PrintWriter("a.txt", "UTF-8");
         writer.print(b);
         
         
     }
}
