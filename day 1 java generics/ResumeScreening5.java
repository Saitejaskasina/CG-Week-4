import java.util.List;

abstract class JobRole {}
class SoftwareEngineer extends JobRole {}
class DataScientist extends JobRole {}

class Resume<T extends JobRole> {}

public class ResumeScreening5 {
    static void processResumes(List<? extends JobRole> resumes) {
        System.out.println("Processing resumes...");
    }
}
