package dev.mvc.category;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

//CREATE TABLE CATEGORY(
//    CATEGORYNO                            NUMBER(10)         NOT NULL         PRIMARY KEY,
//    NAME                                  VARCHAR2(30)         NOT NULL,
//    NAMESUB                               VARCHAR2(30)         DEFAULT '-'         NOT NULL,
//    CNT                                   NUMBER(7)         DEFAULT 0         NOT NULL,
//    RDATE                                 DATE         NOT NULL,
//    SEQNO                                 NUMBER(5)         DEFAULT 0         NOT NULL,
//    VISIBLE                               CHAR(1)         DEFAULT 'N'         NOT NULL
//);

@Setter @Getter
public class CategoryVO {
  public Integer getCategoryno() {
		return categoryno;
	}

	public void setCategoryno(Integer categoryno) {
		this.categoryno = categoryno;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNamesub() {
		return namesub;
	}

	public void setNamesub(String namesub) {
		this.namesub = namesub;
	}

	public Integer getCnt() {
		return cnt;
	}

	public void setCnt(Integer cnt) {
		this.cnt = cnt;
	}

	public String getRdate() {
		return rdate;
	}

	public void setRdate(String rdate) {
		this.rdate = rdate;
	}

	public Integer getSeqno() {
		return seqno;
	}

	public void setSeqno(Integer seqno) {
		this.seqno = seqno;
	}

	public String getVisible() {
		return visible;
	}

	public void setVisible(String visible) {
		this.visible = visible;
	}

/** 오버렌딩 카테고리 번호 */
  private Integer categoryno=0;
  
  /** 중분류명 */
  @NotEmpty(message="중분류명은 필수 입력 항목입니다.")
  @Size(min=2, max=10, message="중분류명의 입력 글자 수는 최소 2자에서 10자 이어야합니다.")
  private String name;

  /** 소분류명 */
  @NotEmpty(message="소분류명은 필수 입력 항목입니다.")
  @Size(min=1, max=30, message="소분류명의 입력 글자 수는 최소 1자에서 30자(한글 10자) 이어야합니다.")
  private String namesub="";
  
  /** 관련 자료수 */
  @NotNull(message="관련자료수는 필수 입력 항목입니다.")
  @Min(value = 0)
  @Max(value = 1000000)
  private Integer cnt=0;
  
  /** 등록일 */
  private String rdate;
  
  /** 출력 순서 */
  @NotNull(message="출력 순서는 필수 입력 항목입니다.")
  @Min(value = 1)
  @Max(value = 1000000)
  private Integer seqno;

  /** 출력 모드 */
  @NotEmpty(message="출력 모드는 필수 입력 항목입니다.")
  @Pattern(regexp="^[YN]$", message="Y 또는 N만 입력 가능합니다.")
  private String visible = "N";
}

