class AnimalMethod{
    protected String name;
    protected int age;

    public AnimalMethod(String name, int age){
        this.name = name;
        this.age = age;
    }

    public void speak(){
        System.out.println("Speak:");
    }

    public void showInformation(){
        System.out.println("Ten: "+ name + "    Tuoi:" + age);
    }
}

class Cat extends AnimalMethod{
    public Cat(String name, int age){
        super(name,age);
    }
    public void speak(){
        System.out.println(name + " MeoMeo");
    }
}

class Dog extends AnimalMethod{
    public Dog(String name, int age){
        super(name,age);
    }
    public void speak(){
        System.out.println(name +":" + " GauGau");
    }
}

public class Animals{
    public static void main(String[] args) {
        AnimalMethod cat01 = new Cat("Mun", 7);
        AnimalMethod cat02 = new Cat("Nike", 8);
        AnimalMethod dog01 = new Dog("Cun", 10);
        AnimalMethod dog02 = new Dog("nyc", 19);

        cat01.showInformation(); cat01.speak();
        cat02.showInformation(); cat02.speak();
        dog01.showInformation(); dog01.speak();
        dog02.showInformation(); dog02.speak();
    }
}