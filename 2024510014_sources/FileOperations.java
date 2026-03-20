import java.io.*;

public class FileOperations {

    public static int[] readIntArray(String fileName){
        int[] intArray = new  int[1000000];
        try {
            FileReader fileReader = new FileReader(fileName);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line = bufferedReader.readLine();

            int i = 0;

             while(line != null){
                intArray[i] = Integer.parseInt(line.trim());
                line = bufferedReader.readLine();
                i += 1;
             }

        } catch (IOException e) {
            System.out.println("Error reading file");
        } catch (NumberFormatException e) {
            System.out.println("Wrong number format");
        }
        return intArray;
    }

    public static void writeIntArray(String fileName, int[] array) throws IOException {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(fileName))) {
            for (int i : array) {
                bufferedWriter.write(i + "");
                bufferedWriter.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }

    }
}
