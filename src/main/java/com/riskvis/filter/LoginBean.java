package com.riskvis.filter;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

import com.riskvis.db.service.IAdminsService;
import com.riskvis.entity.Admins;
import com.riskvis.util.PasswordHash;

@ManagedBean
@SessionScoped
public class LoginBean {

	private String email;

	private String password;

	private Admins current;

	@ManagedProperty(value = "#{AdminsService}")
	IAdminsService adminService;

	/**
	 * Realiza login
	 * 
	 * @return outcome
	 */
	public String login() {
		current = matchLogin(email, password);

		HttpServletRequest request = (HttpServletRequest) FacesContext
				.getCurrentInstance().getExternalContext().getRequest();
		String ipAddress = request.getHeader("X-FORWARDED-FOR");
		if (ipAddress == null) {
			ipAddress = request.getRemoteAddr();
		}

		if (current == null) {
			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR,
							"Incorrect Password!", "Try Again"));
			password = null;
			System.out.println("Unsuccessful login for user " + email
					+ " from IP address " + ipAddress);
			return (email = password = null);
		}
		System.out.println("Successful login for user " + email
				+ " from IP address " + ipAddress);
		return "/admin/index.jsf?faces-redirect=true";
	}

	private Admins matchLogin(String email, String password) {

		int count = adminService.getCount();
		if (count < 1) {

			Admins firstUser;
			try {
				firstUser = new Admins(email, email.toLowerCase(),
						PasswordHash.createHash(password));
				adminService.addAdmins(firstUser);
				return firstUser;
			} catch (Exception e) {
				e.printStackTrace();
			}
			return null;

		} else {

			Admins user = adminService.getAdminsByEmail(email.toLowerCase());

			try {
				if (user != null
						&& PasswordHash.validatePassword(password,
								user.getPassword())) {
					return user;
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			System.out.println("Wrong Password. Cannot authenticate");
			return null;
		}

	}

	/**
	 * logouts user
	 * 
	 * @return
	 */
	public String logout() {
		FacesContext.getCurrentInstance().getExternalContext()
				.invalidateSession();
		return "/login.jsf?faces-redirect=true";
	}

	/**
	 * @return true if user is logged in
	 */
	public boolean isLoggedIn() {
		return current != null;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email
	 *            the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password
	 *            the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the current
	 */
	public Admins getCurrent() {
		return current;
	}

	/**
	 * @param current
	 *            the current to set
	 */
	public void setCurrent(Admins current) {
		this.current = current;
	}

	public IAdminsService getAdminService() {
		return adminService;
	}

	public void setAdminService(IAdminsService adminService) {
		this.adminService = adminService;
	}

}
