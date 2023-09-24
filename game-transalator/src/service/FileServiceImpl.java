package service;

import service.interfaces.FileServiceInter;
import util.InputUtil;

import java.io.*;

public class FileServiceImpl implements FileServiceInter {
    @Override
    public void addWordToFile(String fileName, String fileName2) {
        try {

            BufferedWriter buffer = new BufferedWriter(new FileWriter(fileName, true));
            BufferedWriter buffer2 = new BufferedWriter(new FileWriter(fileName2, true));
            int numOfWord = InputUtil.requireInt("How many word to want to add ");
            for (int i = 0; i < numOfWord; i++) {
                String engWord = InputUtil.requeireString("Enter " + (i + 1) + ". English word  ");
                String azeWord = InputUtil.requeireString("Enter " + (i + 1) + ". Azerbaijan word  ");

                buffer.write(engWord);
                buffer.newLine();
                buffer2.write(azeWord);
                buffer2.newLine();
            }

            buffer.close();
            buffer2.close();

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public String[] addWordToDinamicArr(String fileName) {
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName));
            int arraySize = 0;
            while (bufferedReader.readLine() != null) {
                arraySize++;
            }
            bufferedReader.close();

            bufferedReader = new BufferedReader(new FileReader(fileName));
            String line;
            String[] randomWordsDinamicArr = new String[arraySize];
            int index = 0;
            while ((line = bufferedReader.readLine()) != null) {
                randomWordsDinamicArr[index] = line;
                index++;
            }
            return randomWordsDinamicArr;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void writeLogToFile(String log, String fileName){
        try(FileWriter fileWriter = new FileWriter(fileName,true)) {
            fileWriter.write(log+ "\n");

        }catch (IOException ex){
            ex.printStackTrace();
        }
    }

    public void readFile (String fileName){
        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))) {
            String reader = bufferedReader.readLine();
            System.out.println(reader);

        }catch (IOException ex){
            ex.printStackTrace();
        }
    }

}
