package com.homework.methods;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.homework.log.LogUtil;  
  
public class WriteExcel {  
    private static final String EXCEL_XLS = "xls";  
    private static final String EXCEL_XLSX = "xlsx";
  
    @SuppressWarnings("rawtypes")
	public static void writeExcel(List<Map> dataList,String filepath){  
        OutputStream out = null;
        try {   
        	LogUtil.logInfo("开始获取制定文件");
            // 读取Excel文档  
            File finalXlsxFile = new File(filepath);  
            Workbook workBook = getWorkbok(finalXlsxFile);  
            // sheet 对应一个工作页  
            Sheet sheet = workBook.getSheetAt(0);  
            // 创建文件输出流，输出电子表格
            out =  new FileOutputStream(filepath);  
            workBook.write(out);  
            LogUtil.logInfo("文件获取完毕");
            LogUtil.logInfo("开始写入表头");
            Row title = sheet.createRow(0);
            Cell nametitle = title.createCell(0);
            nametitle.setCellValue("姓名");
            Cell agetitle = title.createCell(1);
            agetitle.setCellValue("年龄");
            Cell sextitle = title.createCell(2);
            sextitle.setCellValue("性别");
            LogUtil.logInfo("表头写入完毕");
            /** 
             * 往Excel中写新数据 
             */  
            LogUtil.logInfo("开始向表中写入数据");
            for (int j = 0; j < dataList.size(); j++) {  
                // 创建一行：从第二行开始，跳过属性列  
                Row row = sheet.createRow(j + 1);  
                // 得到要插入的每一条记录  
                Map dataMap = dataList.get(j);  
                String name = dataMap.get("姓名").toString(); 
                String age = dataMap.get("年龄").toString();  
                String sex = dataMap.get("性别").toString();  
                
                Cell first = row.createCell(0);  
                first.setCellValue(name);  
                
                Cell third = row.createCell(1);  
                third.setCellValue(age);
          
                Cell second = row.createCell(2);  
                second.setCellValue(sex);    
                }  
            LogUtil.logInfo("文件写入完毕");
            // 创建文件输出流，准备输出电子表格
            out =  new FileOutputStream(filepath);  
            workBook.write(out);  
        } catch (Exception e) {  
            e.printStackTrace();  
        } finally{  
            try {  
                if(out != null){  
                    out.flush();  
                    out.close();  
                }  
            } catch (IOException e) {  
                e.printStackTrace();  
            }  
        }  
        System.out.println("数据写入成功");  
    }  
  
    /** 
     * 判断Excel的版本,获取Workbook 
     * @param in 
     * @param filename 
     * @return 
     * @throws IOException 
     */  
    public static Workbook getWorkbok(File file) throws IOException{  
        Workbook wb = null;  
        FileInputStream in = new FileInputStream(file);  
        if(file.getName().endsWith(EXCEL_XLS)){  //Excel 2003  
            wb = new HSSFWorkbook(in);  
        }else if(file.getName().endsWith(EXCEL_XLSX)){  // Excel 2007/2010  
            wb = new XSSFWorkbook(in);  
        }  
        return wb;  
    }  
}  