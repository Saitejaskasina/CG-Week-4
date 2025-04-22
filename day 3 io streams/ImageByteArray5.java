import java.io.*;

public class ImageByteArray5 {
    public static void main(String[] args) {
        try (FileInputStream fis = new FileInputStream("input.jpg");
             ByteArrayOutputStream baos = new ByteArrayOutputStream()) {
            byte[] buffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = fis.read(buffer)) != -1) {
                baos.write(buffer, 0, bytesRead);
            }

            try (ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray());
                 FileOutputStream fos = new FileOutputStream("output.jpg")) {
                while ((bytesRead = bais.read(buffer)) != -1) {
                    fos.write(buffer, 0, bytesRead);
                }
            }
            System.out.println("Image file copied successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}