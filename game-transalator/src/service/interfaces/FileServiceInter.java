package service.interfaces;

import java.io.IOException;

public interface FileServiceInter {

    void addWordToFile (String fileName,String fileName2) throws IOException;
    String[] addWordToDinamicArr(String fileName);
    void writeLogToFile (String log , String fileName);
    void readFile (String fileName);
}
