package Util.jsonToBean;

import Util.jsonToBean.Beans.returnBean;
import cn.hutool.json.JSONUtil;

import java.util.List;

/**
 * @author fantombos
 * @date 2019/4/19-10:53
 */
public class returnDate {

  public returnBean toOneBean(String returnMessage){
    returnBean returnBean = JSONUtil.toBean(returnMessage,returnBean.class);
    return returnBean;
  }

  public List<returnBean> toArrayBeans(String returnMessage){
    List<returnBean> list = JSONUtil.toList(JSONUtil.parseArray(returnMessage),returnBean.class);
    return list;
  }
}
