
package views.html

import play.templates._
import play.templates.TemplateMagic._

import play.api.templates._
import play.api.templates.PlayMagic._
import models._
import controllers._
import java.lang._
import java.util._
import scala.collection.JavaConversions._
import scala.collection.JavaConverters._
import play.api.i18n._
import play.core.j.PlayMagicForJava._
import play.mvc._
import play.data._
import play.api.data.Field
import play.mvc.Http.Context.Implicit._
import views.html._
/**/
object index extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template1[String,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(message: String):play.api.templates.HtmlFormat.Appendable = {
        _display_ {

Seq[Any](format.raw/*1.19*/("""

"""),_display_(Seq[Any](/*3.2*/main("Welcome to Play")/*3.25*/ {_display_(Seq[Any](format.raw/*3.27*/("""

    <a href="/send-a-link">send a link</a><br>
    <a href="/signup-form">sign up</a>
    <h1>"""),_display_(Seq[Any](/*7.10*/message)),format.raw/*7.17*/("""</h1>

""")))})),format.raw/*9.2*/("""
"""))}
    }
    
    def render(message:String): play.api.templates.HtmlFormat.Appendable = apply(message)
    
    def f:((String) => play.api.templates.HtmlFormat.Appendable) = (message) => apply(message)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Thu Mar 05 18:24:14 IST 2015
                    SOURCE: /home/sarath/xDlink/xDlink-server/app/views/index.scala.html
                    HASH: 3b67b0eff22456c8677267970c81a8b99a5d2a93
                    MATRIX: 774->1|885->18|922->21|953->44|992->46|1124->143|1152->150|1190->158
                    LINES: 26->1|29->1|31->3|31->3|31->3|35->7|35->7|37->9
                    -- GENERATED --
                */
            