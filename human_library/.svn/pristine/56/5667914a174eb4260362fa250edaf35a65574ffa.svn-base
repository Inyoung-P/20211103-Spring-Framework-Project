package shop.j980108.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author 김재은
 * @date 2021-10-18
 * @name 중고게시판 첨부파일
 */
@Data @NoArgsConstructor @AllArgsConstructor
public class AttachDto {
	/*사용자지정파일이름*/
	private String origin; 
	/*저장경로*/ 
	private String path; 
	/*실제파일이름*/ 
	private String uuid; 
	/*확장자*/ 
	private String ext; 
	/*마임?*/
	private String mime;
	/*파일크기*/
	private Long size; 
	/*이미지여부*/
	private boolean image;
	
	public AttachDto(String fullPath){
		ext=fullPath.substring(fullPath.lastIndexOf(".")+1);
		fullPath =fullPath.replace("."+ext, "");
		path = fullPath.substring(0,fullPath.lastIndexOf("/"));
		uuid = fullPath.substring(fullPath.lastIndexOf("/")+1);
		
	}
	
	public String getThumb(){
		return path + "/s_" + uuid + "." + ext;
	}
	public String getFullPath(){
		return path + "/" + uuid + "." + ext;
	}
}