package JsonToJavaBean;

import lombok.Data;

import java.util.List;


/**
 * 病毒过滤、内容过滤、内容转换
 * @author 石华磊
 */
@Data
public class ContentFilterPo {

    /**
     * 行级日志的开关 0开；1关，默认为1
     */
    private String detailedLogSwitch;

    /**
     * 是否开启病毒过滤 0 否 1是
     */
    private String virusFilter;

    /**
     * 内容过滤，不过滤为null 或者size=0
     */
    private List<FilterContent> filterContents;
    /**
     * 内容转换 不转换为null 或者size=0
     */
    private List<ChangeContent> changeContents;

    public String getVirusFilter() {
        return virusFilter;
    }

    public void setVirusFilter(String virusFilter) {
        this.virusFilter = virusFilter;
    }

    public List<FilterContent> getFilterContents() {
        return filterContents;
    }

    public void setFilterContents(List<FilterContent> filterContents) {
        this.filterContents = filterContents;
    }

    public List<ChangeContent> getChangeContents() {
        return changeContents;
    }

    public void setChangeContents(List<ChangeContent> changeContents) {
        this.changeContents = changeContents;
    }

    public String getDetailedLogSwitch() {
        return detailedLogSwitch;
    }

    public void setDetailedLogSwitch(String detailedLogSwitch) {
        this.detailedLogSwitch = detailedLogSwitch;
    }
}
