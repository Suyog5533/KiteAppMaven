package libraryfiles2;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class utility {
	FileInputStream MyFile;
	static Sheet MySheet;
	public static String getDataExcelSheet(int rowIndex, int columnIndex) throws EncryptedDocumentException, IOException
	{
		FileInputStream MyFile = new FileInputStream("C:\\Users\\suyog\\Desktop\\JDK SOFTWEAR LINK\\ExcelSheet\\Zerodha.xlsx");
		 MySheet = WorkbookFactory.create(MyFile).getSheet("Sheet1");
		String value = MySheet.getRow(rowIndex).getCell(columnIndex).getStringCellValue();
		return value;
	}
	public static void takeScreenShot(WebDriver driver,int TCID) throws IOException
	{
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File distination= new File("C:\\Users\\suyog\\Desktop\\JDK SOFTWEAR LINK\\ScreenShot\\"+TCID+"SS.png");
		FileHandler.copy(src, distination);
	}
}
