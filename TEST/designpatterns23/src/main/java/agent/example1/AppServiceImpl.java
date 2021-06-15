package agent.example1;

/**
 * @author shihl
 * @date 2020/8/31 16:38
 * @description 该接口的默认实现类
 */
public class AppServiceImpl implements AppService {
    @Override
    public boolean createApp(String name) {
        System.out.println("App["+name+"] has been created.");
        return true;
    }
}
