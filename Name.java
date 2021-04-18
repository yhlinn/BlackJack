/**
 * An enum type that represents a card's name.
 */
public enum Name {
    ACE(1), TWO(2), THREE(3), FOUR(4), FIVE(5),
    SIX(6), SEVEN(7), EIGHT(8), NINE(9), TEN(10),
    JACK(11, 10), QUEEN(12,10), KING(13,10);

    private final int num;
    private final int point;

    /**
     * The constructor of the Name enum with its numerical value.
     * @param num the numerical value of the Card
     */
    Name(int num){
        this.num = num;
        this.point = num;
    }

    /**
     * The constructor of the Name enum with a numerical value and Black Jack points.
     * @param num the numerical value of the Card
     * @param point the number of points the Card is worth in BlackJack
     */
    Name(int num, int point){
        this.num = num;
        this.point = point;
    }

    /**
     * Returns the numerical value of this specific card name.
     * @return the numerical value
     */
    public int number(){
        return this.num;
    }

    /**
     * Returns the number of Black Jack points for this specific card name.
     * @return the number of points worth in Black Jack
     */
    public int point(){
        return this.point;
    }
}



