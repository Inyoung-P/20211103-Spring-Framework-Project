package shop.j980108.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import lombok.AllArgsConstructor;
import shop.j980108.domain.AttachVo;
import shop.j980108.domain.BoardVo;
import shop.j980108.domain.Criteria;
import shop.j980108.mapper.AttachMapper;
import shop.j980108.mapper.BoardMapper;


@Service //해당 클래스를 루트 컨테이너에 빈(Bean) 객체로 생성
@AllArgsConstructor //클래스에 존재하는 모든 필드에 대한 생성자를 자동으로 생성
public class BoardServiceImpl implements BoardService {
   private BoardMapper boardMapper; //BoardMapper객체 생성
   private AttachMapper attachMapper; //트랜잭션하기
   //게시글 작성
   //마지막 시퀀스기준 하나 증가시킨 시퀀스에 INSERT시킴
   //트랜잭션
   //1.게시물작성자체가 실패->첨부파일도 안됨
   //2.첨부파일작성에 실패->게시글 작성도 안됨
   @Override @Transactional
   public void register(BoardVo boardVo) {
      boardMapper.insertSelectKey(boardVo);//여기서 글번호받아서
      
      boardVo.getAttachs().forEach(attach->{
    	  attach.setBno(boardVo.getBno());
    	  //attachMapper에 attach를 insert할것이다
    	  attachMapper.insert(attach);
      });
      //attachMapper.insert(boardVo.getAttachs().get(0));
   }

   //게시글 상세보기
   @Override
   public BoardVo get(Long bno) {
      return boardMapper.read(bno);
   }

   //게시글 수정 후 첨부파일 삭제
   @Override @Transactional
   public boolean modify(BoardVo boardVo) {
	 //게시글수정
	 boolean result= boardMapper.update(boardVo) >0;
	 //첨부파일 다지우고
	 attachMapper.deleteAll(boardVo.getBno());
	 //첨부파일 다시 작성
	   if(result){
		   boardVo.getAttachs().forEach(vo->{
			   vo.setBno(boardVo.getBno());
			   attachMapper.insert(vo);
		   });
	   }
      return result;
   }
   
   //게시글 삭제시 첨부파일도삭제
   @Override @Transactional
   public boolean remove(Long bno) {
	  attachMapper.deleteAll(bno);
      return boardMapper.delete(bno) >0 ;
   }
   
   //게시글 목록
   @Override
   public List<BoardVo> getList(Criteria cri) {
      return boardMapper.getListWithPaging(cri);
   }
   
   //검색한 게시글 갯수 또는 게시글 개수
   @Override
   public int getTotal(Criteria cri){
    return boardMapper.getTotalCount(cri);
   }

	@Override
	public List<AttachVo> getAttachs(Long bno) {
		return attachMapper.findByBno(bno);
	}
   
}