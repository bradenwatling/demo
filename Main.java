/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package nodes;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Braden
 */
public class Main {
    
    static class ConstantNode extends Node {
        
        public ConstantNode(int value) {
            super();
            addOutput("constant", Integer.class).setValue(value);
        }
        
        @Override
        public void execute() {
        }
    }

    static class ExampleNode extends Node {
        
        public ExampleNode() {
            super();
            addInput("test", Integer.class);
            addOutput("rawr", Integer.class);
        }

        @Override
        public void execute() {
            Input testInput = mInputs.get("test");
            
            for (Output output : mOutputs.values()) {
                output.setValue(testInput.getValue());
            }
        }
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Node myNode = new ExampleNode();
        Node constantNode = new ConstantNode(12);
        
        List<Node> nodes = new ArrayList<>();
        nodes.add(myNode);
        nodes.add(constantNode);
        constantNode.connect(myNode, "constant", "test");
        
        while (true) {
            for (Node node : nodes) {
                System.out.println(node.isReady());
                if (node.isReady()) {
                    constantNode.execute();
                    constantNode.postOutputs();
                }
            }
        }
    }
}
