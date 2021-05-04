package SayHello;

public abstract class Person {
    private String name;

    Person(String name){
        this.name = name;
    }

    public void sayHello(){
        System.out.println("Hello");
    }
}
