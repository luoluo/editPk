import java.util.*;
import java.io.*;


class EditPK {
	private int  _wrong;
	private String question, answer;
	EditPK(){
		this(3);
	}
	EditPK(int wrong){
		_wrong = wrong;	
	}

	int gaming(int _score){
		while(_wrong > 0){
			putOut();
			boolean flag = getInAndCheck();
			if(!flag)
				_wrong--;
			else
				_score++;
		}
		return _score;
	}

	void putOut(){
		question = gentrateQuestion();
		answer = question; 
		System.out.println(question);		
	}
	boolean getInAndCheck(){
		Scanner in = new Scanner(System.in);
			String s;
			s =  in.nextLine();
			return s.equals(answer);
	}	
	String gentrateQuestion(){
		//可以在此处实现一个多台的类来实现多种不同难度的输出：单个、多个 以及时间控制；
		return new LevelQuestion().generate();	
	}
		
}


class RandQues{
	static Random rand = new Random();
	String questions = "qwertyuiopasdfghjkl;'zxcvbnm,./";
	String nextChar(){
		int	r = rand.nextInt(questions.length());
		return "" + questions.charAt(r);	
	}
	
}

	
interface Question{
	static RandQues r = new RandQues();
	String generate();	
}
class SimpleQuestion implements Question{
	public	String generate(){
		return r.nextChar();
	}
}
class ComplexQuestion implements Question{
	public String generate(){
		return r.nextChar() + r.nextChar();
	}
		
}
class MoreComplexQuestion implements Question{
	public String generate(){
		return r.nextChar() + r.nextChar() + r.nextChar();	
	}	
}
class LevelQuestion implements Question{
	int _level;
	LevelQuestion(){
		_level = 3;	
	}
	LevelQuestion(int level){
		_level = level;	
	}
	public String generate(){
		String s = "";
		for(int i = 0; i < _level; i++)
			s += r.nextChar();
		return s;
	}	
}


class Player {
	private	int _score;
	void play(){
		EditPK g = new EditPK();
		_score = g.gaming(0);
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
