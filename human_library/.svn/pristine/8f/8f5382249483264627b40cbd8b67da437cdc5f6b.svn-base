package shop.j980108.domain;

import org.springframework.web.util.UriComponentsBuilder;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data @AllArgsConstructor
public class Criteria {
	private int pageNum; //페이지 번호
	private int amount;  //보여줄 글갯수
	private String type; //검색할 타입 T-title C-content W-writer
	private String keyword; //검색할 단어
	private int category=1; 
	
	
	public Criteria(){
		this(1,10);
	}

	public Criteria(int pageNum, int amount) {
		super();
		this.pageNum = pageNum;
		this.amount = amount;
	}
	
	public String[] getTypeArr(){
		return type == null ? new String[]{} : type.split("");
	}
	public String getParams(){
		return UriComponentsBuilder.newInstance()
				.queryParam("pageNum", pageNum)
				.queryParam("amount", amount)
				.queryParam("type", type)
				.queryParam("keyword", keyword)
				.build().toString();
	}
}
