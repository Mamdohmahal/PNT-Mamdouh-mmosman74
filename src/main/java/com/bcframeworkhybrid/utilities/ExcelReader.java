package com.bcframeworkhybrid.utilities;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/*import org.apache.poi.sl.usermodel.Sheet;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import com.google.common.collect.Table.Cell;
*/

public class ExcelReader {
	private Workbook workbook;

	public ExcelReader(String filePath) {
		try (FileInputStream fis = new FileInputStream(filePath)) {
			workbook = new XSSFWorkbook(fis);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public String getCellData(String sheetName, int rowNum, int colNum) {
		   //org.apache.poi.ss.usermodel.Sheet sheet = workbook.getSheet(Sheet1);
			Sheet sheet = workbook.getSheet(sheetName);
			if (sheet == null) {
	            System.out.println("Sheet " + sheetName + " does not exist in the Excel file.");
	            return "";
	        }
	        Row row = sheet.getRow(rowNum);
	        Cell cell = (Cell) row.getCell(colNum);

	        if (cell == null) {
	            return "";
	        }

	        switch (cell.getCellType()) {
            case STRING:
                return cell.getStringCellValue();
            case NUMERIC:
                if (DateUtil.isCellDateFormatted(cell)) {
                    return cell.getDateCellValue().toString();
                } else {
                    return String.valueOf((int) cell.getNumericCellValue());
                }
            case BOOLEAN:
                return String.valueOf(cell.getBooleanCellValue());
            case FORMULA:
                return cell.getCellFormula();
            case BLANK:
                return "";
            default:
                return "Invalid cell type";
        }
    }

    public int getRowCount(String sheetName) {
        Sheet sheet = workbook.getSheet(sheetName);
        if (sheet == null) {
            System.out.println("Sheet " + sheetName + " does not exist in the Excel file.");
            return 0;
        }
        return sheet.getLastRowNum();
    }

}
