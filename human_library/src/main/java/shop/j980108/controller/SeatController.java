package shop.j980108.controller;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;
import shop.j980108.domain.NAvailableVo;
import shop.j980108.domain.ReservationVo;
import shop.j980108.domain.SeatVo;
import shop.j980108.service.NAvailableService;
import shop.j980108.service.ReservationService;
import shop.j980108.service.SeatService;

/**
 * @author 조윤정
 * @date 2021-10-27 ~
 * @name 자리 컨트롤러
 */

@Controller
@Log4j
@RequestMapping("seat/*")
@AllArgsConstructor
public class SeatController {
	private SeatService service;
	private NAvailableService nservice;
	
	 @GetMapping("list")
	   public void list(Integer loc,Model model){
		 model.addAttribute("loc",loc);
		 model.addAttribute("revTime",service.getCurrentTime());
	      log.info("seat.list");
	   }
	 
		@GetMapping("getSeats")
		public @ResponseBody List<SeatVo> getSeats(SeatVo vo) {
			return service.getList(vo);
		}
		
		@GetMapping("choose")
		public void choose(Model model){
			log.info("seat.choose");
		}
		
		@GetMapping("complete")
		public void complete(Model model){
			log.info("seat: complete");
		}
		
		@GetMapping("seatManage")
		public void manage(Model model){
			log.info("seat management");
			model.addAttribute("list",nservice.getList());
		}
		
		@PostMapping("seatManage")
		public String insert(NAvailableVo vo,RedirectAttributes rttr){
			log.info("navailable seat insert");
			int code=nservice.insert(vo);
			rttr.addFlashAttribute("code", code);
			return "redirect:/seat/seatManage";
		}
		
		@ResponseBody
		@DeleteMapping("update/{nANo}")
		public String update(@PathVariable long nANo){
			log.info("cancel"+nANo);
			nservice.delete(nANo);
			return "success";
		}

}
