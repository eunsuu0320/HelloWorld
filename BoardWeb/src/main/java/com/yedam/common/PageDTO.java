package com.yedam.common;

import lombok.Data;

@Data
public class PageDTO {
	//게시글 건수 -> 페이지 계산.
	private int start, end, currentPage; // 페이지 블록의 시작, 끝, 현재 페이지
	private boolean prev, next; // 이전, 다음 페이지의 여부(boolean)
	
	public PageDTO(int page, int totalCnt) {
		this.currentPage = page;
		this.end = (int) Math.ceil(1.0 * page / 10) * 10; // 현재 페이지가 어느 10단위 블록에 속하는지 계산. 즉, 블록의 끝 페이지를 의미함.
		this.start = this.end - 9;
		
		int realEnd = (int) Math.ceil(1.0 * totalCnt / 5); // 건수를 기준으로 실제 마지막페이지
		this.end = this.end > realEnd ? realEnd : this.end; // 만약 계산된 블록 끝 페이지가 진짜 마지막 페이지보다 크면, 진짜 마지막 페이지로 교체함

		// 이전, 이후 페이지의 존재 체크.
		this.prev = this.start > 1;
		this.next = this.end < realEnd;
	}
}
