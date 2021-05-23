public class ExcelSheetColumnTitle {
    public String convertToTitle(int columnNumber) {
        StringBuilder str = new StringBuilder();

        while (columnNumber > 0) {
            columnNumber--;
            char rightMost = (char) (columnNumber % 26 + 'A');
            str.append(rightMost);
            columnNumber /= 26;
        }

        return str.reverse().toString();
    }
}