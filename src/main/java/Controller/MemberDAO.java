package Controller;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import DTO.MemberDTO;

@Repository
public class MemberDAO {
	@Autowired
	SqlSession sqlSession;
	
	public MemberDTO findUser(String email, String password) {
		System.out.println("findUserメソッド入場");
		MemberDTO memberDTO = new MemberDTO(email, password);
		return sqlSession.selectOne("member.login", memberDTO);
	}
}
