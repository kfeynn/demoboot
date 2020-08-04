package cn.grand.demoboot.entity.sqlserver;

public class XpGridFunctionsForPublic {
    private String funccode;

    private String funcname;

    private String funcurl;

    private String funcparent;

    private String funcimg;

    private Integer enable;

    private Integer displayorder;

    public String getFunccode() {
        return funccode;
    }

    public void setFunccode(String funccode) {
        this.funccode = funccode == null ? null : funccode.trim();
    }

    public String getFuncname() {
        return funcname;
    }

    public void setFuncname(String funcname) {
        this.funcname = funcname == null ? null : funcname.trim();
    }

    public String getFuncurl() {
        return funcurl;
    }

    public void setFuncurl(String funcurl) {
        this.funcurl = funcurl == null ? null : funcurl.trim();
    }

    public String getFuncparent() {
        return funcparent;
    }

    public void setFuncparent(String funcparent) {
        this.funcparent = funcparent == null ? null : funcparent.trim();
    }

    public String getFuncimg() {
        return funcimg;
    }

    public void setFuncimg(String funcimg) {
        this.funcimg = funcimg == null ? null : funcimg.trim();
    }

    public Integer getEnable() {
        return enable;
    }

    public void setEnable(Integer enable) {
        this.enable = enable;
    }

    public Integer getDisplayorder() {
        return displayorder;
    }

    public void setDisplayorder(Integer displayorder) {
        this.displayorder = displayorder;
    }
}