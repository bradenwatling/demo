package nodes;

public class Input {

    private Node mParent;
    private String mName;
    private Class mDataType;
    private Object mValue;

    public Input(Node parent, String name, Class dataType) {
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

    public Object getValue() {
        return mValue;
    }

    public void setValue(Object value) {
        mValue = value;
    }

    public boolean isReady() {
        return mValue != null;
    }
}
