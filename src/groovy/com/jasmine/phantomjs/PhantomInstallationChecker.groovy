package com.jasmine.phantomjs

class PhantomInstallationChecker {

	def isProperlyInstalled() {
		try {
			phantomVerificationCommand().execute()
			return true
		} catch(all) {
			println 	"""
							phantomjs seems to be not correcty installed or its not it the execution path
								- command 'phantomjs -v' failed to execute with message: $all.message
								- to install phantomjs follow the instructions on http://phantomjs.org/ site for your O.S.
			 			"""
			return false
		}
	}	

	private phantomVerificationCommand() { "phantomjs -v" } 

}