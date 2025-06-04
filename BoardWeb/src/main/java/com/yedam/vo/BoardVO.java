package com.yedam.vo;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


/*
 * 필드, 생성자, 메소드(getter, setter) 
 * lombok 사용 - 설치해야하고 라이브러리도 가져와야 함.
 */

//@Getter
//@Setter


@NoArgsConstructor // 매개값을 가지지 않는 기본 생성자
@AllArgsConstructor // 전체 매개값을 가지는 생성자
@Data
public class BoardVO {
	private int boardNo;
	private String title;
	private String content;
	private String writer;
	private Date writeDate;
	private int readCnt;
	
	
}
