package webservice.trysecond;

import javax.jws.WebService;

/**
 * @author shihl
 * @date 2020/9/9 16:13
 * @description
 */
@WebService
public class StudentServiceImpl implements StudentService {
    @Override
    public String sayHi(String name) {
        return "学生说" + name;
    }
}
