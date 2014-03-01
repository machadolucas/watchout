package com.riskvis.game.view;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.PhaseId;

import org.primefaces.event.FlowEvent;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.DualListModel;
import org.primefaces.model.StreamedContent;
import org.springframework.dao.DataIntegrityViolationException;

import com.riskvis.db.service.IPlayersHasQuestsService;
import com.riskvis.db.service.IPlayersService;
import com.riskvis.db.service.IQuestInsurancesService;
import com.riskvis.db.service.ITurnsHistoryHasPlacesrisksService;
import com.riskvis.db.service.ITurnsHistoryHasTransportationrisksService;
import com.riskvis.db.service.ITurnsHistoryService;
import com.riskvis.entity.Insurances;
import com.riskvis.entity.Places;
import com.riskvis.entity.PlacesHasTransports;
import com.riskvis.entity.Placesrisks;
import com.riskvis.entity.Players;
import com.riskvis.entity.PlayersHasQuests;
import com.riskvis.entity.PlayersHasQuestsId;
import com.riskvis.entity.QuestInsurances;
import com.riskvis.entity.QuestInsurancesId;
import com.riskvis.entity.Quests;
import com.riskvis.entity.Transportationrisks;
import com.riskvis.entity.TurnsHistory;
import com.riskvis.entity.TurnsHistoryHasPlacesrisks;
import com.riskvis.entity.TurnsHistoryHasPlacesrisksId;
import com.riskvis.entity.TurnsHistoryHasTransportationrisks;
import com.riskvis.entity.TurnsHistoryHasTransportationrisksId;
import com.riskvis.entity.TurnsHistoryId;
import com.riskvis.util.MessageUtils;
import com.riskvis.util.PasswordHash;

/**
 * This bean is responsible for a game session
 * 
 * @author <a href="http://machadolucas.me">machadolucas</a>
 *
 */
@SessionScoped
@ManagedBean
public class PlayerSessionBean {

	/**
	 * Outcome of the game start page (file name)
	 */
	private static final String INDEX_PAGE_OUTCOME = "index";
	/**
	 * Outcome of the game main page (file name)
	 */
	private static final String GAME_PAGE_OUTCOME = "stage";
	/**
	 * Url relative to the xhtml of the game main page
	 */
	private static final String GAME_PAGE_URL = "stage.jsf";
	/**
	 * Url relative to the xhtml of the end of the game page
	 */
	private static final String ENDGAME_PAGE_URL = "end.jsf";

	@ManagedProperty(value = "#{PlayersService}")
	IPlayersService playersService;

	@ManagedProperty(value = "#{PlayersHasQuestsService}")
	IPlayersHasQuestsService playersHasQuestsService;

	@ManagedProperty(value = "#{QuestInsurancesService}")
	IQuestInsurancesService questInsurancesService;

	@ManagedProperty(value = "#{TurnsHistoryService}")
	ITurnsHistoryService turnsHistoryService;

	@ManagedProperty(value = "#{TurnsHistoryHasPlacesrisksService}")
	ITurnsHistoryHasPlacesrisksService turnsHistoryHasPlacesrisksService;

	@ManagedProperty(value = "#{TurnsHistoryHasTransportationrisksService}")
	ITurnsHistoryHasTransportationrisksService turnsHistoryHasTransportationrisksService;

	@ManagedProperty(value = "#{gameBean}")
	GameBean gameBean;

	/**
	 * Model for picklist of insurances selection before starting a quest
	 */
	private DualListModel<Insurances> insurancesPicklist = new DualListModel<Insurances>();

	/**
	 * Model for picklist of insurances selection during the game
	 */
	private DualListModel<Insurances> manageInsurancesPicklist = new DualListModel<Insurances>();

	/**
	 * Active player of the game
	 */
	private Players player;
	// ***************** Constants *****************
	private static final BigDecimal playerInitialCash = new BigDecimal(
			"5000.00");
	private static final String playerDefaultName = "Player";
	private static final int playerInitialEnergy = 1000;

	// ***************** Start page register fields *****************
	private String newUsername;
	private String newUserEmail;
	private String oldPassword;
	private String newPassword;

	// ***************** Start page login fields *****************
	private String loginEmail;
	private String loginPassword;

	// ***************** Quest and insurance selection *****************
	private double totalCostOfInsurances;
	private Quests selectedQuest; // Used only for quest selection
	private PlayersHasQuests selectedQuestRelation; // Used only for quest
													// selection

