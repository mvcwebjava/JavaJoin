package model;

import java.util.Date;

public class MemberVO {

  private String id;
  private String name;
  private String email;
  private String phone;
  private String pwd;
  private Date regDate;
  
  public MemberVO(String id, String name, String email, String phone, String pwd, Date regDate) {
    super();
    this.id = id;
    this.name = name;
    this.email = email;
    this.phone = phone;
    this.pwd = pwd;
    this.regDate = regDate;
  }

  
  public String getId() {
    return id;
  }
  public void setId(String id) {
    this.id = id;
  }
  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }
  public String getEmail() {
    return email;
  }
  public void setEmail(String email) {
    this.email = email;
  }
  public String getPhone() {
    return phone;
  }
  public void setPhone(String phone) {
    this.phone = phone;
  }
  public String getPwd() {
    return pwd;
  }
  public void setPwd(String pwd) {
    this.pwd = pwd;
  }
  public Date getRegDate() {
    return regDate;
  }
  public void setRegDate(Date regDate) {
    this.regDate = regDate;
  }
}
