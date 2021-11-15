package shop.j980108.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import shop.j980108.domain.Criteria;
import shop.j980108.domain.LoansVo;
import shop.j980108.domain.SmsVo;

/**
 * @author 박인영
 * @date 2021-10-19 ~ 
 * @name 대출 Mapper
 */
public interface LoansMapper {
	
	/** 대출테이블에 대출예약 관련 정보(대출번호, 대출예약일, 대출만기일, 상태, 도서번호, 아이디) 입력 */
	void insertLoansReservation(LoansVo loans);
	
	/** 대출 관련 상태 변경 */
	void updateLoansStatus(LoansVo loans);
	
	/** 대출 예약 건 대출 완료 후 추가 정보(대출일, 반납예정일, 대출 상태) 입력 */
	void updateLoans(LoansVo loans);
	
	/** 대출 테이블에 대출 관련 정보(대출번호, 대출일, 반납예정일, 대출상태, 도서번호, 아이디) 입력 */
	void insertLoans(LoansVo loans);
	
	/** 대출중인 도서 중 반납예정일 지난 건 연체 처리 */
	void updateLoansOverdue();	
	
	/** 연체 처리된 건 리스트 (for 반납 독촉 문자 발송) */
	List<SmsVo> listUpdateLoansOverdue();
	
	/** 대출중인 도서 반납 정보(반납일, 대출상태) 입력 */
	void returnLoans(LoansVo loans);
	
	/** 대출 예약 현황 리스트 by Member */
	List<LoansVo> listLoansReservationForMember(String id);
	
	/** 대출 예약 현황 리스트 by manager */
	List<LoansVo> listLoansReservationForManager(@Param("cri") Criteria cri, @Param("status") int status);
	
	/** 대출중 리스트 by Member */
	List<LoansVo> listLoansForMember(String id);
	
	/** 대출중 리스트 by Manager */
	List<LoansVo> listLoansForManager(Criteria cri);	
	
	/** 최근 7일 이내 반납 도서 개수 by Member */
	int getReturnedLoansCountRecently(String id);
	
	/** 최근 7일 이내 반납 도서 리스트 by Member */
	List<LoansVo> listReturnedLoansRecently(@Param("cri") Criteria cri, @Param("id") String id);
	
	/** 반납 완료 대출 리스트 by Member */
	List<LoansVo> listReturnedLoans(@Param("cri") Criteria cri, @Param("id") String id);
	
	/** 대출 상태별 개수 조회 for Member */
	int getLoansStatusCount(@Param("status") int status, @Param("id") String id);
	
	/** 대출 상태별 개수 조회 for Manager */
	int getLoansStatusTotalCount(int status);
	
	/** 대출 이중 상태 개수 조회 for Member */
	int getLoansDualStatusCount(@Param("status1") int status1, @Param("status2") int status2, @Param("id") String id);
	
	/** 대출 이중 상태 개수 조회 for Manager */
	int getLoansDualStatusTotalCount(@Param("status1") int status1, @Param("status2") int status2);
	
	/** 대출번호로 대출 조회 */
	LoansVo findLoansByLno(Long lno);

}