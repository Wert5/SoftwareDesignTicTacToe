import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.Socket;

import TicTacToe.TicTacToeWindow;
import static TicTacToe.TicTacToeWindow.icon;

public class TicTacToeController {
	
	private TicTacToeWindow view;
	private boolean ourTurn=true;
	private icon player;

	private Socket socket;

    // for writing to and reading from the server
    private Out out;
    private In in;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TicTacToeController a= new TicTacToeController(new TicTacToeWindow(),icon.O,"10.144.10.165");
		a.listen();
	}
	
	private icon hasWon(){
		for(int x=0;x<3;x++){
			if(view.getImagePosition(x, 0)!=icon.BLANK && view.getImagePosition(x, 0)==view.getImagePosition(x, 1)&& view.getImagePosition(x, 0)==view.getImagePosition(x, 2)){
				return view.getImagePosition(x, 0);
			}
		}
		
		for(int y=0;y<3;y++){
			if(view.getImagePosition(0, y)!=icon.BLANK && view.getImagePosition(0, y)==view.getImagePosition(1, y)&& view.getImagePosition(0, y)==view.getImagePosition(2, y)){
				return view.getImagePosition(0, y);
			}
		}
		
		if(view.getImagePosition(0, 0)!=icon.BLANK && view.getImagePosition(1,1)==view.getImagePosition(0, 0)&& view.getImagePosition(0, 0)==view.getImagePosition(2,2)){
			return view.getImagePosition(0, 0);
		}
		
		if(view.getImagePosition(0, 2)!=icon.BLANK && view.getImagePosition(1,1)==view.getImagePosition(0, 2)&& view.getImagePosition(2, 0)==view.getImagePosition(0,2)){
			return view.getImagePosition(0, 2);
		}
		
		return icon.BLANK;
	}
	
	public TicTacToeController(TicTacToeWindow w,icon ic, String hostName){
		view=w;
		player=ic;
		System.out.println(player);
		for(int i=0;i<3;i++){
			for(int j=0;j<3;j++){
				view.addActionGrid(i, j, new ButtonListener(i,j));
			}
		}
		try {
            socket = new Socket(hostName, 4444);
            out    = new Out(socket);
            in     = new In(socket);
        } catch (Exception ex) { ex.printStackTrace(); }
		
	}
	
	public void listen() {
        String s;
        while ((s = in.readLine()) != null) {
            
        }
        out.close();
        in.close();
        try                 { socket.close();      }
        catch (Exception e) { e.printStackTrace(); }
        System.err.println("Closed client socket");
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
