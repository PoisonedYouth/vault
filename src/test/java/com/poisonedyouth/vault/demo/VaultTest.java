package com.poisonedyouth.vault.demo;

import com.bettercloud.vault.Vault;
import com.bettercloud.vault.VaultConfig;
import com.bettercloud.vault.VaultException;
import com.bettercloud.vault.response.LogicalResponse;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Handler;

public class VaultTest {

	Vault vault;

	@BeforeEach
	public void setUp() throws VaultException {
		VaultConfig vaultConfig = new VaultConfig()
				.address("http://127.0.0.1:8200").token("s.0dNxmvUw7GiTbLEH48jD3nUY").build();
		vault = new Vault(vaultConfig);
	}

	@AfterEach
	public void tearDown() {

	}

	@Test
	public void testEncryptAndDecrypt() throws VaultException {
		Map<String, Object> values = new HashMap<>();
		values.put("password", "passw0rd");
		values.put("newPassword", "passw0rdN3w");
		vault.logical().write("secret/vault", values);

		LogicalResponse read = vault.logical().read("secret/vault");
		System.out.println(read.getData());
	}
}
