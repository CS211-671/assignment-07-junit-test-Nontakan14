package ku.cs.models;

import java.util.ArrayList;

public class StudentList {
    private ArrayList<Student> students;

    public StudentList() {
        students = new ArrayList<>();
    }

    public void addNewStudent(String id, String name) {
        id = id.trim();
        name = name.trim();
        if (!id.isEmpty() && !name.isEmpty()) {
            Student exist = findStudentById(id);
            if (exist == null) {
                students.add(new Student(id, name));
            }
        }
    }

    public void addNewStudent(String id, String name, double score) {
        id = id.trim();
        name = name.trim();
        if (!id.isEmpty() && !name.isEmpty()) {
            Student exist = findStudentById(id);
            if (exist == null) {
                students.add(new Student(id, name, score));
            }
        }
    }

    public Student findStudentById(String id) {
        for (Student student : students) {
            if (student.isId(id)) {
                return student;
            }
        }
        return null;
    }

    public void giveScoreToId(String id, double score) {
        Student exist = findStudentById(id);
        if (exist != null) {
            exist.addScore(score);
        }
    }

    public String viewGradeOfId(String id) {
        Student exist = findStudentById(id);
        if (exist != null) {
            return exist.grade();
        }
            return false;
    }

    public ArrayList<Student> getStudents() {
        return students;
    }


    public Student findStudentByObject(Student s){
        if (students.contains(s)){
            return s;   //ใช้เช็คว่าข้อมูลในออบเจ็กที่ เรฟเฟอเรน มาตัวเดียวกันไหม ไม่ return False
        }

    }
}