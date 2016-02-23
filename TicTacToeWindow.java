import java.awt.GridLayout;

import javax.swing.*;


public class TicTacToeWindow extends JFrame {
	private JButton[][] gridButtons= new JButton[3][3];
	private ImageIcon xImage;
	private ImageIcon oImage;
	private ImageIcon blankImage;
	enum icon {X,O,BLANK}
	
	public void setImagePosition (int x, int y, icon a){
		switch(a){
		case X:
			gridButtons[x][y].setIcon(xImage);
			break;
		case O:
			gridButtons[x][y].setIcon(oImage);
			break;
		case BLANK:
			gridButtons[x][y].setIcon(blankImage);
			break;
		}
		
	}
	
	public static void main(String[] args) {
		TicTacToeWindow w= new TicTacToeWindow();
		w.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		w.setResizable(false);
		w.setSize(600,600);
		w.setTitle("Tic Tac Toe");
		w.setVisible(true);
		
	}
	
	public void setEnabledGrid(int x, int y, boolean e){
		gridButtons[x][y].setEnabled(e);
	}
	
	public TicTacToeWindow(){
		super();
		xImage= new ImageIcon("TicTacToeX.png");
		oImage= new ImageIcon("TicTacToeO.png");
		blankImage= new ImageIcon("BlankSpace.png");

		this.setLayout(new GridLayout(3,3));
		for (int i=0; i<3;i++){
			for (int j=0; j<3;j++){
				gridButtons[i][j]= new JButton();
				gridButtons[i][j].setIcon(blankImage);
				this.add(gridButtons[i][j],i,j);
				
			}
		}
		
	}
}
