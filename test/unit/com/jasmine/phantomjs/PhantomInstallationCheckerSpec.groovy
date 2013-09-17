package com.jasmine.phantomjs

import spock.lang.*

class PhantomInstallationCheckerSpec extends Specification {

	def phantomjsInstallationChecker = new PhantomInstallationChecker()

	def "can determine if phantomjs is properly installed"() {
		expect: phantomjsInstallationChecker.isProperlyInstalled()
	}

	def "can determine when phantomjs if not properly installed"() {
		given: 
			phantomjsInstallationChecker.metaClass.phantomVerificationCommand = {
				"bad_command"
			}
			
		expect: !phantomjsInstallationChecker.isProperlyInstalled()
	}

}