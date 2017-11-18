package executionInit;

import java.util.ArrayList;
import java.util.List;

import org.testng.TestListenerAdapter;
import org.testng.TestNG;
import org.testng.collections.Lists;

public class RunTestNGXML {
	
	public static void main(String[] args) {
//        TestNG testng = new TestNG();
//        List<String> suites = Lists.newArrayList();
//        suites.add("testng.xml");
//        testng.setTestSuites(suites);
//        testng.run();
        
        
//     // Create object of TestNG Class
//        TestNG runner=new TestNG();
//
//        // Create a list of String 
//        List<String> suitefiles=new ArrayList<String>();
//
//        // Add xml file which you have to execute
//        suitefiles.add("testng.xml");
//
//        // now set xml file for execution
//        runner.setTestSuites(suitefiles);
//
//        // finally execute the runner using run method
//        runner.run();
        
		List<String> suitesList = new ArrayList<String>();
		
		TestNG testng = new TestNG();
		testng.setOutputDirectory("outputfoldername");
		suitesList.add("testng.xml");
		testng.setTestSuites(suitesList);
		
		testng.run(); 

    }

}
