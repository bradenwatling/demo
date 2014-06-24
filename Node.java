package nodes;

import java.util.HashMap;
import java.util.Map;

public abstract class Node {

    protected Map<String, Input> mInputs;
    protected Map<String, Output> mOutputs;

    public Node() {
        mInputs = new HashMap<>();
        mOutputs = new HashMap<>();
    }

    protected final Input addInput(String name, Class type) {
        Input ret = new Input(this, name, type);
        mInputs.put(name, ret);
        return ret;
    }

    protected final Output addOutput(String name, Class type) {
        Output ret = new Output(this, name, type);
        mOutputs.put(name, ret);
        return ret;
    }

    public final void postOutputs() {
        for (Output output : mOutputs.values()) {
            output.postValue();
        }
    }

    public boolean isReady() {
        boolean ready = true;
        for (Input input : mInputs.values()) {
            if (!input.isReady()) {
                ready = false;
            }
        }

        return ready;
    }
    
    public final Input getInput(String name) {
        return mInputs.get(name);
    }
    
    public final Output getOutput(String name) {
        return mOutputs.get(name);
    }
    
    public final void connect(Node node, String output, String input) {
        mOutputs.get(output).connectTo(node.getInput(input));
    }

    public abstract void execute();
}
