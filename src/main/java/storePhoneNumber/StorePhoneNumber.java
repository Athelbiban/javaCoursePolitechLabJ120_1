package storePhoneNumber;

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

    @Override
    public String toString() {
        int lengthFirstGroup;
        final int LENGTHSECONDGROUP = 2;

        String stringPhoneNumber = phoneNumber + "";
        int lengthPhoneNumber = stringPhoneNumber.length();
        if (lengthPhoneNumber % 2 == 0) {
            lengthFirstGroup = 2;
        }
        else {
            lengthFirstGroup = 3;
        }

        StringBuilder temp = new StringBuilder("(");
        temp.append(regionCode).append(")");
        String firstGroup = stringPhoneNumber.substring(0, lengthFirstGroup);
        temp.append(firstGroup);

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
