import java.util.*;
class EditPK {
	private int _score, _wrong;
	EditPK(){
		this(3);
	}
	EditPK(int wrong){
		_wrong = wrong;	
	}
	int gaming(){
		while(_wrong > 0){
			System.out.println("3\n");		
			getAndCheckInput();
		}
		return _score;	//实现输出字符并匹配；	
	}
	void getAndCheckInput(){
		_wrong--;
		_score++;
	}
}
class Player {
	private	int _score;
	void play(){
		EditPK g = new EditPK();
		_score = g.gaming();
		showScore();
	}
	void showScore(){
		System.out.println("Your score is: " + _score + "\n");	
	}	
}
public class Test {
	public static void main(String [] args){
		Player p = new Player();
		p.play();
	}	
}
