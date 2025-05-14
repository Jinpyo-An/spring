package hello.spring_core;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class HelloLombok {

    private String name;
    private int age;

    public static void main(String[] args) {
        final HelloLombok helloLombok = new HelloLombok();
        helloLombok.setName("name"  );

        final String name = helloLombok.getName();
        System.out.println("name = " + name);
    }
}
