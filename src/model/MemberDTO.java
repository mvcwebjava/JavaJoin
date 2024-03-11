package model;

public class MemberDTO {
 
  private String id;
  private String name;
  private String email;
  private String phone;
  private String pwd;
  private String confirmPwd;
  
  
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
  public String getConfirmPwd() {
    return confirmPwd;
  }
  public void setConfirmPwd(String confirmPwd) {
    this.confirmPwd = confirmPwd;
  }


  //동일암호 입력확인
  public Boolean comparePwd() {
    return pwd.equals(confirmPwd);
  }

  
}
