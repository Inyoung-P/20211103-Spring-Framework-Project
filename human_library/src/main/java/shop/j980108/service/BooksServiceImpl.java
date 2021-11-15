package shop.j980108.service;


import java.util.List;

import org.springframework.stereotype.Service;


import lombok.AllArgsConstructor;
import shop.j980108.domain.BookVo;
import shop.j980108.domain.Criteria;
import shop.j980108.mapper.BooksMapper;


@Service
@AllArgsConstructor
public class BooksServiceImpl implements BooksService {
   private BooksMapper booksMapper; 

   @Override
   public void register(BookVo bookVo) {
	   booksMapper.insert(bookVo);
   }
   
   //리스트
   @Override
   public List<BookVo> getList(Criteria cri) {
      return booksMapper.getListWithPaging(cri);
   }
   
   //검색한 게시글 갯수 또는 게시글 개수
   @Override
   public int getTotal(Criteria cri){
    return booksMapper.getTotalCount(cri);
   }

   //게시글 상세보기
   @Override
   public BookVo get(String isbn) {
      return booksMapper.read(isbn);
   }
}