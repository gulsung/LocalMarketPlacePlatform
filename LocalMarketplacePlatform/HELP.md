# Read Me First
The following was discovered as part of building this project:

* The JVM level was changed from '11' to '17', review the [JDK Version Range](https://github.com/spring-projects/spring-framework/wiki/Spring-Framework-Versions#jdk-version-range) on the wiki for more details.

# Getting Started

### Reference Documentation
For further reference, please consider the following sections:

* [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)
* [Spring Boot Maven Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/3.0.6/maven-plugin/reference/html/)
* [Create an OCI image](https://docs.spring.io/spring-boot/docs/3.0.6/maven-plugin/reference/html/#build-image)
* [Spring Integration JDBC Module Reference Guide](https://docs.spring.io/spring-integration/reference/html/jdbc.html)
* [Spring Integration JPA Module Reference Guide](https://docs.spring.io/spring-integration/reference/html/jpa.html)
* [Spring Integration R2DBC Module Reference Guide](https://docs.spring.io/spring-integration/reference/html/r2dbc.html)
* [Spring Integration Test Module Reference Guide](https://docs.spring.io/spring-integration/reference/html/testing.html)
* [Spring Integration Security Module Reference Guide](https://docs.spring.io/spring-integration/reference/html/security.html)
* [Spring Integration HTTP Module Reference Guide](https://docs.spring.io/spring-integration/reference/html/http.html)
* [Spring Integration WebFlux Module Reference Guide](https://docs.spring.io/spring-integration/reference/html/webflux.html)
* [Spring Integration Web Services Module Reference Guide](https://docs.spring.io/spring-integration/reference/html/ws.html)
* [Spring Boot DevTools](https://docs.spring.io/spring-boot/docs/3.0.6/reference/htmlsingle/#using.devtools)
* [Spring Configuration Processor](https://docs.spring.io/spring-boot/docs/3.0.6/reference/htmlsingle/#appendix.configuration-metadata.annotation-processor)
* [Spring Web](https://docs.spring.io/spring-boot/docs/3.0.6/reference/htmlsingle/#web)
* [Spring Reactive Web](https://docs.spring.io/spring-boot/docs/3.0.6/reference/htmlsingle/#web.reactive)
* [Spring for GraphQL](https://docs.spring.io/spring-boot/docs/3.0.6/reference/html/web.html#web.graphql)
* [Rest Repositories](https://docs.spring.io/spring-boot/docs/3.0.6/reference/htmlsingle/#howto.data-access.exposing-spring-data-repositories-as-rest)
* [Spring Session](https://docs.spring.io/spring-session/reference/)
* [Spring HATEOAS](https://docs.spring.io/spring-boot/docs/3.0.6/reference/htmlsingle/#web.spring-hateoas)
* [Spring Web Services](https://docs.spring.io/spring-boot/docs/3.0.6/reference/htmlsingle/#io.webservices)
* [Jersey](https://docs.spring.io/spring-boot/docs/3.0.6/reference/htmlsingle/#web.servlet.jersey)
* [Vaadin](https://vaadin.com/docs)
* [Thymeleaf](https://docs.spring.io/spring-boot/docs/3.0.6/reference/htmlsingle/#web.servlet.spring-mvc.template-engines)
* [Apache Freemarker](https://docs.spring.io/spring-boot/docs/3.0.6/reference/htmlsingle/#web.servlet.spring-mvc.template-engines)
* [Spring Security](https://docs.spring.io/spring-boot/docs/3.0.6/reference/htmlsingle/#web.security)
* [OAuth2 Client](https://docs.spring.io/spring-boot/docs/3.0.6/reference/htmlsingle/#web.security.oauth2.client)
* [OAuth2 Resource Server](https://docs.spring.io/spring-boot/docs/3.0.6/reference/htmlsingle/#web.security.oauth2.server)
* [Spring LDAP](https://docs.spring.io/spring-boot/docs/3.0.6/reference/htmlsingle/#data.nosql.ldap)
* [Okta Spring Boot documentation](https://github.com/okta/okta-spring-boot#readme)
* [JDBC API](https://docs.spring.io/spring-boot/docs/3.0.6/reference/htmlsingle/#data.sql)
* [Spring Data JPA](https://docs.spring.io/spring-boot/docs/3.0.6/reference/htmlsingle/#data.sql.jpa-and-spring-data)
* [Spring Data JDBC](https://docs.spring.io/spring-boot/docs/3.0.6/reference/htmlsingle/#data.sql.jdbc)
* [Spring Data R2DBC](https://docs.spring.io/spring-boot/docs/3.0.6/reference/htmlsingle/#data.sql.r2dbc)
* [Spring Integration](https://docs.spring.io/spring-boot/docs/3.0.6/reference/htmlsingle/#messaging.spring-integration)
* [Spring Batch](https://docs.spring.io/spring-boot/docs/3.0.6/reference/htmlsingle/#howto.batch)
* [Validation](https://docs.spring.io/spring-boot/docs/3.0.6/reference/htmlsingle/#io.validation)
* [Spring REST Docs](https://docs.spring.io/spring-restdocs/docs/current/reference/html5/)
* [Cloud Bootstrap](https://docs.spring.io/spring-cloud-commons/docs/current/reference/html/)
* [Config Client Quick Start](https://docs.spring.io/spring-cloud-config/docs/current/reference/html/#_client_side_usage)
* [Config Server](https://docs.spring.io/spring-cloud-config/docs/current/reference/html/#_spring_cloud_config_server)

### Guides
The following guides illustrate how to use some features concretely:

* [Building a RESTful Web Service](https://spring.io/guides/gs/rest-service/)
* [Serving Web Content with Spring MVC](https://spring.io/guides/gs/serving-web-content/)
* [Building REST services with Spring](https://spring.io/guides/tutorials/rest/)
* [Building a Reactive RESTful Web Service](https://spring.io/guides/gs/reactive-rest-service/)
* [Building a GraphQL service](https://spring.io/guides/gs/graphql-server/)
* [Accessing JPA Data with REST](https://spring.io/guides/gs/accessing-data-rest/)
* [Accessing Neo4j Data with REST](https://spring.io/guides/gs/accessing-neo4j-data-rest/)
* [Accessing MongoDB Data with REST](https://spring.io/guides/gs/accessing-mongodb-data-rest/)
* [Building a Hypermedia-Driven RESTful Web Service](https://spring.io/guides/gs/rest-hateoas/)
* [Producing a SOAP web service](https://spring.io/guides/gs/producing-web-service/)
* [Creating CRUD UI with Vaadin](https://spring.io/guides/gs/crud-with-vaadin/)
* [Handling Form Submission](https://spring.io/guides/gs/handling-form-submission/)
* [Securing a Web Application](https://spring.io/guides/gs/securing-web/)
* [Spring Boot and OAuth2](https://spring.io/guides/tutorials/spring-boot-oauth2/)
* [Authenticating a User with LDAP](https://spring.io/guides/gs/authenticating-ldap/)
* [Okta-Hosted Login Page Example](https://github.com/okta/samples-java-spring/tree/master/okta-hosted-login)
* [Custom Login Page Example](https://github.com/okta/samples-java-spring/tree/master/custom-login)
* [Okta Spring Security Resource Server Example](https://github.com/okta/samples-java-spring/tree/master/resource-server)
* [Accessing Relational Data using JDBC with Spring](https://spring.io/guides/gs/relational-data-access/)
* [Managing Transactions](https://spring.io/guides/gs/managing-transactions/)
* [Accessing Data with JPA](https://spring.io/guides/gs/accessing-data-jpa/)
* [Using Spring Data JDBC](https://github.com/spring-projects/spring-data-examples/tree/master/jdbc/basics)
* [Accessing data with R2DBC](https://spring.io/guides/gs/accessing-data-r2dbc/)
* [Accessing data with MySQL](https://spring.io/guides/gs/accessing-data-mysql/)
* [Integrating Data](https://spring.io/guides/gs/integration/)
* [Creating a Batch Service](https://spring.io/guides/gs/batch-processing/)
* [Validation](https://spring.io/guides/gs/validating-form-input/)
* [Centralized Configuration](https://spring.io/guides/gs/centralized-configuration/)

### Additional Links
These additional references should also help you:

* [R2DBC Homepage](https://r2dbc.io)

## OAuth 2.0 and OIDC with Okta

If you don't have a free Okta developer account, you can create one with [the Okta CLI](https://cli.okta.com):

```bash
$ okta register
```

Then, register your Spring Boot app on Okta using:

```bash
$ okta apps create
```

Select **Web** > **Okta Spring Boot Starter** and accept the default redirect URIs.

