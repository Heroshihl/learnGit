package webservice.jobservice.intf;

import javax.jws.WebService;

/**
 * @author shihl
 * @date 2020/9/11 10:21
 * @description 面向接口的webservice发布方式
 */
@WebService
public interface JobService {
    public String getJob();
}
