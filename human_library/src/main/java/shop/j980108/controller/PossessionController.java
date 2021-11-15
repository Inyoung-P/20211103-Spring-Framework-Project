package shop.j980108.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;
import shop.j980108.domain.PossessionVo;
import shop.j980108.service.PossessionService;

/**
 * @author 박인영
 * @date 2021-10-29 ~ 2021-11-10
 * @name 대출 Controller
 */
@Controller
@Log4j
@RequestMapping("/possession")
@AllArgsConstructor
public class PossessionController {

	private PossessionService service;

	/** 소장 도서 정보(possession) 1건 조회 */
	@GetMapping("detail")
	@ResponseBody
	public ResponseEntity<PossessionVo> detail(Long bkno) {
		return new ResponseEntity<>(service.getPossession(bkno), HttpStatus.OK);
	}
	
}
