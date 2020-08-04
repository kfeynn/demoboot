package cn.grand.demoboot.helper;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.*;
import com.itextpdf.text.Image;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

public class PDFHelper
{

    public static void test(HttpServletResponse response) throws IOException, DocumentException, WriterException
    {
        // pdf模板
        String fileName = "D:/s2.pdf";
        PdfReader reader = new PdfReader(fileName);
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        /* 将要生成的目标PDF文件名称 */
        PdfStamper ps = new PdfStamper(reader, bos);
        PdfContentByte under = ps.getUnderContent(1);
        /* 使用中文字体 */
        //BaseFont bf = BaseFont.createFont("STSong-Light", "UniGB-UCS2-H", BaseFont.NOT_EMBEDDED);
        BaseFont bf = BaseFont.createFont("c:\\windows\\fonts\\SIMFANG.TTF", BaseFont.IDENTITY_H, BaseFont.NOT_EMBEDDED);
        ArrayList<BaseFont> fontList = new ArrayList<BaseFont>();
        fontList.add(bf);
        /* 取出报表模板中的所有字段 */
        AcroFields fields = ps.getAcroFields();
        fields.setSubstitutionFonts(fontList);
        fillData(ps,fields, data());
        /* 必须要调用这个，否则文档不会生成的 */
        ps.setFormFlattening(true);
        ps.close();
        //生成pdf路径
        OutputStream fos = new FileOutputStream("D:/result.pdf");
        fos.write(bos.toByteArray());
        fos.flush();
        fos.close();
        bos.close();





        //提供下载start
        download(response,"D:/result.pdf");

    }

    public static void download(HttpServletResponse response,String filePath)
    {
        //提供下载start
        File file = new File(filePath);
        BufferedInputStream bis = null;
        OutputStream os = null;
        response.reset();
        response.setCharacterEncoding("utf-8");



        response.setContentType("application/pdf"); // pdf格式
        response.setHeader("Content-Disposition", "attachment; filename=" + "ss1.pdf");



        try
        {
            bis = new BufferedInputStream(new FileInputStream(file));
            byte[] b = new byte[bis.available() + 1000];
            int i = 0;
            os = response.getOutputStream();   //直接下载导出
            while ((i = bis.read(b)) != -1)
            {
                os.write(b, 0, i);
            }
            os.flush();
            os.close();
        } catch (IOException e)
        {
            e.printStackTrace();
        } finally
        {
            if (os != null)
            {
                try
                {
                    os.close();
                } catch (IOException e)
                {
                    e.printStackTrace();
                }
            }
        }






    }

    /**
     *     * 填充模板
     *     *
     */
    public static void fillData(PdfStamper ps,AcroFields fields, Map<String, String> data)
            throws IOException, DocumentException, WriterException
    {
        for (String key : data.keySet())
        {
            String value = data.get(key);
            if(!"barcode".equals(key))
            {
                fields.setField(key, value); // 为字段赋值,注意字段名称是区分大小写的  
            }
            else
            {
                //1.生成二维码
                createTempQRImage("barcodevalue",86,"d:/barcode.png");

                //2.指定位置插入二维码


                //获取位置(左上右下)
                AcroFields.FieldPosition fieldPosition = fields.getFieldPositions("barcode").get(0);//获取二维码位置
                //绘制二维码
                float width = fieldPosition.position.getRight() - fieldPosition.position.getLeft();
                //生成二维码
                //createTempQRImage(pn.getDnnum(), (int)width, tempQRImagePath);
                PdfContentByte cb;

                 //绘制在第一页
                cb = ps.getOverContent(1);


                //读取二维码图片
                Image qrImage = Image.getInstance("d:/barcode.png");
                //取表单字段的位置
                float marginLeft = (fieldPosition.position.getRight() - fieldPosition.position.getLeft() - qrImage.getWidth()) / 2;
                //设置二维码图片显示位置
                qrImage.setAbsolutePosition(fieldPosition.position.getLeft() + marginLeft, fieldPosition.position.getBottom());
                //添加二维码
                cb.addImage(qrImage);
            }


        }
    }


    /**
     *     * 填充数据源
     *     * 其中data存放的key值与pdf模板中的文本域值相对应
     *     *
     */
    public static Map<String, String> data()
    {
        Map<String, String> data = new HashMap<String, String>();
        data.put("name", "李磊");
        data.put("address", "2018年1月12日-2018年5月12日");
        data.put("barcode", "2018年5月18日");
        return data;
    }


    //生成二维码

    /**
     *
     * @param qr 二维码内容
     * @param width 宽度
     * @param path 路径
     * @throws WriterException
     * @throws IOException
     */
    private static synchronized void createTempQRImage(String qr, int width, String path) throws WriterException, IOException {
        Hashtable hints= new Hashtable();
        hints.put(EncodeHintType.CHARACTER_SET, "utf-8");
        hints.put(EncodeHintType.MARGIN, 0);
        BitMatrix bitMatrix = new MultiFormatWriter().encode(qr, BarcodeFormat.QR_CODE, width, width, hints);
        BufferedImage image = new BufferedImage(width, width, BufferedImage.TYPE_INT_ARGB);
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < width; y++) {
                image.setRGB(x, y, bitMatrix.get(x, y) == true ?
                        Color.BLACK.getRGB():Color.WHITE.getRGB());
            }
        }
        ImageIO.write(image, "png", new File(path));
    }


}
