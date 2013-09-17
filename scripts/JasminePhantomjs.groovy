includeTargets << grailsScript("_GrailsCompile")

target(executeJasmineTest: "script that execute jasmine test using phantomjs") {
    println "bla,bla,bla"	
}

setDefaultTarget(executeJasmineTest)
