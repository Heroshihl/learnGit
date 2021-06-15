package JsonToJavaBean;


import lombok.Data;

import java.io.Serializable;

/**
 * @author 石华磊
 * @description 过滤内容
 * @date 2021/5/18
 */
@Data
public class FilterContent implements Serializable {


    private static final long serialVersionUID = 933241911936565156L;
    /**
     * 过滤内容
     */
    private  String filterContent;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getFilterContent() {
        return filterContent;
    }

    public void setFilterContent(String filterContent) {
        this.filterContent = filterContent;
    }
}
