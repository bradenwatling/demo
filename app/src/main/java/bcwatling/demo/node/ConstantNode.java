package bcwatling.demo.node;

public class ConstantNode extends Node {

    public ConstantNode() {
        super("Number Constant");
        addConstant("constant", String.class);
        addOutput("value", String.class);
    }

    @Override
    public void execute() {
        getOutput("value").setValue(getConstant("constant").getValue());
    }
}
