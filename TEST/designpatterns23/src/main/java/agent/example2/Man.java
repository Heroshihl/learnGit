package agent.example2;

import static javafx.scene.input.KeyCode.L;

/**
 * @author shihl
 * @date 2020/8/31 16:45
 * @description
 */
public class Man implements IPerson {
    @Override
    public void say() {
        System.out.println("男人说话");
    }
}
