package com.jasmine.phantomjs

class JasmineExecutionEnviroment {

	static final TEMPORAL_JASMINE_EXECUTION_DIR = new File('target','jasmine-test-execution')

	def prepareEnviroment() {
		TEMPORAL_JASMINE_EXECUTION_DIR.mkdirs()
	}

}