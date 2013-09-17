package com.jasmine.phantomjs

class SpecRunnerBuilder {

	def scripts_to_add

	static final JASMINE_EXECUTE_SCRIPT = """
		(function() {
	      var jasmineEnv = jasmine.getEnv();
	      jasmineEnv.updateInterval = 1000;

	      var htmlReporter = new jasmine.HtmlReporter();

	      jasmineEnv.addReporter(htmlReporter);

	      jasmineEnv.specFilter = function(spec) {
	        return htmlReporter.specFilter(spec);
	      };

	      var currentWindowOnload = window.onload;

	      window.onload = function() {
	        if (currentWindowOnload) {
	          currentWindowOnload();
	        }
	        execJasmine();
	      };

	      function execJasmine() {
	        jasmineEnv.execute();
	      }

	    })();
	"""
	def scripts_to_add() {
		scripts_to_add.collect { script ->
			"<script type='text/javascript' src='${script}'></script>"
		}
	}

	def createHtml() {
		"""
			<html>
				<head>
					<script type='text/javascript' src='lib/jasmine-1.3.1/jasmine.js'></script>
  					<script type='text/javascript' src='lib/jasmine-1.3.1/jasmine-html.js'></script>
  					${scripts_to_add()}
				</head>
				<body>
					${JASMINE_EXECUTE_SCRIPT}
				</body>

			</html>
		"""
	}

}