package SayHello;

public class Bulgarian extends Person{
    Bulgarian(String name) {
        super(name);
    }

    @Override
    public void sayHello() {
        System.out.println("Здравей");;
    }
}
