package com.kosmo.k10spring;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import di.BMIInfoView;
import di.CalculatorDTO;

@Controller
public class DIController {

	//DI를 이용한 간단한 사칙연산 계산기 구현
	@RequestMapping("/di/myCalculator")
	public String myCalculator(Model model) {
		/*
		 ApplicationContext파일의 위치를 문자열에 저장한다.
		 물리적경로는 /src/main/resources 디렉토리 하위이다.
		 webapp하위의 resources 디렉토리와 혼동하지 않도록 주의한다.
		 */
		String configLocation = "classpath:DIAppCtxCalculator.xml";

		/*
		 스프렝컨테이너 생성 : xml파일을 파싱하여 파싱된 내용을 기반으로
		 	ctx참조변수를 생성한다.
		 */
		AbstractApplicationContext ctx = new GenericXmlApplicationContext(configLocation);

		/*
		 XML설정 파일에서 생성한 빈을 getBean()을 통해 주입받아 참조변수에
		 할당한다. new 연산자를 통해 생성한 것과 동일하지만 외부 설정파일에서
		 미리 생성한것을 주입(injection)받아 사용하고 있다.
		 */
		CalculatorDTO myCal = ctx.getBean("myCal", CalculatorDTO.class);

		/*
		 주입받은 빈을 통해 사칙연산을 수행하고, 결과값을 model객체에
		 저장한 후 view로 전달한다.
		 */
		model.addAttribute("addResult", myCal.add());
		model.addAttribute("subResult", myCal.sub());
		model.addAttribute("mulResult", myCal.mul());
		model.addAttribute("divResult", myCal.div());

		return "04DI/myCalculator";
	}
	
	//체질량 지수 계산하기
	@RequestMapping("/di/myBMICal")
	public String bmiCal(Model model) {
		// xml 설정파일을 기반으로 스프링 컨테이너 생성
		String configLoc = "classpath:DIAppCtxBMICal.xml";
		AbstractApplicationContext ctx =
				new GenericXmlApplicationContext(configLoc);
		//빈 주입
		BMIInfoView myInfo = 
				ctx.getBean("myInfo", BMIInfoView.class);
		ctx.close();
		//빈을 통한 메소드 호출 및 결과 저장
		String myBMIResult = myInfo.getInfo();
		model.addAttribute("myBMIResult", myBMIResult);
		
		return "04DI/myBMICal";
	}

}
