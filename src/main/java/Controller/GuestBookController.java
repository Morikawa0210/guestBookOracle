package Controller;



import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;


import DTO.GuestBookDTO;
@Controller
public class GuestBookController {
	@Autowired
	GuestBookDAO GuestBookDAO;
	
//	ゲストブック一覧
	@RequestMapping("/guestbook")
	public ModelAndView list(ModelAndView mv) {
		System.out.println("Controller,listメソッド入場");
		mv.setViewName("guestbook");
		
//		DAOから取得した商品情報リストをModelAndViewに「list」という名前で格納
		mv.addObject("guestList", GuestBookDAO.list());
		System.out.println("GuestBook:" + mv);
		System.out.println(mv.getModel());
		System.out.println("遷移先:" + mv.getViewName());
		return mv;
	}
	
//	ゲストブック作成のページを表示
	@RequestMapping("/guestbookcreate")
	public String insert() {
		return "guestbookcreate";
	}
	
	
//	ゲストブックをDBに登録
	@RequestMapping("/GuestBookinsert")
	public String insert(@RequestParam String name,@RequestParam String email,
			@RequestParam String content,
			HttpServletRequest request,
			GuestBookDTO GuestBookDTO) {
		GuestBookDTO.setEmail(email);
		GuestBookDTO.setName(name);
		GuestBookDTO.setContent(content);
//		DBに登録
		GuestBookDAO.insert(GuestBookDTO);
		System.out.println("insertだよー");
		System.out.println(GuestBookDTO);
//		一覧へ遷移
		return "redirect:/guestbook";
	}

	
//	ゲストブック詳細
	@RequestMapping("/guestbookdetail/{idx}")
	public ModelAndView detail(@PathVariable int idx, ModelAndView mv) {
		System.out.println("detailだよー");
		mv.setViewName("guestbookdetail");
		
		mv.addObject("GuestBook", GuestBookDAO.detail(idx));
		
		System.out.println("GuestBook:" + mv);
		System.out.println("遷移先:" + mv.getViewName());
		return mv;
	}
	
	
//	ゲストブック更新
	@RequestMapping("/GuestBookupdate/{idx}")
	public String update(GuestBookDTO GuestBookDTO,
			@RequestParam String name,@RequestParam String email,
			@RequestParam String content,@RequestParam String post_date,
				@PathVariable int idx,
				HttpServletRequest request) {
		System.out.println("updateだよー");
		GuestBookDTO.setContent(content);
		GuestBookDTO.setEmail(email);
		GuestBookDTO.setName(name);
		GuestBookDTO.setPost_date(post_date);
//		ゲストブック更新
		GuestBookDAO.update(GuestBookDTO);
		return "redirect:/guestbook";
	}
	
//	ゲストブック削除
	@RequestMapping("/GuestBookdelete/{idx}")
	public String delete(@PathVariable int idx, HttpServletRequest request) {
//			ゲストブック番号をもとに削除
		GuestBookDAO.delete(idx);
		return "redirect:/GuestBook";
	}
}
