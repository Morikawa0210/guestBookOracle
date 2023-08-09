package Controller;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import DTO.MemoDTO;

@Repository
public class MemoDAO {
	@Autowired
	SqlSession sqlSession;
	
//	全件取得（検索と併用）
	public List<MemoDTO> list(){
//		selectList()メソッドの第一引数にはnamespace.idを、第二引数にはmapperに渡す変数を指定する
		System.out.println("dao.listメソッド入場");
		return sqlSession.selectList("memo.list");
	}
	
//	メモ詳細
	public MemoDTO detail(int idx) {
		System.out.println("dao.detailメソッド入場");
		return sqlSession.selectOne("memo.detail", idx);
	}
	
//	新規メモ登録
	public void insert(MemoDTO memoDTO) {
		System.out.println("dao.insertメソッド入場");
		System.out.println(memoDTO);
		sqlSession.insert("memo.insert", memoDTO);
		sqlSession.commit();
		sqlSession.close();
	}
	
//	編集
	public void update(MemoDTO memoDTO) {
		System.out.println("dao.updateメソッド入場");
		sqlSession.update("memo.update", memoDTO);
	}
	
//	削除
	public void delete(int idx) {
		System.out.println("dao.deleteメソッド入場");
		sqlSession.update("memo.delete", idx);
	}
}
