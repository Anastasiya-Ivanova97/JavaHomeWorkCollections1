import java.io.FileNotFoundException;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        FileWorker fileWorker = new FileWorker();
        try {
        fileWorker.getFileName();
        fileWorker.bytesToString();
        fileWorker.printWords();
        fileWorker.printFrequency();
        fileWorker.printMostFrequent();
        } catch (FileNotFoundException f) {
            System.out.println("Incorrect filename. Please try again");
        } catch (IOException io) {
            io.printStackTrace();
        } catch (Exception e) {
            System.out.println("An error occurred");
        }
    }
}
