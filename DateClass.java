import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class DateClass {
    private Calendar calendar;

    // Constructor for MM/DD/YYYY format
    public DateClass(int month, int day, int year) {
        calendar = Calendar.getInstance();
        calendar.set(year, month - 1, day); // Month is 0-based in Calendar
    }

    // Constructor for "June 14, 1992" format
    public DateClass(String month, int day, int year) {
        calendar = Calendar.getInstance();
        calendar.set(year, getMonthIndex(month), day);
    }

    // Constructor for DDD YYYY format
    public DateClass(int dayOfYear, int year) {
        calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, year);
        calendar.set(Calendar.DAY_OF_YEAR, dayOfYear);
    }

    private int getMonthIndex(String month) {
        String[] months = new SimpleDateFormat("MMMM", Locale.ENGLISH).getDateFormatSymbols().getMonths();
        for (int i = 0; i < months.length; i++) {
            if (months[i].equalsIgnoreCase(month)) {
                return i;
            }
        }
        throw new IllegalArgumentException("Invalid month name");
    }

    // Output date in MM/DD/YYYY format
    public String format1() {
        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
        return sdf.format(calendar.getTime());
    }

    // Output date in "June 14, 1992" format
    public String format2() {
        SimpleDateFormat sdf = new SimpleDateFormat("MMMM d, yyyy", Locale.ENGLISH);
        return sdf.format(calendar.getTime());
    }

    // Output date in DDD YYYY format
    public String format3() {
        SimpleDateFormat sdf = new SimpleDateFormat("DDD yyyy");
        return sdf.format(calendar.getTime());
    }

    public static void main(String[] args) {
        // Example usage
        DateClass date1 = new DateClass(6, 14, 1992);
        DateClass date2 = new DateClass("June", 14, 1992);
        DateClass date3 = new DateClass(166, 1992);

        System.out.println("Format 1: " + date1.format1());
        System.out.println("Format 2: " + date2.format2());
        System.out.println("Format 3: " + date3.format3());
    }
}
