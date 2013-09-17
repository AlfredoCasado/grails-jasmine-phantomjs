package com.jasmine.phantomjs

import spock.lang.*

class JasmineExecutionEnviromentSpec extends Specification {

	def jasmineExecutionEnviroment = new JasmineExecutionEnviroment()

	def cleanup() {
		JasmineExecutionEnviroment.TEMPORAL_JASMINE_EXECUTION_DIR.deleteDir()
	}

	def "create temporal directory for test execution in target"() {
		when: jasmineExecutionEnviroment.prepareEnviroment()
		then: JasmineExecutionEnviroment.TEMPORAL_JASMINE_EXECUTION_DIR.exists()
	}

	def "copy jasmine js files in temporal execution directory"() {
		when: jasmineExecutionEnviroment.prepareEnviroment()
		then: libs().haveFile('jasmine.js')
			
	}

	private libs() {
		def lib = new File(JasmineExecutionEnviroment.TEMPORAL_JASMINE_EXECUTION_DIR, '/lib')
		lib.metaClass.haveFile = { fileName ->
			new File(delegate,fileName).exists()
		}
		return lib
	}

}
