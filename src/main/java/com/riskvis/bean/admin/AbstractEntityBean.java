package com.riskvis.bean.admin;

import java.io.Serializable;
import java.util.List;
import java.util.ResourceBundle;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedProperty;
import javax.faces.event.ActionEvent;

import org.primefaces.context.RequestContext;

import com.riskvis.entity.AbstractEntity;
import com.riskvis.util.MessageUtils;

public abstract class AbstractEntityBean<T extends AbstractEntity> implements
		Serializable {

	private static final long serialVersionUID = 6222001013594481011L;

	public AbstractEntityBean() {
		super();
	}

	@ManagedProperty("#{msg}")
	protected ResourceBundle bundle;

	protected T bean;

	protected List<T> list;

	abstract void doInit();

	@PostConstruct
	private void init() {
		doInit();
	}

	abstract String doAdd();

	public String add() {
		return doAdd();
	}

	abstract String doEdit();

	public String edit() {
		String outcome = null;
		try {
			if (this.bean != null) {

				try {
					outcome = doEdit();
					if (outcome == null) {
						outcome = "edit";
					}
				} catch (Exception e) {
					System.out
							.println("doEdit() execution has thrown an exception...");
					throw e;
				}

			} else {
				MessageUtils.showWarnInGrowl(bundle.getString("warning_title"),
						bundle.getString("edit_selection_required_message"));
			}
		} catch (Throwable throwable) {
			MessageUtils.showFatalInGrowl(bundle.getString("error_title"),
					bundle.getString("unexpected_error_message"));
			throwable.printStackTrace();
		}

		return outcome;
	}

	abstract String doSave();

	/**
	 * Save a recently created item
	 * 
	 * @return outcome
	 */
	public String save() {
		// System.out.println("trying to insert entity");
		return doSave();
	}

	abstract String doUpdate();

	/**
	 * Update a item after the edition
	 * 
	 * @return outcome
	 */
	public String update() {
		// System.out.println("trying to update entity");
		return doUpdate();
	}

	abstract void doDelete();

	/**
	 * Delete the item from the database
	 */
	public void delete() {
		System.out.println("trying to delete entity");
		doDelete();
	}

	/**
	 * Cancel the view, resetting it.
	 * 
	 * @return o <i>outcome</i> para a regra de navegao
	 */
	public abstract String cancel();

	/**
	 * Does the loading of the main page
	 * 
	 * @return o <i>outcome</i> para a regra de navegao
	 */
	public abstract String loadMain();

	/**
	 * Resets the content of the view
	 * 
	 * @return o <i>outcome</i> para a regra de navegao
	 */
	public abstract void reset();

	/**
	 * Shows a confirmation dialog for deleting if there is a bean selected.
	 * Otherwise, shows a message stating that selection is required
	 * 
	 * @param actionEvent
	 */
	public void dialogIfSelected(ActionEvent actionEvent) {
		RequestContext context = RequestContext.getCurrentInstance();
		boolean canContinue = false;
		if (this.bean != null) {
			canContinue = true;
		} else {
			MessageUtils.showWarnInGrowl(bundle.getString("warning_title"),
					bundle.getString("delete_selection_required_message"));
		}

		context.addCallbackParam("canContinue", canContinue);
	}

	/**
	 * Executes <i>javascript</i> code.
	 * 
	 * @param script
	 *            o {@link String} code to be executed
	 */
	protected static void executeJS(String script) {
		RequestContext requestContext = RequestContext.getCurrentInstance();
		if (requestContext != null) {
			requestContext.execute(script);
		} else {
			System.out.println("could not execute javascript '" + script
					+ "' because the request context is null");
		}
	}

	/**
	 * @return the bean
	 */
	public T getBean() {
		return bean;
	}

	/**
	 * @param bean
	 *            the bean to set
	 */
	public void setBean(T bean) {
		this.bean = bean;
	}

	/**
	 * @return the list
	 */
	public List<T> getList() {
		return list;
	}

	/**
	 * @param list
	 *            the list to set
	 */
	public void setList(List<T> list) {
		this.list = list;
	}

	/**
	 * @return the bundle
	 */
	public ResourceBundle getBundle() {
		return bundle;
	}

	/**
	 * @param bundle
	 *            the bundle to set
	 */
	public void setBundle(ResourceBundle bundle) {
		this.bundle = bundle;
	}
}
