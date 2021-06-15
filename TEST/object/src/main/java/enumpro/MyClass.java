package enumpro;

/**
 * @author SHI-HUA-LEI
 * @DATE 2020/7/29
 * @CLASSNAME
 * @description
 */
public class MyClass {
    public static void main(String[] args) {
//        Color myVar = Color.BLUE;

//        switch(myVar) {
//            case RED:
//                System.out.println("红色");
//                break;
//            case GREEN:
//                System.out.println("绿色");
//                break;
//            case BLUE:
//                System.out.println("蓝色");
//                break;
//                default:
//        }
        Color[] colors = Color.values();
        for (Color color:colors){
            System.out.println(color + "索引是:" + color.ordinal());
        }
    }
}
