package shop.j980108.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.AllArgsConstructor;
import shop.j980108.domain.Criteria;
import shop.j980108.domain.LoansVo;
import shop.j980108.domain.MemberVo;
import shop.j980108.domain.PossessionVo;
import shop.j980108.domain.SmsVo;
import shop.j980108.mapper.LoansMapper;
import shop.j980108.mapper.MemberMapper;
import shop.j980108.mapper.PossessionMapper;

/**
 * @author 박인영
 * @date 2021-10-21 ~ 
 * @name 대출 Service
 */
@Service
@AllArgsConstructor
public class LoansServiceImpl implements LoansService {
	
	private LoansMapper loansMapper;
	private PossessionMapper possessionMapper;
	private MemberMapper memberMapper;
	
	/** 대출 예약 by Member <br>
	 * (1) 대출예약시 대출테이블에 튜플이 추가된다. <br>
	 * (2) 소장도서의 상태가 0(대출가능)에서 1(대출예약중)로 변경된다. <br>
	 * (3) 회원의 대출중도서수 합계가 1 증가한다.
	 */
	@Override @Transactional
	public void reserveLoans(LoansVo loans) {
		loansMapper.insertLoansReservation(loans);
		PossessionVo possession = new PossessionVo();
		possession.setBkno(loans.getBkno());
		possession.setStatus(1);
		possessionMapper.updatePossessionStatus(possession);
		MemberVo member = new MemberVo();
		member.setId(loans.getId());
		member.setLoansCnt(1L);
		memberMapper.updateMemberLoansCnt(member);
	}
	
	/** 대출 예약 취소 by Member <br>
	 * - 사용자가 대출 예약 후 예약을 취소할 수 있다. <br>
	 * (1) 대출 상태가 0(대출 예약 신청)에서 1(예약 사용자 취소)로 변경된다. <br>
	 * (2) 소장도서의 상태가 2(대출예약중)에서 0(대출가능)으로 변경된다. <br>
	 * (3) 회원의 대출중 도서수 합계가 1 감소한다.
	 */
	@Override @Transactional
	public void cancelLoansReservationByMember(LoansVo loans) {
		loans.setStatus(1);
		loansMapper.updateLoansStatus(loans);
		PossessionVo possession = new PossessionVo();
		possession.setBkno(loans.getBkno());
		possession.setStatus(0);
		possessionMapper.updatePossessionStatus(possession);
		MemberVo member = new MemberVo();
		member.setId(loans.getId());
		member.setLoansCnt(-1L);
		memberMapper.updateMemberLoansCnt(member);
	}
	
	/** 대출 예약 취소 by Task <br>
	 * - 사용자가 대출만기일까지 대출하지 않으면 만기일 도서관 영업 종료 시간에 자동으로 예약이 취소된다. <br>
	 * (1) 대출 상태가 0(대출 예약 신청)에서 2(예약 자동 취소)로 변경된다. <br>
	 * (2) 소장도서의 상태가 2(대출예약중)에서 0(대출가능)으로 변경된다. <br>
	 * (3) 회원의 대출중 도서수 합계가 1 감소한다.
	 */
	@Override @Transactional
	public void cancelLoansReservationByTask(LoansVo loans) {
		loans.setStatus(2);
		loansMapper.updateLoansStatus(loans);
		PossessionVo possession = new PossessionVo();
		possession.setBkno(loans.getBkno());
		possession.setStatus(0);
		possessionMapper.updatePossessionStatus(possession);
		MemberVo member = new MemberVo();
		member.setId(loans.getId());
		member.setLoansCnt(-1L);
		memberMapper.updateMemberLoansCnt(member);
	}
	
	/** 대출 예약 취소 by Manager <br>
	 * - 관리자가 도서 픽업 중 도서 상태(분실, 훼손 등)를 확인 후 대출 예약을 취소할 수 있다. <br>
	 * (1) 대출 상태가 0(대출 예약 신청)에서 3(예약 관리자 취소)로 변경된다. <br>
	 * (2) 소장도서의 상태가 2(대출예약중)에서 3(대출불가)으로 변경된다. <br>
	 * (3) 회원의 대출중 도서수 합계가 1 감소한다.
	 */
	@Override @Transactional
	public void cancelLoansReservationByManager(LoansVo loans) {
		loans.setStatus(3);
		loansMapper.updateLoansStatus(loans);
		PossessionVo possession = new PossessionVo();
		possession.setBkno(loans.getBkno());
		possession.setStatus(3);
		possessionMapper.updatePossessionStatus(possession);
		MemberVo member = new MemberVo();
		member.setId(loans.getId());
		member.setLoansCnt(-1L);
		memberMapper.updateMemberLoansCnt(member);
	}
	
