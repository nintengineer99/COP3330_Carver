import java.util.Arrays;

public class Decrypter {
    // decrypt entered value
    public String decrypt(String userNum) {
        // declare int array to store value for work
        int[] userDecryptNum;
        // convert the string to an int array and begin decryption
        userDecryptNum = convertStringToInt(userNum);
        userDecryptNum = decryptProcess(userDecryptNum);
        // convert int array back to string and return
        userNum = convertIntToString(userDecryptNum);
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

    // invert the encryption algorithm and switch digits 1 and 3, then 2 and 4
    private int[] decryptProcess(int[] userNumInt) {
        int tempOnes = userNumInt[3], tempTens = userNumInt[2], tempHundreds = userNumInt[1],
                tempThousands = userNumInt[0];
        tempOnes = invertMod(tempOnes) - 7;
        tempTens = invertMod(tempTens) - 7;
        tempHundreds = invertMod(tempHundreds) - 7;
        tempThousands = invertMod(tempThousands) - 7;
        return new int[]{tempTens, tempOnes, tempThousands, tempHundreds};
    }

    // reverses the offset done to the [0, 9] domain by the encryption algorithm's modulus
    private int invertMod(int invertModNum) {
        if (invertModNum - 7 < 0)
        {
            return invertModNum + 10;
        }
        return invertModNum;
    }

}
