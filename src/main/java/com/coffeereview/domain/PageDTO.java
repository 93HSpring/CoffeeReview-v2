package com.coffeereview.domain;

import lombok.Getter;
import lombok.ToString;

/**
* @packageName   : com.coffeereview.domain
* @fileName      : PageDTO.java
* @author        : SeongPyo Jo
* @date          : 2020.11.23
* @description   : 페이징 처리를 위한 여러 정보를 저장할 클래스
* ===========================================================
* DATE              AUTHOR             NOTE
* -----------------------------------------------------------
* 2020.11.23        SeongPyo Jo       최초 생성
*/

@Getter
@ToString
public class PageDTO {

	// 시작 페이지 번호
	private int startPage;
	// 마지막 페이지 번호
	private int endPage;
	private boolean prev, next;
	
	private int total;
	private Criteria cri;
	
	public PageDTO(Criteria cri, int total) {
		
		this.cri = cri;
		this.total = total;
		
		// 10페이지씩 보여준다면 마지막 페이지를 계산 가능
		// e.g. 11 ~ 20, 1 ~ 10
		this.endPage = (int) (Math.ceil(cri.getPageNum() / 10.0)) * 10;
		
		// 10페이지씩 보여줄 경우 마지막 페이지에서 -9를 하면 시작페이지가 된다.
		// e.g. 20 - 9 = 11, 10 - 9 = 1
		this.startPage = this.endPage - 9;
		
		// 실제 마지막 페이지는 데이터 수에 결정되므로 
		// 데이터 수가 적을 경우 실제 페이지는 적어지게 된다.
		// e.g. 18 페이지 일 경우 처음 10페이지 후 8페이지만 나오기 때문
		int realEnd = (int) (Math.ceil((total * 1.0) / cri.getAmount()));
		
		if (realEnd < this.endPage) {
			this.endPage = realEnd;
		}
		
		// 현재 페이지가 1 보다 크다면 이전 버튼을 활성화 가능
		this.prev = this.startPage > 1;
		
		// 마지막 페이지가 실제 마지막 페이지보다 작다면 다음 버튼을 활성화 가능
		this.next = this.endPage < realEnd;
		
	}
	
}
