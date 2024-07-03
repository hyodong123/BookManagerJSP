package member;

import java.util.List;

public class MemberService {

	private MemberDAO memberDAO;

	public MemberService(MemberDAO memberDao) {
		this.memberDAO = memberDao;
	}

	public boolean regist(Member member) {
		int result = MemberDAO.insertMember(member);
		return (result == 1) ? true : false;
	}

	public Member read(int no) {
		Member member = memberDAO.selectMember(no);
		return member;
	}

	public List<Member> listAll() {
		///
		List<Member> memberList = memberDAO.selectMemberAll();
		return memberList;
	}

	public boolean edit(Member member, String oldPassword) {
		if (member == null)
			return false;
		if (oldPassword == null)
			return false;

		int result = 0;

		Member memInfo = memberDAO.selectMember(member.getNo());
		if (oldPassword.equals(memInfo.getPassword())) {
			result = memberDAO.updateMember(member);
		}
		return (result == 1) ? true : false;
	}

	public boolean remove(int no) {
		return true;

	}
}
