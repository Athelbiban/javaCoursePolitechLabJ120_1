package storePhoneNumber;

import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        StorePhoneNumber number1 = new StorePhoneNumber(981, 8567753);
        StorePhoneNumber number2 = new StorePhoneNumber(4982, 627415);
        System.out.println(number1);
        System.out.println(number2);
        System.out.println();

        Set<StorePhoneNumber> setPhoneNumber = new HashSet<>();
        setPhoneNumber.add(number1);
        setPhoneNumber.add(number2);
        setPhoneNumber.add(new StorePhoneNumber(812, 6161273));
        System.out.println(setPhoneNumber);
    }
}
