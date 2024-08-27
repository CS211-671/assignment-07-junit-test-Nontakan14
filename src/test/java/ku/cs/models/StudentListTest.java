package ku.cs.models;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class StudentListTest {

    @Test
    @DisplayName("ทดสอบการเพิ่มนักเรียนใหม่ที่มี id และชื่อ")
    void testAddNewStudent() {
        StudentList studentList = new StudentList();
        studentList.addNewStudent("123", "John Doe");

        assertEquals(1, studentList.getStudents().size());
        assertEquals("John Doe", studentList.getStudents().get(0).getName());
        assertEquals(0, studentList.getStudents().get(0).getScore());
    }

    @Test
    @DisplayName("ทดสอบการเพิ่มนักเรียนใหม่ที่มี id, ชื่อ และคะแนน")
    void testAddNewStudentWithScore() {
        StudentList studentList = new StudentList();
        studentList.addNewStudent("123", "John Doe", 95.0);

        assertEquals(1, studentList.getStudents().size());
        assertEquals("John Doe", studentList.getStudents().get(0).getName());
        assertEquals(95.0, studentList.getStudents().get(0).getScore());
    }

    @Test
    @DisplayName("ทดสอบการเพิ่มนักเรียนใหม่ซ้ำกันด้วย id เดิม")
    void testAddDuplicateStudent() {
        StudentList studentList = new StudentList();
        studentList.addNewStudent("123", "John Doe");
        studentList.addNewStudent("123", "Jane Doe");

        assertEquals(1, studentList.getStudents().size());
        assertEquals("John Doe", studentList.getStudents().get(0).getName());
    }

    @Test
    @DisplayName("ทดสอบการค้นหานักเรียนด้วย id ที่มีอยู่")
    void testFindStudentByIdExists() {
        StudentList studentList = new StudentList();
        studentList.addNewStudent("123", "John Doe");

        Student student = studentList.findStudentById("123");
        assertNotNull(student);
        assertEquals("John Doe", student.getName());
    }

    @Test
    @DisplayName("ทดสอบการค้นหานักเรียนด้วย id ที่ไม่มีอยู่")
    void testFindStudentByIdNotExists() {
        StudentList studentList = new StudentList();
        studentList.addNewStudent("123", "John Doe");

        Student student = studentList.findStudentById("999");
        assertNull(student);
    }

    @Test
    @DisplayName("ทดสอบการให้คะแนนแก่นักเรียนด้วย id ที่มีอยู่")
    void testGiveScoreToId() {
        StudentList studentList = new StudentList();
        studentList.addNewStudent("123", "John Doe");
        studentList.giveScoreToId("123", 50.0);

        Student student = studentList.findStudentById("123");
        assertEquals(50.0, student.getScore());
    }

    @Test
    @DisplayName("ทดสอบการให้คะแนนแก่นักเรียนด้วย id ที่ไม่มีอยู่")
    void testGiveScoreToNonExistentId() {
        StudentList studentList = new StudentList();
        studentList.addNewStudent("123", "John Doe");
        studentList.giveScoreToId("999", 50.0);

        Student student = studentList.findStudentById("123");
        assertEquals(0, student.getScore());
    }

    @Test
    @DisplayName("ทดสอบการดูเกรดของนักเรียนด้วย id ที่มีอยู่")
    void testViewGradeOfId() {
        StudentList studentList = new StudentList();
        studentList.addNewStudent("123", "John Doe", 85.0);

        String grade = studentList.viewGradeOfId("123");
        assertEquals("A", grade);
    }

    @Test
    @DisplayName("ทดสอบการดูเกรดของนักเรียนด้วย id ที่ไม่มีอยู่")
    void testViewGradeOfNonExistentId() {
        StudentList studentList = new StudentList();
        studentList.addNewStudent("123", "John Doe", 85.0);

        String grade = studentList.viewGradeOfId("999");
        assertNull(grade);
    }

    @Test
    @DisplayName("ทดสอบการดึงรายชื่อนักเรียนทั้งหมด")
    void testGetStudents() {
        StudentList studentList = new StudentList();
        studentList.addNewStudent("123", "John Doe");
        studentList.addNewStudent("456", "Jane Doe");

        ArrayList<Student> students = studentList.getStudents();
        assertEquals(2, students.size());
        assertEquals("John Doe", students.get(0).getName());
        assertEquals("Jane Doe", students.get(1).getName());
    }
}
