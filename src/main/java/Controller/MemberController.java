package Controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import DTO.MemberDTO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

public class MemberController {
	@Autowired
	MemberDAO memberDAO;
	
//	RequestMapping = PostMapping/GetMapping両方に対応
//	url: localhostでhome()メソッド実行
	@RequestMapping("/")
	public String home() {		//スタートページ
//		list()メソッドにリダイレクト
		return "redirect:/showLogin";
	}
	
//	ログインページ表示
	@RequestMapping("/showLogin")
	public ModelAndView showLogin(ModelAndView mv) {
		mv.setViewName("login");
		
		System.out.println("遷移先:" + mv.getViewName());
		return mv;
	}
	
	
	
	
	
//	ログイン
	@RequestMapping("/login")
	public String login(HttpServletRequest request, 
			String email,String password, ModelAndView mv) {
		System.out.println("Controller,loginメソッド入場");
		System.out.println("emailとpass:" + email +"+"+ password);
		
			boolean existsError = dataValidation(email, password, request);
			
			if(existsError == true) {
				return "redirect:/showLogin";
			}
			
			MemberDTO memberDTO = memberDAO.findUser(email, password);
			
//		ログイン情報を保存する
			HttpSession session = request.getSession();
			session.setAttribute("memberDTO", memberDTO);
			
			
			return "redirect:/list";
	}
	
	
	
	public boolean dataValidation(String email, String password, 
			HttpServletRequest request) {
		boolean existsError = false;
		
//		エラーチェック
		String errMsgEmail = errMsgEmail(email);
		if(!errMsgEmail.isEmpty()) {
			request.setAttribute("errMsgEmail", errMsgEmail);
			existsError = true;
		}

		String errMsgPass = errMsgPass(password);
		if(!errMsgPass.isEmpty()) {
			request.setAttribute("errMsgPass", errMsgPass);
			existsError = true;
		}
		System.out.println("existsError: " + existsError);

		return existsError;
	}
	
	private String errMsgEmail(String email) {
		System.out.println("email: " + email);
		String errMsg = "";

		if (email == null || email.trim().length() == 0) {
			return errMsg ="メールアドレスを入力してください。";
		}

		if (email.length() > 30) {
			return errMsg ="メールアドレスは30文字以内のみ入力してください。";
		}

		if (email.matches("^[a-zA-Z0-9-_\\.]+@[a-zA-Z0-9-_\\.]+$") != true) {
			return errMsg ="メールアドレスは正しい形式で入力してください。";
		}
		return errMsg;
	}

	private String errMsgPass(String password) {
		System.out.println("password: " + password);
		String errMsg = "";

		if (password == null || password.trim().length() == 0) {
			return errMsg ="パスワードを入力してください。";
		}

		return errMsg;
	}
}
