package cn.grand.demoboot.helper;

import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.xssf.usermodel.*;
import javax.servlet.http.HttpServletResponse;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Future;

public class ExcelHelper
{
    /**
     * Excel表格导出
     * @param response HttpServletResponse对象
     * @param list Excel表格的数据，封装为List<List<String>>,List<LinkedHashMap<String, Object>>
     * @param sheetName sheet的名字
     * @param fileName 导出Excel的文件名
     * @param columnWidth Excel表格的宽度，建议为15
     * @throws IOException 抛IO异常
     */
    public static void exportExcel(HttpServletResponse response,
                                   //List<List<String>> excelData,
                                   List<LinkedHashMap<String, Object>> list,
                                   String sheetName,
                                   String fileName,
                                   int columnWidth) throws IOException
    {
        //声明一个工作簿
        HSSFWorkbook workbook = new HSSFWorkbook();

        //生成一个表格，设置表格名称
        HSSFSheet sheet = workbook.createSheet(sheetName);

        //设置表格列宽度
        sheet.setDefaultColumnWidth(columnWidth);

        //写入List<List<String>>中的数据
        int rowIndex = 0,cellIndex=0;
        for(LinkedHashMap<String, Object> data : list){
            //创建一个row行，然后自增1
            HSSFRow row = sheet.createRow(rowIndex++);

            cellIndex=0;
            //循环行内 、取字段取值（bug，没值就会错行。通用的做不了 ？）
            for( Map.Entry<String, Object> entry :data.entrySet())
            {
                cellIndex++;
                //创建一个单元格
                HSSFCell cell = row.createCell(cellIndex);
                //创建一个内容对象
                HSSFRichTextString text = new HSSFRichTextString(entry.getValue().toString());
                //将内容对象的文字内容写入到单元格中
                cell.setCellValue(text);
            }

            //region
//            //遍历添加本行数据
//            for (int i = 0; i < data.size(); i++) {
//                //创建一个单元格
//                HSSFCell cell = row.createCell(i);
//
//                //创建一个内容对象
//                HSSFRichTextString text = new HSSFRichTextString(data.get(i));
//
//                //将内容对象的文字内容写入到单元格中
//                cell.setCellValue(text);
//            }
            //endregion
        }

        //准备将Excel的输出流通过response输出到页面下载
        //八进制输出流
        response.setContentType("application/octet-stream");
        //设置导出Excel的名称
        response.setHeader("Content-disposition", "attachment;filename=" + fileName);
        //刷新缓冲
        response.flushBuffer();
        //workbook将Excel写入到response的输出流中，供页面下载该Excel文件
        workbook.write(response.getOutputStream());
        //关闭workbook
        workbook.close();
    }

    public static void exportExcel2007(HttpServletResponse response,
                                   List<LinkedHashMap<String, Object>> list,
                                   String sheetName,
                                   String fileName,
                                   int columnWidth) throws IOException
    {
        // 声明一个工作薄
        XSSFWorkbook workbook =  new XSSFWorkbook();
        // 生成一个表格
        XSSFSheet sheet = workbook.createSheet(sheetName);
        //workbook.setSheetName(0,"学生信息");
        // 创建表格标题行 第一行
        //XSSFRow titleRow = sheet.createRow(0);

        //生成一个表格，设置表格名称
        //XSSFSheet sheet = workbook.createSheet(sheetName);

        //设置表格列宽度
        sheet.setDefaultColumnWidth(columnWidth);

        //写入List<List<String>>中的数据
        int rowIndex = 0,cellIndex=0;
        for(LinkedHashMap<String, Object> data : list){
            //创建一个row行，然后自增1
            XSSFRow row = sheet.createRow(rowIndex++);

            cellIndex=0;
            //循环行内 、取字段取值（bug，没值就会错行。通用的做不了 ？）
            for( Map.Entry<String, Object> entry :data.entrySet())
            {
                cellIndex++;
                //创建一个单元格
                XSSFCell cell = row.createCell(cellIndex);
                //创建一个内容对象
                XSSFRichTextString text = new XSSFRichTextString(entry.getValue().toString());
                //将内容对象的文字内容写入到单元格中
                cell.setCellValue(text);
            }
        }
//        //导出文件路径
//        String basePath = "D:/";
//        //文件名
//        String exportFileName = "数据_"+".xlsx";
//        String file = basePath + exportFileName;
//        //文件输出流
//        FileOutputStream outStream = new FileOutputStream(file);
//        workbook.write(outStream);
//        outStream.flush();
//        outStream.close();

//        准备将Excel的输出流通过response输出到页面下载
//        八进制输出流
        response.setContentType("application/octet-stream");
        //设置导出Excel的名称
        response.setHeader("Content-disposition", "attachment;filename=" + fileName);
        //刷新缓冲
        response.flushBuffer();
        //workbook将Excel写入到response的输出流中，供页面下载该Excel文件
        workbook.write(response.getOutputStream());
        //关闭workbook
        workbook.close();
    }

}
