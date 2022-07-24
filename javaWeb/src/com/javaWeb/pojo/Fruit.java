package com.javaWeb.pojo;

/**
 * @Author wzc
 * @Date 2022/6/5
 */
public class Fruit {

    private Long id;

    private String fname;

    private Integer price;

    private Integer fcount;

    private String remark;

    public Fruit() {
    }

    public Fruit(Long id, String fname, Integer price, Integer fcount, String remark) {
        this.id = id;
        this.fname = fname;
        this.price = price;
        this.fcount = fcount;
        this.remark = remark;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getFcount() {
        return fcount;
    }

    public void setFcount(Integer fcount) {
        this.fcount = fcount;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
