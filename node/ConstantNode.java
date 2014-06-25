package bcwatling.demo.node;

public class ConstantNode extends Node {

    public ConstantNode() {
        super("Number Constant");
        addConstant("constant", Number.class);
        addOutput("value", Integer.class);
    }

    @Override
    public void execute() {
        getOutput("value").setValue(getConstant("constant").getValue());
    }
}
