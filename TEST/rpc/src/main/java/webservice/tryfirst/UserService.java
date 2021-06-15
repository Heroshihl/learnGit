package webservice.tryfirst;

import javax.jws.WebService;

/**
 * @author shihl
 * @date 2020/9/9 16:20
 * @description
 */
@WebService
public interface UserService {
    String sayHello(String name);
}
