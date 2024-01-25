# Wave
Sistema Integrado de gestão empresarial
Especificações: Java 11 e Spring Boot 2.3.4

Checklist para baixar e executar projeto pronto
JDK 11, variáveis PATH e JAVA_HOME

Configurar IDE para Java 11

Importar projetos na IDE

Configurar credenciais do config server

Preparar Postman (collection e environment)

Subir projetos em ordem:

Config server
Eureka server
Outros
Fase 1: Comunicação simples, Feign, Ribbon
1.1 Criar projeto wave-worker

1.2 Implementar projeto wave-worker

Script SQL:
INSERT INTO tb_worker (name, daily_Income) VALUES ('Bob', 200.0);
INSERT INTO tb_worker (name, daily_Income) VALUES ('Maria', 300.0);
INSERT INTO tb_worker (name, daily_Income) VALUES ('Alex', 250.0);

application.properties:
spring.application.name=wave-worker
server.port=8001

# Database configuration
spring.datasource.url=jdbc:h2:mem:testdb
spring.datasource.username=sa
spring.datasource.password=

spring.h2.console.enabled=true
spring.h2.console.path=/h2-console

1.3 Criar projeto wave-payroll

application.properties:
spring.application.name=wave-payroll
server.port=8101

1.4 Implementar projeto wave-payroll (mock)

1.5 RestTemplate

1.6 Feign

1.7 Ribbon load balancing

Run configuration:
-Dserver.port=8002
Fase 2: Eureka, Hystrix, Zuul
2.1 Criar projeto wave-eureka-server

2.2 Configurar wave-eureka-server

Porta padrão: 8761
Acessar o dashboard no navegador: http://localhost:8761
2.3 Configurar clientes Eureka

Eliminar o Ribbon de wave-payroll:
Dependência Maven
Annotation no programa principal
Configuração em application.properties
Atenção: aguardar um pouco depois de subir os microsserviços
2.4 Random port para wave-worker
server.port=${PORT:0}
eureka.instance.instance-id=${spring.application.name}:${spring.application.instance_id:${random.value}}

Atenção: deletar as configurações múltiplas de execução de wave-worker

2.5 Tolerância a falhas com Hystrix

2.6 Timeout de Hystrix e Ribbon

Atenção: testar antes sem a annotation do Hystrix
hystrix.command.default.execution.isolation.thread.timeoutInMilliseconds=60000
ribbon.ConnectTimeout=10000
ribbon.ReadTimeout=20000

2.7 Criar projeto wave-zuul-server
