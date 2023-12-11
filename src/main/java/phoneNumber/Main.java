package phoneNumber;

import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        PhoneNumber number1 = new PhoneNumber(981, 8567753);
        PhoneNumber number2 = new PhoneNumber(4982, 627415);
        PhoneNumber number3 = new PhoneNumber(981, 8567753);
        System.out.println(number1);
        System.out.println(number2);
        System.out.println(number3);
        System.out.println();

        Set<PhoneNumber> setPhoneNumber = new HashSet<>();
        setPhoneNumber.add(number1);
        setPhoneNumber.add(number2);
        setPhoneNumber.add(new PhoneNumber(812, 6161273));
        System.out.println(setPhoneNumber);

        System.out.println(number1.equals(number3));
        setPhoneNumber.add(number3); // номер не будет добавлен т.к. уже есть в множестве
        System.out.println(setPhoneNumber);
    }
}
