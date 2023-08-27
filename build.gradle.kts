plugins {
	java
	id("org.springframework.boot") version "2.7.8"
	id("io.spring.dependency-management") version "1.0.15.RELEASE"
}

group = "hs-core-server"
version = "0.0.1"

java {
	sourceCompatibility = JavaVersion.VERSION_11
}

configurations {
	compileOnly {
		extendsFrom(configurations.annotationProcessor.get())
	}
}

repositories {
	mavenCentral()
}

dependencies {
	// spring starter
	implementation("org.springframework.boot:spring-boot-starter-data-jpa")
	implementation("org.springframework.boot:spring-boot-starter-validation")
	implementation("org.springframework.boot:spring-boot-starter-web")
	testImplementation("org.springframework.boot:spring-boot-starter-test")

	// lombok
	compileOnly("org.projectlombok:lombok")
	annotationProcessor("org.projectlombok:lombok")

	// spring devtools
	developmentOnly("org.springframework.boot:spring-boot-devtools")

	// h2
	runtimeOnly("com.h2database:h2")

	// mysql
	runtimeOnly("com.mysql:mysql-connector-j")

	// json
	implementation("org.json:json:20230618")
}

tasks.withType<Test> {
	useJUnitPlatform()
}
