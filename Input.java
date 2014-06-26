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
        if (!mDataType.isAssignableFrom(value.getClass())) {
            throw new ClassCastException();
        } else {
            mValue = value;
        }
    }

    public boolean isReady() {
        return mValue != null;
    }
}
