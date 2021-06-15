package br.com.orangetalent5.proposta.config;

import org.jasypt.util.text.BasicTextEncryptor;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Encrypter {
	
	private BasicTextEncryptor textEncryptor = new BasicTextEncryptor();
	
	private void textPass() {
		textEncryptor.setPasswordCharArray("senha-seguranca".toCharArray());
	}
	public String encrypt(String str) {
		textPass();
		return textEncryptor.encrypt(str);
	}
}
