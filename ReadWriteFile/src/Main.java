import java.io.*;

public class Main {

    public static void main(String[] args) {
        try (FileWriter fr = new FileWriter("test.txt", true);
             BufferedWriter writer = new BufferedWriter(fr);){
            writer.write("second string");
            writer.newLine();
            writer.flush();
        } catch (IOException e){
            System.out.println("ошибка записи в файл");
        }

        try (BufferedReader reader = new BufferedReader(
                new FileReader("test.txt")
        )){
            while(reader.ready()){
                String s = reader.readLine();
                System.out.println(s);
            }
        } catch (IOException e) {
            System.out.println("Файл не существует");
        }

    }
}
