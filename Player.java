class Player {
    private Pile myPile;
    private String name;
    public Player(String name, int numberOfPlayers, int startingPoint) {
        this.myPile = new Pile(numberOfPlayers, startingPoint);
        this.name = name;
    }

    public Card getTopCard() {
        Card topCard = myPile.getPile().get(0);
        myPile.getPile().remove(0);
        return topCard;
    }

    public String getName() {
        return this.name;
    }
}
