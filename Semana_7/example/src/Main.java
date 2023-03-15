import model.Contact;

public class Main {
    
    public static void main(String[] args) {
        System.out.println("Hi there");
        Contact c= new Contact("Andres", "3171231233", "asdfasdf@gasdfa.com");
        System.out.println(c.getEmail());
    }
}
