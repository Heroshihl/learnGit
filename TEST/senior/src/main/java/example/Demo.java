package example;

/**
 * @author SHI-HUA-LEI
 * @DATE 2020/7/31
 * @CLASSNAME
 * @description
 */
public class Demo {
    public static void main(String[] args){
        for(int i=1;i<=5;i++){
            for(int j=5; i<=j; j--)
                System.out.print(" ");
            for(int j=1; j<=i; j++)
                System.out.print("*");
            for(int j=1; j<i; j++)
                System.out.print("*");
            System.out.println();
        }
    }
}
