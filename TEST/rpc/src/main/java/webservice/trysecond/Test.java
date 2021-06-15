package webservice.trysecond;

/**
 * @author shihl
 * @date 2020/9/9 16:15
 * @description
 */
public class Test {
    public static void main(String[] args) {
        StudentServiceImpService service = new StudentServiceImpService();
        StudentServiceImp serviceImp = service.getStudentServiceImpPort();
        String sayHi = serviceImp.sayHi("两份腰子");
        System.out.println(sayHi);

    }
}
