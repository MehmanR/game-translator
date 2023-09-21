package managment;

import enums.MenuEnum;
import util.InputUtil;

public class Managment {

    public void printMenu(){
        for (MenuEnum menu: MenuEnum.values()) {
            System.out.println("["+menu.getId()+"]" + "====>>>> "+menu.getStatus());

            int option = InputUtil.requireInt("Choose option: ");
            switch (option){
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Wrong input!!!");
            }



        }


    }


}
