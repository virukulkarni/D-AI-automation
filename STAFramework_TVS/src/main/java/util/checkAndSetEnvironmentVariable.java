package util;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;

public class checkAndSetEnvironmentVariable
{
		//@BeforeTest
		public static void main(String[] args) throws Exception{
		Path path = Paths.get(checkAndSetEnvironmentVariable.class.getResource(".").toURI());
        String classpathvalue = "";
        Boolean libStatus=false;
        Boolean binStatus=false;
        ProcessBuilder pb = new ProcessBuilder("CMD.exe", "/C", "SET classpath"); // SET prints out the environment variables
        pb.redirectErrorStream(true);
        Process process = pb.start();
        BufferedReader in = new BufferedReader(new InputStreamReader(process.getInputStream()));
        String classpathEnvironmentVariable;
        while ((classpathEnvironmentVariable = in.readLine()) != null)
        {
        	//Check classpath present or not, if not add classpath in environment variable
            if(classpathEnvironmentVariable.equals("Environment variable classpath not defined")){
            	 pb = new ProcessBuilder("CMD.exe", "/C", "SETX classpath "+path.getParent().getParent()+"\\lib\\*;"+path.getParent().getParent()+"\\bin;");
            	 pb.redirectErrorStream(true);
                 process = pb.start();
            }else{
            	//check checkpath have correct lib and bin location, if not add correct lib, bin location to classpath in environment variable 
            	String[]  environmentVariableValue= classpathEnvironmentVariable.split("=");
            	String[]  valuesInclasspath=environmentVariableValue[1].split(";");
            	for(int counter=0;counter<valuesInclasspath.length;counter++){
            		classpathvalue=classpathvalue+valuesInclasspath[counter]+";";
            		if(valuesInclasspath[counter].equals(path.getParent().getParent()+"\\lib\\*")){
            			libStatus=true;
            		}
            		if(valuesInclasspath[counter].equals(path.getParent().getParent()+"\\bin")){
            			binStatus=true;
            		}
            	}
            	if(libStatus==false){
            		classpathvalue=classpathvalue+path.getParent().getParent()+"\\lib\\*;";
            	}
            	if(binStatus==false){
            		classpathvalue=classpathvalue+path.getParent().getParent()+"\\bin;";
            	}
            	 pb = new ProcessBuilder("CMD.exe", "/C", "SETX classpath "+classpathvalue);
            	 pb.redirectErrorStream(true);
                 process = pb.start();
              
            }
        }
        
    }
}
