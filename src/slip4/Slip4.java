package slip4;

public class Slip4 {
    public enum Signals{
        RED,GREEN,YELLOW;
    }
    public static Signals getRedSignal(){
        return Signals.RED;
    }
    public static Signals getGreenSignal(){
        return Signals.GREEN;
    }
    public static Signals getYellowSignal(){
        return Signals.YELLOW;
    }
    public static void main(String[] args) {
        while (true) {     
        System.out.println(getRedSignal()+"->STOP");
        sleep(5000);
        System.out.println(getGreenSignal()+"->GO");
        sleep(5000);
        System.out.println(getYellowSignal()+"->SLOW DOWN");
        sleep(5000);
        }
    }

    private static void sleep(int millisecond){
        try {
            Thread.sleep(millisecond);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
