package cn.grand.demoboot.vo;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "apiconfig")
public class APIConfigBean
{
    //从配置文件加载
    /** 访问服务端地址 */
    private String server;
    /** pdf存储路径 */
    private String pdfDir;
    /** excel上传文件路径 */
    private String excelDir;
    /** 送货单经手人缓存文件路径 */
    //private String signatureFilePath;
    /** 送货单经手人缓存文件名 */
    private String signatureFileName;
    /** 送货单经手人缓存文件名 */
    private String downloadDir;

    public String getServer() {
        return server;
    }
    public void setServer(String server) {
        this.server = server;
    }

    public String getPdfDir() {
        return pdfDir;
    }

    public void setPdfDir(String pdfDir) {
        this.pdfDir = pdfDir;
    }

    public String getExcelDir() {
        return excelDir;
    }

    public void setExcelDir(String excelDir) {
        this.excelDir = excelDir;
    }

    public String getSignatureFileName() {
        return signatureFileName;
    }

    public void setSignatureFileName(String signatureFileName) {
        this.signatureFileName = signatureFileName;
    }

    public String getDownloadDir() {
        return downloadDir;
    }

    public void setDownloadDir(String downloadDir) {
        this.downloadDir = downloadDir;
    }
}
