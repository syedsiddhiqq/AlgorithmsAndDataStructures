package LeetCode.implementation;

public class SpreadSheet {
    private int[][] data;

    public SpreadSheet(int rows) {
        this.data = new int[rows + 1][27];
    }

    public void setCell(String cell, int value) {
        int column = (cell.charAt(0) - 'A') + 1;
        int row = Integer.parseInt(cell.substring(1));
        // System.out.println("Cell :: " + cell + " column " + column + " row " + row);
        data[row][column] = value;
    }

    public void resetCell(String cell) {
        int column = (cell.charAt(0) - 'A') + 1;
        int row = Integer.parseInt(cell.substring(1));
        data[row][column] = 0;
    }

    public int getValue(String formula) {
        formula = formula.substring(1);
        String[] values = formula.split("\\+");
        String firstValue = values[0];
        String secondValue = values[1];
        int firstData = 0, secondData = 0;
        if(firstValue.charAt(0) >= 'A' && firstValue.charAt(0) <='Z'){
            int column = (firstValue.charAt(0) - 'A') + 1;
            int row = Integer.parseInt(firstValue.substring(1));
            firstData = data[row][column];
        }else{
            firstData = Integer.parseInt(firstValue);
        }

        if(secondValue.charAt(0) >= 'A' && secondValue.charAt(0) <='Z'){
            int column = (secondValue.charAt(0) - 'A') + 1;
            int row = Integer.parseInt(secondValue.substring(1));
            secondData = data[row][column];
        }else{
            secondData = Integer.parseInt(secondValue);
        }
        return firstData + secondData;
    }

    public static void main(String[] args) {
        SpreadSheet spreadsheet = new SpreadSheet(100); // Initializes a spreadsheet with 3 rows and 26 columns
        spreadsheet.getValue("=5+7"); // returns 12 (5+7)
        spreadsheet.setCell("A1", 9); // sets A1 to 10
        spreadsheet.setCell("Z100", 10); // sets A1 to 10
        spreadsheet.getValue("=A1+6"); // returns 16 (10+6)
        spreadsheet.setCell("B2", 15); // sets B2 to 15
        System.out.println(spreadsheet.getValue("=A1+Z100"));
        spreadsheet.resetCell("A1"); // resets A1 to 0
        spreadsheet.getValue("=A1+B2"); // returns 15 (0+15)
    }
}
