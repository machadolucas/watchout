package com.riskvis.bean.admin;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import com.riskvis.db.service.IPlayersService;
import com.riskvis.entity.Players;

/**
 * @author machadolucas@me.com
 * 
 */
@ManagedBean
@SessionScoped
public class PlayersBean extends AbstractEntityBean<Players> {

	private static final long serialVersionUID = 3960687977045277086L;

	private static final String mainOutcome = "main?faces-redirect=true";

	private List<Players> filteredList = new ArrayList<Players>();

	@ManagedProperty(value = "#{PlayersService}")
	IPlayersService playersService;

	@Override
	void doInit() {
		this.list = playersService.getPlayerss();
		filteredList = this.list;
	}

	@Override
	String doAdd() {
		return mainOutcome;
	}

	@Override
	String doEdit() {
		return mainOutcome;
	}

	@Override
	String doSave() {
		return mainOutcome;
	}

	@Override
	String doUpdate() {
		return mainOutcome;
	}

	@Override
	void doDelete() {
		playersService.deletePlayers(bean);
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
		this.list = playersService.getPlayerss();
		filteredList = this.list;
		this.bean = new Players();

	}

	/**
	 * @return the filteredList
	 */
	public List<Players> getFilteredList() {
		return filteredList;
	}

	/**
	 * @param filteredList
	 *            the filteredList to set
	 */
	public void setFilteredList(List<Players> filteredList) {
		this.filteredList = filteredList;
	}

	public IPlayersService getPlayersService() {
		return playersService;
	}

	public void setPlayersService(IPlayersService playersService) {
		this.playersService = playersService;
	}

}
