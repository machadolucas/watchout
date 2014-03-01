package com.riskvis.bean.admin;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import com.riskvis.db.service.IAdminsService;
import com.riskvis.entity.Admins;
import com.riskvis.filter.LoginBean;
import com.riskvis.util.MessageUtils;
import com.riskvis.util.PasswordHash;

/**
 * @author machadolucas@me.com
 * 
 */
@ManagedBean
@SessionScoped
public class AdminsBean extends AbstractEntityBean<Admins> {

	private static final long serialVersionUID = 3960687977045277086L;

	private static final String mainOutcome = "main?faces-redirect=true";
	private static final String editOutcome = "/admin/admins/edit.jsf?faces-redirect=true";

	private List<Admins> filteredList = new ArrayList<Admins>();

	@ManagedProperty(value = "#{AdminsService}")
	IAdminsService adminService;

	private String oldPassword;
	private String newPassword;

	@Override
	void doInit() {
		this.list = adminService.getAdminss();
		filteredList = this.list;
	}

	@Override
	String doAdd() {
		this.bean = new Admins();
		return NavigationOutcomeTypes.ADD;
	}

	@Override
	String doEdit() {
		return editOutcome;
	}

	@Override
	String doSave() {
		try {
			bean.setPassword(PasswordHash.createHash(newPassword));
		} catch (Exception e) {
			e.printStackTrace();
		}
		bean.setEmail(bean.getEmail().toLowerCase());
		adminService.addAdmins(bean);
		reset();
		return mainOutcome;
	}

	@Override
	String doUpdate() {
		if (oldPassword != null && oldPassword.length() > 0) {
			try {
				if (PasswordHash.validatePassword(oldPassword,
						bean.getPassword())) {
					if (newPassword != null && newPassword.length() > 0) {
						this.bean.setPassword(PasswordHash
								.createHash(newPassword));
					}
				} else {
					MessageUtils
							.showErrorInGrowl("Senha incorreta",
									"A senha informada como senha atual está incorreta. Por favor, verifique.");
					return null;
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		bean.setEmail(bean.getEmail().toLowerCase());
		adminService.updateAdmins(bean);
		reset();
		return mainOutcome;
	}

	@Override
	void doDelete() {
		adminService.deleteAdmins(bean);
		reset();
	}

	@Override
	public String cancel() {
		reset();
		return mainOutcome;
	}

	@Override
	public String loadMain() {
		reset();
		return mainOutcome;
	}

	@Override
	public void reset() {
		this.list = adminService.getAdminss();
		filteredList = this.list;
		this.bean = new Admins();

	}

	/**
	 * Método utilizado para o carregamento da tela de edição para o usuário
	 * logado.
	 * 
	 * @return o {@link String} que representa o <i>outcome</i> para a regra de
	 *         navegação definida em <a>/WEB-INF/faces-config.xml</a>
	 * @throws Exception
	 *             caso o carregamento da tela de edição falhe
	 */
	public String editCurrentUser() throws Exception {

		doInit();

		FacesContext facesContext = FacesContext.getCurrentInstance();
		HttpSession session = (HttpSession) facesContext.getExternalContext()
				.getSession(true);
		LoginBean loginHelper = (LoginBean) session.getAttribute("loginBean");

		bean = loginHelper.getCurrent();

		return edit();
	}

	/**
	 * @return the newPassword
	 */
	public String getNewPassword() {
		return newPassword;
	}

	/**
	 * @param newPassword
	 *            the newPassword to set
	 */
	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}

	/**
	 * @return the oldPassword
	 */
	public String getOldPassword() {
		return oldPassword;
	}

	/**
	 * @param oldPassword
	 *            the oldPassword to set
	 */
	public void setOldPassword(String oldPassword) {
		this.oldPassword = oldPassword;
	}

	/**
	 * @return the filteredList
	 */
	public List<Admins> getFilteredList() {
		return filteredList;
	}

	/**
	 * @param filteredList
	 *            the filteredList to set
	 */
	public void setFilteredList(List<Admins> filteredList) {
		this.filteredList = filteredList;
	}

	public IAdminsService getAdminService() {
		return adminService;
	}

	public void setAdminService(IAdminsService adminService) {
		this.adminService = adminService;
	}

}
