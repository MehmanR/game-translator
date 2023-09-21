package service;

import service.interfaces.FileServiceInter;
import util.InputUtil;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class FileServiceImpl implements FileServiceInter {
    @Override
    public void addWordToFile(String fileName, String fileName2) {
        try {
            BufferedWriter buffer = new BufferedWriter(new FileWriter(fileName, true));
            BufferedWriter buffer2 = new BufferedWriter(new FileWriter(fileName2, true));
            int numOfWord = InputUtil.requireInt("How many word to want to add to file: ");
            for (int i = 0; i < numOfWord; i++) {
                String engWord = InputUtil.requeireString("Enter " + i + 1 + ". English word : ");
                String AzeWord = InputUtil.requeireString("Enter " + i + 1 + ". Azerbaijan word : ");
                buffer.write(engWord);
                buffer.newLine();

                buffer2.write(AzeWord);
                buffer2.newLine();
            }
            buffer.flush();
            buffer2.flush();
            buffer.close();
            buffer2.close();

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