	// ***************** Game mechanics objects *****************
	private Places currentPlace;
	private Quests activeQuest; // Quest being played
	private List<PlayersHasQuests> playerQuests = null; // List of saved games
	private List<QuestInsurances> initialInsurances; // Insurances previously
														// saved for a quest
	private List<Insurances> insurances; // Insurances used by player in game
	private double totalCostOfNewInsurances; // Used to buy insurances
	private Places selectedPlaceForTravel; // Selected for jackpot popup
	private List<MovementAndRiskData> movementOptions = new LinkedList<MovementAndRiskData>();
	private MovementAndRiskData selectedMovement;// Movement selected in wizard
	private MovementAndRiskData calculatedMovement;// Movement with only risks
													// calculated
	private String jackpotResult = "1, 2, 3"; // Indexes of pre-determined
												// result of jackpot
	private MoneyLossesData moneyLosses;// Amount of losses after calculating
										// risks

	/**
	 * History of traveled places in the session.
	 */
	private List<TurnsHistory> initialTurnsHistory = new LinkedList<TurnsHistory>();
	private List<TurnsHistory> turnsHistory = new LinkedList<TurnsHistory>();

	/**
	 * Default constructor for the bean. Initializes player attributes
	 */
	public PlayerSessionBean() {
		super();
		player = new Players();
		player.setCash(playerInitialCash);
		player.setEnergy(playerInitialEnergy);
		player.setName(playerDefaultName);

	}

	/**
	 * Initializes the picklist objects in the bean
	 */
	@PostConstruct
	private void init() {

		insurancesPicklist.setSource(new ArrayList<Insurances>(gameBean
				.getInsurances()));
		insurancesPicklist.setTarget(new ArrayList<Insurances>());
	}

	/**
	 * Checks if there's a quest being played, so the start screen can be
	 * skipped. If the current quest is completed, then redirects to end game
	 * page.
	 * 
	 * @return stage to redirect to game page or end game page
	 */
	public void isSessionActive() {
		if (activeQuest != null) {
			try {
				if (getIsCurrentQuestCompleted()) {
					FacesContext.getCurrentInstance().getExternalContext()
							.dispatch(ENDGAME_PAGE_URL);
				} else {
					FacesContext.getCurrentInstance().getExternalContext()
							.dispatch(GAME_PAGE_URL);
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * Creates a new player register in the database
	 */
	public void registerNewPlayer() {
		try {
			player.setName(newUsername);
			player.setEmail(newUserEmail);
			player.setPassword(PasswordHash.createHash(newPassword));

			playersService.addPlayers(player);
			MessageUtils
					.showInfoInGrowl(
							"Success!",
							"Your account was created! Now you can play the game and your information will be saved");
		} catch (Exception e) {
			MessageUtils.showErrorInGrowl("Invalid fields",
					"Please check if all the fields are filled correctly");
		}

	}

	/**
	 * Looks for an existing player in the database and tries to login
	 */
	public void loginPlayer() {
		player = matchLogin(loginEmail, loginPassword);

		if (player == null) {
			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR,
							"Incorrect Password!", "Try Again"));
			loginPassword = null;
		} else {
			loadPlayerQuests();
			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_INFO, "Success!",
							"You are now logged as " + player.getName()));
		}
	}

	/**
	 * Matches given player credentials with the database
	 * 
	 * @param email
	 * @param password
	 * @return the Players object if the login information is correct, otherwise
	 *         null
	 */
	private Players matchLogin(String email, String password) {

		Players player = playersService.getPlayersByEmail(email);

		try {
			if (player != null
					&& PasswordHash.validatePassword(password,
							player.getPassword())) {
				return player;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;

	}

	/**
	 * Logout the player and cleans the session
	 * 
	 * @return outcome to context path with faces-redirect
	 */
	public String logout() {

		insurancesPicklist.setSource(new ArrayList<Insurances>(gameBean
				.getInsurances()));
		insurancesPicklist.setTarget(new ArrayList<Insurances>());

		FacesContext.getCurrentInstance().getExternalContext()
				.invalidateSession();
		FacesContext.getCurrentInstance().addMessage(
				null,
				new FacesMessage(FacesMessage.SEVERITY_INFO, "Log out",
						"You are now logged off"));
		return "/?faces-redirect=true";
	}

	/**
	 * Load all the relations between the current logged player and quests
	 * (saved games) and populates in playerQuests list
	 */
	public void loadPlayerQuests() {
		if (player.getIdplayers() != null) {
			PlayersHasQuestsId id = new PlayersHasQuestsId();
			id.setPlayersIdplayers(player.getIdplayers());
			playerQuests = playersHasQuestsService
					.getPlayersHasQuestsByPlayer(id);
		}
	}

	/**
	 * Deletes the relation between a player and a quest (a saved game), and all
	 * its data in cascade
	 * 
	 * @param phq
	 *            relation to be deleted
	 */
	public void deletePlayerHasQuest(PlayersHasQuests phq) {
		if (player.getIdplayers() != null) {
			playersHasQuestsService.deletePlayersHasQuests(phq);
			loadPlayerQuests();
			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_INFO, "Deleted",
							"Your saved data about this quest was removed"));
		}
	}

