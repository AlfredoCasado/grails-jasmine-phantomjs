package com.jasmine.phantomjs

import spock.lang.*

class SpecRunnerBuilderSpec extends Specification {

	def specRunnerBuilder = new SpecRunnerBuilder()

	def "build a well formed html file"() {
		expect: isWellFormed specRunnerBuilder.createHtml()
	}

	def "the html include referentes to the jasmine scripts"() {
		when: def htmlGenerated = specRunnerBuilder.createHtml() 
		then: 
			htmlGenerated.contains("src='lib/jasmine-1.3.1/jasmine.js'") 
			htmlGenerated.contains("src='lib/jasmine-1.3.1/jasmine-html.js'")
	}

	private isWellFormed(html) {
		new XmlParser().parseText(html)
	}


}