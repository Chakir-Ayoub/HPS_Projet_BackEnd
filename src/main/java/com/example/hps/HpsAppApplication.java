package com.example.hps;

import java.util.Properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

import org.springframework.context.annotation.Bean;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.example.hps.dto.UtilisateurDto;
import com.example.hps.entity.Role;
import com.example.hps.entity.Utilisateur;
import com.example.hps.repository.RoleRepository;
import com.example.hps.repository.UtilisateurRepository;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.HttpClients;
import org.apache.hc.client5.http.impl.io.PoolingHttpClientConnectionManagerBuilder;
import org.apache.hc.client5.http.io.HttpClientConnectionManager;
import org.apache.hc.client5.http.ssl.NoopHostnameVerifier;
import org.apache.hc.client5.http.ssl.SSLConnectionSocketFactory;
import org.apache.hc.core5.ssl.SSLContexts;
import org.apache.hc.core5.ssl.TrustStrategy;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;
import javax.net.ssl.SSLContext;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;


@SpringBootApplication
public class HpsAppApplication extends SpringBootServletInitializer   {
	@Autowired
	UtilisateurRepository utilisateurRepository;
	@Autowired
	RoleRepository roleRepository;
	protected SpringApplicationBuilder Configure(SpringApplicationBuilder application) {
		   return application.sources(HpsAppApplication.class);	
		}
	public static void main(String[] args) {
		SpringApplication.run(HpsAppApplication.class, args);
	}
	@Bean
	public BCryptPasswordEncoder bCryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	public SpringApplicationContext springApplicationContext() {
		return new SpringApplicationContext();
	}

	@Bean
	CommandLineRunner SaveUsers() {
		return (args)->{
			roleRepository.save(new Role(Long.valueOf(1), "Admin", null));
			roleRepository.save(new Role(Long.valueOf(2), "Manager", null));
			roleRepository.save(new Role(Long.valueOf(3), "Emploi", null));
		};
	}
	
	@Bean
	public RestTemplate getRestTemplate() throws NoSuchAlgorithmException, KeyManagementException, KeyStoreException {
	    TrustStrategy acceptingTrustStrategy = (x509Certificates, s) -> true;
	    SSLContext sslContext = SSLContexts.custom().loadTrustMaterial(null, acceptingTrustStrategy).build();
	    SSLConnectionSocketFactory csf = new SSLConnectionSocketFactory(sslContext, new NoopHostnameVerifier());
	    HttpComponentsClientHttpRequestFactory requestFactory = new HttpComponentsClientHttpRequestFactory();
	    HttpClientConnectionManager connectionManager = PoolingHttpClientConnectionManagerBuilder.create().setSSLSocketFactory(csf).build();
	    CloseableHttpClient httpClient = HttpClients.custom().setConnectionManager(connectionManager).build();
	    requestFactory.setHttpClient(httpClient);
	    return new RestTemplate(requestFactory);
	}
	
	
	@Bean
	public JavaMailSender getJavaMailSender() {
	    JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
	    mailSender.setHost("smtp.gmail.com");
	    mailSender.setPort(587);
	    
	    mailSender.setUsername("hhps2304@gmail.com");
	    mailSender.setPassword("modagwhnnbilgfuq");
	    
	    Properties props = mailSender.getJavaMailProperties();
	    props.put("mail.transport.protocol", "smtp");
	    props.put("mail.smtp.auth", "true");
	    props.put("mail.smtp.starttls.enable", "true");
	    props.put("mail.debug", "true");
	    
	    return mailSender;
	}



	
}