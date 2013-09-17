grails.project.work.dir = 'target'

grails.project.dependency.resolution = {

	inherits 'global'

	repositories {
		grailsCentral()
		mavenLocal()
		mavenCentral()
	}

	dependencies {
    	test "org.spockframework:spock-grails-support:0.7-groovy-2.0"
  	}
  
  	plugins {
    	test(":spock:0.7") {
      		exclude "spock-grails-support"
    	}
  	}
	
}