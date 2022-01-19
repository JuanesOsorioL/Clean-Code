package co.com.sofka.score.domain.course;

public class Student {

    private String name;
    private String email;

    public Student(String name, String email) {
        //TODO:validar los argumentos
        this.name = name;
        this.email = email;
    }

    public String name() {
        return name;
    }

    public String id() {
        return email;
    }

    public String email() {
        return email;
    }

    public void eval (Score score) {
    }
}
