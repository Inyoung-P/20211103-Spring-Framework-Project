package shop.j980108.controller;

import java.security.Principal;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;
import shop.j980108.domain.Criteria;
import shop.j980108.service.BoardService;
import shop.j980108.service.LoansService;
import shop.j980108.service.PossessionService;
import shop.j980108.service.SeatService;

@Controller
@Log4j
@AllArgsConstructor 
public class HomeController {
	
	private LoansService loansService;
	private PossessionService possessionService;
	private BoardService boardService;
	private SeatService seatService;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Model model, Principal principal) {
		if(principal != null) {
			String id = principal.getName();
			/** 회원의 대출예약중 도서수 */
			model.addAttribute("countLoansReserVation", loansService.getLoansDualStatusCount(0, 4, id));
			/** 회원의 예약확정중 도서수 */
			model.addAttribute("countLoansAccept", loansService.getLoansStatusCount(4, id));
			/** 회원의 대출중 도서수 */
			model.addAttribute("countLoans", loansService.getLoansDualStatusCount(5, 6, id));
			/** 회원의 연체중 도서수 */
			model.addAttribute("countLoansOverdue", loansService.getLoansStatusCount(6, id));
			/** 회원의 최근 반납 도서수 */
			model.addAttribute("countReturnedLoansRecently", loansService.getReturnedLoansCountRecently(id));
		}
		/** index 최근 7일 대출 인기 소장 도서 6권 리스트 */
		model.addAttribute("listPopularityPossession", possessionService.listPopularityPossession());
		/** index 신착 도서(최근 등록된 소장도서) 6권 리스트 */
		model.addAttribute("listNewPossession", possessionService.listNewPossession());
		/** 휴먼마켓 최신글 5개 리스트 */
		model.addAttribute("listMarketBoard", boardService.getList(new Criteria(1, 5)));
		/** 열람실 현황 좌석수 받아오기 */
		int revTime=seatService.getCurrentTime();
		model.addAttribute("loc1", seatService.getSeatCntByLoc(1,revTime));
		model.addAttribute("loc2", seatService.getSeatCntByLoc(2,revTime));
		model.addAttribute("loc3", seatService.getSeatCntByLoc(3,revTime));
		model.addAttribute("loc4", seatService.getSeatCntByLoc(4,revTime));
		return "/common/index";
	}
	
}