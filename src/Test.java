import java.util.*;
import java.io.*;
class EditPK {
	private int _score, _wrong;
	private String question;
	static Random rand = new Random();
	EditPK(){
		this(3);
	}
	EditPK(int wrong){
		_wrong = wrong;	
	}
	int gaming(){
		while(_wrong > 0){
			getAndCheckInput();
		}
		return _score;	//实现输出字符并匹配；	
	}
	void getAndCheckInput(){
		putOut();
		boolean flag = getIn();
		if(!flag)
			_wrong--;
		else
			_score++;
	}
	void putOut(){
		question = "" + rand.nextInt(20); 
		System.out.println(question);		
	}
	boolean getIn(){
		Scanner in = new Scanner(System.in);
			String s;
			s =  in.nextLine();
			return s.equals(question);
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
