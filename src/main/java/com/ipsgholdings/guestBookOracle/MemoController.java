package com.ipsgholdings.guestBookOracle;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import DTO.MemoDTO;
import jakarta.servlet.http.HttpServletRequest;



public class MemoController {
	@Autowired
	MemoDAO memoDAO;
	
	
//	メモ帳一覧
	@RequestMapping("/list")
	public ModelAndView list(ModelAndView mv) {
		System.out.println("Controller,listメソッド入場");
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
		mv.setViewName("detail");
		
		mv.addObject("product", memoDAO.detail(idx));
		
		System.out.println("memo:" + mv);
		System.out.println("遷移先:" + mv.getViewName());
		return mv;
		
	}
	
//	memo更新
	@RequestMapping("/memoupdate")
	public String update(MemoDTO memoDTO,
				@PathVariable int idx,
				HttpServletRequest request) {
//		memo更新
		memoDAO.update(memoDTO);
		return "redirect:/memo";
	}
	
//	memoをDBに登録
	@RequestMapping("/memoinsert")
	public String insert(@RequestParam MultipartFile img, 
			HttpServletRequest request,
			MemoDTO memoDTO) {
//		DBにファイル名ごと登録
		memoDAO.insert(memoDTO);
//		一覧へ遷移
		return "redirect:/memo";
	}
	
	
//	memo削除
	@RequestMapping("/memodelete")
	public String delete(int idx, HttpServletRequest request) {
//			idxをもとに削除
		memoDAO.delete(idx);
		return "redirect:/memo";
	}
}
