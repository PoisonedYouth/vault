# Problem: 
# Hardcoded secrets in source code / property files is not secure


## Current State:
* Secrets are spread over different places (Source Code, Config Files, VCS)
* No information about who has access to this secrets
* Changing a secret is difficult because don't know on which plasses it occurs
* Changing a secret leads to changing the source code

## Vault:
* Can be solved by centralize all secrets
* Encrypt at rest / in transit between vault and application
* ACL
* Audit
* Dynamic Secret (expires, unique for each client, easy to revoke)
* Encrypts-as-a-Service
* Named keys (i.e. password)
* Provides high level API (implementation is done by vault) --> Developer not has to challenge with encryption
* Key life cycle provieded by vault
* Highly plugable
    * Authentication Identity (AWS, Kubernetes, LDAP, ...)
	* Audit (Splunk, Syslog, ...)
	* Storage Backend (MySQL, Postgresql, Consul, ...)
	* Secret Backends (Key-Value, Database, RabbitMQ, AWS, PKI ...)

