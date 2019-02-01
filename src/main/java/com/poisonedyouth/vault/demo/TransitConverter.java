package com.poisonedyouth.vault.demo;

import org.springframework.vault.core.VaultOperations;
import org.springframework.vault.support.Ciphertext;
import org.springframework.vault.support.Plaintext;

import javax.persistence.AttributeConverter;

public class TransitConverter implements AttributeConverter<String, String> {

	@Override
	public String convertToDatabaseColumn(String customer) {
		VaultOperations vaultOps = BeanUtil.getBean(VaultOperations.class);
		Plaintext plaintext = Plaintext.of(customer);
		return vaultOps.opsForTransit().encrypt("order", plaintext).getCiphertext();
	}

	@Override
	public String convertToEntityAttribute(String customer) {
		VaultOperations vaultOps = BeanUtil.getBean(VaultOperations.class);
		Ciphertext ciphertext = Ciphertext.of(customer);
		return vaultOps.opsForTransit().decrypt("order", ciphertext).asString();
	}

}
