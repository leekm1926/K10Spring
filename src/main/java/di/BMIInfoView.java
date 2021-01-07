package di;

import java.util.ArrayList;

public class BMIInfoView {

	private String name; // 이름 - String형
	private double height; // 키 -double형
	private double weight; // 몸무게 - double형
	private ArrayList<String> hobbys; // 취미-컬렉션(리스트계열)
	private BMICalResult bmiCalResult; // 체질량지수 - 개발자가 정의한 객체

	// BMI지수를 계산하는 멤버변수 객체의 메소드를 호출
	public String bmiCalculation() {
		//몸무게와 신장을 전달하여 BMI지수 계산결과를 반환받음.
		String bmiResult = bmiCalResult.bmiCalculation(weight, height);
		return bmiResult;
	}

	public String getInfo() {

		return String.format("이름:%s<br/>" + "키:%s<br/>" + "몸무게:%s<br/>" + "취미:%s<br/>%s", name, height, weight, hobbys,
				bmiCalculation());
	}

	// setter정의
	public void setName(String name) {
		this.name = name;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public void setHobbys(ArrayList<String> hobbys) {
		this.hobbys = hobbys;
	}

	public void setBmiCalResult(BMICalResult bmiCalResult) {
		this.bmiCalResult = bmiCalResult;
	}

	// getter정의
	public String getName() {
		return name;
	}

	public double getHeight() {
		return height;
	}

	public double getWeight() {
		return weight;
	}

	public ArrayList<String> getHobbys() {
		return hobbys;
	}

	public BMICalResult getBmiCalResult() {
		return bmiCalResult;
	}

}
