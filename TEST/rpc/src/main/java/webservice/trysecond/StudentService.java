package webservice.trysecond;

import javax.jws.WebService;

/**
 * @author shihl
 * @date 2020/9/9 15:59
 * @description 1-1、创建远程服务接口
 */
@WebService
public interface StudentService {
    String sayHi(String name);
}
