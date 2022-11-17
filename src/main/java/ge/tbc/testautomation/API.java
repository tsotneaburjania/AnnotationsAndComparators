package ge.tbc.testautomation;

public class API {
    @Deprecated(forRemoval = true)
    public static void oldFunction(){
        System.out.println("I AM OLD");
        System.out.println();
    }

    public static void newFunction(){
        System.out.println("I AM NEW");
    }
}
