
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
object signup extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template1[String,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(message: String):play.api.templates.HtmlFormat.Appendable = {
        _display_ {

Seq[Any](format.raw/*1.19*/("""

"""),_display_(Seq[Any](/*3.2*/main("Welcome to Play")/*3.25*/ {_display_(Seq[Any](format.raw/*3.27*/("""
<form method="post" action=""""),_display_(Seq[Any](/*4.30*/routes/*4.36*/.Registration.registerDevice())),format.raw/*4.66*/("""">
    <input type="text" name="First Name" /><br/>
    <input type="text" name="Last Name" /><br/>
    <input type="text" name="comments" /><br/>
    <h2>model-at-app</h2>
    <input type="submit" value="send" />
</form>
""")))})),format.raw/*11.2*/("""
"""))}
    }
    
    def render(message:String): play.api.templates.HtmlFormat.Appendable = apply(message)
    
    def f:((String) => play.api.templates.HtmlFormat.Appendable) = (message) => apply(message)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Thu Mar 05 18:24:14 IST 2015
                    SOURCE: /home/sarath/xDlink/xDlink-server/app/views/signup.scala.html
                    HASH: 6e8cd1616d7ba234619170a29bf27214b681e07d
                    MATRIX: 775->1|886->18|923->21|954->44|993->46|1058->76|1072->82|1123->112|1377->335
                    LINES: 26->1|29->1|31->3|31->3|31->3|32->4|32->4|32->4|39->11
                    -- GENERATED --
                */
            