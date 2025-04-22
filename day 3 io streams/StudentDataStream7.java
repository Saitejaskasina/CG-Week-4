import java.io.*;

public class StudentDataStream7 {
    public static void main(String[] args) {
        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream("students.dat"));
             DataInputStream dis = new DataInputStream(new FileInputStream("students.dat"))) {
            dos.writeInt(101);
            dos.writeUTF("Alice");
            dos.writeDouble(3.8);

            System.out.println("Student Data: Roll: " + dis.readInt() + ", Name: " + dis.readUTF() + ", GPA: " + dis.readDouble());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}