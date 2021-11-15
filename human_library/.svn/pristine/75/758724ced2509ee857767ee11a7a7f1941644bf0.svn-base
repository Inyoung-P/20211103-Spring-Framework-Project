package shop.j980108.domain;


import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class PageDTO {
	private static int PAGE_AMOUNT = 10;

	private int total; //데이터베이스로 처리
	private Criteria cri; //파라미터로 처리

	private int startPage; //시작페이지
	private int endPage; //종료페이지
	private boolean prev; //이전
	private boolean next; //다음

	public PageDTO() {
	}

	public PageDTO(int total, Criteria cri) {
		this.total=total;
		this.cri=cri;
		
		//마지막페이지 구하기
		//((2-1)/10 +1)*10>> 2페이지일때 마지막11페이지
		endPage =((cri.getPageNum()-1)/PAGE_AMOUNT +1)*PAGE_AMOUNT;
		//시작페이지 구하기
		//11-10+1 >> 마지막이 11일떄 시작페이지는 2페이지
		startPage = endPage -PAGE_AMOUNT +1;
		
		//진짜 마지막페이지 구하기
		//(전체 게시글수 + 한페이지당글개수 -1) / 한페이지당 글개수
		//(17 + 10 -1)/10 =2.6
		int realEnd= (total +cri.getAmount() -1)/cri.getAmount();
		
		//System.out.println(realEnd);
		
		//마지막 페이지가 진짜 마지막페이지 보다 크면 진짜 마지막페이지 작으면 마지막페이지
		endPage= realEnd< endPage ? realEnd:endPage;
		
		//시작페이지가 1보다 크면 prev에 true로 활성화
		prev = startPage>1;
		//마지막페이지가 진짜 마지막페이지보다 작으면 next활성화
		next = endPage<realEnd;
		
		//endPage = (cri.getPageNum()+9)/cri.getAmount();
	}

	public static void main(String[] args) {
		System.out.println(new PageDTO(279, new Criteria(22, 10)));
	}

}
