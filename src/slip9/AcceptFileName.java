package slip9;

import java.io.*;
public class AcceptFileName {
    public static void main(String args[]) {
        if (args.length < 2) {
            System.out.println("provide  two file name through command line");
            return;
        }
        String name = args[0];  
        String file2 = args[1]; 
        System.out.println("The first file name is: " + name);
        System.out.println("The second file name is: " + file2);
        String output = "outputfile.txt";
        File file = new File(output);
        try {
            if (file.createNewFile()) {
                System.out.println("Output file is created: " + file.getName());
            } else {
                System.out.println("File already exists.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred while creating the output file: " + e.getMessage());
            e.printStackTrace();
            return;
        }
        try (BufferedReader br = new BufferedReader(new FileReader(name));
             BufferedReader br2 = new BufferedReader(new FileReader(file2));
             FileWriter writer = new FileWriter(file, true)) {
            String content;
            while ((content = br.readLine()) != null) {
                writer.write(content + "\n");  
            }
            String content2;
            while ((content2 = br2.readLine()) != null) {
                writer.write(content2 + "\n");  
            }
            System.out.println("content of the two file is written in output  file");
        } catch (IOException e) {
            System.out.println("An error files: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
