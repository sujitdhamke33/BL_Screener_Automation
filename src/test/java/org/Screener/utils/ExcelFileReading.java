package org.Screener.utils;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Method;

public class ExcelFileReading {

    public static FileInputStream fi;
    public static XSSFWorkbook wb;
    public static XSSFSheet ws;
    public static XSSFRow row;
    public static XSSFCell cell;
    public static String link ="C:\\Users\\sujit\\Automation_Final12\\src\\main\\java\\org\\Screener\\TestData\\Book1.xlsx";


    public static String[][] getData(String Sheets) throws IOException {
        int totalRows = getRowCount(Sheets);
        int totalCols = getColCount(Sheets,1);

        String loginDatas[][] = new String[totalRows][totalCols];
        for(int i=1;i<=totalRows;i++){
            for(int j=0;j<totalCols;j++){
                loginDatas[i-1][j]= getCellData(Sheets,i,j);
            }
        }
        return loginDatas;
    }
    public static int getRowCount(String sheetName) throws IOException {
        fi = new FileInputStream(link);
        wb = new XSSFWorkbook(fi);
        ws = wb.getSheet(sheetName);
        int rowCount = ws.getLastRowNum();
        wb.close();
        fi.close();
        return rowCount;
    }

    public static int getColCount(String sheetName, int rownum) throws IOException {
        fi = new FileInputStream(link);
        wb = new XSSFWorkbook(fi);
        ws = wb.getSheet(sheetName);
        row = ws.getRow(rownum);
        int cellCount = row.getLastCellNum();
        wb.close();
        fi.close();
        return cellCount;
    }

    public static String getCellData(String sheetName, int rownum, int colnum) throws IOException {
        fi = new FileInputStream(link );
        wb = new XSSFWorkbook(fi);
        ws = wb.getSheet(sheetName);
        row = ws.getRow(rownum);
        cell = row.getCell(colnum);

        String data;
        try{
            DataFormatter formatter = new DataFormatter();
            data = formatter.formatCellValue(cell);
        }
        catch (Exception e){
            data = " ";
        }
        wb.close();
        fi.close();
        return data;
    }

    @DataProvider(name="LoginData1")
    public static Object[][] logindata2() throws IOException {
        return getData("Sheet1");
    }



//    public static Object[][] readDataFile(String sheetName) throws IOException {
//
//        FileInputStream ip = new FileInputStream(link);
//        wb = new XSSFWorkbook(ip);
//        ws = wb.getSheet(sheetName);
//        int rows = ws.getLastRowNum();
//        int cols = ws.getRow(0).getLastCellNum();
//
//        Object[][] data = new Object[rows][cols];
//
//        for (int i = 0; i < rows; i++) {
//            XSSFRow row = ws.getRow(i + 1);
//
//            for (int j = 0; j < cols; j++) {
//                XSSFCell cell = row.getCell(j);
//
//                CellType cellType = cell.getCellType();
//
//                switch (cellType) {
//
//                    case STRING:
//                        data[i][j] = cell.getStringCellValue();
//                        break;
//                    case NUMERIC:
//                        data[i][j] = Integer.toString((int) cell.getNumericCellValue());
//                        break;
//                    case BOOLEAN:
//                        data[i][j] =cell.getBooleanCellValue();
//                }
//            }
//        }
//        return data;
//    }


}

