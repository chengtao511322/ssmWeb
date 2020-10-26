

public class Test {

    @org.junit.Test
    public void testTrue(){

        System.out.println("输入1/0");
        int num = 0;
        Boolean flag = num==0? false : true;
        System.out.println(flag);
    }
}
