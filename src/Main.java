import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        int[] numArray = {1, 2, 3, 5, 6, 7, 8, 10, 9};
        int maxNum = 10;
        int numberMissing = missingNumber(numArray,maxNum);
        System.out.println("The number missing from array is " + numberMissing);
    }
public static  int missingNumber(int[] numArray, int maxNum) {
        Arrays.sort(numArray);
        for(int i=1;i<maxNum;i++)
        {
            if(i!=numArray[i-1])
            return i;
        }

        if (numArray.length == maxNum && numArray[maxNum - 1] == maxNum) {
            return 0;
        }
         return maxNum;
         }
}