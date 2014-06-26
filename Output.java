package bcwatling.demo;

import bcwatling.demo.node.Node;
import java.util.ArrayList;
import java.util.List;

public class Output extends NodePoint {

    private Object mValue;
    private List<Input> mConnections;

    public Output(Node parent, String name, Class dataType) {
        super(parent, name, dataType);
        mConnections = new ArrayList<Input>();
    }
    
    public void setValue(Object value) {
        if (!mDataType.isAssignableFrom(value.getClass())) {
            throw new ClassCastException();
        } else {
            mValue = value;
        }
    }

    public void postValue() {
        for (Input connection : mConnections) {
            connection.setValue(mValue);
        }
    }

    public void connectTo(Input input) {
        if (mDataType != input.getDataType()) {
            throw new ClassCastException();
        } else {
            mConnections.add(input);
        }
    }

    @Override
    public boolean isReady() {
        return mValue != null;
    }
}
