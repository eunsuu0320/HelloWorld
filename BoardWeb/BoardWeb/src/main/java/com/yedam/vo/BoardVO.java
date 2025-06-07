package com.yedam.vo;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//@Getter
//@Setter
@NoArgsConstructor // 기본 생성자
@AllArgsConstructor // 모든 매개변수가 있는 생성자
@Data // 다양한 기능을 함축
public class BoardVO {
	private int boardNo;
	private String title;
	private String content;
	private String writer;
	private Date writeDate;
	private int readCnt;
}
