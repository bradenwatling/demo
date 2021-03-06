package bcwatling.demo.node;

import bcwatling.demo.Input;
import bcwatling.demo.Output;

public class TestNode extends Node {

    public TestNode() {
        super("Test");
        addInput("test", Number.class);
    }

    @Override
    public void execute() {
        Input testInput = getInput("test");

        for (Output output : mOutputs) {
            output.setValue(testInput.getValue());
        }
    }
}
