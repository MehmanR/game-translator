package service;

import files.GlobalStrings;
import service.interfaces.FileServiceInter;
import service.interfaces.GameServiceInter;
import util.InputUtil;
import util.RandomUtil;

import java.util.Random;

public class GameServiceImpl implements GameServiceInter {
    FileServiceInter fileServiceInter = new FileServiceImpl();

    @Override
    public void start() {

        int point = 0;
        int wrong = 0;
        boolean  isShowed = false;


        String[] engWordsDinamicArr = fileServiceInter.addWordToDinamicArr(GlobalStrings.ENG_FILE_NAME);
        String[] azeWordsDinamicArr = fileServiceInter.addWordToDinamicArr(GlobalStrings.AZE_FILE_NAME);

        for (int i = 0; i < 10; i++) {
            int randomIndex = RandomUtil.getRandomNumber(engWordsDinamicArr.length);
            String randomWord = engWordsDinamicArr[randomIndex];

            int foundedIndex = getIndex(randomWord);
            String azeWord = azeWordsDinamicArr[foundedIndex];

            
            System.out.println(randomWord);
            String enteredWord = InputUtil.requeireString("Enter translat of the word ");
            if (enteredWord.equals(azeWord)) {
                point++;
            } else {
                wrong++;
            }
        }
    }


    public Integer getIndex(String word) {
        String[] engWordsDinamicArr = fileServiceInter.addWordToDinamicArr(GlobalStrings.ENG_FILE_NAME);
        for (int i = 0; i < engWordsDinamicArr.length; i++) {
            String engWord = engWordsDinamicArr[i];
            if (word.equals(engWord)) {
                return i;
            }
        }
        return null;
    }


}
