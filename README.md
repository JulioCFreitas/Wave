## Wave
Sistema Integrado de gestão empresarial
# Microsserviços Java com Spring Boot e Spring Cloud

## Checklist para baixar e executar projeto pronto

1. **JDK 11, variáveis PATH e JAVA_HOME**
   
2. **Configurar IDE para Java 11**
   
3. **Importar projetos na IDE**
   
4. **Configurar credenciais do config server**
   
5. **Preparar Postman (collection e environment)**
   
6. **Subir projetos em ordem:**
   - Config server
   - Eureka server
   - Outros

...

## Fase 1: Comunicação simples, Feign, Ribbon

1.1 **Criar projeto wave-worker**

1.2 **Implementar projeto wave-worker**
   
**Script SQL:**
```sql
INSERT INTO tb_worker (name, daily_Income) VALUES ('Bob', 200.0);
INSERT INTO tb_worker (name, daily_Income) VALUES ('Maria', 300.0);
INSERT INTO tb_worker (name, daily_Income) VALUES ('Alex', 250.0);
```

**application.properties**
```sql
spring.application.name=wave-worker
server.port=8001

# Database configuration
spring.datasource.url=jdbc:h2:mem:testdb
spring.datasource.username=sa
spring.datasource.password=

spring.h2.console.enabled=true
spring.h2.console.path=/h2-console
