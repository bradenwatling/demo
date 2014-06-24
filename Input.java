public class Input {
  
  private Node mParent;
  private String mName;
  private Class mDataType;
  private Object mValue;
  
  public Input(String name, Class dataType) {
    mName = name;
    mDataType = dataType;
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
  
  public void setValue(Object value) {
    mValue = value;
  }
  
  public boolean isReady() {
    return mValue != null;
  }
}