	/**
	 * Checks if the player already has the quest, and returns the
	 * PlayerHasQuest object if yes. Otherwise, returns null
	 * 
	 * @param quest
	 * @return null if false, otherwise the object that represents the relation
	 */
	public PlayersHasQuests doesPlayerHasQuest(Quests quest) {
		if (player != null && player.getIdplayers() != null) {
			if (playerQuests == null) {
				loadPlayerQuests();
			}
			for (int i = 0; i < playerQuests.size(); i++) {
				PlayersHasQuests phq = playerQuests.get(i);
				if (phq.getQuests().equals(quest)) {
					return phq;
				}
			}
		}
		return null;
	}

	/**
	 * Checks if the player have the specified quest marked as completed.
	 * 
	 * @param quest
	 * @return true or false
	 */
	public boolean doesPlayerHaveCompleteQuest(Quests quest) {
		PlayersHasQuests relation = doesPlayerHasQuest(quest);
		if (relation == null) {
			return false;
		}
		return relation.isCompleted();
	}

	/**
	 * Handles the selection of a quest to be displayed with more details in the
	 * popup in index page
	 * 
	 * @param quest
	 *            the quest
	 */
	public void selectQuest(Quests quest) {
		this.selectedQuest = quest;
		selectedQuestRelation = doesPlayerHasQuest(quest);
	}

	/**
	 * Handles the insurance selection transfer event in the picklist before
	 * starting a quest
	 */
	public void insuranceSelection() {
		double sum = 0;
		List<Insurances> targetList = insurancesPicklist.getTarget();
		for (Insurances i : targetList) {
			sum += i.getCost().doubleValue();
		}
		totalCostOfInsurances = sum;
	}

	/**
	 * Takes the selected quest and puts as active. Creates the relation between
	 * the player and the quest if it does not exist. Prepare objects that are
	 * used during the game. If quest was already completed, redirects to end
	 * game screen.
	 * 
	 * @return outcome to game screen or end game screen
	 */
	public String startQuest() {
		this.activeQuest = this.selectedQuest;
		this.insurances = new ArrayList<Insurances>(
				insurancesPicklist.getTarget());
		for (Insurances in : insurances) {
			this.player.setCash(this.player.getCash().subtract(in.getCost()));
		}
		insurancesPicklist.setSource(new ArrayList<Insurances>(gameBean
				.getInsurances()));
		insurancesPicklist.setTarget(new ArrayList<Insurances>());
		totalCostOfInsurances = 0;

		List<Insurances> availableToBuy = new ArrayList<Insurances>(
				gameBean.getInsurances());
		availableToBuy.removeAll(this.insurances);
		manageInsurancesPicklist.setSource(availableToBuy);
		manageInsurancesPicklist.setTarget(new ArrayList<Insurances>());

		if (player.getIdplayers() != null) {
			PlayersHasQuests hasQuest = doesPlayerHasQuest(activeQuest);
			if (hasQuest == null) {
				PlayersHasQuestsId ids = new PlayersHasQuestsId(
						player.getIdplayers(), activeQuest.getIdquests());
				PlayersHasQuests object = new PlayersHasQuests();
				object.setId(ids);
				object.setCompleted(false);
				object.setPlaces(activeQuest.getPlacesByOrigin());
				object.setEnergyAmount(player.getEnergy());
				object.setCashAmount(player.getCash());
				playersHasQuestsService.addPlayersHasQuests(object);
				loadPlayerQuests();

				currentPlace = activeQuest.getPlacesByOrigin();
			} else {
				initialInsurances = questInsurancesService
						.getQuestInsurancesByPlayersHasQuestId(hasQuest.getId());
				if (initialInsurances != null) {
					for (QuestInsurances relation : initialInsurances) {
						insurances.add(relation.getInsurances());
					}
				}
				manageInsurancesPicklist.getSource().removeAll(insurances);
				initialTurnsHistory = turnsHistoryService
						.getTurnsHistoryByPlayerHasQuestsId(hasQuest.getId());
				turnsHistory = turnsHistoryService
						.getTurnsHistoryByPlayerHasQuestsId(hasQuest.getId());
				if (turnsHistory == null) {
					turnsHistory = new LinkedList<TurnsHistory>();
				}
				currentPlace = hasQuest.getPlaces();
				player.setCash(hasQuest.getCashAmount());
				player.setEnergy(hasQuest.getEnergyAmount());
				if (hasQuest.isCompleted()) {
					return ENDGAME_PAGE_URL;
				}
			}

		} else {
			currentPlace = activeQuest.getPlacesByOrigin();
		}
		return GAME_PAGE_OUTCOME;
	}

