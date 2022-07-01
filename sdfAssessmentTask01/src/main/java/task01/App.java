package task01;

import java.io.*;
import java.util.*;


public class App {  

    public static void main(String[] args) throws Exception { 
        String line = ""; 
        String txtLine = ""; 
        List<String> lineList = new LinkedList<>();  
        List<String> txtList = new LinkedList<>();  
        ArrayList<String> termsList = new ArrayList<>(); 
        ArrayList<String> varList = new ArrayList<>(); 
        String printResults = "";
        try {   
                BufferedReader brCsv = new BufferedReader(new FileReader(args[0])); 
                while((line = brCsv.readLine()) != null) {
                    lineList.add(line); 
                    break;
                }
                    for(String terms:lineList) {
                        String[] termsSplit = terms.split(",");
                        for(int i=0; i<termsSplit.length; i++) {
                            termsList.add(termsSplit[i]); 
                        }                      
                    } 
                
                BufferedReader txtCsv = new BufferedReader(new FileReader(args[1])); 
                while((txtLine = txtCsv.readLine()) != null) {
                    txtList.add(txtLine); 
                    break;
                    }
            
                for(int i=0; i<termsList.size()-1; i++) {
                    printResults = txtList.toString();
                    String variables = termsList.get(0);  
                    varList.add(variables);
                    for(int j=0; j<varList.size(); j++) {
                        if(varList.get(j).equals("first_name")) {
                            printResults = printResults.replace(varList.get(j), termsList.get(i));
                        if(varList.get(j).equals("last_name")) {
                            printResults = printResults.replace(varList.get(j), termsList.get(i));
                        if(varList.get(j).equals("address")) {
                            printResults = printResults.replace(varList.get(j), termsList.get(i));
                        if(varList.get(j).equals("years")) {
                            printResults = printResults.replace(varList.get(j), termsList.get(i));
                        }
                    }

                }
            }
        }
        printResults = printResults.replace("\\n", "\n"); 
        printResults = printResults.replace("__", ""); 
        System.out.println(printResults);
    }
    brCsv.close();
    txtCsv.close();
                
            } catch (IOException ioe) {
                ioe.printStackTrace();
            }
        
    } 
}  