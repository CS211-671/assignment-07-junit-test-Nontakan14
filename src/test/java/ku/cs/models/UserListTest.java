package ku.cs.models;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserListTest {

    @Test
    @DisplayName("ทดสอบการสร้างผู้ใช้ใหม่พร้อมกับการตั้งรหัสผ่าน")
    void testCreateUserWithPassword() {
        User user = new User("john_doe", "password123");

        assertEquals("john_doe", user.getUsername());
        assertNotNull(user.getPassword());
        assertTrue(user.validatePassword("password123"));
    }

    @Test
    @DisplayName("ทดสอบการสร้างผู้ใช้ใหม่โดยไม่มีรหัสผ่าน")
    void testCreateUserWithoutPassword() {
        User user = new User("john_doe");

        assertEquals("john_doe", user.getUsername());
        assertNull(user.getPassword());
    }

    @Test
    @DisplayName("ทดสอบการตั้งรหัสผ่านใหม่")
    void testSetPassword() {
        User user = new User("john_doe");
        user.setPassword("new_password123");

        assertNotNull(user.getPassword());
        assertTrue(user.validatePassword("new_password123"));
    }

    @Test
    @DisplayName("ทดสอบการตรวจสอบรหัสผ่านที่ถูกต้อง")
    void testValidateCorrectPassword() {
        User user = new User("john_doe", "password123");

        assertTrue(user.validatePassword("password123"));
    }

    @Test
    @DisplayName("ทดสอบการตรวจสอบรหัสผ่านที่ไม่ถูกต้อง")
    void testValidateIncorrectPassword() {
        User user = new User("john_doe", "password123");

        assertFalse(user.validatePassword("wrong_password"));
    }

    @Test
    @DisplayName("ทดสอบการตรวจสอบชื่อผู้ใช้ที่ถูกต้อง")
    void testIsUsernameCorrect() {
        User user = new User("john_doe", "password123");

        assertTrue(user.isUsername("john_doe"));
    }

    @Test
    @DisplayName("ทดสอบการตรวจสอบชื่อผู้ใช้ที่ไม่ถูกต้อง")
    void testIsUsernameIncorrect() {
        User user = new User("john_doe", "password123");

        assertFalse(user.isUsername("jane_doe"));
    }
}

