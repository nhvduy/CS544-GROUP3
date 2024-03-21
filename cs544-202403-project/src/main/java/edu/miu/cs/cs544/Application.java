package edu.miu.cs.cs544;

import edu.miu.cs.cs544.repository.AttendanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

//import edu.miu.cs.cs544.service.MemberService;

@SpringBootApplication
(scanBasePackages = {"edu.miu.common", "edu.miu.cs.cs544"})
public class Application implements CommandLineRunner {

//	@Autowired
//	private MemberService service;
//
	public static void main(String[] args) {

		SpringApplication.run(Application.class, args);
	}

	@Autowired
	AttendanceRepository scanRecordRepository;
	@Override
	public void run(String... args) throws Exception {
		//service.findAll().forEach(System.out::println);
//		for(int i = 0 ; i <10; i++){
//			ScanRecord record = new ScanRecord("111","1234", LocalDateTime.now());
//
//		}
	}
}
