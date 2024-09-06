package gradebook;

public class GradeBookTest {

    public static void main(String[] args) {
        GradeBook gradebook1 = new GradeBook("Programming 2");
        
        gradebook1.displayMessage();

        gradebook1.setCourseName("Advanced Programming");
        
        gradebook1.newMessage();
    } 
}
