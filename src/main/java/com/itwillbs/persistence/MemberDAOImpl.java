package com.itwillbs.persistence;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.itwillbs.domain.MemberVO;

//@Repository : 스프링이 해당파일이 MemberDAO 역할을 수행하는 객체로 인식되게 하는 코드
@Repository
public class MemberDAOImpl implements MemberDAO {

	private static final Logger logger = LoggerFactory.getLogger(MemberDAOImpl.class);
	//디비연결정보(자동연결, mapper접근...) 처리하는 객체가 필요하다
	// => root-cntext.xml에서 생성되어있는 객체(빈)를 주입받음
	
	@Inject
	private SqlSession sqlSession; //root-context에서 정보 받아옴

	//mapper 위치정보 저장
	private static final String NAMESPACE = "com.itwillbs.mapper.MemberMapper";
	
	//alt shift v - 오버라이딩해야 오류가 안뜸
	@Override
	public String getTime() {
		//디비연결
		//SQL 구문작성 -> mapper.xml 파일
		//SQL 실행
		//sqlSession.selectOne("SQL구문의 위치정보");
		String time = sqlSession.selectOne("com.itwillbs.mapper.MemberMapper.getTime"); //memberMapper.xml에서 들고옴
		System.out.println("SQL 실행완료!");
		System.out.println("time: "+time);
		
		return time;
	}
	@Override
	public void insertMember(MemberVO vo) {
		logger.debug("insertMember(MemberVO vo) 호출 - 시작");
		logger.debug("myBatis가 mapper에 접근");
		logger.debug("sql 구문 실행");
		logger.debug("sql 구문 실행결과 발생");
		sqlSession.insert(NAMESPACE + ".insertMember", vo);
		logger.debug("insertMember(MemberVO vo) 호출 - 끝");
	}
	
	@Override
	public MemberVO loginMember(MemberVO vo) {
	logger.debug("loginMember(MemberVO vo) 호출");
	logger.debug("DAO -> mapper 호출");
	
	MemberVO resultVO = sqlSession.selectOne(NAMESPACE+".loginMember", vo);
	logger.debug("resultVO: "+resultVO);
	
	if(resultVO != null) {
		logger.debug("◕ܫ◕로그인 성공");
	} else {
		logger.debug("༼ ༎ຶ ෴ ༎ຶ༽   로그인 실패");
	}
	
	return resultVO;
	}
	
	@Override
	public MemberVO loginMember(String userid, String boadrdpw) {
		logger.debug("loginMember(String userid, String userpw) 실행");
//		MemberVO vo = new MemberVO();
//		vo.setUserid(userid);
//		vo.setUserpw(userpw);
		
		// 전달된 정보가 하나의 객체(VO) 저장이 불가능한 경우 => JOIN
		// => 해결방법: 하나의 형태로 만들어서 mapper로 전달
		// Map<Key, Value> 컬렉션 사용
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("userid", userid);
		paramMap.put("userpw", boadrdpw);
		
		
		MemberVO resultVO = sqlSession.selectOne(NAMESPACE + ".loginMember", paramMap);
		// => mapper로 전달가능한 객체는 1개뿐
		return resultVO;
	}
	
	@Override
	public MemberVO getMember(String userid) {
		logger.debug("getMember(String userid) 호출");
		
//		MemberVO resultVO = sqlSession.selectOne(NAMESPACE+".getMember", userid);
//		logger.debug("resultVO: "+resultVO);
//		return resultVO;
		
		return sqlSession.selectOne(NAMESPACE+".getMember", userid);
	}
	
	@Override
	public void updateMember(MemberVO uvo) {
		logger.debug(" updateMember(MemberVO uvo) ");
		sqlSession.update(NAMESPACE+".updateMember", uvo);
	}


	@Override
	public int deleteMember(MemberVO dvo) {
		logger.debug(" deleteMember(MemberVO dvo) ");
		
		return sqlSession.delete(NAMESPACE+".deleteMember",dvo);
	}
	@Override
	public List<MemberVO> getMemberList() {
		logger.debug(" getMemberList() 호출 ");

		return sqlSession.selectList(NAMESPACE+".getList");
		
	}
	
	
	
	
} // MemberDAOImpl
