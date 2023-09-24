package managment;

import enums.MenuEnum;
import files.GlobalStrings;
import service.FileServiceImpl;
import service.GameServiceImpl;
import service.interfaces.FileServiceInter;
import service.interfaces.GameServiceInter;
import util.InputUtil;

import java.io.IOException;

public class Managment {
    FileServiceInter fileServiceInter = new FileServiceImpl();
    GameServiceInter gameServiceInter = new GameServiceImpl();

    public void printMenu() throws IOException {
        for (MenuEnum menu: MenuEnum.values()) {
            System.out.println("[" + menu.getId() + "]" + "====>>>> " + menu.getStatus());
        }
            int option = InputUtil.requireInt("Choose option ");
            switch (option){
                case 1:gameServiceInter.start();
                    break;
                case 2:
                    fileServiceInter.addWordToFile(GlobalStrings.ENG_FILE_NAME,GlobalStrings.AZE_FILE_NAME);
                    break;
                case 3:
                    break;
                case 0:
                    System.out.println("BYE🧑‍💻🙋‍♂️🙌");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Wrong input!!!");
            }



        }


    }



