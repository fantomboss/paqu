package Util.HttpUtil;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/**
 * @author fantomboss
 * @date 2019/4/19-10:31
 */


/**
 * 参数结合到工具类
 */
public class QueryParams {
  /**
   * 内容
   */
  private StringBuilder suffix=new StringBuilder();
  /**
   * 编码
   */
  private String code;
  public QueryParams(){
    this.code="UTF-8";
  }
  public QueryParams(String code){
    this.code=code;
  }
  public void add(String name,String value){
    suffix.append("&");
    try {
      suffix.append(URLEncoder.encode(name,code));
      suffix.append("=");
      suffix.append(URLEncoder.encode(value,code));
    } catch (UnsupportedEncodingException e) {
      //记录下日志
    }
  }
  @Override
  public String toString(){
    return suffix.toString();
  }
}
