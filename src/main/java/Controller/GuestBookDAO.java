package Controller;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import DTO.GuestBookDTO;
import DTO.MemoDTO;
@Repository
public class GuestBookDAO {
	@Autowired
	SqlSession sqlSession;
	
//	全件取得（検索と併用）
	public List<MemoDTO> list(){
//		selectList()メソッドの第一引数にはnamespace.idを、第二引数にはmapperに渡す変数を指定する
		System.out.println("dao.listメソッド入場");
		return sqlSession.selectList("guestbook.list");
	}
	
//	メモ詳細
	public GuestBookDTO detail(int idx) {
		System.out.println("dao.detailメソッド入場");
		return sqlSession.selectOne("guestbook.detail", idx);
	}
	
//	新規メモ登録
	public void insert(GuestBookDTO guestBookDTO) {
		System.out.println("dao.insertメソッド入場");
		sqlSession.insert("guestbook.insert", guestBookDTO);
	
	}
	
//	編集
	public void update(GuestBookDTO GuestBookDTO) {
		System.out.println("dao.updateメソッド入場");
		System.out.println(GuestBookDTO);
		sqlSession.update("guestbook.update", GuestBookDTO);
	}
	
//	削除
	public void delete(int idx) {
		System.out.println("dao.deleteメソッド入場");
		sqlSession.update("guestbook.delete", idx);
	}
}
