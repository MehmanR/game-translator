package service;

import enums.EnumException;
import exception.AppException;
import files.GlobalStrings;
import service.interfaces.FileServiceInter;
import service.interfaces.GameServiceInter;
import util.InputUtil;
import util.RandomUtil;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;

public class GameServiceImpl implements GameServiceInter {
    FileServiceInter fileServiceInter = new FileServiceImpl();

    @Override
    public void start() {

        int point = 0;
        int wrong = 0;

        String[] engWordsDinamicArr = fileServiceInter.addWordToDinamicArr(GlobalStrings.ENG_FILE_NAME);
        String[] azeWordsDinamicArr = fileServiceInter.addWordToDinamicArr(GlobalStrings.AZE_FILE_NAME);

        LocalDateTime startTimer = LocalDateTime.now();

        for (int i = 0; i < 10; i++) {
            int randomIndex = RandomUtil.getRandomNumber(engWordsDinamicArr.length);
            String randomWord = engWordsDinamicArr[randomIndex];

            int foundedIndex = getIndex(randomWord);
            String azeWord = azeWordsDinamicArr[foundedIndex];
            String enteredWord = "";
            System.out.println(randomWord);
            enteredWord = InputUtil.requeireString("Enter translat of the word ");

            if (enteredWord.equals(azeWord)) {
                point++;
            } else {
                wrong++;
            }
            if (wrong == 3) {
                point--;
            }
        }
        LocalDateTime endTimer = LocalDateTime.now();
        Duration duration = Duration.between(startTimer, endTimer);
        long secondsOfGame = duration.getSeconds();

        try {
            if (point < 0) {
                throw new AppException(EnumException.ILLEGAL_POINT_EXCEPTION);
            }
            System.out.println("----------------- END -----------------");
            if (point == 0 || point == 1 || point == 2) {
                System.out.println("Your point :  " + point);
                System.out.println("Your English level A0");

            } else if (point == 3 || point == 4) {
                System.out.println("Your point :  " + point);
                System.out.println("Your English level A1");

            } else if (point == 5 || point == 6) {
                System.out.println("Your point :  " + point);
                System.out.println("Your English level B1");

            } else if (point == 7 || point == 8) {
                System.out.println("Your point :  " + point);
                System.out.println("Your English level C1");

            } else if (point == 9 || point == 10) {
                System.out.println("Your point :  " + point);
                System.out.println("Your English level C2");
            }
            System.out.println("Time: " + secondsOfGame + " seconds");
            String log = "Time - " + startTimer.format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm")) + " Point- " + point + ", Game time: " + secondsOfGame + " seconds";
            fileServiceInter.writeLogToFile(log, GlobalStrings.LOG_FILE_NAME);
        } catch (AppException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void showHistory() {
        fileServiceInter.readFile(GlobalStrings.LOG_FILE_NAME);
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
