import java.util.List;

abstract class CourseType {}
class ExamCourse extends CourseType {}
class AssignmentCourse extends CourseType {}

class Course<T extends CourseType> {}

public class UniversityCourses3 {
    static void listCourses(List<? extends CourseType> courses) {
        System.out.println("Courses available: " + courses.size());
    }
}