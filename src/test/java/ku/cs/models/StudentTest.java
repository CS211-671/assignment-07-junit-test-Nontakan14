package ku.cs.models;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StudentTest {
    @Test
    @DisplayName("ทดสอบการเพิ่มคะแนน 45.15 คะแนน")
    void testAddScore(){
        Student s = new Student("6xxxxxxxx", "StudentTest");
        s.addScore(45.15);
        assertEquals(45.15, s.getScore());

    }



    @Test
    @DisplayName("ทดสอบการเพิ่มคะแนน 85 คะแนน และให้ Object คำนวนเกรดออกมา")
    void testCalculateGrade(){
        Student s = new Student("6xxxxxxxxx", "StudentTest");
        s.addScore(85);
        assertEquals("A", s.grade());
    }

    @Test
    void testGetId(){
        Student s = new Student("6xxxxxxxxx", "StudentTest");
        String result = s.getId();
        assertEquals("6xxxxxxxxx",result);
    }

    @Test
    void testIsId(){
        Student s = new Student("6xxxxxxxxx","StudentTest");
        boolean sameId = s.isId("6xxxxxxxxx");
        assertEquals(true , s.isId("6xxxxxxxxx"));

    }

    @Test
    void testGetName(){
        Student s = new Student("6xxxxxxxxx","StudentTest");
        String namestudent = s.getName();
        assertEquals("StudentTest",namestudent);

    }
    @Test
    void testGetScore(){
        Student s = new Student("6xxxxxxxxx","StudentTest",90.5);
        double result = s.getScore();
        assertEquals(90.5,result);
    }

    @Test
        void testChangeName() {
            Student s = new Student("6xxxxxxxxx", "StudentTest");

            s.changeName("NewName");

            assertEquals("NewName", s.getName());
        }


    }


}