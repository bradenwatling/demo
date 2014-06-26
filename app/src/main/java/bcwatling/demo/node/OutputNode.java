package bcwatling.demo.node;

import bcwatling.demo.Input;

public class OutputNode extends Node {

    public OutputNode() {
        super("Output");
        addConstant("output", String.class);
        addInput("input", String.class);
    }

    @Override
    public void execute() {
        getConstant("output").setValue(getInput("input").getValue());
    }

    @Override
    public boolean isReady() {
        boolean ready = true;
        for (Input input : mInputs) {
            if (!input.isReady()) {
                ready = false;
                break;
            }
        }

        return ready;
    }
}
