import java.util.*;

public class IDCodeValidator {


    public static boolean isCorrect(String idCode) {
        System.out.println(idCode);
        IDNumberData personalCode = IDNumberData.getInformationFromIdCode(idCode);
        if (idCode.length() == 11
                && isGenderNumberCorrect(personalCode.genderNumber)
                && isDayNumberCorrect(personalCode.dayNumber)
                && isMonthNumberCorrect(personalCode.monthNumber)
                && isBirthDateCorrect(getFullYear(personalCode.genderNumber, personalCode.yearNumber), personalCode.monthNumber, personalCode.dayNumber)
                && checkControlNumber(idCode)){

            System.out.println("ID is correct");
            return true;
        }
        if (idCode.length() != 11) {
            System.out.println("The length is not correct");

        }

        return false;
    }


    public static boolean isGenderNumberCorrect(int genderNumber) {
        if (genderNumber == 1 || genderNumber == 3 || genderNumber == 5 || genderNumber == 2 || genderNumber == 4 || genderNumber == 6) {
            return true;
        }
        return false;
    }


    public static boolean isDayNumberCorrect(int dayNumber) {
        if (dayNumber > 0 && dayNumber <= 31) {
            System.out.println(dayNumber);
            return true;
        }
        System.out.println("There is no such day");
        return false;
    }

    public static boolean isMonthNumberCorrect(int monthNumber) {
        if (monthNumber > 0 && monthNumber <= 12) {
            System.out.println(monthNumber);
            return true;
        }
        System.out.println("There is no such month");
        return false;
    }


    public static boolean isBirthDateCorrect(int yearNumber, int monthNumber, int dayNumber) {
        boolean result;
        int[] numbersOfDays = {0, 31, 28, 31, 30, 31, 30, 31, 30, 31, 30, 31};
        if (numbersOfDays[2] == 28 && isLeapYear(yearNumber)) {
            result = (dayNumber <= numbersOfDays[monthNumber] + 1);
        } else {
            result = (dayNumber <= numbersOfDays[monthNumber]);
        }
        if (result) {
            System.out.println("Your birth date is correct");
        } else {
            System.out.println("Your birth date is not correct");
        }
        return result;
    }


    public static boolean isLeapYear(int yearNumber) {
        if ((yearNumber % 4 == 0 && yearNumber % 100 != 0) || (yearNumber % 400 == 0)) {
            return true;
        } else {
            return false;
        }
    }


    public static boolean checkControlNumber(String idCode) {
        int result = 0;
        List<Integer> a = new ArrayList<>();
        a.add(Integer.valueOf(idCode));
        for (int i = 0; i < idCode.length(); i++) {
            String n = String.valueOf(idCode.charAt(i));
            a.add(Integer.parseInt(n));


            List<Integer> x = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 1);
            result = result + (a.get(i) * x.get(i));

            int leftover = result % 11;


            List<Integer> k = List.of(3, 4, 5, 6, 7, 8, 9, 1, 2, 3);

            result = result + (a.get(i) * k.get(i));

        }
        int leftover = result % 11;
        if ( leftover == a.get(a.size()-1)){
            System.out.printf("Control number is correct", leftover,a.get(a.size()-1));
            return true;
        } else{
            System.out.printf("Control number is not correct", leftover,a.get(a.size()-1));
            return false;

        }

    }


    public static String getInformation(String idCode) {
        if (isCorrect(idCode)) {
            IDNumberData personalCode = IDNumberData.getInformationFromIdCode(idCode);
            int year = personalCode.yearNumber;
            int genderNum = personalCode.genderNumber;
            int month = personalCode.monthNumber;
            int day = personalCode.dayNumber;
            int fullYear = getFullYear(genderNum, year);
            String gender = String.valueOf(getGender(genderNum));
            return String.format("This is a %s born on %d %d %d", gender, day, month, fullYear);
        } else {
            return "ID is not correct";

        }
    }


    public static Gender getGender(int genderNumber) {
        if (genderNumber == 2 || genderNumber == 4 || genderNumber == 6) {
            System.out.println("Gender number is correct");
            return Gender.FEMALE;
        } else if (genderNumber == 1 || genderNumber == 3 || genderNumber == 5) {
            System.out.println("Gender number is correct");
            return Gender.MALE;
        } else
            throw new IllegalArgumentException("No such option");
    }


    public static int getFullYear(int genderNumber, int yearNumber) {
        if (isYearCorrect(yearNumber)
                && isGenderNumberCorrect(genderNumber)) {
            return switch (genderNumber) {
                case 1, 2 -> 1800 + yearNumber;
                case 3, 4 -> 1900 + yearNumber;
                case 5, 6 -> 2000 + yearNumber;
                default -> throw new RuntimeException("Unknown gender");
            };

        }

        return genderNumber;
    }

    public static boolean isYearCorrect(int yearNumber) {
        if (yearNumber >= 0 && yearNumber <= 99) {
            System.out.println(yearNumber);
            return true;
        } else {
            return false;
        }
    }
}