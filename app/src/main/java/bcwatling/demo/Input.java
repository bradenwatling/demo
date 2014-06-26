package bcwatling.demo;

import bcwatling.demo.node.Node;

public class Input extends NodePoint {
    
    private Object mValue;

    public Input(Node parent, String name, Class dataType) {
        super(parent, name, dataType);
    }

    public Object getValue() {
        return mValue;
    }

    public void setValue(Object value) {
        if (!mDataType.isInstance(value)) {
            throw new ClassCastException();
        } else {
            mValue = value;
        }
    }

    public void clear() {
        mValue = null;
    }

    public boolean isReady() {
        return mValue != null;
    }
}
