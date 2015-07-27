class TennisScoring {
	private int state_d,state_f;
	private int[] scoreMap = {0, 15, 30, 40};
	
	public static void main(String[] args) {
        // TODO code application logic here
        
        String input="dddd";
        TennisScoring s=new TennisScoring();
        
        s.displayState();
        for(int i=0;i<input.length();i++)
        {
        s.nextState(input.charAt(i));
        s.displayState();
        }
	
	public void nextState(char point)
	{
		if((state_d==4)&&(state_f==4))
            {
                state_d-=1;
                state_f-=1;
            }
            if(point=='d')
                state_d+=1;
            else
                state_f+=1;
	}
	
	public void displayState()
	{
		if(gameOver()){
			state_d = 0;
			state_f =0;
		}
		else if (state_d == 4 && state_f == 3) {
			System.out.println("Advantage D");
		}
		else if (state_d == 3 && state_f == 4) {
			System.out.println("Advantage F");
		}
		else {
			System.out.println( "D : " + scoreMap[state_d] + "\t F : " + scoreMap[state_f]);
		}
	}
	
	
	static boolean gameOver()
	{
		if ( state_f < 4 && state_d < 4) {
			return false;
		}
		if ( Math.abs (state_f - state_d) >= 2) {
			return true;
		}
		return false;
	}
	
	
}
