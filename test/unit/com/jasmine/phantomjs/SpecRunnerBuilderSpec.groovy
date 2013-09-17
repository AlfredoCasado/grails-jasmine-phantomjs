package com.jasmine.phantomjs

import spock.lang.*

class SpecRunnerBuilderSpec extends Specification {

	def specRunnerBuilder = new SpecRunnerBuilder()

	def "build a well formed html file"() {
		expect: isWellFormed specRunnerBuilder.createHtml()
	}

	def "the html include references to the jasmine scripts"() {
		when: def htmlGenerated = specRunnerBuilder.createHtml() 
		then: 
			htmlGenerated.contains("src='lib/jasmine-1.3.1/jasmine.js'") 
			htmlGenerated.contains("src='lib/jasmine-1.3.1/jasmine-html.js'")
	}

	def "the html includes the javascript for running jasmine test"() {
		when: def htmlGenerated = specRunnerBuilder.createHtml() 
		then: htmlGenerated.contains(SpecRunnerBuilder.JASMINE_EXECUTE_SCRIPT)
	}

	def "can add scripts to the generated html"() {
		given: 
			def scripts_to_add = 	[	
									'lib/jquery/jquery.js', 
									'MySpec.js',
									'MyCode.js'
									]

			def specRunnerBuilder = new SpecRunnerBuilder(scripts_to_add: scripts_to_add)

		when: def htmlGenerated = specRunnerBuilder.createHtml() 

		then:
			htmlGenerated.contains("src='lib/jquery/jquery.js'") 
			htmlGenerated.contains("src='MySpec.js'") 
			htmlGenerated.contains("src='MyCode.js'") 
	}

	private isWellFormed(html) {
		new XmlParser().parseText(html)
	}


}