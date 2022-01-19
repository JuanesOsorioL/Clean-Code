package co.com.sofka.score.domain.course;

import java.util.*;

public final class Lesson {

    private final String id;
    private String name;
    private final Map<String,Student> students;

    public Lesson(String id, String name) {
        this.id = Objects.requireNonNull(id);
        this.name = Objects.requireNonNull(name);
        this.students=new HashMap<>();
    }

    public void addStudent(String name, String email) {
        this.students.put(email,new Student(name,email));
    }

    public void evaluationStudent(String email,Score score) {
        this.students.get(email).eval(score);
    }

    public String id() {
        return id;
    }

    public Map<String, Student> students() {
        return students;
    }

    public String name() {
        return name;
    }

    public void updateName(String name) {
        this.name = Objects.requireNonNull(name);
    }
}
