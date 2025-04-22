import java.io.*;

public class BufferedFileCopy2 {
    public static void main(String[] args) {
        File source = new File("largefile.txt");
        File destination = new File("copy_largefile.txt");

        long startTime = System.nanoTime();
        try (BufferedInputStream bis = new BufferedInputStream(new FileInputStream(source));
             BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(destination))) {
            byte[] buffer = new byte[4096];
            int bytesRead;
            while ((bytesRead = bis.read(buffer)) != -1) {
                bos.write(buffer, 0, bytesRead);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        long endTime = System.nanoTime();
        System.out.println("Buffered stream execution time: " + (endTime - startTime) + " ns");
    }
}