import java.util.List;

public abstract class Node {

  protected Map<String, Input> mInputs;
  protected Map<String, Output> mOutputs;

  public Node() {
    mInputs = new HashMap<Input>();
    mOutputs = new HashMap<Output>();
  }
  
  protected void addInput(String name, Class type) {
    mInputs.put(name, new Input(name, type));
  }
  
  protected void addOutput(String name, Class type) {
    mOutputs.put(name, new Output(name, type));
  }
  
  public final void makeConnection(String outputName, String inputName) {
    Input input = mInputs.get(inputName);
    Output output = mOutputs.get(outputName);
    
    output.connectTo(input);
  }
  
  public void execute() {
    for (Input input : mInputs.values()) {
      
    }
  }
}
