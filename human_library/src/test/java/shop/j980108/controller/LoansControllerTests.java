package shop.j980108.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.ui.ModelMap;
import org.springframework.web.context.WebApplicationContext;

import com.google.gson.Gson;

import lombok.Setter;
import lombok.extern.log4j.Log4j;
import shop.j980108.domain.LoansVo;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"file:src/main/webapp/WEB-INF/spring/root-context.xml",
	"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml",
	"file:src/main/webapp/WEB-INF/spring/security-context.xml"})
@Log4j
@WebAppConfiguration
public class LoansControllerTests {
	
	@Autowired @Setter
	private WebApplicationContext ctx;
	private MockMvc mvc;
	
	@Before
	public void setup() {
		mvc = MockMvcBuilders.webAppContextSetup(ctx).build();
	}

	/** 대출 예약 by Member <br>
	 * - 필수 파라메터 : 소장도서번호 bkno, 아이디 id <br>
	 * - 현재 대출/대출예약 중인 도서수의 합계가 5권을 초과할 수 없다. <br>
	 * - 대출가능 도서만 대출예약이 가능하다. <br>
	 * - 대출예약시 대출테이블에 튜플이 추가된다. <br>
	 * - 소장도서의 상태가 0(대출가능)에서 1(대출예약중)로 변경된다. <br>
	 * - 회원의 대출중도서수 합계가 1 증가한다.
	 */
	@Test
	public void testReserveLoans() throws Exception {
		LoansVo loansVo = new LoansVo();
		loansVo.setBkno(1L);
		loansVo.setId("dldlrwns");
		String jsonStr = new Gson().toJson(loansVo);
		log.info("jsonStr ::" + jsonStr);
		mvc.perform(post("/loans/reserveLoans")
				.contentType(MediaType.APPLICATION_JSON_VALUE)
				.content(jsonStr))
				.andExpect(status().is(200));
	}

	/** 대출 예약 취소 by Member <br>
	 * - 필수 파라메터 : 대출번호 lno, 도서번호 bkno, 아이디 id <br>
	 * - 사용자가 대출 예약 후 예약을 취소할 수 있다. <br>
	 * - 대출예약일과 대출만기일에만 해당 대출의 상태가 0(대출 예약 신청) 또는 4(예약확정)이 아니면
	 *   (예. 대출만기일이 지나 자동 취소 되거나 관리자가 도서상태(분실, 훼손 등)로 인해 먼저 취소한 경우) 취소할 수 없다. <br>
	 * - 대출 상태가 0(대출 예약 신청)에서 1(예약 사용자 취소)로 변경된다. <br>
	 * - 소장도서의 상태가 2(대출예약중)에서 0(대출가능)으로 변경된다. <br>
	 * - 회원의 대출중 도서수 합계가 1 감소한다.
	 */
	@Test
	public void testCancelLoansReservationByMember() throws Exception {
		LoansVo loansVo = new LoansVo();
		loansVo.setLno(473L);
		loansVo.setBkno(21L);
		loansVo.setId("dldlrwns");
		String jsonStr = new Gson().toJson(loansVo);
		log.info("jsonStr ::" + jsonStr);
		mvc.perform(post("/loans/cancelLoansReservationByMember")
				.contentType(MediaType.APPLICATION_JSON_VALUE)
				.content(jsonStr))
				.andExpect(status().is(200));
	}

	/** 대출 예약 취소 by Task <br>
	 * - 필수 파라메터 : 대출번호 lno, 소장도서번호 bkno, 아이디 id <br>
	 * - 사용자가 대출만기일까지 대출하지 않으면 만기일 도서관 영업 종료 시간에 자동으로 예약이 취소된다. <br>
	 * - 대출 상태가 0(대출 예약 신청) 또는 4(예약확정)에서 2(예약 자동 취소)로 변경된다. <br>
	 * - 소장도서의 상태가 2(대출예약중)에서 0(대출가능)으로 변경된다. <br>
	 * - 회원의 대출중 도서수 합계가 1 감소한다. <br>
	 */
	@Test
	public void testCancelLoansReservationByTask() throws Exception {
		LoansVo loansVo = new LoansVo();
		loansVo.setLno(261L);
		loansVo.setBkno(186L);
		loansVo.setId("아이디1");
		String jsonStr = new Gson().toJson(loansVo);
		log.info("jsonStr ::" + jsonStr);
		mvc.perform(post("/loans/cancelLoansReservationByTask")
				.contentType(MediaType.APPLICATION_JSON_VALUE)
				.content(jsonStr))
				.andExpect(status().is(200));
	}

