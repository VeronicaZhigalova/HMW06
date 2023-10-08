
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.*;

public class IDCodeValidator {


    public static boolean isCorrect(String idCode) {
        System.out.println(idCode);
        IDNumberData personalCode = IDNumberData.getInformationFromIdCode(idCode);
        if (idCode.length() == 11 && isGenderNumberCorrect(personalCode.genderNumber) && isDayNumberCorrect(personalCode.dayNumber) && isMonthNumberCorrect(personalCode.monthNumber) && isBirthDateCorrect(personalCode.yearNumber, personalCode.monthNumber, personalCode.dayNumber) && checkControlNumber(idCode)) {
            System.out.println("ID is correct");
            return true;
        }
        if (idCode.length() != 11) {
            System.out.println("The length is not correct");

        }

        return false;
    }


    public static boolean isGenderNumberCorrect(int genderNumber) {
        if (genderNumber == 1 || genderNumber == 3 || genderNumber ==5){
            return true;
        }
        if (genderNumber == 2 || genderNumber == 4 || genderNumber ==6) {
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
        LocalDateTime birthday = LocalDateTime.of(1998, 01, 29, 0, 0);
        LocalDateTime now = LocalDateTime.now();
        long yearsOld = ChronoUnit.YEARS.between(birthday, now);
        System.out.println(yearsOld);

        if (monthNumber == 2 && isLeapYear(yearNumber) && yearsOld > 0) {
            System.out.println(yearsOld + 1);
            return true;
        }
        if ((!(yearsOld > 0))) {
            System.out.println("Error");
        }

        return false;
    }


    public static boolean isLeapYear(int yearNumber) {
        if ((yearNumber % 4 == 0 && yearNumber % 100 != 0) || (yearNumber % 400 == 0)) {
            return true;
        } else return false;
    }


    public static boolean checkControlNumber(String idCode) {
        int result = 0;
        List<Integer> a = new ArrayList<>();
        a.add(Integer.valueOf(idCode));
        for (int i = 0; i < idCode.length(); i++) {
            String n = String.valueOf(idCode.charAt(i));
            a.add(Integer.parseInt(n));
        }
        List<Integer> x = new ArrayList<>();
        x.add(1);
        x.add(2);
        x.add(3);
        x.add(4);
        x.add(5);
        x.add(6);
        x.add(7);
        x.add(8);
        x.add(9);
        x.add(1);
        for (int i = 0; i < a.size() - 1; i++) {
            result = result + (a.get(i) * x.get(i));
        }
        int leftover = result % 11;

        if (leftover < 10) {
            System.out.println(result);
        }
        if (leftover == 10) {
            System.out.println(result == 0);
        }
        if (leftover > 10) {
            System.out.println("Error");
        }
        return false;
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
            return String.format("This is a " + gender + "born on " + convertIntToString(day), convertIntToString(month), fullYear);
        } else {
            return "ID is not correct";

        }
    }




    public static Gender getGender(int genderNumber) {
        if (genderNumber == 2 || genderNumber == 4 || genderNumber ==6) {
            System.out.println("Gender number is correct");
            return Gender.FEMALE;
        }
        else if (genderNumber == 1 || genderNumber == 3 || genderNumber == 5) {
            System.out.println("Gender number is correct");
            return Gender.MALE;
        }else
            throw new IllegalArgumentException("No such option");
    }



    public static int getFullYear(int genderNumber, int year) {
        int years;
        GregorianCalendar gcalendar = new GregorianCalendar();
        System.out.println(years = gcalendar.get(Calendar.YEAR));
        System.out.println(years);

        return years;
    }

    public static String convertIntToString(int num) {
        String a = String.valueOf(num);
        if (a.length() == 1) {
            a = " " + a;
        }
        return a;
    }
}









