package shop.j980108.domain;

import org.apache.ibatis.type.Alias;

import lombok.Data;

/**
 * @author 양희찬
 * @date 2021-10-19
 * @name 회원
 */

@Data @Alias("student")
public class StudentVo {
	/**학번 <br>  */
	private Long studNo;
	/**이름*/
	private String name;
	/**학과*/
	private String dept;
}