	/** 대출 예약 취소 by Manager <br>
	 * - 필수 파라메터 : 대출번호 lno, 소장도서번호 bkno, 아이디 id <br>
	 * - 관리자가 도서 픽업 중 도서 상태(분실, 훼손 등)를 확인 후 대출 예약을 취소할 수 있다. <br>
	 * - 해당 대출의 상태가 0(대출 예약 신청)이 아니면(예. 회원이 먼저 예약을 취소한 경우) 취소할 수 없다. <br>
	 * - 대출 상태가 0(대출 예약 신청)에서 3(예약 관리자 취소)로 변경된다. <br>
	 * - 소장도서의 상태가 2(대출예약중)에서 3(대출불가)으로 변경된다. <br>
	 * - 회원의 대출중 도서수 합계가 1 감소한다.
	 */
	@Test
	public void testCancelLoansReservationByManager() throws Exception {
		LoansVo loansVo = new LoansVo();
		loansVo.setLno(444L);
		loansVo.setBkno(1L);
		loansVo.setId("dldlrwns");
		String jsonStr = new Gson().toJson(loansVo);
		log.info("jsonStr ::" + jsonStr);
		mvc.perform(post("/loans/cancelLoansReservationByManager")
				.contentType(MediaType.APPLICATION_JSON_VALUE)
				.content(jsonStr))
				.andExpect(status().is(200));
	}

	/** 대출 예약 확정 by Manager <br>
	 * - 필수 파라메터 : 대출번호 lno <br>
	 * - 관리자가 대출 예약 신청이 들어온 소장도서를 픽업하여 대출 예약을 확정한다. <br>
	 * - 해당 대출의 상태가 0(대출 예약 신청)이 아니면(예. 회원이 먼저 예약을 취소한 경우) 확정할 수 없다. <br>
	 * - 대출의 상태가 0(대출 예약 신청)에서 4(예약확정)로 변경된다. <br>
	 */
	@Test
	public void testAcceptLoans() throws Exception {
		LoansVo loansVo = new LoansVo();
		loansVo.setLno(463L);
		String jsonStr = new Gson().toJson(loansVo);
		log.info("jsonStr ::" + jsonStr);
		mvc.perform(post("/loans/acceptLoans")
				.contentType(MediaType.APPLICATION_JSON_VALUE)
				.content(jsonStr))
				.andExpect(status().is(200));
	}

	/** 대출 완료 by Manager <br>
	 * - 필수 파라메터 : 대출번호 lno, 소장도서번호 bkno <br>
	 * - 사용자가 대출만기일 이내에 도서관에서 대출을 완료한다. <br>
	 * - 대출의 상태가 4(예약확정)에서 5(대출)로 변경된다. <br>
	 * - 소장 도서의 상태가 1(대출예약중)에서 2(대출중)으로 변경된다.
	 */
	@Test
	public void testCompleteLoans() throws Exception {
		LoansVo loansVo = new LoansVo();
		loansVo.setLno(468L);
		loansVo.setBkno(16L);
		String jsonStr = new Gson().toJson(loansVo);
		log.info("jsonStr ::" + jsonStr);
		mvc.perform(post("/loans/completeLoans")
				.contentType(MediaType.APPLICATION_JSON_VALUE)
				.content(jsonStr))
				.andExpect(status().is(200));
	}

	/** 현장 대출 by Manager <br>
	 * - 필수 파라메터 : 소장도서번호 bkno, 아이디 id <br>
	 * - 사용자는 대출 예약 없이도 도서관에서 직접 대출을 할 수 있다. <br>
	 * - 대출테이블에 튜플이 추가된다. <br>
	 * - 소장도서의 상태가 0(대출가능)에서 2(대출중)로 변경된다. <br>
	 * - 회원의 대출중도서수 합계가 1 증가한다. <br>
	 */
	@Test
	public void testLoans() throws Exception {
		LoansVo loansVo = new LoansVo();
		loansVo.setBkno(5L);
		loansVo.setId("아이디1");
		String jsonStr = new Gson().toJson(loansVo);
		log.info("jsonStr ::" + jsonStr);
		mvc.perform(post("/loans/loans")
				.contentType(MediaType.APPLICATION_JSON_VALUE)
				.content(jsonStr))
				.andExpect(status().is(200));
	}

