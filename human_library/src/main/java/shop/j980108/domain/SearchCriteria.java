package shop.j980108.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data @AllArgsConstructor
public class SearchCriteria extends Criteria {
	private String searchType; //검색타임
	private String keyword; //검색 키워드
}
