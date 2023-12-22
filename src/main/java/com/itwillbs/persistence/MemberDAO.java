package com.itwillbs.persistence;

import java.util.List;
import com.itwillbs.domain.MemberVO;

public interface MemberDAO {
	
	//추상메서드로 처리동작 구현선언
	
	// 디비의 시간정보 조회
	public String getTime();
	
	// 회원가입 처리동작
	public void insertMember(MemberVO vo);
	
	// 로그인 처리동작 - id, pw 필요
	public MemberVO loginMember(String userid, String userpw);
	public MemberVO loginMember(MemberVO vo); //정보를 모두 담고 있는 vo 객체 전달
	// 한방에 보내는게 좋음!
	// => 1. 데이터 주고받기 매우 편함 
	// => 2. 매개변수를 사용하게 되면, 메서드 변경시 메서드 형태 전체를 바꾸는 상황이 생길 수 있기에 대비
	
	// 회원정보 조회동작 
	public MemberVO getMember(String userid);
	
	// 회원정보 수정
	public void updateMember(MemberVO uvo);
	// 회원정보 삭제
	public int deleteMember(MemberVO dvo);
	
	//회원정보 리스트 조회
	public List<MemberVO> getMemberList();
}