	/** 대출 연체 처리 by Task <br>
	 * - 필수 파라메터 : X <br>
	 * - 사용자가 반납예정일 이내에 반납처리 하지 않으면 일정 시간에 연체처리 된다. <br>
	 * - 매일 9시 전날 반납예정일이었던 대출 건 중 반납처리 되지 않은 건들의 상태를 5(대출)에서 6(연체)로 변경된다. <br>
	 * - 해당 회원에게 연체되었음을 안내하고 반납을 독촉하는 문자를 발송한다. <br>
	 */
	@Test
	public void testCheckLoansOverdue() throws Exception {
		mvc.perform(post("/loans/checkLoansOverdue"));
	}

	/** 도서 반납 by Manager <br>
	 * - 필수 파라메터 : 대출번호 lno, 소장도서번호 bkno, 아이디 id <br>
	 * - 사용자가 도서관에 도서를 반납하면 관리자가 반납처리를 한다. <br>
	 * - 대출 상태가 5(대출) 또는 6(연체)에서 7(반납)로 변경된다. <br>
	 * - 소장 도서의 상태가 0(대출가능)으로 변경된다. <br>
	 * - 회원의 대출중도서수 합계가 1 감소한다. <br>
	 */
	@Test
	public void testReturnLoans() throws Exception {
		LoansVo loansVo = new LoansVo();
		loansVo.setLno(466L);
		loansVo.setBkno(13L);
		loansVo.setId("dldlrwns");
		String jsonStr = new Gson().toJson(loansVo);
		log.info("jsonStr ::" + jsonStr);
		mvc.perform(post("/loans/returnLoans")
				.contentType(MediaType.APPLICATION_JSON_VALUE)
				.content(jsonStr))
				.andExpect(status().is(200));
	}

	/** 도서 영구미반납 by Manager <br>
	 * - 필수 파라메터 : 대출번호 lno, 소장도서번호 bkno, 아이디 id <br>
	 * - 사용자가 도서관에 도서를 반납할 수 없음을 알렸을 때 (분실, 훼손 등) 관리자가 관련 처리를 한다. <br>
	 * - 대출 상태가 5(대출) 또는 6(연체)에서 8(영구미반납)로 변경된다. <br>
	 * - 소장 도서의 상태가 3(대출불가(분실, 훼손 등)으로 변경된다. <br>
	 * - 회원의 대출중도서수 합계가 1 감소한다. <br>
	 */
	@Test
	public void testNotReturnLoans() throws Exception {
		LoansVo loansVo = new LoansVo();
		loansVo.setLno(468L);
		loansVo.setBkno(16L);
		loansVo.setId("dldlrwns");
		String jsonStr = new Gson().toJson(loansVo);
		log.info("jsonStr ::" + jsonStr);
		mvc.perform(post("/loans/notReturnLoans")
				.contentType(MediaType.APPLICATION_JSON_VALUE)
				.content(jsonStr))
				.andExpect(status().is(200));
	}

	/** 대출 예약 현황 리스트 by Member <br>
	 * - 필수 파라메터 : 아이디 id <br>
	 * - 사용자는 본인이 예약한 현황을 조회할 수 있다. <br>
	 * - 대출 상태가 0(예약신청)인 건과 4(예약확정)인 건을 함께 조회한다.
	 */
	@Test
	public void testListLoansReservationForMember() throws Exception {
		ModelMap map = mvc.perform(MockMvcRequestBuilders.get("/loans/listLoansReservationForMember")
				.param("id", "dldlrwns"))
			.andReturn()
			.getModelAndView()
			.getModelMap();
		List<?> list = (List<?>)map.get("list");
		list.forEach(log::info);
	}
	
	/** 대출 예약 신청 현황 리스트 by Manager <br>
	 * - 선택 파라메터 : 페이지번호 pageNum, 보여줄 대출갯수 amount <br>
	 * - 관리자는 사용자들이 대출 예약 신청한 현황을 조회할 수 있다. <br>
	 * - 대출 상태가 0(예약신청)인 건이 조회된다. <br>
	 * - 관리자는 해당 화면을 이용하여 확정(픽업) 및 대출취소(불가)를 처리한다.
	 */
	@Test
	public void testListLoansReservationRequest() throws Exception {
		ModelMap map = mvc.perform(MockMvcRequestBuilders.get("/loans/listLoansReservationRequest"))
			.andReturn()
			.getModelAndView()
			.getModelMap();
		List<?> list = (List<?>)map.get("list");
		list.forEach(log::info);
	}

