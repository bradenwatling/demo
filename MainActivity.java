//package bcwatling.demo;
//
//import android.app.Activity;
//import android.os.Bundle;
//import android.view.MotionEvent;
//import android.view.View;
//import android.widget.RelativeLayout;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import bcwatling.demo.node.ConstantNode;
//import bcwatling.demo.node.Node;
//import bcwatling.demo.node.TestNode;
//
//
//public class MainActivity extends Activity {
//
//    List<Node> mNodes;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//    }
//
//    @Override
//    protected void onResume() {
//        super.onResume();
//
//        Node myNode = new TestNode();
//        Node constantNode = new ConstantNode();
//
//        constantNode.connect(myNode, "value", "test");
//
//        mNodes = new ArrayList<Node>();
//        mNodes.add(myNode);
//        mNodes.add(constantNode);
//
//        for (Node node : mNodes) {
//            final View nodeView = node.inflate(this);
//
//            nodeView.setOnTouchListener(new View.OnTouchListener() {
//                private int xStart
//                        ,
//                        yStart;
//
//                @Override
//                public boolean onTouch(View v, MotionEvent event) {
//                    int xEvent = (int) event.getRawX(), yEvent = (int) event.getRawY();
//                    switch (event.getAction()) {
//                        case MotionEvent.ACTION_MOVE:
//                            v.setX(xEvent - xStart);
//                            v.setY(yEvent - yStart);
//                            break;
//                        case MotionEvent.ACTION_DOWN:
//                            xStart = xEvent - (int) v.getX();
//                            yStart = yEvent - (int) v.getY();
//                            break;
//                    }
//                    return false;
//                }
//            });
//        }
//
//        new Thread(executeThread).start();
//    }
//
//    private Runnable executeThread = new Runnable() {
//
//        @Override
//        public void run() {
//            boolean executing = true;
//            while (executing) {
//                try {
//                    for (Node node : mNodes) {
//                        //System.out.println(node.isReady());
//                        if (node.isReady()) {
//                            node.execute();
//                            node.postOutputs();
//                        }
//                    }
//                    Thread.sleep(500);
//                } catch (Exception e) {
//                }
//            }
//        }
//    };
//}
