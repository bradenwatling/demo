package bcwatling.demo.node;

import bcwatling.demo.Input;
import bcwatling.demo.Output;
import java.util.List;
import junit.framework.Assert;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class NodeTests {
    
    private static final String INPUT_NAME = "input";
    private static final String OUTPUT_NAME = "output";
    private static final String CONSTANT_NAME = "constant";
    
    private Node mOutputNode;
    private Node mInputNode;
    
    public NodeTests() {
    }
    
    @Before
    public void setUp() {
        mOutputNode = new Node("Test") {

            @Override
            public void execute() {
            }
            
        };
        mInputNode = new Node("Test")  {

            @Override
            public void execute() {
            }
            
        };
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void testConnectNodesAndPostOutput() {
        // Given I have 2 nodes such that I have 1 input and 1 output
        mOutputNode.addOutput(OUTPUT_NAME, Number.class);
        mInputNode.addInput(INPUT_NAME, Number.class);
        
        // And the output has a set value
        mOutputNode.getOutput(OUTPUT_NAME).setValue(12);
        
        // When I try to connect the output node to input node
        mOutputNode.connect(mInputNode, OUTPUT_NAME, INPUT_NAME);
        
        // And when I call postOutputs
        mOutputNode.postOutputs();
        
        // Then the input contains the correct value
        assertEquals(12, mInputNode.getInput(INPUT_NAME).getValue());
    }
    
    @Test
    public void testIsReady() {
        // Given I have 2 nodes that are not ready
        mOutputNode.addOutput(OUTPUT_NAME, Number.class);
        mInputNode.addInput(INPUT_NAME, Number.class);
        mOutputNode.addConstant(CONSTANT_NAME, Number.class);
        mInputNode.addConstant(CONSTANT_NAME, String.class);
        
        assertFalse("mOutputNode was prematurely ready", mOutputNode.isReady());
        assertFalse("mInputNode was prematurely ready", mInputNode.isReady());
        
        // The output needs to have gotten a value
        mOutputNode.mOutputs.get(0).setValue(12);
        
        // When I connect the outputs to the inputs and give the constants values
        mOutputNode.connect(mInputNode, OUTPUT_NAME, INPUT_NAME);
        mOutputNode.getConstant(CONSTANT_NAME).setValue(12);
        mInputNode.getConstant(CONSTANT_NAME).setValue("test");
        
        mOutputNode.postOutputs();
        
        // Then the 2 nodes are ready
        assertTrue("mOutputNode did not become ready", mOutputNode.isReady());
        assertTrue("mInputNode did not become ready", mInputNode.isReady());
    }
    
    @Test
    public void testConnectType_success() {
        // Given I have 2 nodes with an input and output of mismatched types
        mOutputNode.addOutput(OUTPUT_NAME, Number.class);
        mInputNode.addInput(INPUT_NAME, Number.class);
        
        // When I try to connect the output node to input node
        mOutputNode.connect(mInputNode, OUTPUT_NAME, INPUT_NAME);
        
        // Then no exception is thrown
    }
    
    @Test(expected=ClassCastException.class)
    public void testConnectType_mismatch() {
        // Given I have 2 nodes with an input and output of mismatched types
        mOutputNode.addOutput(OUTPUT_NAME, Number.class);
        mInputNode.addInput(INPUT_NAME, String.class);
        
        // When I try to connect the output node to input node
        mOutputNode.connect(mInputNode, OUTPUT_NAME, INPUT_NAME);
        
        // Then an exception is thrown
    }
}
