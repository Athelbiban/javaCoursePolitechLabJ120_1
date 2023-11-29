package storePhoneNumber;

import java.util.Objects;

public class StorePhoneNumber {
    private Integer regionCode;
    private Integer phoneNumber;

    public StorePhoneNumber(Integer regionCode, Integer phoneNumber) {
        setRegionCode(regionCode);
        setPhoneNumber(phoneNumber);
    }

    public Integer getRegionCode() {
        return regionCode;
    }

    public void setRegionCode(Integer regionCode) {
        Verification.dataVerification(regionCode);
        this.regionCode = regionCode;
    }

    public Integer getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(Integer phoneNumber) {
        Verification.dataVerification(phoneNumber);
        this.phoneNumber = phoneNumber;
    }

    // контракт equals-hashCode для обеспечения использования с множествами и ассоциативными массивами
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof StorePhoneNumber that)) return false;
        return Objects.equals(regionCode, that.regionCode) && Objects.equals(phoneNumber, that.phoneNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(regionCode, phoneNumber);
    }

    // реализовать особый toString()
    @Override
    public String toString() {
        int lengthFirstGroup;
        final int LENGTHSECONDGROUP = 2;

        String stringPhoneNumber = phoneNumber + "";
        int lengthPhoneNumber = stringPhoneNumber.length();
        lengthFirstGroup = lengthPhoneNumber % 2 == 0 ? 2 : 3;

        StringBuilder temp = new StringBuilder("(");
        temp.append(regionCode).append(")").append(stringPhoneNumber, 0, lengthFirstGroup);

        for (int i = 1; i < lengthPhoneNumber / LENGTHSECONDGROUP; i++) {
            temp.append("-").append(stringPhoneNumber, lengthFirstGroup, LENGTHSECONDGROUP + lengthFirstGroup);
            lengthFirstGroup += i*LENGTHSECONDGROUP;
        }

        return temp.toString();
    }

    private abstract static class Verification {
        private static void dataVerification(Integer data) {
            if (data == null) {
                throw new IllegalArgumentException ("IllegalArgumentException: number not be null");
            }
        }
    }
}