	/**
	 * Removes quest from active state and return to start page
	 * 
	 * @return outcome to start screen
	 */
	public String endQuest() {
		this.selectedQuest = new Quests();
		this.activeQuest = null;
		this.turnsHistory = new LinkedList<TurnsHistory>();
		player.setCash(playerInitialCash);
		player.setEnergy(playerInitialEnergy);
		return INDEX_PAGE_OUTCOME + "?faces-redirect=true";
	}

	/**
	 * Saves the current quest state in the database
	 */
	public void saveQuest() {
		if (player.getIdplayers() != null && activeQuest != null) {
			PlayersHasQuestsId ids = new PlayersHasQuestsId(
					player.getIdplayers(), activeQuest.getIdquests());
			PlayersHasQuests questRelation = new PlayersHasQuests();
			questRelation.setId(ids);
			questRelation.setPlaces(currentPlace);
			questRelation.setEnergyAmount(player.getEnergy());
			questRelation.setCashAmount(player.getCash());
			playersHasQuestsService.updatePlayersHasQuests(questRelation);

			// Save Insurance relations
			List<QuestInsurances> insurancesToSave = new ArrayList<QuestInsurances>();
			for (int i = 0; i < insurances.size(); i++) {
				QuestInsurancesId iRelationId = new QuestInsurancesId();
				iRelationId.setInsurancesIdinsurances(insurances.get(i)
						.getIdinsurances());
				iRelationId.setPlayersHasQuestsPlayersIdplayers(player
						.getIdplayers());
				iRelationId.setPlayersHasQuestsQuestsIdquests(activeQuest
						.getIdquests());
				QuestInsurances insuranceRelation = new QuestInsurances();
				insuranceRelation.setId(iRelationId);
				insuranceRelation.setInsurances(insurances.get(i));
				insuranceRelation.setPlayersHasQuests(questRelation);

				insurancesToSave.add(insuranceRelation);
			}
			if (initialInsurances != null) {
				insurancesToSave.removeAll(initialInsurances);
			}
			for (QuestInsurances insuranceRelation : insurancesToSave) {
				questInsurancesService.addQuestInsurances(insuranceRelation);
			}

			// Save Turns history
			List<TurnsHistory> turnsHistoryToSave = new ArrayList<TurnsHistory>(
					turnsHistory);
			if (initialTurnsHistory != null) {
				turnsHistoryToSave.removeAll(initialTurnsHistory);
			}
			for (TurnsHistory history : turnsHistoryToSave) {
				try {
					turnsHistoryService.addTurnsHistory(history);

					for (TurnsHistoryHasPlacesrisks risk : history
							.getTurnsHistoryHasPlacesriskses()) {
						turnsHistoryHasPlacesrisksService
								.addTurnsHistoryHasPlacesrisks(risk);
					}
					for (TurnsHistoryHasTransportationrisks risk : history
							.getTurnsHistoryHasTransportationriskses()) {
						turnsHistoryHasTransportationrisksService
								.addTurnsHistoryHasTransportationrisks(risk);
					}
				} catch (DataIntegrityViolationException e) {
					// Traveling between same cities in same direction and
					// transport. Support not implemented
				}
			}

			FacesContext
					.getCurrentInstance()
					.addMessage(
							null,
							new FacesMessage(
									FacesMessage.SEVERITY_INFO,
									"Saved!",
									"Your game was saved with success. In the next time that you start this quest, you will continue from this point"));
		} else {
			FacesContext
					.getCurrentInstance()
					.addMessage(
							null,
							new FacesMessage(
									FacesMessage.SEVERITY_ERROR,
									"Error!",
									"Apparently there is no user logged in or active quest. Game could not be saved"));
		}
	}

