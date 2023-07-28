package Controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;


import DTO.GuestBookDTO;
import jakarta.servlet.http.HttpServletRequest;
@Controller
public class GuestBookController {
	@Autowired
	GuestBookDAO GuestBookDAO;
	
//	ゲストブック一覧
	@RequestMapping("/guestbook")
	public ModelAndView list(ModelAndView mv) {
		System.out.println("Controller,listメソッド入場");
		mv.setViewName("GuestBook");
		
//		DAOから取得した商品情報リストをModelAndViewに「list」という名前で格納
		mv.addObject("list", GuestBookDAO.list());

		System.out.println("GuestBook:" + mv);
		System.out.println("遷移先:" + mv.getViewName());
		return mv;
	}
	
//	ゲストブック作成のページを表示
	@RequestMapping("/guestbookcreate")
	public String insert() {
		return "insert";
	}
	
	
//	ゲストブックをDBに登録
	@RequestMapping("/GuestBookinsert")
	public String insert(@RequestParam MultipartFile img, 
			HttpServletRequest request,
			GuestBookDTO GuestBookDTO) {
//		DBに登録
		GuestBookDAO.insert(GuestBookDTO);
//		一覧へ遷移
		return "redirect:/guestbook";
	}

	
//	ゲストブック詳細
	@RequestMapping("/GuestBookdetail/{idx}")
	public ModelAndView detail(@PathVariable int idx, ModelAndView mv) {
		mv.setViewName("detail");
		
		mv.addObject("GuestBook", GuestBookDAO.detail(idx));
		
		System.out.println("GuestBook:" + mv);
		System.out.println("遷移先:" + mv.getViewName());
		return mv;
	}
	
	
//	ゲストブック更新
	@RequestMapping("/GuestBookupdate")
	public String update(GuestBookDTO GuestBookDTO,
				@PathVariable int idx,
				HttpServletRequest request) {
//		ゲストブック更新
		GuestBookDAO.update(GuestBookDTO);
		return "redirect:/GuestBook";
	}
	
//	ゲストブック削除
	@RequestMapping("/GuestBookdelete")
	public String delete(int idx, HttpServletRequest request) {
//			ゲストブック番号をもとに削除
		GuestBookDAO.delete(idx);
		return "redirect:/GuestBook";
	}
}
