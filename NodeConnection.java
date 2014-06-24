public class Input {
  
  private String mName;
  private Class mDataType;
  
  public Input(String name, Class dataType) {
    mName = name;
    mDataType = dataType;
  }
  
  public String getName() {
    return mName;
  }
  
  public Class getDataType() {
    return mDataType;
  }
}
