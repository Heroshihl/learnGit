package JsonToJavaBean;

import lombok.Data;

import java.io.Serializable;

/**
 * @author 石华磊
 * @description 转换内容
 * @date 2021/5/18
 */
@Data
public class ChangeContent implements Serializable {
    private static final long serialVersionUID = -3423089363919782344L;

    /**
     * 原有内容
     */
    private String originContent;

    /**
     * 转换内容
     */
    private String changeContent;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getOriginContent() {
        return originContent;
    }

    public void setOriginContent(String originContent) {
        this.originContent = originContent;
    }

    public String getChangeContent() {
        return changeContent;
    }

    public void setChangeContent(String changeContent) {
        this.changeContent = changeContent;
    }
}
