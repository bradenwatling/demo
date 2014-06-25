package bcwatling.demo.node;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import bcwatling.demo.NodeAdapter;
import bcwatling.demo.Constant;
import bcwatling.demo.Input;
import bcwatling.demo.Output;
import bcwatling.demo.R;

public abstract class Node {

    private String mName;
    private View mNodeView;
    protected List<Input> mInputs;
    protected List<Output> mOutputs;
    protected List<Constant> mConstants;

    public Node(String name) {
        mName = name;
        mInputs = new ArrayList<Input>();
        mOutputs = new ArrayList<Output>();
        mConstants = new ArrayList<Constant>();
    }

    public final String getName() {
        return mName;
    }

    public final View getNodeView() {
        return mNodeView;
    }

    protected final Input addInput(String name, Class type) {
        Input ret = new Input(this, name, type);
        mInputs.add(ret);
        return ret;
    }

    protected final Output addOutput(String name, Class type) {
        Output ret = new Output(this, name, type);
        mOutputs.add(ret);
        return ret;
    }

    protected final Constant addConstant(String name, Class type) {
        Constant ret = new Constant(this, name, type);
        mConstants.add(ret);
        return ret;
    }

    public final Input getInput(String name) {
        for (Input input : mInputs) {
            if (input.getName().equals(name)) {
                return input;
            }
        }

        return null;
    }
    
    public final Output getOutput(String name) {
        for (Output output : mOutputs) {
            if (output.getName().equals(name)) {
                return output;
            }
        }

        return null;
    }

    public final Constant getConstant(String name) {
        for (Constant constant : mConstants) {
            if (constant.getName().equals(name)) {
                return constant;
            }
        }

        return null;
    }

    public boolean isReady() {
        boolean ready = true;
        for (Input input : mInputs) {
            if (!input.isReady()) {
                ready = false;
                break;
            }
        }

        if (ready) {
            for (Constant constant : mConstants) {
                if (!constant.isReady()) {
                    ready = false;
                    break;
                }
            }
        }

        return ready;
    }

    public final void postOutputs() {
        for (Output output : mOutputs) {
            output.postValue();
        }
    }

    public final void connect(Node node, String output, String input) {
        getOutput(output).connectTo(node.getInput(input));
    }

    public final View inflate(Activity activity) {
        RelativeLayout parent = (RelativeLayout) activity.findViewById(R.id.node_space);
        LayoutInflater inflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        // Inflate the node view
        mNodeView = inflater.inflate(R.layout.node_view, parent, false);

        ((TextView) mNodeView.findViewById(R.id.node_name)).setText(mName);

        ListView inputs = (ListView) mNodeView.findViewById(R.id.inputs);
        inputs.setAdapter(new NodeAdapter(activity, R.layout.input_item, mInputs));

        ListView outputs = (ListView) mNodeView.findViewById(R.id.outputs);
        outputs.setAdapter(new NodeAdapter(activity, R.layout.output_item, mOutputs));

        ListView constants = (ListView) mNodeView.findViewById(R.id.constants);
        constants.setAdapter(new NodeAdapter(activity, R.layout.constant_item, mConstants));

        parent.addView(mNodeView);

        return mNodeView;
    }

    public abstract void execute();
}
