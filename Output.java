import java.utils.HashMap;
import java.utils.Map;

public class Output {

  private String mName;
  private Class mDataType;
  private Map<String, Input> mConnections;
  
  public Output(String name, Class dataType) {
    mName = name;
    mDataType = dataType;
    mConnections = new HashMap<String, Input>();
  }
  
  public String getName() {
    return mName;
  }
  
  public Class getDataType() {
    return mDataType;
  }
  
  public void addConnection(Input input) {
    mConnections.put(input.getName(), input);
  }
}
