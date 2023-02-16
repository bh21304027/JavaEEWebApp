package dao.user;

import bean.UserBean;

public interface UserDao{
	public void addUser(UserBean u);
	public void updateUser(UserBean u);
	public void deleteUser(String userid);
	public String getUser(String userid, String userpass);
	public UserBean getUserInfo(String uid);
	public void updateUserpass(UserBean u);
}
