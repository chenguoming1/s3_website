package s3.website

object Ruby {
  lazy val rubyRuntime = org.jruby.Ruby.newInstance() // Instantiate heavy object

  def rubyRegexMatches(text: String, regex: String) =
    rubyRuntime.evalScriptlet(s"Regexp.new('$regex').match '$text'").toJava(classOf[Boolean]).asInstanceOf[Boolean]
}
