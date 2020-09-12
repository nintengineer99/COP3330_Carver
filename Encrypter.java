import java.util.Arrays;

public class Encrypter {
    public String encrypt(String userNum) {
        int userEncryptNum[];
        userEncryptNum = convertStringToInt(userNum);
        userEncryptNum = encryptProcess(userEncryptNum);
        userNum = convertIntToString(userEncryptNum);
        return userNum;
    }

    private int[] convertStringToInt(String userNum) {
        int[] temp = new int[userNum.length()];
        for(int i = 0; i < 4; i++) {
            temp[i] = Character.digit(userNum.charAt(i), 10);
        }
        return temp;
    }

    private String convertIntToString(int userNumInt[]) {
        String temp = Arrays.toString(userNumInt).replace("[", "")
                .replace("]", "").replace(",", "")
                .replace(" ", "");
        return temp;
    }

    /*private int getOnesDig(int userEncryptNum[]) {
        int temp = userEncryptNum[4];
        return temp;
    }

    private int getTensDig(int userEncryptNum) {
        int temp = userEncryptNum;
        temp = temp / 10;
        temp = temp % 10;
        return temp;
    }

    private int getHundredsDig(int userEncryptNum) {
        int temp = userEncryptNum;
        temp = temp / 10;
        temp = temp / 10;
        temp = temp % 10;
        return temp;
    }

    private int getThousandsDig(int userEncryptNum) {
        int temp = userEncryptNum;
        temp = temp / 10;
        temp = temp / 10;
        temp = temp / 10;
        temp = temp % 10;
        return temp;
    }*/

    private int[] encryptProcess(int userNumInt[]) {
        int tempOnes = userNumInt[3], tempTens = userNumInt[2], tempHundreds = userNumInt[1],
                tempThousands = userNumInt[0];
        tempOnes = (tempOnes + 7) % 10;
        tempTens = (tempTens + 7) % 10;
        tempHundreds = (tempHundreds + 7) % 10;
        tempThousands = (tempThousands + 7) % 10;
        int newNum[] = {tempTens, tempOnes, tempThousands, tempHundreds};
        return newNum;
    }
}
