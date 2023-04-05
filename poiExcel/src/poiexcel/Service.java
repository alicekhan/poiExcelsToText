package poiexcel;

import java.awt.Desktop;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

public class Service {
        public String excelFilePath = null;     
        public String excelFilePath1 = null; 

    public void setExcelFilePath(String excelFilePath) {
        this.excelFilePath = excelFilePath;
    }

    public void setExcelFilePath1(String excelFilePath1) {
        this.excelFilePath1 = excelFilePath1;
    }

    public String getExcelFilePath() {
        return excelFilePath;
    }

    public String getExcelFilePath1() {
        return excelFilePath1;
    }
 public void excelDataManipulation() throws FileNotFoundException, InvalidFormatException, IOException   {
        MainFrame object = new MainFrame();
//        String excelFilePath = "C:\\javacode\\excel - txt java\\Sheet1.xls";
//        String excelFilePath1 = "C:\\javacode\\excel - txt java\\Sheet2.xls";

        System.out.println(excelFilePath);
        System.out.println(excelFilePath1);
        FileInputStream inputStream = new FileInputStream(new File(excelFilePath));
        FileInputStream inputStream1 = new FileInputStream(new File(excelFilePath1));
        String textFilePath;    
        System.out.println(inputStream);
        System.out.println(inputStream1);
        HSSFWorkbook workbook = new HSSFWorkbook(inputStream);
        HSSFSheet worksheet = workbook.getSheetAt(0);
        HSSFWorkbook workbook1 = new HSSFWorkbook(inputStream1);
        HSSFSheet worksheet1 = workbook1.getSheetAt(0);            
        textFilePath = "SheetValue.txt";
        FileWriter writer = new FileWriter(textFilePath);

        List<String> names = new ArrayList<String>();
        List<Integer> numbers = new ArrayList<Integer>(); 
        List<Integer> numbersNext = new ArrayList<Integer>(); 
            int rows = worksheet.getLastRowNum();
            for(int rowCounter = 1; rowCounter<=rows ; rowCounter++) {
                int dataSum=0;
                 int cols = worksheet.getRow(rowCounter).getLastCellNum();                       
                           HSSFRow row = worksheet.getRow(rowCounter); 
                           HSSFRow firstRow = worksheet.getRow(0);                        

                for(int colCounter = 1; colCounter<cols ; colCounter++) {
                    HSSFCell cell =  row.getCell(colCounter);
                    HSSFCell firstCell = row.getCell(0);
                    dataSum += Double.valueOf(cell.toString()); 
                } 
                names.add(row.getCell(0).toString());
                System.out.println("names:"+names);

                numbers.add(dataSum);                           
                System.out.println(numbers);
            }
            
            int rowsNext = worksheet1.getLastRowNum();
            for(int rowCounter = 1; rowCounter<=rowsNext ; rowCounter++) {
                      int dataSum=0;
                       int colsNext = worksheet1.getRow(rowCounter).getLastCellNum();                       
            			 HSSFRow row = worksheet1.getRow(rowCounter); 
            			 HSSFRow firstRow = worksheet1.getRow(0);                        
                      
                for(int colCounter = 1; colCounter<colsNext ; colCounter++) {
                  HSSFCell cell =  row.getCell(colCounter);
                   HSSFCell firstCell = row.getCell(0);
                   dataSum += Double.valueOf(cell.toString());                       
                //                    writer.write(firstRow.toString());
                //                    writer.write("\t");
                } 
//                      names.add(row.getCell(0).toString());
//                      System.out.println("names:"+names);
                      
                numbersNext.add(dataSum);                           
                System.out.println(numbersNext);
            }
            
                int arrNameLen = names.size()-1;
                writer.write(names.toString());
                writer.write("\n");
                int arrData1 = numbers.size()-1;
                writer.write(numbers.toString());
                writer.write("\n");
                int arrData2 = numbersNext.size()-1;
                writer.write(numbersNext.toString());
                writer.write("\n");
                
//          loop throw each and every cell of excel and write in text file
//            for (Row row : worksheet) {
//                for (Cell cell : row) {
//                    writer.write(cell.toString());
//                    writer.write("\t");
//                }
//                writer.write("\n");
//            } for (Row row : worksheet1) {
//                for (Cell cell : row) {
//                    writer.write(cell.toString());
//                    writer.write("\t");
//                }
//                writer.write("\n");
//            }
           
               writer.close();
            
        System.out.println("Data exported successfully to " + textFilePath);
        Desktop dk = Desktop.getDesktop(); 
        dk.open(new File(textFilePath)); 
    }
 
}
