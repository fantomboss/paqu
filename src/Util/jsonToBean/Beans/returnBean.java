package Util.jsonToBean.Beans;

/**
 * @author fantomboss
 * @date 2019/4/19-10:54
 */

public class returnBean {
  private int state;
  private String msg;
  private Object data;

  public int getState() {
    return state;
  }

  public void setState(int state) {
    this.state = state;
  }

  public String getMsg() {
    return msg;
  }

  public void setMsg(String msg) {
    this.msg = msg;
  }

  public Object getData() {
    return data;
  }

  public void setData(Object date) {
    this.data = data;
  }

  @Override
  public String toString() {
    return "returnBean{" +
            "state=" + state +
            ", msg='" + msg + '\'' +
            ", data='" + data + '\'' +
            '}';
  }
}
