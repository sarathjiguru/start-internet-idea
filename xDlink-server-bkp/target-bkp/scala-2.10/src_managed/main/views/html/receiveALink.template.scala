
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
object receiveALink extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template1[String,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(message: String):play.api.templates.HtmlFormat.Appendable = {
        _display_ {

Seq[Any](format.raw/*1.19*/("""

"""),_display_(Seq[Any](/*3.2*/main("Welcome to Play")/*3.25*/ {_display_(Seq[Any](format.raw/*3.27*/("""
<form method="post" action=""""),_display_(Seq[Any](/*4.30*/routes/*4.36*/.Application.receiveALink())),format.raw/*4.63*/("""">
    <input type="text" name="host" /><br/>
    <input type="text" name="link_at_client" /><br/>
    <input type="text" name="guest" /><br/>
    <input type="submit" value="send" />
</form>
""")))})),format.raw/*10.2*/("""

"""))}
    }
    
    def render(message:String): play.api.templates.HtmlFormat.Appendable = apply(message)
    
    def f:((String) => play.api.templates.HtmlFormat.Appendable) = (message) => apply(message)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Mon Jan 26 22:10:42 IST 2015
                    SOURCE: /home/sarath/xDlink/xDlink-server/app/views/receiveALink.scala.html
                    HASH: 661340d008e207f1b3986d10b7178505e235316e
                    MATRIX: 781->1|892->18|929->21|960->44|999->46|1064->76|1078->82|1126->109|1350->302
                    LINES: 26->1|29->1|31->3|31->3|31->3|32->4|32->4|32->4|38->10
                    -- GENERATED --
                */
            