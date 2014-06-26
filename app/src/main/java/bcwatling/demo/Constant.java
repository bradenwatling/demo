package bcwatling.demo;

import android.view.View;
import android.widget.EditText;

import bcwatling.demo.node.Node;

public class Constant extends NodePoint {

    private Object mValue;

    public Constant(Node parent, String name, Class dataType) {
        super(parent, name, dataType);
    }

    public Object getValue() {
        EditText editText = getEditText();
        if (editText != null) {
            String text = editText.getText().toString();

            if (!"".equals(text)) {
                if (mDataType == Number.class) {
                    mValue = Double.parseDouble(text);
                } else if (mDataType == String.class) {
                    mValue = text;
                }
            }
        }

        return mValue;
    }

    public void setValue(final Object value) {
        mValue = value;

        final EditText editText = getEditText();
        if (editText != null && value != null) {
            editText.post(new Runnable() {

                @Override
                public void run() {
                    editText.setText(value.toString());
                }
            });
        }
    }

    public boolean isReady() {
        EditText editText = getEditText();
        if (editText != null) {
            return editText.getText() != null && !"".equals(editText.getText().toString());
        } else {
            return mValue != null;
        }
    }

    private EditText getEditText() {
        View nodeView = mParent.getNodeView();
        if (nodeView != null) {
            return (EditText) nodeView.findViewById(R.id.constant_value);
        } else {
            return null;
        }
    }
}
