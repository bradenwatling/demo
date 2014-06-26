package bcwatling.demo;

import bcwatling.demo.node.Node;

public abstract class NodePoint {
    
    protected Node mParent;
    protected String mName;
    protected Class mDataType;
    
    public NodePoint(Node parent, String name, Class dataType) {
        mParent = parent;
        mName = name;
        mDataType = dataType;
    }
    
    public Node getParent() {
        return mParent;
    }

    public String getName() {
        return mName;
    }

    public Class getDataType() {
        return mDataType;
    }
    
    public abstract boolean isReady();
}
