package nodes;

import java.util.HashMap;
import java.util.Map;

public class Output {

    private Node mParent;
    private String mName;
    private Class mDataType;
    private Object mValue;
    private Map<String, Input> mConnections;

    public Output(Node parent, String name, Class dataType) {
        mParent = parent;
        mName = name;
        mDataType = dataType;
        mConnections = new HashMap<>();
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

    public void setValue(Object value) {
        mValue = value;
    }

    public void postValue() {
        for (Input connection : mConnections.values()) {
            connection.setValue(mValue);
        }
    }

    public void connectTo(Input input) {
        mConnections.put(input.getName(), input);
    }
}
