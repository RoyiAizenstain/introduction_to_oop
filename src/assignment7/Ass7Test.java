package assignment7;


import org.junit.Test;

import java.io.*;

import static org.junit.Assert.*;

public class Ass7Test {

    @Test(timeout = 2000)
    public void studentSerializeTest_1P() {
        Student s = new Student("Dad", 1, 2);
        CourseReport cr = new CourseReport("IOOP", 5, 95);
        s.addCourse(cr);
        try (FileOutputStream fileOut = new FileOutputStream("student.dat");
             ObjectOutputStream out = new ObjectOutputStream(fileOut)) {
            out.writeObject(s);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        Student loadedStudent;
        try (FileInputStream fileIn = new FileInputStream("student.dat");
             ObjectInputStream in = new ObjectInputStream(fileIn)) {
            loadedStudent = (Student) in.readObject();
        } catch (IOException | ClassNotFoundException i) {
            throw new RuntimeException(i);
        }

        assertEquals("ID was saved and loaded", 0, loadedStudent.getId());
        assertEquals("Name was saved or loaded improperly", "Dad", loadedStudent.getName());
        assertEquals("array is not in the corrrect size", 2, loadedStudent.getCourseReports().length);
        assertTrue("course was not loaded properly", loadedStudent.getCourseReports()[0].equals(cr));
    }

    @Test(timeout = 2000)
    public void courseReportTextSaveTest_1P() {
        File file = new File("cr.txt");
        CourseReport cr = new CourseReport("IOOP", 5, 8);
        try {
            cr.saveToTextFile(file);
        } catch (Throwable e) {
            throw new RuntimeException("Something was thrown");
        }

        CourseReport loaded;
        try {
            loaded = new CourseReport(file);
        } catch (Throwable e) {
            throw new RuntimeException("Something was thrown");
        }
        assertTrue("loaded course is not identical to the one printed to file", cr.equals(loaded));
    }

}