	/** 대출 예약 확정 by manager <br> 
	 * - 관리자가 대출 예약 신청이 들어온 소장도서를 픽업하여 대출 예약을 확정한다. <br>
	 * (1) 대출의 상태가 0(대출 예약 신청)에서 4(예약확정)로 변경된다.
	 */
	@Override
	public void acceptLoans(LoansVo loans) {
		loans.setStatus(4);
		loansMapper.updateLoansStatus(loans);
	}
	
	/** 대출 완료 by manager <br> 
	 * - 사용자가 대출만기일 이내에 도서관에서 대출을 완료한다. <br>
	 * (1) 대출의 상태가 4(예약확정)에서 5(대출)로 변경된다. <br>
	 * (2) 소장 도서의 상태가 1(대출예약중)에서 2(대출중)으로 변경된다.
	 */
	@Override @Transactional
	public void completeLoans(LoansVo loans) {
		loansMapper.updateLoans(loans);
		PossessionVo possession = new PossessionVo();
		possession.setBkno(loans.getBkno());
		possession.setStatus(2);
		possessionMapper.updatePossessionStatus(possession);
	}
	
	/** 현장 대출 by Manager <br>
	 * - 사용자는 대출 예약 없이도 도서관에서 직접 대출을 할 수 있다. <br>
	 * (1) 대출테이블에 튜플이 추가된다. <br>
	 * (2) 소장도서의 상태가 0(대출가능)에서 2(대출중)로 변경된다. <br>
	 * (3) 회원의 대출중도서수 합계가 1 증가한다.
	 * */
	@Override @Transactional
	public void loans(LoansVo loans) {
		loansMapper.insertLoans(loans);
		PossessionVo possession = new PossessionVo();
		possession.setBkno(loans.getBkno());
		possession.setStatus(2);
		possessionMapper.updatePossessionStatus(possession);
		MemberVo member = new MemberVo();
		member.setId(loans.getId());
		member.setLoansCnt(1L);
		memberMapper.updateMemberLoansCnt(member);		
	}
	
	/** 대출 연체 처리 by Task <br>
	 * - 사용자가 반납예정일 이내에 반납처리 하지 않으면 일정 시간에 연체처리 된다. <br>
	 * (1) 매일 9시 전날 반납예정일이었던 대출 건 중 반납처리 되지 않은 건들의 상태를 5(대출)에서 6(연체)로 변경된다. <br>
	 * (2) 해당 회원에게 연체되었음을 안내하고 반납을 독촉하는 문자를 발송한다.
	 * */
	@Override @Transactional
	public List<SmsVo> checkLoansOverdue() {
		loansMapper.updateLoansOverdue();
		return loansMapper.listUpdateLoansOverdue();
	}
	
	/** 도서 반납 by Manager <br>
	 * - 사용자가 도서관에 도서를 반납하면 관리자가 반납처리를 한다. <br>
	 * (1) 대출 상태가 5(대출) 또는 6(연체)에서 7(반납)로 변경된다. <br>
	 * (2) 소장 도서의 상태가 0(대출가능)으로 변경된다. <br>
	 * (3) 회원의 대출중도서수 합계가 1 감소한다. <br>
	 * X (4) 연체되었다면 연체일수만큼 패널티가 부과된다.
	 */
	@Override @Transactional
	public void returnLoans(LoansVo loans) {
		loans.setStatus(7);
		loansMapper.returnLoans(loans);
		PossessionVo possession = new PossessionVo();
		possession.setBkno(loans.getBkno());
		possession.setStatus(0);
		possessionMapper.updatePossessionStatus(possession);
		MemberVo member = new MemberVo();
		member.setId(loans.getId());
		member.setLoansCnt(-1L);
		memberMapper.updateMemberLoansCnt(member);
	}
	
