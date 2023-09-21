import files.GlobalStrings;
import managment.Managment;
import service.FileServiceImpl;
import service.GameServiceImpl;
import service.interfaces.FileServiceInter;
import service.interfaces.GameServiceInter;
import util.InputUtil;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {

        Managment managment = new Managment();
        managment.printMenu();

//        FileServiceInter fileServiceInter = new FileServiceImpl();
//        fileServiceInter.addWordToDinamicArr(GlobalStrings.ENG_FILE_NAME);



    }
}