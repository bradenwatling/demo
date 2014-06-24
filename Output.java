import java.utils.HashMap;
import java.utils.Map;

public class Output {

  private Node mParent;
  private String mName;
  private Class mDataType;
  private Object mValue;
  
  private Map<String, Input> mConnections;
  
  public Output(String name, Class dataType) {
    mName = name;
    mDataType = dataType;
    mConnections = new HashMap<String, Input>();
  }
  
  public Node getParent() {
    return mParent;
  }
  
  public String getName() {
    return mName;
  }
  
  public Class getDataType() {
    return mDataType;
  }
  
  public void postValue() {
    for (Input connection : mConnections) {
      connection.setValue(mValue);
    }
  }
  
  public void addConnection(Input input) {
    mConnections.put(input.getName(), input);
  }
}
