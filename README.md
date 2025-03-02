# Explication

## web.xml
Dans le fichier web.xml de l’application, il faut déclarer la Servlet fournie par Jersey

```xml
<web-app xmlns="http://java.sun.com/xml/ns/javaee"
	xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xsi:schemaLocation="http://java.sun.com/xml/ns/javaee 
         http://java.sun.com/xml/ns/javaee/web-app_3_0.xsd"
	version="3.0">

	<servlet>
		<servlet-name>Jersey Web app</servlet-name>
		<servlet-class>org.glassfish.jersey.servlet.ServletContainer</servlet-class>
		<init-param>
			<param-name>jersey.config.server.provider.packages</param-name>
			<param-value>fr.adriencaubel</param-value>
		</init-param>
		<init-param>
			<param-name>jersey.config.server.provider.scanning.recursive</param-name>
			<param-value>true</param-value>
		</init-param>
		<load-on-startup>1</load-on-startup>
	</servlet>

	<servlet-mapping>
		<servlet-name>Jersey Web app</servlet-name>
		<url-pattern>/*</url-pattern>
	</servlet-mapping>
</web-app>
```

ou écrire la classe suivante

```java
@ApplicationPath("")
public class RestService extends Application {

}
```

## Création de ressources
```java
@Path("/api/hello")
class HelloResource {
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String sayHello() {
        return "{\"message\": \"Hello from JAX-RS!\"}";
    }
}
```

Depuis accessible depuis `http://[hôte]/[contexte racine]/api/hello`

## Lancement via TomEE Maven Plugin
Configurable dans le pom.xml, lancer via `mvn package tomee:run`