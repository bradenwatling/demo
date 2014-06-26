package bcwatling.demo;

import bcwatling.demo.node.ConstantNode;
import bcwatling.demo.node.Node;
import bcwatling.demo.node.TestNode;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Main {

    private static List<Node> mNodes;
    
    private static Runnable executeThread = new Runnable() {

        @Override
        public void run() {
            boolean executing = true;
            while (executing) {
                try {
                    for (Iterator<Node> iter = mNodes.iterator(); iter.hasNext(); ) {
                        Node node = iter.next();
                        System.out.println(node + " is " + (node.isReady() ? "" : "not") + " ready");
                        if (node.isReady()) {
                            System.out.println("EXECUTING..." + node);
                            node.execute();
                            node.doExecute();
                            iter.remove();
                        }
                    }
                    Thread.sleep(500);
                } catch (Exception e) {
                    System.out.println(e);
                }
            }
        }
    };
    
    public static void main(String[] args) {
        Node myNode = new TestNode();
        Node constantNode = new ConstantNode();
        
        constantNode.getConstant("constant").setValue(12);

        constantNode.connect(myNode, "value", "test");

        mNodes = new ArrayList<Node>();
        mNodes.add(myNode);
        mNodes.add(constantNode);
        
        new Thread(executeThread).start();
    }
}
