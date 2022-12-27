package com.postman.collection.transform;

import org.apache.jmeter.control.LoopController;
import org.apache.jmeter.engine.StandardJMeterEngine;
import org.apache.jmeter.protocol.http.sampler.HTTPSampler;
import org.apache.jmeter.testelement.TestElement;
import org.apache.jmeter.testelement.TestPlan;
import org.apache.jmeter.threads.SetupThreadGroup;
import org.apache.jmeter.util.JMeterUtils;
import org.apache.jorphan.collections.HashTree;
import com.postman.collection.*;
import java.io.File;

/**
 * Hello world!
 *
 */
public class jmeter 
{
    public static void main( String[] args ) throws Exception
    {
        String filePath = new File("").getAbsolutePath();
        PostmanCollection pmcTest = PostmanCollection.PMCFactory(filePath + "/jmeter/src/main/resources/com/postman/collection/catfact-collx.json");
        System.out.println("Its done");
        System.out.println(pmcTest.getJson());
        
        
    }

    public static void Transform()
    {
        //String configPath = System.getenv("GITHUB_WORKSPACE") + "/com/postman/collection/transform";

        
        // Engine
         StandardJMeterEngine jm = new StandardJMeterEngine();
         // jmeter.properties
         System.out.println( "Hello World!" );
        String filePath = new File("").getAbsolutePath();
        filePath.concat("path to the property file");
        System.out.print("Path: " + filePath);
         JMeterUtils.loadJMeterProperties(filePath + "/jmeter/src/main/resources/com/postman/collection/transform/jmeter.config");
 
         HashTree hashTree = new HashTree();     
 
         // HTTP Sampler
         HTTPSampler httpSampler = new HTTPSampler();
         httpSampler.setDomain("www.google.com");
         httpSampler.setPort(80);
         httpSampler.setPath("/");
         httpSampler.setMethod("GET");
 
         // Loop Controller
         TestElement loopCtrl = new LoopController();
         ((LoopController)loopCtrl).setLoops(1);
         ((LoopController)loopCtrl).addTestElement(httpSampler);
         ((LoopController)loopCtrl).setFirst(true);
 
         // Thread Group
         SetupThreadGroup threadGroup = new SetupThreadGroup();
         threadGroup.setNumThreads(1);
         threadGroup.setRampUp(1);
         threadGroup.setSamplerController((LoopController)loopCtrl);
 
         // Test plan
         TestPlan testPlan = new TestPlan("MY TEST PLAN");
 
         hashTree.add("testPlan", testPlan);
         hashTree.add("loopCtrl", loopCtrl);
         hashTree.add("threadGroup", threadGroup);
         hashTree.add("httpSampler", httpSampler);       
 
         jm.configure(hashTree);
 
         jm.run();
    }

    
}
