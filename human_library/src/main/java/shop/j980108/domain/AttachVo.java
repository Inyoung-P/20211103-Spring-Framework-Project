package shop.j980108.domain;

import org.apache.ibatis.type.Alias;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @ToString(callSuper=true) @Alias("attach")
public class AttachVo extends AttachDto {
	private Long bno;
}
