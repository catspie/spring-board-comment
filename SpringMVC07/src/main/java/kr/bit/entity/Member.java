package kr.bit.entity;

import lombok.Data;

@Data
public class Member {
		private String memId; //멤버아이디
		private String memPwd; //멤버비밀번호
		private String memName; //멤버이름
		private String memPhone; //멤버전화번호
		private String memAddr; //멤버주소
		private int latitude; //멤버위도
		private int longitude; //멤버경도
		
}
