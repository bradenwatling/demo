package bcwatling.demo;

import android.widget.EditText;

import bcwatling.demo.node.Node;

public class Constant {

    private Node mParent;
    private String mName;
    private Class mDataType;

    public Constant(Node parent, String name, Class dataType) {
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
        Object value = null;
        EditText editText = getEditText();
        String text = editText.getText().toString();

        if (mDataType == Number.class) {
            value = Double.parseDouble(text);
        } else if (mDataType == String.class) {
            value = text;
        }

        return value;
    }

    public boolean isReady() {
        EditText editText = getEditText();
        return editText != null && editText.getText() != null && !"".equals(editText.getText().toString());
    }

    private EditText getEditText() {
        return (EditText) mParent.getNodeView().findViewById(R.id.constant_value);
    }
}
