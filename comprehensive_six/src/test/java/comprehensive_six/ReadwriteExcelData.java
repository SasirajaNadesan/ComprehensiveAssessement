package comprehensive_six;

import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadwriteExcelData {
	
	public static void main(String[] args) {
		getRowCount();
		
	}

	public static void getRowCount() {
		try {
		String excelpath = "./Data/ReaDWriteData.xlsx";
		XSSFWorkbook workbook = new XSSFWorkbook(excelpath);
		
		XSSFSheet sheet = workbook.getSheet("Sheet1");
		int rowCount = sheet.getPhysicalNumberOfRows();
		System.out.println("no of rows"+rowCount);
		
		// Using the Iterator to read data
		java.util.Iterator<Row> iterator = sheet.iterator();
		while (iterator.hasNext()) {
			Row row = iterator.next();

			java.util.Iterator<Cell> cellIterator = row.cellIterator();

			while (cellIterator.hasNext()) {
				Cell cell = cellIterator.next();
				switch (cell.getCellType()) {
				case STRING:
					System.out.print(cell.getStringCellValue());
					break;
				case NUMERIC:
					System.out.print(cell.getNumericCellValue());
					break;
				case BOOLEAN:
					System.out.print(cell.getBooleanCellValue());
					break;
				default:
					break;
				}
				System.out.print(" | ");
			}
			System.out.println();
		}
		workbook.close();
		}
		catch(Exception e){
			System.out.println(e.getCause());
			System.out.println(e.getMessage());
		}
	}
	
	public static void getCellData() throws IOException {
		String excelpath = "./Data/ReaDWriteData.xlsx";
		XSSFWorkbook workbook = new XSSFWorkbook(excelpath);
		
		XSSFSheet sheet = workbook.getSheet("Sheet1");
		
		int rowCount = sheet.getPhysicalNumberOfRows();
		System.out.println("no of rows"+rowCount);
			
		
	}
}
