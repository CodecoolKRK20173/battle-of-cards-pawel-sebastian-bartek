public enum Suits{
    CLUBS ('\u2663'), DIAMONDS('\u2662'), HEARTS('\u2661'), SPADES('\u2660');
    
    
    private char graphicalRepresentation;
    
    private Suits(char representation){
        this.graphicalRepresentation = representation;
    }
        
    public String getRepresentation(){
        return String.valueOf(graphicalRepresentation);
    }
}
    
