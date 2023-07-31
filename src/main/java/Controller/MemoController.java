package Controller;



import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import DTO.MemoDTO;


@Controller
public class MemoController {
	@Autowired
	MemoDAO memoDAO;
	
	
//	メモ帳一覧
	@RequestMapping("/list")
	public ModelAndView list(ModelAndView mv) {
		System.out.println("Controller,listメソッド入場");
		System.out.println("a");
		mv.setViewName("memo");
		
//		DAOから取得した商品情報リストをModelAndViewに「list」という名前で格納
		mv.addObject("list", memoDAO.list());

		System.out.println("memo:" + mv);
		System.out.println("遷移先:" + mv.getViewName());
		return mv;
	}
//	memo作成のページを表示
	@RequestMapping("/memodetail")
	public String detail() {
		return "detail";
	}
	
//	メモ帳詳細
	@RequestMapping("/memodetail/{idx}")
	public ModelAndView detail(@PathVariable int idx, ModelAndView mv) {
		mv.setViewName("memodetail");
		
		mv.addObject("product", memoDAO.detail(idx));
		
		System.out.println("memo:" + mv);
		System.out.println("遷移先:" + mv.getViewName());
		return mv;
		
	}
	
//	memo更新
	@RequestMapping("/memoupdate/{idx}")
	public String update(@PathVariable int idx,MemoDTO memoDTO,
			@RequestParam String writer,@RequestParam String memo,@RequestParam String post_date) {
//		memo更新
		memoDTO.setIdx(idx);
		System.out.println(memoDTO);
		memoDAO.update(memoDTO);
		System.out.println(memoDTO);
		return "redirect:/list";
	}
	
//	memoをDBに登録
	@RequestMapping("/memoinsert")
	public String insert(MemoDTO memoDTO) {
//		DBにファイル名ごと登録
		memoDTO.setAttendee("a");
		memoDTO.setLocation("a");
		memoDTO.setConclusion("a");
		memoDTO.setPurpose("a");
		memoDAO.insert(memoDTO);
//		一覧へ遷移
		System.out.println(memoDTO);
		return "redirect:/list";
	}
	
	
//	memo削除
	@RequestMapping("/memodelete/{idx}")
	public String delete(@PathVariable int idx) {
//			idxをもとに削除
		memoDAO.delete(idx);
		return "redirect:/list";
	}
}