	/** 대출 예약 확정 현황 리스트 by Manager <br>
	 * - 선택 파라메터 : 페이지번호 pageNum, 보여줄 대출갯수 amount <br>
	 * - 관리자는 대출 예약 신청 건 중 확정(픽업)한 현황을 조회할 수 있다. <br>
	 * - 대출 상태가 4(예약확정)인 건이 조회된다. <br>
	 * - 관리자는 해당 조회 화면을 이용하여 대출 처리를 한다.
	 */
	@Test
	public void testListLoansReservationAccept() throws Exception {
		ModelMap map = mvc.perform(MockMvcRequestBuilders.get("/loans/listLoansReservationAccept")
				.param("pageNum", "1")
				.param("amount", "10"))
			.andReturn()
			.getModelAndView()
			.getModelMap();
		List<?> list = (List<?>)map.get("list");
		list.forEach(log::info);
	}

	/** 대출중 리스트 by Member <br>
	 * - 필수 파라메터 : 아이디 id <br>
	 * - 사용자는 본인이 대출한 현황을 조회할 수 있다. <br>
	 * - 대출 상태가 5(대출)인 건과 6(연체)인 건을 함께 조회한다.
	 */
	@Test
	public void testListLoansForMember() throws Exception {
		ModelMap map = mvc.perform(MockMvcRequestBuilders.get("/loans/listLoansForMember")
				.param("id", "dldlrwns"))
			.andReturn()
			.getModelAndView()
			.getModelMap();
		List<?> list = (List<?>)map.get("list");
		list.forEach(log::info);
	}

	/** 대출중 리스트 by Manager <br>
	 * - 선택 파라메터 : 페이지번호 pageNum, 보여줄 대출갯수 amount <br>
	 * - 관리자는 사용자들이 대출한 현황을 조회할 수 있다. <br>
	 * - 대출 상태가 5(대출)인 건과 6(연체)인 건을 함께 조회한다.
	 */
	@Test
	public void testListLoansForManager() throws Exception {
		ModelMap map = mvc.perform(MockMvcRequestBuilders.get("/loans/listLoansForManager")
				.param("pageNum", "1")
				.param("amount", "10"))
			.andReturn()
			.getModelAndView()
			.getModelMap();
		List<?> list = (List<?>)map.get("list");
		list.forEach(log::info);
	}

	/** 최근 반납 완료 리스트 by Member <br>
	 * - 필수 파라메터 : 아이디 id <br>
	 * - 선택 파라메터 : 페이지번호 pageNum, 보여줄 대출갯수 amount <br>
	 * - 사용자가 무인 반납기를 이용하여 반납할 경우 반납처리가 잘 되었는지 확인하기 위한 조회이다. <br>
	 * - 최근 일주일 간의 반납 완료된 건을 조회할 수 있다.
	 */
	@Test
	public void testListReturnedLoansRecently() throws Exception {
		ModelMap map = mvc.perform(MockMvcRequestBuilders.get("/loans/listReturnedLoansRecently")
				.param("pageNum", "1")
				.param("amount", "10")
				.param("id", "dldlrwns"))
			.andReturn()
			.getModelAndView()
			.getModelMap();
		List<?> list = (List<?>)map.get("list");
		list.forEach(log::info);
	}

	/** 반납 완료 대출 리스트 by Member <br>
	 * - 필수 파라메터 : 아이디 id <br>
	 * - 선택 파라메터 : 페이지번호 pageNum, 보여줄 대출갯수 amount <br>
	 * - 사용자는 반납이 완료된 지난 대출 내역을 조회할 수 있다.
	 */
	@Test
	public void testListReturnedLoans() throws Exception {
		ModelMap map = mvc.perform(MockMvcRequestBuilders.get("/loans/listReturnedLoans")
				.param("pageNum", "1")
				.param("amount", "10")
				.param("id", "dldlrwns"))
			.andReturn()
			.getModelAndView()
			.getModelMap();
		List<?> list = (List<?>)map.get("list");
		list.forEach(log::info);
	}
	
}
