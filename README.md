Vault:

- Installation/Configuration of Server
https://learn.hashicorp.com/vault/

- Adding MySql storage backend to vault server
https://github.com/hashicorp/vault-guides/blob/master/secrets/spring-cloud-vault
https://www.vaultproject.io/docs/configuration/storage/mysql.html

- Adding MSql secrets engine to vault server
https://www.vaultproject.io/docs/secrets/databases/mysql-maria.html
MySQL Database Secret engine

`vault write database/config/vault plugin_name=mysql-database-plugin connection_url="{{username}}:{{password}}@tcp(127.0.0.1:3306)/" allowed_roles="*" username="vault_user" password="password"
vault write database/roles/order db_name=vault creation_statements="CREATE USER '{{name}}'@'%' IDENTIFIED BY '{{password}}';GRANT SELECT ON *.* TO '{{name}}'@'%';" default_ttl="1h" max_ttl="24h"`

- Adding File Audit Device
https://www.vaultproject.io/docs/audit/file.html


Spring Vault:

- Using Vault in Spring Boot Application
https://spring.io/blog/2016/06/24/managing-secrets-with-vault
https://cloud.spring.io/spring-cloud-vault/



Run "Vault Application"

- Start docker container "mysql_vault"
- Start vault server
- Unseal vault server
- Start vault application

