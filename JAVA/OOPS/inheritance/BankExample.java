import java.util.*;
public class BankExample {
    public static void main(String[] args){
        Bank sbibank=new SBI();
        Bank icicibank=new ICICI();
        Bank axisbank=new AXIS();
        System.out.println("SBI Rate Of Intrest: "+sbibank.getRateOfIntrest());
        System.out.println("ICICI Rate Of Intrest: "+icicibank.getRateOfIntrest());
        System.out.println("AXIS Rate Of Intrest: "+axisbank.getRateOfIntrest());
    }
}
    class Bank{
        int getRateOfIntrest(){return 0;}
    }
    class SBI extends Bank{
        int getRateOfIntrest(){return 8;}
    }
    class ICICI extends Bank{
        int getRateOfIntrest(){return 7;}
    }
    class AXIS extends Bank{
        int getRateOfIntrest(){return 9;}
    }