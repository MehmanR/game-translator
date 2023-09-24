package managment;
import enums.MenuEnum;
import files.GlobalStrings;
import service.FileServiceImpl;
import service.GameServiceImpl;
import service.interfaces.FileServiceInter;
import service.interfaces.GameServiceInter;
import util.InputUtil;
import java.io.IOException;
import java.util.InputMismatchException;
public class Managment {
    FileServiceInter fileServiceInter = new FileServiceImpl();
    GameServiceInter gameServiceInter = new GameServiceImpl();

    public void printMenu() throws IOException {
        while (true) {


            int option = 0;
            for (MenuEnum menu : MenuEnum.values()) {
                System.out.println("[" + menu.getId() + "]" + "====>>>> " + menu.getStatus());
            }
            try {
                option = InputUtil.requireInt("Choose option ");
            } catch (InputMismatchException ex) {
                System.out.println("Wrong input!");
                continue;
            }

            switch (option) {
                case 1:
                    gameServiceInter.start();
                    break;
                case 2:
                    fileServiceInter.addWordToFile(GlobalStrings.ENG_FILE_NAME, GlobalStrings.AZE_FILE_NAME);
                    break;
                case 3:
                    gameServiceInter.showHistory();
                    break;
                case 0:
                    System.out.println("BYE 🙋‍♂️");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Wrong input!!!");
            }
        }
    }
}



