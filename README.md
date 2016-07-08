# Usage example for Spring Boot, Vaadin and client side Add-ons

This is a simple example project that shows how to use Vaadin add-ons with Spring Boot based projects.

Since 7.7 (used by this project), there are three modes to use client side extensions with Vaadin:

 * local (default), where a local GWT compilation is done to combine Vaadin core widgets and possible add-ons found from the classpath
 * fetch, where the GWT compilation is delegated for a cloud service, which also caches compilation results. This new mode is typically faster for developers to use, but it don't allow you to have project specific client side customisations.
 * cdn, which is similar to the "fetch" mode, but also the hosting of the client side resources is delegated to the cloud service.

Since Vaadin 7.7 all these modes work out of the box with Spring Boot, all you need is vaadin-maven-plugin configured for your project. You can try these different widgetset modes by modifying the configuration of [vaadin-maven-plugin in the pom.xml](https://github.com/tsuoanttila/vaadin-spring-boot-addons/blob/master/pom.xml#L95-L101) and issuing "mvn clean install spring-boot:run".  

