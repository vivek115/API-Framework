package DataDriven;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.FileOutputStream;
import java.io.IOException;

// Structure to follow workbook>sheet>rows>cell
public class WriteExcel {
    public static void main(String[] args) throws IOException {
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("Emp Info");
        // we store data in object type and array create a homogenous data
        Object empdata[][] = {
                // first row is header part
                {"EmpID", "Name", "job"},
        };
        // using for loop
        int rows = empdata.length;
        int cols = empdata[0].length;
        for (int r = 0; r < rows; r++) //0 ROW
        {
            XSSFRow row = sheet.createRow(r);
            for (int c = 0; c < cols; c++) // O COLUMN
            {
                XSSFCell cell = row.createCell(c);
                Object value = empdata[r][c];
                if (value instanceof String)
                    cell.setCellValue((String) value);
                if (value instanceof Integer)
                    cell.setCellValue((Integer) value);
                if (value instanceof Boolean)
                    cell.setCellValue((Boolean) value);
            }
        }
        String filePath = ".\\Datafiles\\employee.xlsx";
        FileOutputStream outputStream = new FileOutputStream(filePath);
        workbook.write(outputStream);
        outputStream.close();
        System.out.println("Employee.xls file written successfully");
    }
}
