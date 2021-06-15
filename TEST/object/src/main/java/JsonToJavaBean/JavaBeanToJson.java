package JsonToJavaBean;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 石华磊
 * @description
 * @date 2021/5/18
 */
public class JavaBeanToJson {

    public static void main(String[] args) {
        ContentFilterPo filterPo = new ContentFilterPo();
        filterPo.setDetailedLogSwitch("0");
        filterPo.setVirusFilter("0");
        List<FilterContent> filterContents = new ArrayList<>();
        List<ChangeContent> changeContents = new ArrayList<>();
        filterPo.setFilterContents(filterContents);
        filterPo.setChangeContents(changeContents);
        String s = JSON.toJSONString(filterPo);
        System.out.println(s);
    }
}
