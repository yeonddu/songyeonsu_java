import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Calculator extends JFrame{
	private JTextField inputSpace; //JTextField로 화면 구현
	private String num =""; //계산식의 숫자를 담을 변수 
	private ArrayList<String> equation = new ArrayList<String>();
	
	public Calculator() {
		setLayout(null); //레이아웃 관리자 제거
		
		inputSpace = new JTextField();
		inputSpace.setEditable(false);//편집 불가능으로 설정
		inputSpace.setBackground(Color.WHITE); //배경색 설정
		inputSpace.setHorizontalAlignment(JTextField.RIGHT); //정렬 위치
		inputSpace.setFont(new Font("Arial", Font.BOLD, 50)); //글씨체 설정
		inputSpace.setBounds(8, 10, 270, 70); //x:8, y:10 위치에 270x70 크기
		
		
		JPanel buttonPanel = new JPanel();//버튼을 담을 패널
		buttonPanel.setLayout(new GridLayout(4, 4, 10, 10)); //격자 형태로 배치. 가로칸수 4, 세로칸수4, 좌우간격10, 상하간격10
		buttonPanel.setBounds(8, 90, 270, 235); //위치 크기 설정
		
		String button_names[] = {"C", "÷", "×", "=", "7", "8", "9", "+", "4", "5", "6", "-", "1", "2", "3", "0"}; //계산기 버튼의 글자
		JButton buttons[] = new JButton[button_names.length]; //버튼들의 배열
		
		//for문으로 버튼 만들기
		for(int i=0; i<button_names.length; i++) {
			buttons[i] = new JButton(button_names[i]);
			buttons[i].setFont(new Font("Arial", Font.BOLD, 20)); //글씨체 설정
			//때에 따라 버튼 색 다르게 설정
			if(button_names[i] =="C") buttons[i].setBackground(Color.RED); //"C"는 빨강색
			else if((i>=4 && i<=6) || (i>=8 && i<=10) || (i>=12 && i<=14)) buttons[i].setBackground(Color.black);
			else buttons[i].setBackground(Color.gray);
			buttons[i].setBackground(Color.white);
			buttons[i].setBorderPainted(false); //테두리 없애기
			buttons[i].addActionListener(new PadActionListener()); //액션리스너를 버튼에 추가
			buttonPanel.add(buttons[i]); //패널에 버튼 추가
		}
		
		add(inputSpace);
		add(buttonPanel);
		
		
		setTitle("계산기"); //창의 제목
		setVisible(true); //보이기 여부
		setSize(300, 370); //사이즈
		setLocationRelativeTo(null); //화면 가운데에 띄우기
		setResizable(false); //사이즈조절 불가능
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //창을 닫을 때 실행중인 프로그램도 같이 종료 
	}
	
	//기능구현//
	class PadActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String operation = e.getActionCommand();
			if(operation.equals("C")) {
				inputSpace.setText("");
			} else if(operation.equals("=")) {
				String result = Double.toString(calculate(inputSpace.getText()));
				inputSpace.setText("" + result);
				num = "";
			} else {
				inputSpace.setText(inputSpace.getText() + e.getActionCommand()); //눌렀을 경우 계산식에 추가
			}
		}
	}
	
	private void fullTextParsing(String inputText) {
		equation.clear();
		
		//for문을 이용하여 글자 하나하나를 거쳐가게 한다
		for(int i=0; i<inputText.length(); i++) {
			char ch = inputText.charAt(i);
			
			if (ch == '-' || ch == '+' || ch == '×' || ch == '÷') {
				equation.add(num); //숫자를 먼저 ArrayList에 추가
				num = "";
				equation.add(ch + "");
			} else {
				num = num + ch; //나머지(숫자)의 경우 num 문자에 더해준다 
			}
				
		}
	}
	
	public double calculate(String inputText) {
		fullTextParsing(inputText); //메소드를 실행하여 ArrayList에 숫자와 연산기호 담기
		double prev = 0;
		double current = 0;
		String mode = ""; //변수에 연산기호 저장
		
		for(String s : equation) {
			if(s.equals("+")) {
				mode = "add";
			} else if (s.equals("-")) {
				mode = "sub";
			} else if (s.equals("×")) {
				mode = "mul";
			} else if (s.equals("÷")) {
				mode = "div";
			} else {
				current = Double.parseDouble(s);
				//mode에 따라 연산처리
				if(mode == "add") {
					prev += current;
				} else if (mode == "sub") {
					prev -= current;
				} else if (mode == "mul") {
					prev *= current;
				} else if (mode == "div") {
					prev /= current;
				} else {
					prev = current;
				}
									
			}
		}
		return prev; //계산값 반환
	}
	
	public static void main(String []args) {
		new Calculator();
		
	}
	
	
}