	/** 도서 영구미반납 by Manager <br>
	 * - 사용자가 도서관에 도서를 반납할 수 없음을 알렸을 때 (분실, 훼손 등) 관리자가 관련 처리를 한다. <br>
	 * (1) 대출 상태가 5(대출) 또는 6(연체)에서 8(영구미반납)로 변경된다. <br>
	 * (2) 소장 도서의 상태가 3(대출불가(분실, 훼손 등)으로 변경된다. <br>
	 * (3) 회원의 대출중도서수 합계가 1 감소한다. <br>
	 * X (4) 연체되었다면 연체일수만큼 패널티가 부과된다.
	 */
	@Override @Transactional
	public void notReturnLoans(LoansVo loans) {
		loans.setStatus(8);
		loansMapper.returnLoans(loans);
		PossessionVo possession = new PossessionVo();
		possession.setBkno(loans.getBkno());
		possession.setStatus(3);
		possessionMapper.updatePossessionStatus(possession);
		MemberVo member = new MemberVo();
		member.setId(loans.getId());
		member.setLoansCnt(-1L);
		memberMapper.updateMemberLoansCnt(member);
	}
	
	/** 대출 예약 현황 리스트 by Member <br>
	 * - 사용자는 본인이 예약한 현황을 조회할 수 있다. <br>
	 * - 대출 상태가 0(예약신청)인 건과 4(예약확정)인 건을 함께 조회한다.
	 * */
	@Override
	public List<LoansVo> listLoansReservationForMember(String id) {
		return loansMapper.listLoansReservationForMember(id);
	}
	
	/** 대출 예약 현황 리스트 by Manager <br>
	 * - 관리자는 사용자들이 대출 예약 신청한 현황을 조회할 수 있다. <br>
	 * - status 값이 0인 경우 대출 예약 신청 현황이 조회된다. <br>
	 * - status 값이 4인 경우 대출 예약 확정(대출을 위한 픽업 완료상태) 현황이 조회된다.
	 */
	@Override
	public List<LoansVo> listLoansReservationForManager(Criteria cri, int status) {
		return loansMapper.listLoansReservationForManager(cri, status);
	}
	
	/** 대출중 리스트 by Member <br>
	 * - 사용자는 본인이 대출한 현황을 조회할 수 있다. <br>
	 * - 대출 상태가 5(대출)인 건과 6(연체)인 건을 함께 조회한다.
	 */
	@Override
	public List<LoansVo> listLoansForMember(String id) {
		return loansMapper.listLoansForMember(id);
	}
	
	/** 대출중 리스트 by Manager <br>
	 * - 관리자는 사용자들이 대출한 현황을 조회할 수 있다. <br>
	 * - 대출 상태가 5(대출)인 건과 6(연체)인 건을 함께 조회한다.
	 */
	@Override
	public List<LoansVo> listLoansForManager(Criteria cri) {
		return loansMapper.listLoansForManager(cri);
	}
	
	/** 최근 7일 이내 반납 도서 개수 by Member */
	@Override
	public int getReturnedLoansCountRecently(String id) {
		return loansMapper.getReturnedLoansCountRecently(id);
	}
	
	/** 최근 7일 이내 반납 도서 리스트 by Member <br>
	 * - 사용자가 무인 반납기를 이용하여 반납할 경우 반납처리가 잘 되었는지 확인하기 위한 조회이다. <br>
	 * - 최근 일주일 간의 반납 완료된 건을 조회할 수 있다.
	 */
	@Override
	public List<LoansVo> listReturnedLoansRecently(Criteria cri, String id) {
		return loansMapper.listReturnedLoansRecently(cri, id);
	}
	
	/** 반납 완료 대출 리스트 by Member <br>
	 * - 사용자는 반납이 완료된 지난 대출 내역을 조회할 수 있다.
	 */
	@Override
	public List<LoansVo> listReturnedLoans(Criteria cri, String id) {
		return loansMapper.listReturnedLoans(cri, id);
	}
	
	/** 대출 상태별 개수 조회 for Member */
	@Override
	public int getLoansStatusCount(int Status, String id) {
		return loansMapper.getLoansStatusCount(Status, id);
	}
	
	/** 대출 상태별 개수 조회 for Manager */
	@Override
	public int getLoansStatusTotalCount(int Status) {
		return loansMapper.getLoansStatusTotalCount(Status);
	}

	/** 대출 이중 상태 개수 조회 for Member */
	@Override
	public int getLoansDualStatusCount(int status1, int status2, String id) {
		return loansMapper.getLoansDualStatusCount(status1, status2, id);
	}

	/** 대출 이중 상태 개수 조회 for Manager */
	@Override
	public int getLoansDualStatusTotalCount(int status1, int status2) {
		return loansMapper.getLoansDualStatusTotalCount(status1, status2);
	}
	
	/** 대출번호로 대출 조회 */
	@Override
	public LoansVo findLoansByLno(Long lno) {
		return loansMapper.findLoansByLno(lno);
	}

}
