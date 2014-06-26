package bcwatling.demo;

import android.app.Activity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import bcwatling.demo.node.ConstantNode;
import bcwatling.demo.node.Node;
import bcwatling.demo.node.OutputNode;
import bcwatling.demo.node.TestNode;


public class MainActivity extends Activity {

    List<Node> mNodes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onResume() {
        super.onResume();

        Node myNode = new TestNode();
        Node constantNode = new ConstantNode();
        Node outputNode = new OutputNode();

        constantNode.connect(outputNode, "value", "input");

        mNodes = new ArrayList<Node>();
        mNodes.add(outputNode);
        mNodes.add(constantNode);

        for (Node node : mNodes) {
            final View nodeView = node.inflate(this);

            nodeView.setOnTouchListener(new View.OnTouchListener() {
                private int xStart, yStart;

                @Override
                public boolean onTouch(View v, MotionEvent event) {
                    int xEvent = (int) event.getRawX(), yEvent = (int) event.getRawY();
                    switch (event.getAction()) {
                        case MotionEvent.ACTION_MOVE:
                            v.setX(xEvent - xStart);
                            v.setY(yEvent - yStart);
                            break;
                        case MotionEvent.ACTION_DOWN:
                            xStart = xEvent - (int) v.getX();
                            yStart = yEvent - (int) v.getY();
                            break;
                    }
                    return false;
                }
            });
        }

        new Thread(executeThread).start();
    }

    private Runnable executeThread = new Runnable() {

        @Override
        public void run() {
            boolean executing = true;
            while (executing) {
                try {
                    for (Iterator<Node> iter = mNodes.iterator(); iter.hasNext(); ) {
                        Node node = iter.next();
                        if (node.isReady()) {
                            System.out.println("EXECUTING..." + node);
                            node.doExecute();
                            //iter.remove();
                        }
                    }
                    Thread.sleep(500);
                } catch (Exception e) {
                    System.out.println(e);
                }
            }
        }
    };
}
