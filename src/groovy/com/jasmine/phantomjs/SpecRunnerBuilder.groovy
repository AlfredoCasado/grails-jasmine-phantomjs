package com.jasmine.phantomjs

class SpecRunnerBuilder {

	def createHtml() {
		"""
			<html>
				<head>
					<script type='text/javascript' src='lib/jasmine-1.3.1/jasmine.js'></script>
  					<script type='text/javascript' src='lib/jasmine-1.3.1/jasmine-html.js'></script>
				</head>
				<body></body>
			</html>
		"""
	}

}