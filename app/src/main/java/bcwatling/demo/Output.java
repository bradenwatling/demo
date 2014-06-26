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
        // If value is not an of mDataType
        if (!mDataType.isInstance(value)) {
            throw new ClassCastException();
        } else {
            mValue = value;
        }
    }

    public void postValue() {
        for (Input connection : mConnections) {
            // Send the value to the input
            connection.setValue(mValue);
            // And then delete the value from this output
            mValue = null;
            // This, in effect, creates a "relay" property
        }
    }

    public void connectTo(Input input) {
        // If mDataType is not a superclass of input
        if (!mDataType.isAssignableFrom(input.getDataType())) {
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
