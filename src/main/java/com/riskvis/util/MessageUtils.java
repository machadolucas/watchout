package com.riskvis.util;

import java.util.ResourceBundle;

import javax.faces.application.FacesMessage;
import javax.faces.application.FacesMessage.Severity;
import javax.faces.context.FacesContext;

/**
 * Class to send messages to the user
 * 
 * @author machadolucas@me.com
 * 
 */
public class MessageUtils {

	private static ResourceBundle bundle = ResourceBundle.getBundle(
			"com.riskvis.properties.Messages", FacesContext
					.getCurrentInstance().getViewRoot().getLocale());

	public static void errorMsg(String msg) {

		msg = bundle.getString(msg);

		FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_ERROR, msg,
				msg);

		FacesContext fc = FacesContext.getCurrentInstance();

		fc.addMessage(null, fm);

	}

	public static void infoMsg(String msg) {

		msg = bundle.getString(msg);

		FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_INFO, msg, msg);

		FacesContext fc = FacesContext.getCurrentInstance();

		fc.addMessage(null, fm);

	}

	/**
	 * Shows a message for the user in growl
	 * 
	 * @param severity
	 * @param title
	 * @param message
	 */
	public static void showInGrowl(Severity severity, String title,
			String message) {

		FacesContext context = FacesContext.getCurrentInstance();
		context.addMessage(null, createMessage(severity, title, message));

	}

	public static void showKeyInGrowl(Severity severity, String title,
			String message) {

		FacesContext context = FacesContext.getCurrentInstance();
		context.addMessage(null, createMessage(severity, title, message));

	}

	/**
	 * Shows a message for the user in the form
	 * 
	 * @param severity
	 * @param title
	 * @param message
	 */
	public static void showInForm(Severity severity, String title,
			String message) {

		FacesContext context = FacesContext.getCurrentInstance();
		context.addMessage("formMessages",
				createMessage(severity, title, message));

	}

	/**
	 * Shows a message for the user in growl
	 * 
	 * @param title
	 * @param message
	 */
	public static void showInfoInGrowl(String title, String message) {
		showInGrowl(FacesMessage.SEVERITY_INFO, title, message);

	}

	/**
	 * Shows a message for the user in growl
	 * 
	 * @param title
	 * @param message
	 */
	public static void showWarnInGrowl(String title, String message) {
		showInGrowl(FacesMessage.SEVERITY_WARN, title, message);

	}

	/**
	 * Shows a message for the user in growl
	 * 
	 * @param title
	 * @param message
	 */
	public static void showErrorInGrowl(String title, String message) {
		showInGrowl(FacesMessage.SEVERITY_ERROR, title, message);

	}

	/**
	 * Shows a message for the user in growl
	 * 
	 * @param title
	 * @param message
	 */
	public static void showFatalInGrowl(String title, String message) {
		showInGrowl(FacesMessage.SEVERITY_FATAL, title, message);

	}

	/**
	 * Shows a message for the user in form
	 * 
	 * @param title
	 * @param message
	 */
	public static void showInfoInForm(String title, String message) {
		showInForm(FacesMessage.SEVERITY_INFO, title, message);

	}

	/**
	 * Shows a message for the user in form
	 * 
	 * @param title
	 * @param message
	 */
	public static void showWarnInForm(String title, String message) {
		showInForm(FacesMessage.SEVERITY_WARN, title, message);

	}

	/**
	 * Shows a message for the user in form
	 * 
	 * @param title
	 * @param message
	 */
	public static void showErrorInForm(String title, String message) {
		showInForm(FacesMessage.SEVERITY_ERROR, title, message);

	}

	/**
	 * Shows a message for the user in form
	 * 
	 * @param title
	 * @param message
	 */
	public static void showFatalInForm(String title, String message) {
		showInForm(FacesMessage.SEVERITY_FATAL, title, message);

	}

	/**
	 * Creates a message
	 * 
	 * @param severity
	 * @param summary
	 * @return {@link FacesMessage}
	 */
	public static FacesMessage createMessage(Severity severity, String summary) {
		return createMessage(severity, summary, null);
	}

	/**
	 * Creates a message
	 * 
	 * @param severity
	 * @param summary
	 * @param detail
	 * @return {@link FacesMessage}
	 */
	public static FacesMessage createMessage(Severity severity, String summary,
			String detail) {

		if (severity == null || summary == null || summary.length() == 0) {
			throw new IllegalArgumentException();
		}

		return new FacesMessage(severity, summary, detail);
	}

	/**
	 * Creates a message with error severity
	 * 
	 * @param summary
	 * @return {@link FacesMessage}
	 * @see #createMessage(Severity, String)
	 */
	public static FacesMessage createErrorMessage(String summary) {
		return createMessage(FacesMessage.SEVERITY_ERROR, summary);
	}

	/**
	 * Creates a message with fatal severity
	 * 
	 * @param summary
	 * @return {@link FacesMessage}
	 * @see #createMessage(Severity, String)
	 */
	public static FacesMessage createFatalMessage(String summary) {
		return createMessage(FacesMessage.SEVERITY_FATAL, summary);
	}

	/**
	 * Creates a message with info severity
	 * 
	 * @param summary
	 * @return {@link FacesMessage}
	 * @see #createMessage(Severity, String)
	 */
	public static FacesMessage createInfoMessage(String summary) {
		return createMessage(FacesMessage.SEVERITY_INFO, summary);
	}

	/**
	 * Creates a message with warn severity
	 * 
	 * @param summary
	 * @return {@link FacesMessage}
	 * @see #createMessage(Severity, String)
	 */
	public static FacesMessage createWarnMessage(String summary) {
		return createMessage(FacesMessage.SEVERITY_WARN, summary);
	}

}