import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import TicTacToe.TicTacToeWindow;
import static TicTacToe.TicTacToeWindow.icon;

public class TicTacToeController {
	
	private TicTacToeWindow view;
	private INetworkModel model;
	private boolean ourTurn=true;
	private icon player;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TicTacToeController a= new TicTacToeController(new TicTacToeWindow(),new TicTacToeServer(),icon.O);
	}
	
	public TicTacToeController(TicTacToeWindow w, INetworkModel m,icon ic){
		view=w;
		model=m;
		player=ic;
		System.out.println(player);
		for(int i=0;i<3;i++){
			for(int j=0;j<3;j++){
				view.addActionGrid(i, j, new ButtonListener(i,j));
			}
		}
		
	}
	
	
	
	public class ButtonListener implements ActionListener{
		private int x;
		private int y;

		public ButtonListener(int x, int y){
			this.x=x;
			this.y=y;
		}
		
		public void actionPerformed(ActionEvent e) {
			if(ourTurn){
				view.setImagePosition(x, y, player);
				view.setEnabledGrid(x,y,false);
			}
		}

	}
	
	

}
