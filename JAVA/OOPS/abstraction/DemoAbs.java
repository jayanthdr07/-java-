abstract class MotorBike {
    abstract void brake();
}
class  SportsBike extends MotorBike{
    public void brake(){
        System.out.println("SportsBike Brake");
    }
}
class  MountainBike extends MotorBike{
    public void brake(){
        System.out.println("MountainBike Brake");
    }
}
class DemoAbs{
    public static void main(String[] args) {
        SportsBike s1 = new SportsBike();
        s1.brake();
        MountainBike obj = new MountainBike();
        obj.brake();
    }
}



