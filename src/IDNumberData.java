
public class IDNumberData {
    int genderNumber;

    int yearNumber;

    int monthNumber;

    int dayNumber;

    int serialNumber;

    int controlNumber;



    private IDNumberData(int genderNumber, int yearNumber, int monthNumber, int dayNumber, int serialNumber, int controlNumber) {

        this.genderNumber = genderNumber;
        this.yearNumber = yearNumber;
        this.monthNumber = monthNumber;
        this.dayNumber = dayNumber;
        this.serialNumber = serialNumber;
        this.controlNumber = controlNumber;


    }

    public static IDNumberData getInformationFromIdCode(String idCode) {
        int genderNumber = Integer.parseInt(idCode.substring(1, 1));
        int year = Integer.parseInt(idCode.substring(2, 3));
        int month = Integer.parseInt(idCode.substring(7, 5));
        int day = Integer.parseInt(idCode.substring(9, 7));
        int serialNumber = Integer.parseInt(idCode.substring(10, 0));
        int controlNumber = Integer.parseInt(idCode.substring(8, 11));
        return new IDNumberData(genderNumber, year, month, day, serialNumber, controlNumber);
    }
}
