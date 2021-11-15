package shop.j980108.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;
import shop.j980108.domain.BookVo;
import shop.j980108.domain.Criteria;
import shop.j980108.domain.PageDTO;
import shop.j980108.service.BooksService;
import shop.j980108.service.PossessionService;

@Controller
@Log4j
@RequestMapping("/book")
@AllArgsConstructor
public class BooksController {
	private BooksService service;
	private PossessionService possessionService;
	
	@GetMapping("createbook")
	public void createbook(){
		 
	}
	
	@PostMapping("register")
	@ResponseBody
	public String register(@RequestBody BookVo bookVo) {
		log.info(bookVo);
		service.register(bookVo);
		return "success";
	}
	
	@GetMapping("selectbooks")
    public void selectbooks(Model model, Criteria cri){
        log.info("books.list");
        model.addAttribute("list", service.getList(cri)); 
        model.addAttribute("page", new PageDTO(service.getTotal(cri),cri));
    }
	
	@GetMapping("detailbooks")
	public void get(@RequestParam("isbn") String isbn, Model model, @ModelAttribute("cri") Criteria cri){
		log.info("get");
		model.addAttribute("books",service.get(isbn));
		model.addAttribute("possession", possessionService.listPossessionInfo(isbn));
	}
}
