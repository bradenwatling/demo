package bcwatling.demo;

//import android.widget.EditText;

import bcwatling.demo.node.Node;

public class Constant extends NodePoint {

    // TODO: get rid of this
    public static class EditText {
        public String getText() {
            return "";
        }
    }
    
    class R {
        class id {
            public static final int constant_value = 0;
        }
    }
    
    private Object mValue;
    
    public Constant(Node parent, String name, Class dataType) {
        super(parent, name, dataType);
    }

    public Object getValue() {
        return mValue;
        /*Object value = null;
        EditText editText = getEditText();
        String text = editText.getText().toString();

        if (mDataType == Number.class) {
            value = Double.parseDouble(text);
        } else if (mDataType == String.class) {
            value = text;
        }

        return value;*/
    }
    
    public void setValue(Object value) {
        mValue = value;
    }

    public boolean isReady() {
        return mValue != null && !"".equals(mValue);
//        EditText editText = getEditText();
//        return editText != null && editText.getText() != null && !"".equals(editText.getText().toString());
    }

    private EditText getEditText() {
        return (EditText) mParent.getNodeView().findViewById(R.id.constant_value);
    }
}
