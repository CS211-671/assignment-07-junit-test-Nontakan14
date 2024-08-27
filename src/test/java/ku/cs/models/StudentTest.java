package ku.cs.models;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StudentTest {

    @Test
    @DisplayName("ทดสอบการเพิ่มคะแนน 45.15 คะแนน")
    void testAddScore() {
        Student s = new Student("6xxxxxxxxx", "StudentTest");
        s.addScore(45.15);
        assertEquals(45.15, s.getScore());
    }

    @Test
    @DisplayName("ทดสอบการเพิ่มคะแนนเป็น 0 คะแนนไม่ควรเปลี่ยนแปลง")
    void testAddZeroScore() {
        Student s = new Student("6xxxxxxxxx", "StudentTest");
        s.addScore(0);
        assertEquals(0, s.getScore());
    }

    @Test
    @DisplayName("ทดสอบการเพิ่มคะแนนเป็นค่าติดลบไม่ควรเปลี่ยนแปลง")
    void testAddNegativeScore() {
        Student s = new Student("6xxxxxxxxx", "StudentTest");
        s.addScore(-10);
        assertEquals(0, s.getScore());
    }

    @Test
    @DisplayName("ทดสอบการคำนวณเกรดจากคะแนน 85 คะแนน")
    void testCalculateGrade() {
        Student s = new Student("6xxxxxxxxx", "StudentTest");
        s.addScore(85);
        assertEquals("A", s.grade());
    }

    @Test
    @DisplayName("ทดสอบการคำนวณเกรดจากคะแนน 75 คะแนน")
    void testCalculateGradeB() {
        Student s = new Student("6xxxxxxxxx", "StudentTest");
        s.addScore(75);
        assertEquals("B", s.grade());
    }

    @Test
    @DisplayName("ทดสอบการคำนวณเกรดจากคะแนน 65 คะแนน")
    void testCalculateGradeC() {
        Student s = new Student("6xxxxxxxxx", "StudentTest");
        s.addScore(65);
        assertEquals("C", s.grade());
    }

    @Test
    @DisplayName("ทดสอบการคำนวณเกรดจากคะแนน 55 คะแนน")
    void testCalculateGradeD() {
        Student s = new Student("6xxxxxxxxx", "StudentTest");
        s.addScore(55);
        assertEquals("D", s.grade());
    }

    @Test
    @DisplayName("ทดสอบการคำนวณเกรดจากคะแนน 45 คะแนน")
    void testCalculateGradeF() {
        Student s = new Student("6xxxxxxxxx", "StudentTest");
        s.addScore(45);
        assertEquals("F", s.grade());
    }

    @Test
    @DisplayName("ทดสอบการเปลี่ยนชื่อ")
    void testChangeName() {
        Student s = new Student("6xxxxxxxxx", "StudentTest");
        s.changeName("NewName");
        assertEquals("NewName", s.getName());
    }

    @Test
    @DisplayName("ทดสอบการเปลี่ยนชื่อเป็นค่าว่างไม่ควรเปลี่ยนแปลง")
    void testChangeNameToEmpty() {
        Student s = new Student("6xxxxxxxxx", "StudentTest");
        s.changeName(" ");
        assertEquals("StudentTest", s.getName());
    }

    @Test
    @DisplayName("ทดสอบการเปลี่ยนชื่อเป็นค่าว่างไม่ควรเปลี่ยนแปลง")
    void testChangeNameToBlank() {
        Student s = new Student("6xxxxxxxxx", "StudentTest");
        s.changeName("");
        assertEquals("StudentTest", s.getName());
    }

    @Test
    void testGetId() {
        Student s = new Student("6xxxxxxxxx", "StudentTest");
        assertEquals("6xxxxxxxxx", s.getId());
    }

    @Test
    void testIsId() {
        Student s = new Student("6xxxxxxxxx", "StudentTest");
        assertTrue(s.isId("6xxxxxxxxx"));
    }

    @Test
    void testGetName() {
        Student s = new Student("6xxxxxxxxx", "StudentTest");
        assertEquals("StudentTest", s.getName());
    }

    @Test
    void testGetScore() {
        Student s = new Student("6xxxxxxxxx", "StudentTest", 90.5);
        assertEquals(90.5, s.getScore());
    }
}
