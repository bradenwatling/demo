import java.util.List;

public abstract class Node {

  protected Map<String, Input> mInputs;
  protected Map<String, Output> mOutputs;

  public Node() {
    mInputs = new HashMap<String, Input>();
    mOutputs = new HashMap<String, Output>();
  }
  
  protected final void addInput(String name, Class type) {
    mInputs.put(name, new Input(name, type));
  }
  
  protected final void addOutput(String name, Class type) {
    mOutputs.put(name, new Output(name, type));
  }
  
  public final void makeConnection(String outputName, String inputName) {
    Input input = mInputs.get(inputName);
    Output output = mOutputs.get(outputName);
    
    output.connectTo(input);
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
  
  public abstract void execute();
}
