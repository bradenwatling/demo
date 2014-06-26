package bcwatling.demo;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import bcwatling.demo.Constant;
import bcwatling.demo.Input;
import bcwatling.demo.Output;
import bcwatling.demo.node.Node;

import static org.junit.Assert.*;

public class NodePointTests {
    
    private Output mOutputNumber;
    private Output mOutputString;
    private Input mInput;
    private Constant mConstant;
    
    public NodePointTests() {
    }
    
    @Before
    public void setUp() {
        Node testNode = new Node("test") {

            @Override
            public void execute() {
            }
            
        };
        
        mOutputNumber = new Output(testNode, "number_output", Number.class);
        mOutputString = new Output(testNode, "string_output", String.class);
        mInput = new Input(testNode, "input", Number.class);
        mConstant = new Constant(testNode, "constant", Number.class);
    }
    
    @After
    public void tearDown() {
    }
    
    @Test
    public void testConnect_success() {
        // Given I have an output with a value, and an input
        mOutputNumber.setValue(12);
        
        // When I connect my output to my input
        mOutputNumber.connectTo(mInput);
        
        // And when I call postValue()
        mOutputNumber.postValue();
        
        // Then the input contains the value
        assertEquals(12, mInput.getValue());
    }
    
    @Test(expected=ClassCastException.class)
    public void testConnect_mismatch() {
        // Given I have an output with a value, and an input of mismatching types
        mOutputString.setValue("test");
        
        // When I connect my output to my input
        mOutputString.connectTo(mInput);
        
        // Then an exception is thrown
    }
    
    @Test
    public void testOutputSetValue_success() {
        // Given I have a Number output (mOutputNumber)
        
        // When I call setValue() with an Object that is a Number
        mOutputNumber.setValue(12345);
        
        // Then no exception is thrown
    }
    
    @Test(expected=ClassCastException.class)
    public void testOutputSetValue_mismatch() {
        // Given I have a Number output (mOutputNumber)
        
        // When I call setValue() with an Object that is not a Number
        mOutputNumber.setValue("12345");
        
        // Then an exception is thrown
    }
    
    @Test
    public void testInputSetValue_success() {
        // Given I have a Number input (mInput)
        
        // When I call setValue() with an Object that is a Number
        mInput.setValue(12345);
        
        // Then no exception is thrown
    }
    
    @Test(expected=ClassCastException.class)
    public void testInputSetValue_mismatch() {
        // Given I have a Number input (mInput)
        
        // When I call setValue() with an Object that is not a Number
        mInput.setValue("12345");
        
        // Then an exception is thrown
    }
}