	/**
	 * Checks if current quest is completed by comparing current place with
	 * objective
	 * 
	 * @return true or false
	 */
	public boolean getIsCurrentQuestCompleted() {
		if (activeQuest.getPlacesByDestination().equals(currentPlace)) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Finishes the game, saving the quest as completed and redirecting to
	 * results page
	 * 
	 * @return outcume to end game page
	 */
	public String finishGame() {
		if (player.getIdplayers() != null && activeQuest != null
				&& currentPlace != null) {
			saveCurrentQuestAsComplete();
		}
		return ENDGAME_PAGE_URL;
	}

	/**
	 * Saves the current quest, marking it as completed
	 */
	private void saveCurrentQuestAsComplete() {
		if (player.getIdplayers() != null && activeQuest != null) {
			PlayersHasQuestsId ids = new PlayersHasQuestsId(
					player.getIdplayers(), activeQuest.getIdquests());
			PlayersHasQuests questRelation = new PlayersHasQuests();
			questRelation.setId(ids);
			questRelation.setCompleted(true);
			questRelation.setPlaces(currentPlace);
			questRelation.setEnergyAmount(player.getEnergy());
			questRelation.setCashAmount(player.getCash());
			playersHasQuestsService.updatePlayersHasQuests(questRelation);

			// Save Insurance relations
			List<QuestInsurances> insurancesToSave = new ArrayList<QuestInsurances>();
			for (int i = 0; i < insurances.size(); i++) {
				QuestInsurancesId iRelationId = new QuestInsurancesId();
				iRelationId.setInsurancesIdinsurances(insurances.get(i)
						.getIdinsurances());
				iRelationId.setPlayersHasQuestsPlayersIdplayers(player
						.getIdplayers());
				iRelationId.setPlayersHasQuestsQuestsIdquests(activeQuest
						.getIdquests());
				QuestInsurances insuranceRelation = new QuestInsurances();
				insuranceRelation.setId(iRelationId);
				insuranceRelation.setInsurances(insurances.get(i));
				insuranceRelation.setPlayersHasQuests(questRelation);

				insurancesToSave.add(insuranceRelation);
			}
			if (initialInsurances != null) {
				insurancesToSave.removeAll(initialInsurances);
			}
			for (QuestInsurances insuranceRelation : insurancesToSave) {
				questInsurancesService.addQuestInsurances(insuranceRelation);
			}

			// Save Turns history
			List<TurnsHistory> turnsHistoryToSave = new ArrayList<TurnsHistory>(
					turnsHistory);
			if (initialTurnsHistory != null) {
				turnsHistoryToSave.removeAll(initialTurnsHistory);
			}
			for (TurnsHistory history : turnsHistoryToSave) {
				turnsHistoryService.addTurnsHistory(history);
				for (TurnsHistoryHasPlacesrisks risk : history
						.getTurnsHistoryHasPlacesriskses()) {
					turnsHistoryHasPlacesrisksService
							.addTurnsHistoryHasPlacesrisks(risk);
				}
				for (TurnsHistoryHasTransportationrisks risk : history
						.getTurnsHistoryHasTransportationriskses()) {
					turnsHistoryHasTransportationrisksService
							.addTurnsHistoryHasTransportationrisks(risk);
				}
			}
		}
	}

	/**
	 * Handles the transfer of a insurance in picklist during the game
	 */
	public void newInsuranceSelection() {
		double sum = 0;
		List<Insurances> targetList = manageInsurancesPicklist.getTarget();
		for (Insurances i : targetList) {
			sum += i.getCost().doubleValue();
		}
		totalCostOfNewInsurances = sum;
	}

	/**
	 * Get selelected insurances and add to user session. Discounts player cash.
	 */
	public void buyNewInsurances() {
		for (Insurances in : manageInsurancesPicklist.getTarget()) {
			this.player.setCash(this.player.getCash().subtract(in.getCost()));
			this.insurances.add(in);
		}
		List<Insurances> availableToBuy = new ArrayList<Insurances>(
				gameBean.getInsurances());
		availableToBuy.removeAll(this.insurances);
		manageInsurancesPicklist.setSource(availableToBuy);
		manageInsurancesPicklist.setTarget(new ArrayList<Insurances>());
		totalCostOfNewInsurances = 0;
	}

	/**
	 * Handles flow of wizard in traveling process
	 * 
	 * @param event
	 * @return a String with the id of wizard tab
	 */
	public String onWizardProcess(FlowEvent event) {
		return event.getNewStep();
	}

	/**
	 * Handles the selection of a new place to travel through the map
	 * 
	 * @param place
	 *            the destination
	 */
	public void selectPlaceForTravel(Places place) {
		this.selectedPlaceForTravel = place;

		List<PlacesHasTransports> relationsFromOrigin = new ArrayList<PlacesHasTransports>(
				currentPlace.getPlacesHasTransportses());
		Iterator<PlacesHasTransports> it = relationsFromOrigin.iterator();
		while (it.hasNext()) {
			PlacesHasTransports item = it.next();
			if (!item.getDestination().getIdplaces()
					.equals(place.getIdplaces())) {
				it.remove();
			}
		}
		movementOptions = new LinkedList<MovementAndRiskData>();
		for (PlacesHasTransports pht : relationsFromOrigin) {
			MovementAndRiskData option = new MovementAndRiskData();
			option.setDestination(pht.getDestination());
			option.setTransport(pht.getTransports());
			option.setCost(pht.getMoneyCost());

			List<Placesrisks> placesRisks = new LinkedList<Placesrisks>();
			placesRisks.addAll(pht.getDestination().getPlacesriskses());
			option.setPrisks(placesRisks);

			List<Transportationrisks> transportationrisks = new LinkedList<Transportationrisks>();
			transportationrisks.addAll(pht.getTransports()
					.getTransportationriskses());
			option.setTrisks(transportationrisks);

			movementOptions.add(option);
		}
		if (movementOptions.size() > 0) {
			this.selectedMovement = movementOptions.get(0);
		}
	}

	/**
	 * Handles the selection of a new transport to travel to a place through the
	 * wizard
	 * 
	 * @param movement
	 *            movement data with the transportation
	 */
	public void selectTransportForTravel(MovementAndRiskData movement) {
		this.selectedMovement = movement;
	}

	/**
	 * Calculates the risks in traveling to a place with a certain
	 * transportation. The energy consumption and money cost is also calculated
	 * and stored in moneyLosses object. Jackpot output is determined in bomos
	 * (1,1,1) if any risk happens, or something random if nothing happens.
	 */
	public void calculateRisks() {
		List<Placesrisks> placesEvents = EventCalculator
				.generatePlacesEvents(this.selectedMovement.getPrisks());
		List<Transportationrisks> transportsEvents = EventCalculator
				.generateTransportsEvents(this.selectedMovement.getTrisks());
		moneyLosses = EventCalculator.calculateMoneyLosses(placesEvents,
				transportsEvents, this.insurances);
		if (placesEvents.size() > 0 || transportsEvents.size() > 0) {
			jackpotResult = "1, 1, 1";
		} else {
			Random random = new Random();
			int jackpot1 = random.nextInt(5) + 1;
			int jackpot2 = random.nextInt(4) + 2;
			int jackpot3 = random.nextInt(5) + 1;
			jackpotResult = jackpot1 + ", " + jackpot2 + ", " + jackpot3;
		}
		this.calculatedMovement = this.selectedMovement;
		this.calculatedMovement.setPrisks(placesEvents);
		this.calculatedMovement.setTrisks(transportsEvents);
	}

	/**
	 * Moves the player between currentPlace and selectedPlaceForTravel using
	 * the selectedTransportForTravel
	 */
	public void moveBetween() {

		PlacesHasTransports selectedMovementRelation = null;
		for (PlacesHasTransports pht : this.currentPlace
				.getPlacesHasTransportses()) {
			if (pht.getDestination()
					.getIdplaces()
					.equals(this.selectedMovement.getDestination()
							.getIdplaces())) {
				if (pht.getTransports()
						.getIdtransports()
						.equals(this.selectedMovement.getTransport()
								.getIdtransports())) {
					selectedMovementRelation = pht;
					break;
				}
			}
		}
		if (selectedMovementRelation != null) {

			player.setEnergy(player.getEnergy()
					- moneyLosses.getEnergyConsumption());
			player.setCash(player.getCash().subtract(
					selectedMovementRelation.getMoneyCost()));
			player.setCash(player.getCash().subtract(moneyLosses.getTotal()));

			this.currentPlace = selectedPlaceForTravel;

			// Save in history
			PlayersHasQuests existingRelation = doesPlayerHasQuest(activeQuest);
			TurnsHistory historyItem = new TurnsHistory();
			if (player.getIdplayers() != null) {
				TurnsHistoryId thId = new TurnsHistoryId();
				thId.setPlacesHasTransportsPlacesDestination(selectedMovementRelation
						.getDestination().getIdplaces());
				thId.setPlacesHasTransportsPlacesOrigin(selectedMovementRelation
						.getPlaces().getIdplaces());
				thId.setPlacesHasTransportsTransportation(selectedMovementRelation
						.getTransports().getIdtransports());
				thId.setPlayersHasQuestsPlayersIdplayers(existingRelation
						.getId().getPlayersIdplayers());
				thId.setPlayersHasQuestsQuestsIdquests(existingRelation.getId()
						.getQuestsIdquests());

				historyItem.setId(thId);
			}
			historyItem.setPlacesHasTransports(selectedMovementRelation);
			historyItem.setPlayersHasQuests(existingRelation);

			for (int i = 0; i < calculatedMovement.getPrisks().size(); i++) {
				TurnsHistoryHasPlacesrisks thPlacesRisks = new TurnsHistoryHasPlacesrisks();
				if (player.getIdplayers() != null) {
					TurnsHistoryHasPlacesrisksId thrId = new TurnsHistoryHasPlacesrisksId(
							existingRelation.getId().getPlayersIdplayers(),
							existingRelation.getId().getQuestsIdquests(),
							selectedMovementRelation.getPlaces().getIdplaces(),
							selectedMovementRelation.getTransports()
									.getIdtransports(),
							selectedMovementRelation.getDestination()
									.getIdplaces(), calculatedMovement
									.getPrisks().get(i).getIdrisks());
					thPlacesRisks.setId(thrId);
				}
				thPlacesRisks.setPlacesrisks(calculatedMovement.getPrisks()
						.get(i));
				thPlacesRisks.setTurnsHistory(historyItem);
				historyItem.getTurnsHistoryHasPlacesriskses()
						.add(thPlacesRisks);
			}
			for (int i = 0; i < calculatedMovement.getTrisks().size(); i++) {
				TurnsHistoryHasTransportationrisks thTransportRisks = new TurnsHistoryHasTransportationrisks();
				if (player.getIdplayers() != null) {
					TurnsHistoryHasTransportationrisksId thrId = new TurnsHistoryHasTransportationrisksId(
							existingRelation.getId().getPlayersIdplayers(),
							existingRelation.getId().getQuestsIdquests(),
							selectedMovementRelation.getPlaces().getIdplaces(),
							selectedMovementRelation.getTransports()
									.getIdtransports(),
							selectedMovementRelation.getDestination()
									.getIdplaces(), calculatedMovement
									.getTrisks().get(i).getIdrisks());
					thTransportRisks.setId(thrId);
				}
				thTransportRisks.setTransportationrisks(calculatedMovement
						.getTrisks().get(i));
				thTransportRisks.setTurnsHistory(historyItem);
				historyItem.getTurnsHistoryHasTransportationriskses().add(
						thTransportRisks);
			}
			turnsHistory.add(historyItem);
		}
		this.selectedMovement = null;

	}

	/**
	 * If there is a player logged in and with a active quest, saves the game
	 * and shows a message. This method is called by a ajax poll in a determined
	 * interval.
	 */
	public void expireSession() {
		if (player.getIdplayers() != null && activeQuest != null
				&& !doesPlayerHasQuest(activeQuest).isCompleted()) {
			saveQuest();
			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_INFO, "Game saved",
							"Your game was automatically saved"));
		}

	}

	/**
	 * Can be used to render a image in the view with some image data
	 * 
	 * @param data
	 *            array of bytes with image data
	 * @return StreamedContent
	 */
	public StreamedContent getStreamedPhoto(byte[] data) {
		FacesContext context = FacesContext.getCurrentInstance();

		if (context.getCurrentPhaseId() == PhaseId.RENDER_RESPONSE) {
			return new DefaultStreamedContent(FacesContext.getCurrentInstance()
					.getExternalContext()
					.getResourceAsStream("/static/img/default-image.png"));
			// return new DefaultStreamedContent();
		} else {
			if (data != null) {
				return new DefaultStreamedContent(
						new ByteArrayInputStream(data));
			} else {
				return new DefaultStreamedContent(FacesContext
						.getCurrentInstance().getExternalContext()
						.getResourceAsStream("/static/img/default-image.png"));
			}
		}
	}

	// ***************** Getters and Setters *****************

	public Players getPlayer() {
		return player;
	}

	public void setPlayer(Players player) {
		this.player = player;
	}

	public Quests getActiveQuest() {
		return activeQuest;
	}

	public void setActiveQuest(Quests activeQuest) {
		this.activeQuest = activeQuest;
	}

	public List<PlayersHasQuests> getPlayerQuests() {
		return playerQuests;
	}

	public void setPlayerQuests(List<PlayersHasQuests> playerQuests) {
		this.playerQuests = playerQuests;
	}

	public String getOldPassword() {
		return oldPassword;
	}

	public void setOldPassword(String oldPassword) {
		this.oldPassword = oldPassword;
	}

	public String getNewPassword() {
		return newPassword;
	}

	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}

	public String getNewUsername() {
		return newUsername;
	}

	public void setNewUsername(String newUsername) {
		this.newUsername = newUsername;
	}

	public String getNewUserEmail() {
		return newUserEmail;
	}

	public void setNewUserEmail(String newUserEmail) {
		this.newUserEmail = newUserEmail;
	}

	public String getLoginEmail() {
		return loginEmail;
	}

	public void setLoginEmail(String loginEmail) {
		this.loginEmail = loginEmail;
	}

	public String getLoginPassword() {
		return loginPassword;
	}

	public void setLoginPassword(String loginPassword) {
		this.loginPassword = loginPassword;
	}

	public IPlayersService getPlayersService() {
		return playersService;
	}

	public void setPlayersService(IPlayersService playersService) {
		this.playersService = playersService;
	}

	public IPlayersHasQuestsService getPlayersHasQuestsService() {
		return playersHasQuestsService;
	}

	public void setPlayersHasQuestsService(
			IPlayersHasQuestsService playersHasQuestsService) {
		this.playersHasQuestsService = playersHasQuestsService;
	}

	public Quests getSelectedQuest() {
		return selectedQuest;
	}

	public void setSelectedQuest(Quests selectedQuest) {
		this.selectedQuest = selectedQuest;
	}

	public Places getCurrentPlace() {
		return currentPlace;
	}

	public void setCurrentPlace(Places currentPlace) {
		this.currentPlace = currentPlace;
	}

	public DualListModel<Insurances> getInsurancesPicklist() {
		return insurancesPicklist;
	}

	public void setInsurancesPicklist(
			DualListModel<Insurances> insurancesPicklist) {
		this.insurancesPicklist = insurancesPicklist;
	}

	public double getTotalCostOfInsurances() {
		return totalCostOfInsurances;
	}

	public void setTotalCostOfInsurances(double totalCostOfInsurances) {
		this.totalCostOfInsurances = totalCostOfInsurances;
	}

	public PlayersHasQuests getSelectedQuestRelation() {
		return selectedQuestRelation;
	}

	public void setSelectedQuestRelation(PlayersHasQuests selectedQuestRelation) {
		this.selectedQuestRelation = selectedQuestRelation;
	}

	public GameBean getGameBean() {
		return gameBean;
	}

	public void setGameBean(GameBean gameBean) {
		this.gameBean = gameBean;
	}

	public Places getSelectedPlaceForTravel() {
		return selectedPlaceForTravel;
	}

	public void setSelectedPlaceForTravel(Places selectedPlaceForTravel) {
		this.selectedPlaceForTravel = selectedPlaceForTravel;
	}

	public List<Insurances> getInsurances() {
		return insurances;
	}

	public void setInsurances(List<Insurances> insurances) {
		this.insurances = insurances;
	}

	public DualListModel<Insurances> getManageInsurancesPicklist() {
		return manageInsurancesPicklist;
	}

	public void setManageInsurancesPicklist(
			DualListModel<Insurances> manageInsurancesPicklist) {
		this.manageInsurancesPicklist = manageInsurancesPicklist;
	}

	public double getTotalCostOfNewInsurances() {
		return totalCostOfNewInsurances;
	}

	public void setTotalCostOfNewInsurances(double totalCostOfNewInsurances) {
		this.totalCostOfNewInsurances = totalCostOfNewInsurances;
	}

	public List<MovementAndRiskData> getMovementOptions() {
		return movementOptions;
	}

	public void setMovementOptions(List<MovementAndRiskData> movementOptions) {
		this.movementOptions = movementOptions;
	}

	public MovementAndRiskData getSelectedMovement() {
		return selectedMovement;
	}

	public void setSelectedMovement(MovementAndRiskData selectedMovement) {
		this.selectedMovement = selectedMovement;
	}

	public String getJackpotResult() {
		return jackpotResult;
	}

	public void setJackpotResult(String jackpotResult) {
		this.jackpotResult = jackpotResult;
	}

	public MovementAndRiskData getCalculatedMovement() {
		return calculatedMovement;
	}

	public void setCalculatedMovement(MovementAndRiskData calculatedMovement) {
		this.calculatedMovement = calculatedMovement;
	}

	public MoneyLossesData getMoneyLosses() {
		return moneyLosses;
	}

	public void setMoneyLosses(MoneyLossesData moneyLosses) {
		this.moneyLosses = moneyLosses;
	}

	public List<TurnsHistory> getTurnsHistory() {
		return turnsHistory;
	}

	public void setTurnsHistory(List<TurnsHistory> turnsHistory) {
		this.turnsHistory = turnsHistory;
	}

	public List<QuestInsurances> getInitialInsurances() {
		return initialInsurances;
	}

	public void setInitialInsurances(List<QuestInsurances> initialInsurances) {
		this.initialInsurances = initialInsurances;
	}

	public IQuestInsurancesService getQuestInsurancesService() {
		return questInsurancesService;
	}

	public void setQuestInsurancesService(
			IQuestInsurancesService questInsurancesService) {
		this.questInsurancesService = questInsurancesService;
	}

	public ITurnsHistoryService getTurnsHistoryService() {
		return turnsHistoryService;
	}

	public void setTurnsHistoryService(ITurnsHistoryService turnsHistoryService) {
		this.turnsHistoryService = turnsHistoryService;
	}

	public List<TurnsHistory> getInitialTurnsHistory() {
		return initialTurnsHistory;
	}

	public void setInitialTurnsHistory(List<TurnsHistory> initialTurnsHistory) {
		this.initialTurnsHistory = initialTurnsHistory;
	}

	public ITurnsHistoryHasPlacesrisksService getTurnsHistoryHasPlacesrisksService() {
		return turnsHistoryHasPlacesrisksService;
	}

	public void setTurnsHistoryHasPlacesrisksService(
			ITurnsHistoryHasPlacesrisksService turnsHistoryHasPlacesrisksService) {
		this.turnsHistoryHasPlacesrisksService = turnsHistoryHasPlacesrisksService;
	}

	public ITurnsHistoryHasTransportationrisksService getTurnsHistoryHasTransportationrisksService() {
		return turnsHistoryHasTransportationrisksService;
	}

	public void setTurnsHistoryHasTransportationrisksService(
			ITurnsHistoryHasTransportationrisksService turnsHistoryHasTransportationrisksService) {
		this.turnsHistoryHasTransportationrisksService = turnsHistoryHasTransportationrisksService;
	}

}
