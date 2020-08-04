package cn.grand.demoboot.entity.supplier;

import java.util.Date;

public class PN {
    private String dnnum;

    private String pmn33;

    private String supid;

    private String name;

    private Date createTime;

    private String changeUser;

    private String changeTime;

    private String plant;

    private Long status;

    private String importtype;

    private String importnumber;

    public String getDnnum() {
        return dnnum;
    }

    public void setDnnum(String dnnum) {
        this.dnnum = dnnum == null ? null : dnnum.trim();
    }

    public String getPmn33() {
        return pmn33;
    }

    public void setPmn33(String pmn33) {
        this.pmn33 = pmn33 == null ? null : pmn33.trim();
    }

    public String getSupid() {
        return supid;
    }

    public void setSupid(String supid) {
        this.supid = supid == null ? null : supid.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getChangeUser() {
        return changeUser;
    }

    public void setChangeUser(String changeUser) {
        this.changeUser = changeUser == null ? null : changeUser.trim();
    }

    public String getChangeTime() {
        return changeTime;
    }

    public void setChangeTime(String changeTime) {
        this.changeTime = changeTime == null ? null : changeTime.trim();
    }

    public String getPlant() {
        return plant;
    }

    public void setPlant(String plant) {
        this.plant = plant == null ? null : plant.trim();
    }

    public Long getStatus() {
        return status;
    }

    public void setStatus(Long status) {
        this.status = status;
    }

    public String getImporttype() {
        return importtype;
    }

    public void setImporttype(String importtype) {
        this.importtype = importtype == null ? null : importtype.trim();
    }

    public String getImportnumber() {
        return importnumber;
    }

    public void setImportnumber(String importnumber) {
        this.importnumber = importnumber == null ? null : importnumber.trim();
    }
}