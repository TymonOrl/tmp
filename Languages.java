public enum Languages {
    ENGLISH("Start game", "Exit", "Personalise", "Ranking", "CHECKERS", "Resign", "Player", "Move", "The winner is", "Rematch"),
    POLISH("Zacznij grę", "Wyjdź", "Personalizuj", "Ranking", "WARCABY", "Poddaj się", "Gracz", "Ruch", "Zwyciężył", "Rewanż"),
    FRENCH("Démarrer le jeu", "Sortie", "Personnaliser", "Classement", "LES DAMES", "Démissionner", "Joueur", "Mouvement de", "Le gagnant est", "Revanche");

    private final String ranking;
    private final String start;
    private final String exit;
    private final String choose;
    private final String title;
    private final String resign;
    private final String player;
    private final String move;
    private final String winner;
    private final String rematch;

    Languages(String start, String exit, String choose, String ranking, String title, String resign, String player, String move, String winner, String rematch) {
        this.start = start;
        this.exit = exit;
        this.choose = choose;
        this.ranking = ranking;
        this.title = title;
        this.resign = resign;
        this.player = player;
        this.move = move;
        this.winner = winner;
        this.rematch = rematch;
    }

    public String getRanking() {
        return ranking;
    }

    public String getStart() {
        return start;
    }

    public String getExit() {
        return exit;
    }

    public String getChoose() {
        return choose;
    }

    public String getTitle() {
        return title;
    }

    public String getResign() {
        return resign;
    }

    public String getPlayer() {
        return player;
    }

    public String getMove() {
        return move;
    }

    public String getWinner() {
        return winner;
    }

    public String getRematch() {
        return rematch;
    }
}
