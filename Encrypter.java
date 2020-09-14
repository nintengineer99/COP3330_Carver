import java.util.Arrays;

public class Encrypter {
    // encrypt entered value
    public String encrypt(String userNum) {
        // declare int array to store value for work
        int[] userEncryptNum;
        // convert the string to an int array and begin encryption
        userEncryptNum = convertStringToInt(userNum);
        userEncryptNum = encryptProcess(userEncryptNum);
        // convert int array back to string and return
        userNum = convertIntToString(userEncryptNum);
        return userNum;
    }

    // helper functions for converting entered value between data types
    private int[] convertStringToInt(String userNum) {
        int[] temp = new int[userNum.length()];
        for(int i = 0; i < 4; i++) {
            temp[i] = Character.digit(userNum.charAt(i), 10);
        }
        return temp;
    }

    private String convertIntToString(int[] userNumInt) {
        return Arrays.toString(userNumInt).replace("[", "")
                .replace("]", "").replace(",", "")
                .replace(" ", "");
    }

    // encrypt number by adding 7 to it than finding the modulus of that number and 10
    // then switch the digits 1 and 3, and 2 and 4
    private int[] encryptProcess(int[] userNumInt) {
        int tempOnes = userNumInt[3], tempTens = userNumInt[2], tempHundreds = userNumInt[1],
                tempThousands = userNumInt[0];
        tempOnes = (tempOnes + 7) % 10;
        tempTens = (tempTens + 7) % 10;
        tempHundreds = (tempHundreds + 7) % 10;
        tempThousands = (tempThousands + 7) % 10;
        return new int[]{tempTens, tempOnes, tempThousands, tempHundreds};
    }
}
